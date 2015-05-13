/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import org.sonar.plugins.bpm.parser.xpdl.enums.EventType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TriggerType;

/**
 * @author federicopastore
 *
 * Implementation
x
X
WebService | Other | Unspecified
Interrupting
x
x
x
Indicates whether event interrupts process
Name
See section 7.6.4.5.4.
Message
x
X
x
See section 7.9.4.
SubFlow/ProcessRef
See section 7.6.4.5.4.
Result
x
See section 7.6.4.4.5.
TriggerResultCompensation
x
X
x
See section 7.6.4.5.1.
ResultError
x
X
x
See section 7.6.4.5.2.
ResultMultiple
x
See section 7.6.4.5.3.
ConditionName
x
x
See section 7.6.4.5.10.
Target
X
A Target MAY be included for the Intermediate Event. The Target MUST be an activity. This means that the Intermediate Event is attached to the boundary of the activity and is used to signify an exception or compensation for that activity. See section 7.6.4.3.
TimeCycle
x
x
See section 7.6.4.5.11.
TimeDate
x
x
See section 7.6.4.5.11.
Trigger
x
X
TriggerIntermediateMultiple
X
See section 7.6.4.5.8.
TriggerMultiple
x
See section 7.6.4.5.9.
TriggerResultLink
X
See section 7.6.4.5.4.
TriggerResultMessage
x
X
x
See section 7.6.4.5.5.
TriggerResultCancel
X
x
TriggerResultSignal
x
X
x
See section 7.6.4.5.7.
TriggerConditional
x
X
See section 7.6.4.5.10.
TriggerTimer
x
X
See section 7.6.4.5.11.
WebService
x
X
x
See section 7.9.6.
 */
public interface Event extends BaseXpdlElement {

	public static enum ImplementationType{
		WebService , Other , Unspecified
	}
	/*
	public static enum TriggerType{
		None, Message, Timer, Error, Escalation, Compensation, Conditional, Signal, Multiple, ParallelMultiple
	}*/
	public Activity getActivity();
	public String getErrorCode();
	public boolean getInterrupting();
	public EventType getType();
	public String getName();
	public Message getMessage();
	public String getResult();
	public String getTriggerResultCompensation();
	public String getTriggerMultiple();
	public TriggerResultMessage getTriggerResultMessage();
	public String getResultError();
	public String getResultMultiple();
	public String getTriggerConditional();
	public String getTriggerResultSignal();
	public String getTriggerTimer();
	public String getConditionName();
	public Activity getTarget();
	public String getTimeCycle();
	public String getTimeDate();
	public TriggerType getTrigger();
	
	
}
