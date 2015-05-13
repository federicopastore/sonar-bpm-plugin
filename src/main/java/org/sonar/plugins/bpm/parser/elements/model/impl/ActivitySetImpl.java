/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.ActivitySet;
import org.sonar.plugins.bpm.parser.elements.model.DataAssociation;
import org.sonar.plugins.bpm.parser.elements.model.DataObject;
import org.sonar.plugins.bpm.parser.elements.model.Transition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;

/**
 * @author federicopastore
 * 
 */
public class ActivitySetImpl extends ElementParser implements ActivitySet {

	private List<DataAssociation> dataAssociations;
	private List<DataObject> dataObjects;
	private WorkflowProcess parent;
	private List<Activity> activities;
	private List<Transition> transitions;

	public ActivitySetImpl(Element act, WorkflowProcess parent) {
		super(act);
		dataAssociations = new ArrayList<DataAssociation>();
		dataObjects = new ArrayList<DataObject>();
		transitions = new ArrayList<Transition>();
		activities = new ArrayList<Activity>();
		this.parent = parent;

		buildActivities();

		buildTransitions();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.federicopastore.bpmanalyzer.parser.elements.model.ActivitySet#getAdHoc
	 * ()
	 */
	@Override
	public String getAdHoc() {
		return getCurrentElement().getAttributeValue("AdHoc");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ActivitySet#
	 * getAdHocOrdering()
	 */
	@Override
	public String getAdHocOrdering() {
		return getCurrentElement().getAttributeValue("AdHocOrdering");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ActivitySet#
	 * getAdHocCompletionCondition()
	 */
	@Override
	public String getAdHocCompletionCondition() {
		return getCurrentElement()
				.getAttributeValue("AdHocCompletionCondition");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ActivitySet#
	 * getDataAssociations()
	 */
	@Override
	public List<DataAssociation> getDataAssociations() {
		List dtas = getCurrentElement().getChildren("DataAssociation");
		for (Iterator iterator = dtas.iterator(); iterator.hasNext();) {
			Element dta = (Element) iterator.next();
			DataAssociationImpl dtaimpl = new DataAssociationImpl(dta);
			dataAssociations.add(dtaimpl);
		}
		return dataAssociations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ActivitySet#
	 * getDataObjects()
	 */
	@Override
	public List<DataObject> getDataObjects() {

		List dtos = getCurrentElement().getChildren("DataAssociation");
		for (Iterator iterator = dtos.iterator(); iterator.hasNext();) {
			Element dto = (Element) iterator.next();
			DataObjectImpl dtoimpl = new DataObjectImpl(dto);
			dataObjects.add(dtoimpl);
		}
		return dataObjects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ActivitySet#
	 * getDefaultStartActivityId()
	 */
	@Override
	public Activity getDefaultStartActivityId() {
		return parent.getActivityById(getCurrentElement().getAttributeValue(
				"DefaultStartActivityId"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ActivitySet#
	 * getTriggeredByEvent()
	 */
	@Override
	public boolean getTriggeredByEvent() {
		return new Boolean(getCurrentElement().getAttributeValue(
				"TriggeredByEvent")).booleanValue();
	}

	private void buildActivities() {
		Element activitiess = getChildWithName("Activities");
		List trns = activitiess.getChildren();
		for (Iterator iterator = trns.iterator(); iterator.hasNext();) {
			Element act = (Element) iterator.next();
			ActivityImpl activity = new ActivityImpl(act,
					(WorkflowProcessImpl) parent);
			this.activities.add(activity);
			parent.getActivities().add(activity);
		}
	}

	public List<Activity> getActivities() {

		return activities;
	}

	private void buildTransitions() {
		Element child = getChildWithName("Transitions");
		if (child != null) {
			List trns = child.getChildren();
			for (Iterator iterator = trns.iterator(); iterator.hasNext();) {
				Element tr = (Element) iterator.next();
				TransitionImpl transition = new TransitionImpl(tr,
						(WorkflowProcessImpl) parent);
				transitions.add(transition);
				transition.getFrom().addOutgoingTransition(transition);
				transition.getTo().addIngoingTransition(transition);
			}
		}
	}

	@Override
	public List<Transition> getTransitions() {
		return transitions;
	}

}
