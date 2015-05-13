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
import org.sonar.plugins.bpm.parser.elements.model.DataMapping;
import org.sonar.plugins.bpm.parser.elements.model.SubFlow;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;

/**
 * @author federicopastore
 *
 */
public class SubFlowImpl extends ElementParser implements SubFlow {

	

	private WorkflowProcess parent;
	private Activity parentActivity;



	public SubFlowImpl(Element element,  Activity parentActivity) {
		super(element);
		this.parentActivity= parentActivity;
	}



	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.SubFlow#getPackageRef()
	 */
	@Override
	public String getPackageRef() {
		return getCurrentElement().getAttributeValue("PackageRef");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.SubFlow#getEndPointRef()
	 */
	@Override
	public String getEndPointRef() {
		return getCurrentElement().getAttributeValue("EndPointRef");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.SubFlow#getExecution()
	 */
	@Override
	public ExecutionType getExecution() {
		return ExecutionType.valueOf(getCurrentElement().getAttributeValue("Execution"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.SubFlow#getInstanceDataField()
	 */
	@Override
	public String getInstanceDataField() {
		return getCurrentElement().getAttributeValue("InstanceDataField");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.SubFlow#getStartActivityId()
	 */
	@Override
	public Activity getStartActivityId() {
		return this.parent.getActivityById(getCurrentElement().getAttributeValue("StartActivityId"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.SubFlow#getStartActivitySetId()
	 */
	@Override
	public ActivitySet getStartActivitySetId() {
		return this.parent.getActivitySetById(getCurrentElement().getAttributeValue("StartActivitySetId"));
	}



	@Override
	public WorkflowProcess getParentWorkFlow() {
		// TODO Auto-generated method stub
		return this.parent;
	}



	@Override
	public Activity getParentActivity() {
		// TODO Auto-generated method stub
		return null;
	}

}
