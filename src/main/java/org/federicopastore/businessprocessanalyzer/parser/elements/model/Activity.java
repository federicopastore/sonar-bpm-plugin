package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.impl.TransitionImpl;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.ActivityType;
/**
 * 
 * @author federicopastore
 *
 * Assignments A list of data field assignments. See section 7.1.6.
 * BlockActivity An Activity that executes an ActivitySet. See 7.6.3.
 * CompletionQuantity The default value is 1. The value MUST NOT be less than 1. This attribute defines the number
	of Tokens that must be generated from the activity. This number of Tokens will be sent down
	any outgoing Sequence Flow (assuming any Sequence Flow Conditions are satisfied).
 * Deadline Specification of a deadline and action to be taken if it is reached. It is better to use the BPMN timer event to provide this functionality.
 * Description Textual description of the activity.
 * Documentation The address (e.g. path- and filename) for a help file or a description file of the activity.
 * DataFields(Properties) Allows declaration of relevant data local to the activity. See section 7.12 .
 * Event See section 7.6.4.
 * ExtendedAttributes Optional extensions to meet individual implementation needs.
 * FinishMode Describes how the system operates at the end of the Activity.
 * Icon Alternative graphics for an icon to represent the activity in a graphical modeller. May be used to override the modeller icon for an activity. This may be deprecated in the future.
 * Id Used to identify the process activity.
 * Implementation A "regular" Activity. Mandatory if not a Route. Alternative implementations are “no”, “Task”, “SubFlow” or “Reference”.
 * InputSets See section 7.6.10.
 * IORules The IORules attribute is a collection of expressions, each of which specifies the required relationship between one input and one output. That is, if the activity is instantiated with a specified input, that activity shall complete with the specified output.
 * IsATransaction If the activity is a block activity or is implemented as a subflow IsATransaction determines whether or not the behavior of the Sub-Process will be treated as a Transaction.
 * IsForCompensation Default value: false.
 * Limit Expected duration for time management purposes (e.g. starting an escalation procedure etc.) in units of DurationUnit. It is counted from the starting date/time of the Process. The consequences of reaching the limit value are not defined in this document (i.e. vendor specific). Note that BPMN provides Timer Events which can be attached to the boundary of a regular or subflow/subprocess activity.
 * Loop See section 7.6.13.
 * Name Text Used to identify the process activity.
 * NodeGraphicsInfos Optional. See section 7.1.1.
 * Object See section 7.1.9.4.
 * OutputSets See section 7.6.11.
 * Performers List of Links to entity participants. Each Performer may be an expression. Default: Any Participant.
 * Priority A value that describes the initial priority of this activity when it starts execution. If this attribute is not defined but a priority is defined in the Process definition then that is used. By default it is assumed that the priority levels are the natural numbers starting with zero, and that the higher the value the higher the priority (i.e.: 0, 1,…, n).
 * Route A "dummy" Activity used for routing. A BPMN Gateway.
 * SimulationInformation Estimations for simulation of an Activity. No default. See section 7.6.8.
 * StartActivity Designates the first activity to be executed when the process is instantiated. Used when there is no other way to determine this. Conflicts with BPMN StartEvent and no process definition should contain both.
 * StartMode Describes how the execution of an Activity is triggered.
 * StartQuantity The default value is 1. The value MUST NOT be less than 1. This attribute defines the number of Tokens that must arrive before the activity can begin.
 * Status Status values are assigned during execution. Status can be treated as a property and used in expressions local to an Activity.
 * TransactionRef Editors note: are transactions reusable by multiple activities? Must be resolved in BPMN.
	If the IsATransaction attribute is False, then a Transaction MUST NOT be identified. If the IsATransaction attribute is True, then a Transaction MUST be identified. Note that Transactions that are in different Pools and are connected through Message Flow MUST have the same TransactionId. See section 7.6.12.
 * TransitionRestrictions Provides further restrictions and context-related semantics description of Transitions. All activities (including Gateways) with multiple outgoing transitions (sequence flow) must have a TransitionRestrictions Split element with a list of references to the outgoing transition elements. (See 7.6.9.2).
 *
 */
public interface Activity extends BaseXpdlElement{

	  public static enum JoinType {
	    AND, OR, XOR, COMPLEX
	  }

	  public static enum SplitType {
		  AND, OR, XOR, COMPLEX
	  }
/*
	  public static enum ActivityType {
		    None, Implemetation, Route, GateWay, Event, BlockActivity
		  }
*/	
	  public static enum ImplementationType {
	    None, Application, Task, SubFlow, SubProcess
	  }
	  /*
	  public static enum EventType {
		    StartEvent, IntermediateEvent, EndEvent
		  }
	  */
		public String getId();
		public String getName();
		public List<Assignment> getAssignments();
		public BlockActivity getBlockActivity();
		public String getCompletionQuantity();
		public String getDeadline();
		public String getDescription();
		public String getDocumentation();
		public List<DataField> getDataFields();
		public Event getEvent();
		public List<ExtendedAttribute> getExtendedAttributes();
		public String getFinishMode();
		public String getIcon();
		public Implementation getImplementation();
		public List<InputSet> getInputSets();
		public List<String> getIORules();
		public String getIsATransaction();
		public String getIsForCompensation();
		public String getLimit();
		public String getLoop();
		public List<NodeGraphicsInfo> getNodeGraphicsInfos();
		public Object getObject();
		public List<OutputSet> getOutputSets();
		public List<String> getPerformers();
		public String getPriority();
		public Route getRoute();
		public String getSimulationInformation();
		public String getStartMode();
		public String getStartQuantity();
		public String getStatus();
		public Route getTransitionRestrictions();
		public ActivityType getType();
		public WorkflowProcess getParentWorkFlow();
		public void addOutgoingTransition(Transition transition);
		public void addIngoingTransition(Transition transition);
		public boolean isStartActivity();
		public boolean isEndActivity();
		public List<Activity> next();
		public List<Activity> previous();
}
