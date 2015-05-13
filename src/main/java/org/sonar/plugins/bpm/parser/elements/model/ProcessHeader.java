/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.Date;

/**
 * @author federicopastore
 * 
 * Created Creation date of process definition.
 * Description Short textual description of the process.
 * Duration Expected duration time to perform a task in units of DurationUnit.
 * DurationUnit Describes the default unit to be applied to an integer duration value that has no unit tag. Possible units are:
	Y - year
	M - month
	D - day
	H - hour
	m - minute
	s – second
 * Limit Expected duration for time management purposes (e.g. starting an escalation procedure etc.) in units of DurationUnit. It is counted from the starting date/time of the Process. The consequences of reaching the limit value are not defined in this document (i.e. vendor specific).
 * Priority The priority of the process type. The units are defined in the Package header priority units.
 * TimeEstimation Grouping of waiting time, working time, and duration. Used for simulation purposes.
 * ValidFrom The date that the process definition is active from. Empty string means system date. Default: Inherited from Model Definition.
 * ValidTo The date at which the process definition becomes valid. Empty string means unlimited validity. Default: Inherited from Model Definition.
 * WaitingTime Describes the amount of time, which is needed to prepare the performance of the task (time estimation) (waiting time is provided by the analysis environment and may be updated by the runtime environment) in units of DurationUnit.
 * WorkingTime Describes the amount of time the performer of the activity needs to perform the task (time estimation) (working time is needed for analysis purposes and is provided by the evaluation of runtime parameters) in units of DurationUnit.
 */
public interface ProcessHeader extends BaseXpdlElement {

	public Date getCreated();
	public String getDescription();
	public long getDuration();
	public String getDurationUnit();
	public long getLimit();
	public String getPriority();
	public String getTimeEstimation();
	public Date getValidFrom();
	public Date getValidTo();
	public long getWaitingTime();
	public long getWorkingTime();
}
