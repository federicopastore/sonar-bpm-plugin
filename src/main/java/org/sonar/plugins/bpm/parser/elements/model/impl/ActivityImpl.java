package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.Assignment;
import org.sonar.plugins.bpm.parser.elements.model.BlockActivity;
import org.sonar.plugins.bpm.parser.elements.model.DataField;
import org.sonar.plugins.bpm.parser.elements.model.Event;
import org.sonar.plugins.bpm.parser.elements.model.ExtendedAttribute;
import org.sonar.plugins.bpm.parser.elements.model.Implementation;
import org.sonar.plugins.bpm.parser.elements.model.InputSet;
import org.sonar.plugins.bpm.parser.elements.model.OutputSet;
import org.sonar.plugins.bpm.parser.elements.model.Route;
import org.sonar.plugins.bpm.parser.elements.model.SubFlow;
import org.sonar.plugins.bpm.parser.elements.model.Transition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;
import org.sonar.plugins.bpm.parser.xpdl.enums.ActivityType;

public class ActivityImpl extends ElementParser implements Activity {

	private List<Assignment> assignments;
	private ActivityType type;
	private Event event;
	private Implementation implementation;
	private BlockActivity blockActivity;
	private WorkflowProcessImpl parent;
	private Route route;
	private List<Transition> outgoingTransitions;
	private List<Transition> ingoingTransitions;

	public ActivityImpl(Element activity, WorkflowProcessImpl parent) {
		super(activity);
		checkForAssignments();
		this.type = ActivityType.No;
		this.checkForEvent();
		this.checkForImplementation();
		this.checkForRoute();
		//this.blockActivity= new BlockActivityImpl(activity);
		this.parent= parent;
		this.ingoingTransitions = new ArrayList<Transition>();
		this.outgoingTransitions = new ArrayList<Transition>();
	}


	@Override
	public ActivityType getType() {
		return type;
	}

	@Override
	public List<Assignment> getAssignments() {
		List attrs = getChildWithName("Assignments").getChildren();
		for (Iterator iterator = attrs.iterator(); iterator.hasNext();) {
			Element assign = (Element) iterator.next();
			AssignmentImpl assignment = new AssignmentImpl(assign);
			assignments.add(assignment);
		}
		return assignments;
	}

	private void checkForAssignments() {
		assignments = new ArrayList<Assignment>();
		Element assigns = getChildWithName("Assignments");
		if (assigns != null) {
			List attrs = getChildWithName("Assignments").getChildren();
			for (Iterator iterator = attrs.iterator(); iterator.hasNext();) {
				Element assign = (Element) iterator.next();
				AssignmentImpl assignment = new AssignmentImpl(assign);
				assignments.add(assignment);
			}
		}
	}

	@Override
	public BlockActivity getBlockActivity() {
		return this.blockActivity;
	}

	@Override
	public String getCompletionQuantity() {
		return getCurrentElement().getAttributeValue("CompletionQuantity");
	}

	@Override
	public String getDeadline() {
		return getCurrentElement().getAttributeValue("Deadline");
	}

	@Override
	public List<DataField> getDataFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getEvent() {
		return this.event;
	}

	private void checkForEvent() {
		Event evt = null;
		Element evtElem = getChildWithName("Event");
		if (evtElem != null) {
			this.type = ActivityType.Event;
			List<Element> eventsList = evtElem.getChildren();
			Element evtTypeElem = eventsList.get(0);
			String evtType = evtTypeElem.getName();
			switch (evtType) {
			case "StartEvent":
				evt = new StartEvent(evtTypeElem);
				break;
			case "IntermediateEvent":
				evt = new IntermediateEvent(evtTypeElem);
				break;
			case "EndEvent":
				evt = new EndEvent(evtTypeElem);
				break;

			default:
				break;
			}
		}
		this.event = evt;
	}

	@Override
	public List<ExtendedAttribute> getExtendedAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFinishMode() {
		return getCurrentElement().getAttributeValue("FinishMode");
	}

	@Override
	public String getIcon() {
		return getCurrentElement().getAttributeValue("Icon");
	}

	@Override
	public Implementation getImplementation() {
		return this.implementation;
	}

	private void checkForImplementation() {
		Implementation impl = null;
		Element implElem = getChildWithName("Implementation");
		if (implElem != null) {
			List<Element> implList = implElem.getChildren();
			Element implTypeElem = implList.get(0);
			String implType = implTypeElem.getName();
			switch (implType) {
			case "Task":
				this.type = ActivityType.Task;
				Element taskelem = (Element) implTypeElem.getChildren().get(0);
				String taskType = taskelem.getName();
				//System.out.println("questo è "+taskType);
				switch (taskType) {
				case "TaskUser":
					//System.out.println("questo è task utente");
					impl = new ImplementationImpl(
							new TaskUser(taskelem),
							org.sonar.plugins.bpm.parser.xpdl.enums.ImplementationType.Task);
					break;
				case "TaskService":
					impl = new ImplementationImpl(
							new TaskService(taskelem),
							org.sonar.plugins.bpm.parser.xpdl.enums.ImplementationType.Task);
					break;
				case "TaskScript":
					impl = new ImplementationImpl(
							new TaskScript(taskelem),
							org.sonar.plugins.bpm.parser.xpdl.enums.ImplementationType.Task);
					break;
				case "TaskSend":
					impl = new ImplementationImpl(
							new TaskSendImpl(taskelem),
							org.sonar.plugins.bpm.parser.xpdl.enums.ImplementationType.Task);
					break;
				case "TaskReceive":
					impl = new ImplementationImpl(
							new TaskReceive(taskelem),
							org.sonar.plugins.bpm.parser.xpdl.enums.ImplementationType.Task);
					break;
				default:
					break;
				}

				break;
			case "SubFlow":
				this.type = ActivityType.SubFlow;
				SubFlow subflow = new SubFlowImpl(implTypeElem, this);
				impl = new ImplementationImpl(subflow, org.sonar.plugins.bpm.parser.xpdl.enums.ImplementationType.SubFlow);
				break;
			default:
				break;
			}
		}
		this.implementation = impl;
	}

	@Override
	public List<InputSet> getInputSets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getIORules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIsATransaction() {
		return getCurrentElement().getAttributeValue("IsATransaction");
	}

	@Override
	public String getIsForCompensation() {
		return getCurrentElement().getAttributeValue("IsForCompensation");
	}

	@Override
	public String getLimit() {
		return getCurrentElement().getAttributeValue("Limit");
	}

	@Override
	public String getLoop() {
		return getCurrentElement().getAttributeValue("Loop");
	}

	@Override
	public List<OutputSet> getOutputSets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPerformers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPriority() {
		return getCurrentElement().getAttributeValue("Priority");
	}

	private void checkForRoute(){
		Element child = getChildWithName("Route");
		if(child !=null){
			route = new RouteImpl(child);
			this.type= ActivityType.Route;
		}
	}
	
	@Override
	public Route getRoute() {
		return this.route;
	}

	@Override
	public String getSimulationInformation() {
		return getCurrentElement().getAttributeValue("SimulationInformation");
	}

	@Override
	public String getStartMode() {
		return getCurrentElement().getAttributeValue("StartMode");
	}

	@Override
	public String getStartQuantity() {
		return getCurrentElement().getAttributeValue("StartQuantity");
	}

	@Override
	public String getStatus() {
		return getCurrentElement().getAttributeValue("StartQuantity");
	}

	@Override
	public Route getTransitionRestrictions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkflowProcess getParentWorkFlow() {
		return this.parent;
	}

	@Override
	public void addOutgoingTransition(Transition transition) {
		this.outgoingTransitions.add(transition);
	}

	@Override
	public void addIngoingTransition(Transition transition) {
		this.ingoingTransitions.add(transition);	
	}

	@Override
	public boolean isStartActivity() {
		return this.ingoingTransitions.size() ==0;
	}

	@Override
	public boolean isEndActivity() {
		return this.outgoingTransitions.size() ==0;
	}

	@Override
	public List<Activity> next() {
		List<Activity> list = new ArrayList<Activity>();
		for (Iterator iterator = outgoingTransitions.iterator(); iterator.hasNext();) {
			Transition trns = (Transition) iterator.next();
			list.add(trns.getTo());
		}
		return list;
	}

	@Override
	public List<Activity> previous() {
		List<Activity> list = new ArrayList<Activity>();
		for (Iterator iterator = outgoingTransitions.iterator(); iterator.hasNext();) {
			Transition trns = (Transition) iterator.next();
			list.add(trns.getTo());
		}
		return list;
	}

}
