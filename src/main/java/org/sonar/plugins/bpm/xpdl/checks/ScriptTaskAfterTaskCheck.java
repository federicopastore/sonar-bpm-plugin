/**
 * 
 */
package org.sonar.plugins.bpm.xpdl.checks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.sonar.api.rule.RuleKey;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;
import org.sonar.plugins.bpm.parser.elements.model.Activity.ImplementationType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;
import org.sonar.plugins.bpm.xpdl.checks.AbstractXpdlCheck;
import org.sonar.plugins.bpm.xpdl.checks.XpdlSourceCode;

/**
 * @author federicopastore
 *
 */
@Rule(name = "ScriptTask After Task Check", description = "Checks Script task presence after an activity with type TaskService or TaskUser. Examine if you can embed into previous task the script logic", key = "org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.ScriptTaskAfterTaskCheck")

public class ScriptTaskAfterTaskCheck extends AbstractXpdlCheck {

	public static final String RULE_KEY = "org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.ScriptTaskAfterTaskCheck";
	private final RuleKey ruleKey = RuleKey.of(XpdlLanguage.KEY,
			RULE_KEY);

	@RuleProperty(key = "message", defaultValue = "Examine if you can embed into previous task the script logic")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.AbstractXpdlCheck#validate(org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.XpdlSourceCode)
	 */
	@Override
	public void validate(XpdlSourceCode xpdlSourceCode) {
		System.out.println("validating for rule: "+RULE_KEY);
		setWebSourceCode(xpdlSourceCode);
		PackageDefinition model = xpdlSourceCode.getModel();
		List<WorkflowProcess> processes = model.getProcesses();
		for (Iterator iterator = processes.iterator(); iterator.hasNext();) {
			WorkflowProcess process = (WorkflowProcess) iterator.next();
			Collection<Activity> tasks = process.getActivities();
			for (Iterator<Activity> iterator2 = tasks.iterator(); iterator2
					.hasNext();) {
				Activity element = iterator2.next();
				
				if (element.getImplementation()!=null && element.getImplementation().getType().toString()
						 == ImplementationType.Task.toString()) {

					if (element.next().size() == 1
							&& element.next().get(0).getImplementation()!=null
							&& element.next().get(0).getImplementation().getTask()!=null
							&& element.next().get(0).getImplementation().getTask().getType().equals(TaskImplementationType.TaskScript))
							createViolation(element.getStartLineNumber(),
									message);
				}
			}
		}

	}

}
