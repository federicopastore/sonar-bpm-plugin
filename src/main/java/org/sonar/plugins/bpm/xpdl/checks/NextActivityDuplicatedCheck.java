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
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;
import org.sonar.plugins.bpm.parser.xpdl.enums.ActivityType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

/**
 * @author federicopastore
 * 
 */
@Rule(name = "Next Activity Duplicated Check", description = "Checks if next activity is of same type. Examine if you can aggregate into one same sequential activity", key = "org.sonar.plugins.bpm.xpdl.checks.NextActivityDuplicatedCheck")
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.EFFICIENCY_COMPLIANCE)
@SqaleConstantRemediation("15min")
public class NextActivityDuplicatedCheck extends AbstractXpdlCheck {
	public static final String RULE_KEY = "org.sonar.plugins.bpm.xpdl.checks.NextActivityDuplicatedCheck";
	private final RuleKey ruleKey = RuleKey.of(XpdlLanguage.KEY, RULE_KEY);

	@RuleProperty(key = "message", defaultValue = "the activity task \"{0}\" is of same type of current \"{1}\". Examine if you can aggregate into one")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.
	 * AbstractXpdlCheck
	 * #validate(org.federicopastore.businessprocessanalyzer.sonarqube
	 * .xpdl.checks.XpdlSourceCode)
	 */
	@Override
	public void validate(XpdlSourceCode xpdlSourceCode) {
		// System.out.println("validating for rule: "+RULE_KEY);
		setWebSourceCode(xpdlSourceCode);
		PackageDefinition model = xpdlSourceCode.getModel();
		List<WorkflowProcess> processes = model.getProcesses();
		for (Iterator iterator = processes.iterator(); iterator.hasNext();) {
			WorkflowProcess process = (WorkflowProcess) iterator.next();
			Collection<Activity> tasks = process.getActivities();
			for (Iterator<Activity> iterator2 = tasks.iterator(); iterator2
					.hasNext();) {
				Activity activity = iterator2.next();
				switch (activity.getType()) {
				case Event:
					/*if (activity.next().size() == 1
							&& activity.next()
							.get(0).getType() == ActivityType.Event
							&& activity.getEvent().getType() == activity.next()
									.get(0).getEvent().getType())
						createViolation(
								activity.getStartLineNumber(),
								MessageFormat.format(message,
										activity.getName(), activity.next()
												.get(0).getName()));*/
					break;
				case Task:
					if (activity.next().size() == 1
							&& activity.getType() == activity.next().get(0)
									.getType()
							&& activity.getImplementation().getTask().getType() == activity.next().get(0).getImplementation().getTask().getType()
							&& (
									activity.getImplementation().getTask().getType() ==TaskImplementationType.TaskService
								||	activity.getImplementation().getTask().getType() ==TaskImplementationType.TaskScript
									
								)
							){
						
						createViolation(
								activity.getStartLineNumber(),
								MessageFormat.format(message,
										activity.getName(), activity.next()
												.get(0).getName()));
						}
					break;
				case Route:
					if (activity.next().size() == 1
							&& activity.getType() == activity.next().get(0)
									.getType()
							&& activity.getRoute().getGatewayType() == activity
									.next().get(0).getRoute().getGatewayType())
						createViolation(
								activity.getStartLineNumber(),
								MessageFormat.format(message,
										activity.getName(), activity.next()
												.get(0).getName()));
					break;
				case SubFlow:
					/*if (activity.next().size() == 1) {
						if (activity.next().get(0).getType() == ActivityType.SubFlow)
							createViolation(
									activity.getStartLineNumber(),
									MessageFormat.format(message,
											activity.getName(), activity.next()
													.get(0).getName()));
					}*/
					break;
				default:
					break;
				}

				/*
				 * if (element.getImplementation()!=null &&
				 * element.getImplementation().getType()
				 * .equals(ImplementationType.Task)) {
				 * 
				 * if (!element.getImplementation().getTask().getType()
				 * .equals(TaskImplementationType.TaskUser) ||
				 * !element.getImplementation().getTask().getType()
				 * .equals(TaskImplementationType.TaskReceive)) { if
				 * (element.next().size() == 1 && element.getType().equals(
				 * element.next().get(0).getType()))
				 * createViolation(element.getStartLineNumber(),
				 * MessageFormat.format
				 * (message,element.getName(),element.next().get(0).getName())
				 * ); }
				 */
			}
		}
	}

}
