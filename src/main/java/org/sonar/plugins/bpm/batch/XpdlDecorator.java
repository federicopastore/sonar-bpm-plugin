/**
 * 
 */
package org.sonar.plugins.bpm.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.jdom.JDOMException;
import org.sonar.api.batch.Decorator;
import org.sonar.api.batch.DecoratorContext;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.MeasureUtils;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;
import org.sonar.api.resources.ResourceUtils;
import org.sonar.api.resources.Scopes;
import org.sonar.api.scan.filesystem.ModuleFileSystem;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.metrics.ProcessMetrics;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;
import org.sonar.plugins.bpm.parser.xpdl.XpdlParser;
import org.sonar.plugins.bpm.parser.xpdl.enums.ActivityType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 *
 */
public class XpdlDecorator implements Decorator {

	private ModuleFileSystem mfs;

	public XpdlDecorator(ModuleFileSystem mfs){
		this.mfs = mfs;
		
	}
	/* (non-Javadoc)
	 * @see org.sonar.api.batch.CheckProject#shouldExecuteOnProject(org.sonar.api.resources.Project)
	 */
	@Override
	public boolean shouldExecuteOnProject(Project project) {
		//project.getFileSystem().
		//System.out.println("XPDL shouldExecuteOnProject called on "+project.getName() +" for "+project.getLanguageKey());
		return StringUtils.equals(project.getLanguageKey(), XpdlLanguage.KEY);
	}

	/* (non-Javadoc)
	 * @see org.sonar.api.batch.Decorator#decorate(org.sonar.api.resources.Resource, org.sonar.api.batch.DecoratorContext)
	 */
	@Override
	public void decorate(Resource resource, DecoratorContext context) {
		//System.out.println("XPDL Decorator called on "+resource.getName());
		//System.out.println("Scope " +resource.getScope());
		// This method is executed on the whole tree of resources.
        // Bottom-up navigation : Java methods -&amp;amp;amp;gt; Java classes -&amp;amp;amp;gt; files -&amp;amp;amp;gt; packages -&amp;amp;amp;gt; modules -&amp;amp;amp;gt; project
		switch (resource.getScope()) {
		case "PRJ":
			context.saveMeasure(ProcessMetrics.PROCESSES, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.PROCESSES_ON_PKG)));
			context.saveMeasure(ProcessMetrics.ACTIVITIES_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.ACTIVITIES_ON_PKG)));
			context.saveMeasure(ProcessMetrics.TASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.TASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.EVENTS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.EVENTS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.ROUTES_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.ROUTES_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SUBFLOWS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SUBFLOWS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.NO_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.NO_ON_PKG)));
			context.saveMeasure(ProcessMetrics.REFERENCE, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.REFERENCE)));
			//Tasks
			context.saveMeasure(ProcessMetrics.USERTASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.USERTASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SERVICETASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SERVICETASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SENDTASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SENDTASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.RECEIVETASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.RECEIVETASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SCRIPTTASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SCRIPTTASKS_ON_PKG)));
			break;
			
		case "DIR":
			context.saveMeasure(ProcessMetrics.PROCESSES, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.PROCESSES_ON_PKG)));
			context.saveMeasure(ProcessMetrics.ACTIVITIES_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.ACTIVITIES_ON_PKG)));
			context.saveMeasure(ProcessMetrics.TASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.TASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.EVENTS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.EVENTS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.ROUTES_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.ROUTES_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SUBFLOWS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SUBFLOWS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.NO_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.NO_ON_PKG)));
			context.saveMeasure(ProcessMetrics.REFERENCE, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.REFERENCE)));
			
			//Tasks
			context.saveMeasure(ProcessMetrics.USERTASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.USERTASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SERVICETASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SERVICETASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SENDTASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SENDTASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.RECEIVETASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.RECEIVETASKS_ON_PKG)));
			context.saveMeasure(ProcessMetrics.SCRIPTTASKS_ON_PKG, MeasureUtils.sum(true, context.getChildrenMeasures(ProcessMetrics.SCRIPTTASKS_ON_PKG)));
			break;
			
		case "FIL":
			File ResourceFile = new File(this.mfs.baseDir(), resource.getLongName());
			XpdlParser parser = new XpdlParser();
			try {
				PackageDefinition pkg = parser.parse(new FileInputStream(ResourceFile));
				context.saveMeasure(ProcessMetrics.PROCESSES_ON_PKG, new Double(pkg.getProcesses().size()).doubleValue());
				int tot_activities=0;
				int tot_tasks =0;
				int tot_events = 0;
				int tot_routes=0;
				int tot_subflows=0;
				int tot_no=0;
				int tot_reference = 0;
				int tot_tasks_user=0;
				int tot_tasks_service=0;
				int tot_tasks_send = 0;
				int tot_tasks_receive=0;
				int tot_tasks_script=0;
				for (int i = 0; i < pkg.getProcesses().size(); i++) {
					WorkflowProcess process = pkg.getProcesses().get(i);
					tot_activities +=process.getActivities().size();
					tot_tasks += process.getActivitiesbyType(ActivityType.Task).size();
					tot_events +=process.getActivitiesbyType(ActivityType.Event).size();
					tot_routes +=process.getActivitiesbyType(ActivityType.Route).size();
					tot_subflows +=process.getActivitiesbyType(ActivityType.SubFlow).size();
					tot_no +=process.getActivitiesbyType(ActivityType.No).size();
					tot_reference +=process.getActivitiesbyType(ActivityType.Reference).size();
					tot_tasks_user+= process.getActvitiesbyTaskImplementationType(TaskImplementationType.TaskUser).size();
					tot_tasks_service+= process.getActvitiesbyTaskImplementationType(TaskImplementationType.TaskService).size();
					tot_tasks_send+= process.getActvitiesbyTaskImplementationType(TaskImplementationType.TaskSend).size();
					tot_tasks_receive+= process.getActvitiesbyTaskImplementationType(TaskImplementationType.TaskReceive).size();
					tot_tasks_script+= process.getActvitiesbyTaskImplementationType(TaskImplementationType.TaskScript).size();
				}
				//activities
				context.saveMeasure(ProcessMetrics.ACTIVITIES_ON_PKG, new Double(tot_activities).doubleValue());
				context.saveMeasure(ProcessMetrics.TASKS_ON_PKG, new Double(tot_tasks).doubleValue());
				context.saveMeasure(ProcessMetrics.EVENTS_ON_PKG, new Double(tot_events).doubleValue());
				context.saveMeasure(ProcessMetrics.ROUTES_ON_PKG, new Double(tot_routes).doubleValue());
				context.saveMeasure(ProcessMetrics.SUBFLOWS_ON_PKG, new Double(tot_subflows).doubleValue());
				context.saveMeasure(ProcessMetrics.NO_ON_PKG, new Double(tot_no).doubleValue());
				context.saveMeasure(ProcessMetrics.REFERENCE, new Double(tot_reference).doubleValue());
				//Tasks
				context.saveMeasure(ProcessMetrics.USERTASKS_ON_PKG, new Double(tot_tasks_user).doubleValue());
				context.saveMeasure(ProcessMetrics.SERVICETASKS_ON_PKG, new Double(tot_tasks_service).doubleValue());
				context.saveMeasure(ProcessMetrics.SENDTASKS_ON_PKG, new Double(tot_tasks_send).doubleValue());
				context.saveMeasure(ProcessMetrics.RECEIVETASKS_ON_PKG, new Double(tot_tasks_receive).doubleValue());
				context.saveMeasure(ProcessMetrics.SCRIPTTASKS_ON_PKG, new Double(tot_tasks_script).doubleValue());
			} catch ( JDOMException | IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		

	}

}
