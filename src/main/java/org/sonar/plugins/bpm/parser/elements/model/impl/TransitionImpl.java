/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.List;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.enums.ConditionType;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.ConnectorGraphicsInfo;
import org.sonar.plugins.bpm.parser.elements.model.Transition;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;

/**
 * @author federicopastore
 *
 */
public class TransitionImpl extends ElementParser implements Transition {


	private WorkflowProcess parent;
	private ActivitySetImpl activitySetImpl;

	public TransitionImpl(Element tr, WorkflowProcess parent) {
		super(tr);
		this.parent = parent;
		
	}

	public TransitionImpl(Element tr, ActivitySetImpl activitySetImpl) {
		super(tr);
		this.activitySetImpl = activitySetImpl;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Transition#getFrom()
	 */
	@Override
	public Activity getFrom() {
		return parent.getActivityById(getCurrentElement().getAttributeValue("From"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Transition#getTo()
	 */
	@Override
	public Activity getTo() {
		return parent.getActivityById(getCurrentElement().getAttributeValue("To"));
	}

	@Override
	public WorkflowProcess getParentWorkFlow() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	@Override
	public ConditionType getCondition() {
		// TODO Auto-generated method stub
		return ConditionType.valueOf(getCurrentElement().getAttributeValue("Condition"));
	}

	@Override
	public List<ConnectorGraphicsInfo> getConnectorGraphicsInfos() {
		// TODO Auto-generated method stub
		return null;
	}

}
