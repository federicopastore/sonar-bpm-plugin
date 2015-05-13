/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;

/**
 * @author federicopastore
 * 
 * Activities A list of activities that comprise the process. See section 7.6.
 * AdHoc See section 7.5.9.
 * AdHocOrdering See section 7.5.9.
 * AdHocCompletionCondition See section 7.5.9.
 * DataAssociations. To support BPMN2.0.
 * DataObjects To Support BPMN2.0. See section 7.1.10.2
 * DefaultStartActivityId Unless otherwise specified in the ActivitySet invocation (BlockActivity 7.6.3), this is where the activity set will start executing.
	If present, it must be the id of a start activity in the activity set.
	If not present it is assumed the activity set contains exactly one start activity.
 * Id Used to identify the process.
 * Name Name of the activity set/embedded sub-process.
 * Object See section 7.1.9.4.
 * Transitions A list of the transitions that connect the process activities. See section 7.7.
 * Triggered by Event If true indicates that it is a BPMN2.0 Event Sub-Process.
 */
public interface ActivitySet extends BaseXpdlElement{
	public List<Activity> getActivities();
	public String getAdHoc();
	public String getAdHocOrdering();
	public String getAdHocCompletionCondition();
	public List<DataAssociation> getDataAssociations();
	public List<DataObject> getDataObjects();
	public Activity getDefaultStartActivityId();
	public String getId();
	public String getName();
	public Object getObject();
	public List<Transition> getTransitions();
	public boolean getTriggeredByEvent();
}
