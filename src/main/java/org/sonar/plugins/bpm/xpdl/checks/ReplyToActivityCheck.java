/**
 * 
 */
package org.sonar.plugins.bpm.xpdl.checks;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.Event;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.TaskSend;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;
import org.sonar.plugins.bpm.parser.xpdl.enums.ActivityType;
import org.sonar.plugins.bpm.parser.xpdl.enums.EventType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TriggerType;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

/**
 * @author federicopastore
 *
 */
@Rule(
		name="Reply To Activity Check", 
		description="this TIBCO directive is avoided because can generate CLOSE_WAIT issues on threads. this issue can block entire BPM Engine",
		key="org.sonar.plugins.bpm.xpdl.checks.ReplyToActivityCheck"
		)
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.FAULT_TOLERANCE)
@SqaleConstantRemediation("15min")
public class ReplyToActivityCheck extends AbstractXpdlCheck {
    public static final String RULE_KEY = "org.sonar.plugins.bpm.xpdl.checks.ReplyToActivityCheck";
    private final RuleKey ruleKey = RuleKey.of(XpdlLanguage.KEY, RULE_KEY);
	
    @RuleProperty(key = "message", defaultValue = "The activity \"{0}\" contains a reply to \"{1}\". This directive MUST be AVOIDED because can produce CLOSE_WAIT issue")
    private String message;
	public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
	/* (non-Javadoc)
	 * @see org.sonar.plugins.bpm.xpdl.checks.AbstractXpdlCheck#validate(org.sonar.plugins.bpm.xpdl.checks.XpdlSourceCode)
	 */
	@Override
	public void validate(XpdlSourceCode xpdlSourceCode) {
		setWebSourceCode(xpdlSourceCode);
        PackageDefinition model = xpdlSourceCode.getModel();
        List<WorkflowProcess> processes =model.getProcesses();
        for (Iterator iterator = processes.iterator(); iterator.hasNext();) {
			WorkflowProcess workflowProcess = (WorkflowProcess) iterator.next();
			Collection<Activity> acts =workflowProcess.getActvitiesbyTaskImplementationType(TaskImplementationType.TaskSend);
			for (Iterator iterator2 = acts.iterator(); iterator2.hasNext();) {
				Activity activity = (Activity) iterator2.next();
				TaskSend t =(TaskSend) activity.getImplementation().getTask();
				if(!t.getExtendedAttributeValue("ReplyToActivityId").isEmpty())
					createViolation(t.getStartLineNumber(), 
							MessageFormat.format(message,activity.getName(),workflowProcess.getActivityById(t.getExtendedAttributeValue("ReplyToActivityId")).getName())
									);
			}
			//xpdExt:ReplyToActivityId
			Collection<Activity> events =workflowProcess.getActivitiesbyType(ActivityType.Event);
			for (Iterator iterator3 = events.iterator(); iterator3.hasNext();) {
				Activity activity = (Activity) iterator3.next();
				Event ev =(Event) activity.getEvent();
				if(ev.getType() == EventType.EndEvent || ev.getType() == EventType.IntermediateEvent){
				if(ev.getTrigger() == TriggerType.Message && ev.getTriggerResultMessage()!=null)
					if(!ev.getTriggerResultMessage().getExtendedAttributeValue("ReplyToActivityId").isEmpty())
					createViolation(ev.getTriggerResultMessage().getStartLineNumber(), 
							MessageFormat.format(message,activity.getName(),workflowProcess.getActivityById(ev.getTriggerResultMessage().getExtendedAttributeValue("ReplyToActivityId")).getName())
									);
				}
			}
		}
	}

}
