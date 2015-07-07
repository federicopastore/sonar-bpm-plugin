/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.ArrayStack;
import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.ActivitySet;
import org.sonar.plugins.bpm.parser.elements.model.Application;
import org.sonar.plugins.bpm.parser.elements.model.Assignment;
import org.sonar.plugins.bpm.parser.elements.model.ComplexityAlgorithm;
import org.sonar.plugins.bpm.parser.elements.model.DataAssociation;
import org.sonar.plugins.bpm.parser.elements.model.DataField;
import org.sonar.plugins.bpm.parser.elements.model.DataObject;
import org.sonar.plugins.bpm.parser.elements.model.ExtendedAttribute;
import org.sonar.plugins.bpm.parser.elements.model.FormalParameter;
import org.sonar.plugins.bpm.parser.elements.model.InputSet;
import org.sonar.plugins.bpm.parser.elements.model.OutputSet;
import org.sonar.plugins.bpm.parser.elements.model.Participant;
import org.sonar.plugins.bpm.parser.elements.model.PartnerLink;
import org.sonar.plugins.bpm.parser.elements.model.ProcessHeader;
import org.sonar.plugins.bpm.parser.elements.model.RedefinableHeader;
import org.sonar.plugins.bpm.parser.elements.model.Transition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;
import org.sonar.plugins.bpm.parser.xpdl.enums.ActivityType;
import org.sonar.plugins.bpm.parser.xpdl.enums.ProcessType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 *
 */
public class WorkflowProcessImpl extends ElementParser implements WorkflowProcess, ComplexityAlgorithm {

	

	private List<Activity> activities;
	private List<ActivitySet> activitySets;
	private List<Transition> transitions;
	private Activity startActivity;
	private List<DataField> datafields;

	public WorkflowProcessImpl(Element wfp) {
		super(wfp);
		activitySets = new ArrayList<ActivitySet>();
		activities = new ArrayList<Activity>();
		transitions = new ArrayList<Transition>();
		datafields = new ArrayList<DataField>();
		
		buildActivitySets();
		buildActivities();
		buildTransitions();
		checkStartActivity();
		buildDataFields();
	}

	private void buildDataFields() {
		Element child = getChildWithName("DataFields");
		if(child!=null){
			List dataflds =child.getChildren();
			for (Iterator iterator = dataflds.iterator(); iterator.hasNext();) {
				Element dtaf = (Element) iterator.next();
				DataFieldImpl datafield = new DataFieldImpl(dtaf,this);
				datafields.add(datafield);
			}
			}
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getProcessType()
	 */
	@Override
	public ProcessType getProcessType() {
		return ProcessType.valueOf(getCurrentElement().getAttributeValue("ProcessType"));
	}


	private void buildActivitySets() {
		Element child = getChildWithName("ActivitySets");
		if(child!=null){
		List actset =child.getChildren();
		for (Iterator iterator = actset.iterator(); iterator.hasNext();) {
			Element act = (Element) iterator.next();
			ActivitySetImpl activitySet = new ActivitySetImpl(act,this);
			activitySets.add(activitySet);
		}
		}
	}
	
	@Override
	public List<ActivitySet> getActivitySets() {
		return activitySets;
	}

	private void buildActivities() {
		Element activitiess = getChildWithName("Activities");
		List trns = activitiess.getChildren();
		for (Iterator iterator = trns.iterator(); iterator.hasNext();) {
			Element act = (Element) iterator.next();
			ActivityImpl activity = new ActivityImpl(act, this);
			this.activities.add(activity);
		}

	}
	
	public List<Activity> getActivities() {

		return activities;
	}


	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getAdHocOrdering()
	 */
	@Override
	public String getAdHocOrdering() {
		return getCurrentElement().getAttributeValue("AdHocOrdering");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getAdHocCompletionCondition()
	 */
	@Override
	public String getAdHocCompletionCondition() {
		return getCurrentElement().getAttributeValue("AdHocCompletionCondition");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getApplications()
	 */
	@Override
	public List<Application> getApplications() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getAssignments()
	 */
	@Override
	public List<Assignment> getAssignments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getDataAssociations()
	 */
	@Override
	public List<DataAssociation> getDataAssociations() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getDataFields()
	 */
	@Override
	public List<DataField> getDataFields() {
		
		return this.datafields;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getDataObjects()
	 */
	@Override
	public List<DataObject> getDataObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getDefaultStartActivityId()
	 */
	@Override
	public Activity getDefaultStartActivityId() {
		String id = getCurrentElement().getAttributeValue("DefaultStartActivityId");
		if (id!=null){
			for (Activity activity : getActivities()) {
				if (id.equals(activity.getId())) {
					return activity;
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getEnableInstanceCompensation()
	 */
	@Override
	public String getEnableInstanceCompensation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getDefaultStartActivitySetId()
	 */
	@Override
	public ActivitySet getDefaultStartActivitySetId() {
		String id = getCurrentElement().getAttributeValue("DefaultStartActivitySetId");
		for (ActivitySet activity : getActivitySets()) {
			if (id.equals(activity.getId())) {
				return activity;
			}
		}
	return null;
	}


	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getFormalParameters()
	 */
	@Override
	public List<FormalParameter> getFormalParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getInputSets()
	 */
	@Override
	public List<InputSet> getInputSets() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getOutputSets()
	 */
	@Override
	public List<OutputSet> getOutputSets() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getParticipants()
	 */
	@Override
	public List<Participant> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getPartnerLinks()
	 */
	@Override
	public List<PartnerLink> getPartnerLinks() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getProcessHeader()
	 */
	@Override
	public ProcessHeader getProcessHeader() {
		Element child = getChildWithName("ProcessHeader");
		return new ProcessHeaderImpl(child);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getRedefinableHeader()
	 */
	@Override
	public RedefinableHeader getRedefinableHeader() {
		Element child = getChildWithName("RedefinableHeader");
		return new RedefinableHeaderImpl(child);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getStatus()
	 */
	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WorkflowProcess#getSuppressJoinFailure()
	 */
	@Override
	public String getSuppressJoinFailure() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void buildTransitions() {
		Element child = getChildWithName("Transitions");
		List trns = child.getChildren();
		for (Iterator iterator = trns.iterator(); iterator.hasNext();) {
			Element tr = (Element) iterator.next();
			TransitionImpl transition = new TransitionImpl(tr,this);
			transitions.add(transition);
			transition.getFrom().addOutgoingTransition(transition);
			transition.getTo().addIngoingTransition(transition);
		}
	}
	@Override
	public List<Transition> getTransitions() {
		return transitions;
	}

	@Override
	public Activity getActivityById(String id) {
		for ( Iterator iterator = getActivities().iterator(); iterator.hasNext(); ) {
			Activity activity = (Activity) iterator.next();
			if (id.equals(activity.getId())) {
				return activity;
			}
		}
		return null;
	}

	@Override
	public ActivitySet getActivitySetById(String id) {
		for (ActivitySet activity : getActivitySets()) {
			if (id.equals(activity.getId())) {
				return activity;
			}
		}
		return null;
	}

	private void checkStartActivity(){
		boolean done=false;
		for (Iterator iterator = activities.iterator(); iterator.hasNext() && !done;) {
			Activity act = (Activity) iterator.next();
			if (act.isStartActivity())
			{
				this.startActivity=act;
				done = true;
			}
			
		}
	}
	@Override
	public Activity getStartActivity() {
		
		return this.startActivity;
	}

	@Override
	public Collection<Activity> getActivitiesbyType(ActivityType actType) {
		Collection<Activity> list = new ArrayList<Activity>();
		for (Iterator iterator = this.getActivities().iterator(); iterator.hasNext();) {
			Activity activity = (Activity) iterator.next();
			if(activity.getType().toString().equals(actType.toString()))
				list.add(activity);
		}
		for (Iterator iterator = this.activitySets.iterator(); iterator.hasNext();) {
			ActivitySet actset = (ActivitySet) iterator.next();
			
			for (Iterator iterator2 = actset.getActivities().iterator(); iterator2.hasNext();) {
			Activity activity = (Activity) iterator2.next();
			if(activity.getType().toString().equals(actType.toString()))
				list.add(activity);
		}
		}
		return list;
	}

	@Override
	public Collection<Activity> getActvitiesbyTaskImplementationType(
			TaskImplementationType type) {
		Collection<Activity> list = new ArrayList<Activity>();
		for (Iterator iterator = this.getActivitiesbyType(ActivityType.Task).iterator(); iterator.hasNext();) {
			Activity activity = (Activity) iterator.next();
			//System.out.println("getAcitvitiesbyTaskImplementationType: "+ activity.getImplementation().getTask().getType());
			if(activity.getImplementation().getTask().getType().toString().equals(type.toString()))
				list.add(activity);
		}
		return list;
	}

	
	
	
	
	@Override
	public Double calculateCoefficientNetworkComplexity() {
		int arcs= this.getTransitions().size();
		int nodes = this.getActivities().size();
		double result = (arcs^2)/nodes;
		return new Double(result);
	}

	@Override
	public Double calculateCyclomaticNumber() {
		int arcs= this.getTransitions().size();
		int nodes = this.getActivities().size();
		double result = arcs - nodes + 1;
		return new Double(result);
	}

	@Override
	public Double calculateComplexityIndex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateRestrictivenessEstimator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateNumberTreesInGraph() {
		// TODO Auto-generated method stub
		return null;
	}




	

}
