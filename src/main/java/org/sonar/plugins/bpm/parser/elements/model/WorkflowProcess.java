/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sonar.api.measures.Measure;
import org.sonar.plugins.bpm.parser.xpdl.enums.ActivityType;
import org.sonar.plugins.bpm.parser.xpdl.enums.ProcessType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 * Class describing WorkflowProcess schema element.
 * 
 * 
 * AccessLevel The Access level of a process may be either PUBLIC or PRIVATE. If PUBLIC the
process may be invoked by an external system or application. A process with private
access may only be invoked from a SubFlow/subprocess Activity (see section
7.6.5.3.10). Use is optional and default is PUBLIC.

 * Activities A list of activities that comprise the process. See section 7.6.
 * ActivitySets A list of self contained sets of activities and transitions. Used to represent a BPMN
EmbeddedSubprocess and EventSubprocess.
 * AdHoc See section 7.5.9.
		Workflow Management Coalition Process Definition August 30, 2012
		Copyright  2012 The Workflow Management Coalition Page 61 of 155
 * Description
 * AdHocOrdering See section 7.5.9.
 * AdHocCompletionCondition See section 7.5.9.
 * Applications A list of Application Declarations. See section 7.3.
 * Assignments A list of data field assignments. See section 7.1.6.
 * DataAssociations A list of DataAssociation elements defined within the process.
 * DataFields A list of Relevant data fields defined for the process. See section 7.12.
 * DataObjects A list of DataObject elements defined within the process. See section 7.1.10.2
 * DefaultStartActivityId If present, DefaultStartActivityId must be the id of a start activity
 In the Default StartActivitySet if that’s present
 In the top level process activities otherwise
 * DefaultStartActivitySetId If present, DefaultStartActivitySetId must be the id of an Activity Set in the process.
 * EnableInstanceCompensation See section 7.5.8.
 * ExtendedAttributes Optional vendor-defined extensions to meet implementation needs. See section 7.1.1.
 * FormalParameters A list of parameters that may be passed to the process. See section 7.1.4.
 * Id Used to identify the process.
 * InputSets
(BPMN alternative to Formal
Parameters)
The InputSets attribute defines the data requirements for input to the Process. Zero or
more InputSets MAY be defined. Each Input set is sufficient to allow the Process to
be performed (if it has first been instantiated by the appropriate signal arriving from
an incoming Sequence Flow). See section 7.6.10.
 * Name Text Used to identify the process.
 * Object See section 7.1.9.4.
 * OutputSets
(BPMN alternative to Formal
Parameters)
The OutputSets attribute defines the data requirements for output from the Process.
Zero or more OutputSets MAY be defined. At the completion of the Process, only
one of the OutputSets may be produced. It is up to the implementation of the Process
to determine which set will be produced. However, the IORules attribute MAY
indicate a relationship between an OutputSet and an InputSet that started the
 * Process. See section 7.6.11.
 * Participants A list of resources used in implementing the process. See section 7.11.
 * PartnerLinks Partner links used by this process. See section 7.8.2.
 * ProcessHeader A set of elements specifying process characteristics.
 * ProcessType BPMN types: None, Private, Abstract, Collaboration. See section 7.5.5.
 * RedefinableHeader A set of elements and attributes used by both the Package and Process definitions.
 * Status See section 7.5.6.
 * SuppressJoinFailure See section 7.5.7.
 * Transitions A list of the transitions that connect the process activities. See section 7.7. 
 *
 */
public interface WorkflowProcess extends BaseXpdlElement {

	public ProcessType getProcessType();
	public String getId();
	public String getName();
	public List<Transition> getTransitions();
	public List<Activity> getActivities();
	public List<ActivitySet> getActivitySets();
	public String getDescription();
	public String getAdHocOrdering();
	public String getAdHocCompletionCondition();
	public List<Application> getApplications();
	public List<Assignment> getAssignments();
	public List<DataAssociation> getDataAssociations();
	public List<DataField> getDataFields();
	public List<DataObject> getDataObjects();
	public Activity getDefaultStartActivityId();
	public String getEnableInstanceCompensation();
	public ActivitySet getDefaultStartActivitySetId();
	public List<ExtendedAttribute> getExtendedAttributes();
	public List<FormalParameter> getFormalParameters();
	public List<InputSet> getInputSets();
	public Object getObject();
	public List<OutputSet> getOutputSets();
	public List<Participant> getParticipants();
	public List<PartnerLink> getPartnerLinks();
	public ProcessHeader getProcessHeader();
	public RedefinableHeader getRedefinableHeader();
	public String getStatus();
	public String getSuppressJoinFailure();
	public Activity getActivityById(String attributeValue);
	public ActivitySet getActivitySetById(String attributeValue);
	public Activity getStartActivity();
	public Collection<Activity> getActivitiesbyType(ActivityType type);
	public Collection<Activity> getActvitiesbyTaskImplementationType(TaskImplementationType type);
}

