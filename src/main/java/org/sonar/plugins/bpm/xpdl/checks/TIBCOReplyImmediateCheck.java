/**
 * 
 */
package org.sonar.plugins.bpm.xpdl.checks;

import java.text.MessageFormat;
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
import org.sonar.plugins.bpm.parser.xpdl.enums.TriggerType;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

/**
 * @author federicopastore
 * 
 */
@Rule(name = "TIBCO Reply Immediate Check", description = "Checks if StartEvent task have a reply immediate directive", key = "org.sonar.plugins.bpm.xpdl.checks.TIBCOReplyImmediateCheck")
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.EFFICIENCY_COMPLIANCE)
@SqaleConstantRemediation("15min")
public class TIBCOReplyImmediateCheck extends AbstractXpdlCheck {

	public static final String RULE_KEY = "org.sonar.plugins.bpm.xpdl.checks.TIBCOReplyImmediateCheck";
	private final RuleKey ruleKey = RuleKey.of(XpdlLanguage.KEY, RULE_KEY);

	@RuleProperty(key = "message", defaultValue = "The start event activity \"{0}\" doesn't contains reply immediate directive. This directive must be used to speed up process response")
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
	 * @see
	 * org.sonar.plugins.bpm.xpdl.checks.AbstractXpdlCheck#validate(org.sonar
	 * .plugins.bpm.xpdl.checks.XpdlSourceCode)
	 */
	@Override
	public void validate(XpdlSourceCode xpdlSourceCode) {
		setWebSourceCode(xpdlSourceCode);
		PackageDefinition model = xpdlSourceCode.getModel();
		List<WorkflowProcess> processes = model.getProcesses();
		for (Iterator iterator = processes.iterator(); iterator.hasNext();) {
			WorkflowProcess workflowProcess = (WorkflowProcess) iterator.next();
			Activity startEvent = workflowProcess.getStartActivity();
			if (startEvent!=null && startEvent.getEvent()!=null && startEvent.getEvent().getTrigger() == TriggerType.Message) {
				try {
					boolean replyImmediate = startEvent.getEvent()
							.getTriggerResultMessage().getTibcoReplyImmediate();
					if (!replyImmediate) {
						createViolation(
								startEvent.getStartLineNumber(),
								MessageFormat.format(message,
										startEvent.getName()));
					}
				} catch (NullPointerException npe) {
					createViolation(startEvent.getStartLineNumber(),
							MessageFormat.format(message, startEvent.getName()));
				}
			}
		}
	}

}
