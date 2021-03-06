/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Assignment;

/**
 * @author federicopastore
 *
 */
public class AssignmentImpl extends ElementParser implements Assignment {

	public AssignmentImpl(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Assignment#getTarget()
	 */
	@Override
	public String getTarget() {
		return getCurrentElement().getAttributeValue("Target");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Assignment#getExpression()
	 */
	@Override
	public String getExpression() {
		return getCurrentElement().getAttributeValue("Expression");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Assignment#getAssignTime()
	 */
	@Override
	public String getAssignTime() {
		return getCurrentElement().getAttributeValue("AssignTime");
	}

}
