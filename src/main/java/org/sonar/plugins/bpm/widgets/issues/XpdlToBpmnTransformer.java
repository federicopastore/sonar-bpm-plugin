/**
 * 
 */
package org.sonar.plugins.bpm.widgets.issues;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Gateway;
import org.activiti.bpmn.model.ManualTask;
import org.activiti.bpmn.model.ParallelGateway;
import org.activiti.bpmn.model.ReceiveTask;
import org.activiti.bpmn.model.ScriptTask;
import org.activiti.bpmn.model.SendTask;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.ServiceTask;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.SubProcess;
import org.activiti.bpmn.model.ThrowEvent;
import org.activiti.bpmn.model.UserTask;
import org.apache.commons.io.FileUtils;
import org.jdom.JDOMException;
import org.sonar.api.ServerComponent;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.Task;
import org.sonar.plugins.bpm.parser.elements.model.Transition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;
import org.sonar.plugins.bpm.parser.elements.model.impl.IntermediateEvent;
import org.sonar.plugins.bpm.parser.xpdl.XpdlParser;
import org.sonar.plugins.bpm.parser.xpdl.enums.GatewayType;

/**
 * @author federicopastore
 * 
 */
public class XpdlToBpmnTransformer implements ServerComponent{

	private File source;

	public XpdlToBpmnTransformer(File XpdlSource) {
		this.source = XpdlSource;
	}

	public InputStream testXdplToBpmn() throws JDOMException, IOException {
		XpdlParser parser = new XpdlParser();
		PackageDefinition pkg = parser.parse(new FileInputStream(this.source));
		List<WorkflowProcess> processes = pkg.getProcesses();
		BpmnModel model = new BpmnModel();
		for (Iterator iterator = processes.iterator(); iterator.hasNext();) {
			WorkflowProcess process = (WorkflowProcess) iterator.next();
		//WorkflowProcess process = processes.get(3);
			org.activiti.bpmn.model.Process p = new org.activiti.bpmn.model.Process();
			model.addProcess(p);
			p.setId(process.getId());
			p.setName(process.getName());

			List<Activity> acts = process.getActivities();
			for (Iterator iterator2 = acts.iterator(); iterator2.hasNext();) {
				Activity activity = (Activity) iterator2.next();
				p.addFlowElement(transformXdplActivity(activity));
			}

			List<Transition> trns = process.getTransitions();
			for (Iterator iterator3 = trns.iterator(); iterator3.hasNext();) {
				Transition transition = (Transition) iterator3.next();
				SequenceFlow tr = (SequenceFlow) transformXdplTransition(transition);

				System.out.println(tr.getId() + "   " + tr.getSourceRef() + " "
						+ tr.getTargetRef());
				p.addFlowElement(tr);
			}

		}

		new BpmnAutoLayout(model).execute();
		System.out.println(model.getProcesses().size());
		BpmnXMLConverter converter = new BpmnXMLConverter();
		byte[] buffer = converter.convertToXML(model);

		// 7. Save resulting BPMN xml to a file
		InputStream processBpmn = new ByteArrayInputStream(buffer);
		//FileUtils.copyInputStreamToFile(processBpmn, new File("target/process.dweb.xml"));
		return processBpmn;
	}

	private FlowElement transformXdplTransition(Transition transition) {
		return createSequenceFlow(transition.getId(), transition.getFrom()
				.getId(), transition.getTo().getId());
	}

	private FlowElement transformXdplActivity(Activity activity) {
		FlowElement element = createTask("undef", "undef");
		System.out.println("activity " + activity.getId() + " "
				+ activity.getName() + "  " + activity.getType());
		switch (activity.getType().toString()) {
		case "Task":
			// System.out.println("activity "+activity.getId()+" "
			// +activity.getName()+
			// "  "+activity.getImplementation().getType());
			Task task = activity.getImplementation().getTask();
			//System.out.println("Task activity " + activity.getId() + " "
				//	+ activity.getName() + "  " + task.getType());
			switch (task.getType()) {
			case TaskUser:
				element = createUserTask(activity.getId(), activity.getName());
				break;

			case TaskScript:
				element = createScriptTask(activity.getId(), activity.getName());
				break;
			case TaskService:
				element = createServiceTask(activity.getId(),
						activity.getName());
				break;
			case TaskReceive:
				element = createReceiveTask(activity.getId(),
						activity.getName());
				break;
			case TaskSend:
				element = createSendTask(activity.getId(),
						activity.getName());
				break;				
			default:
				element = createTask(activity.getId(), activity.getName());
				break;
			}

			break;

		case "Event":
			//System.out
				//	.println("Event " + activity.getId() + " "
					//		+ activity.getName() + "  "
						//	+ activity.getEvent().getType());
			if (activity.isStartActivity())
				element = createStartEvent(activity.getId(), activity.getName());
			else if (activity.isEndActivity())
				element = createEndEvent(activity.getId(), activity.getName());
			else
				element = createEvent(activity.getId(), activity.getName());
			break;

		case "Route":
			//System.out.println("Route activity " + activity.getId() + " "
			//		+ activity.getName() + "   "
			//		+ activity.getRoute().getGatewayType());
			GatewayType gt = activity.getRoute().getGatewayType();
			switch (gt) {
			case Exclusive:
				element = createGatewayExclusive(activity.getId());
				break;
			case Parallel:
				element = createGatewayParallel(activity.getId());
				break;
			default:
				element = createGatewayExclusive(activity.getId());
				break;
			}
			break;

		case "SubFlow":
			element = createSubProcess(activity.getId(), activity.getName());
			break;
		case "No":
			element = createNoActivity(activity.getId(), activity.getName());
			break;
		default:
			System.out.println("default activity " + activity.getId() + " "
					+ activity.getName());
			element = createTask(activity.getId(), activity.getName());
			break;
		}

		System.out.println(element.getId()+" " +element.getName());

		return element;
	}

	//FIXME correct the NoActivity
	private FlowElement createNoActivity(String id, String name) {
		ManualTask act = new ManualTask();
		act.setId(id);
		act.setName(name);
		return act;
	}

	private FlowElement createGatewayExclusive(String id) {
		ExclusiveGateway g = new ExclusiveGateway();
		g.setId(id);
		return g;
	}
	private FlowElement createGatewayParallel(String id) {
		ParallelGateway g = new ParallelGateway();
		g.setId(id);
		return g;
	}

	private FlowElement createEvent(String id, String name) {
		
		ThrowEvent e = new ThrowEvent();
		e.setId(id);
		e.setName(name);
		return e;
	}

	private FlowElement createSubProcess(String id, String name) {
		SubProcess s = new SubProcess();
		s.setId(id);
		s.setName(name);
		System.out.println(s.getClass());
		return s;
	}

	private FlowElement createGateway(String id, String name) {
		Gateway g = new Gateway() {

			@Override
			public Gateway clone() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		g.setId(id);
		g.setName(name);
		return g;
	}

	protected org.activiti.bpmn.model.Task createTask(String id, String name) {
		org.activiti.bpmn.model.Task task = new org.activiti.bpmn.model.Task() {

			@Override
			public FlowElement clone() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		task.setName(name);
		task.setId(id);
		return task;
	}

	protected ReceiveTask createReceiveTask(String id, String name) {
		ReceiveTask task = new ReceiveTask();
		task.setName(name);
		task.setId(id);
		return task;
	}
	
	protected SendTask createSendTask(String id, String name) {
		SendTask task = new SendTask();
		task.setName(name);
		task.setId(id);
		return task;
	}
	
	protected UserTask createUserTask(String id, String name) {
		UserTask userTask = new UserTask();
		userTask.setName(name);
		userTask.setId(id);
		return userTask;
	}

	protected ScriptTask createScriptTask(String id, String name) {
		ScriptTask task = new ScriptTask();
		task.setName(name);
		task.setId(id);
		return task;
	}

	protected ServiceTask createServiceTask(String id, String name) {
		ServiceTask task = new ServiceTask();
		task.setName(name);
		task.setId(id);
		return task;
	}

	protected SequenceFlow createSequenceFlow(String id, String from, String to) {
		SequenceFlow flow = new SequenceFlow();
		flow.setId(id);
		flow.setSourceRef(from);
		flow.setTargetRef(to);
		return flow;
	}

	protected StartEvent createStartEvent(String id, String name) {
		StartEvent startEvent = new StartEvent();
		startEvent.setId(id);
		startEvent.setName(name);
		// startEvent.
		return startEvent;
	}

	protected EndEvent createEndEvent(String id, String name) {
		EndEvent endEvent = new EndEvent();
		endEvent.setId(id);
		endEvent.setName(name);
		return endEvent;
	}
}
