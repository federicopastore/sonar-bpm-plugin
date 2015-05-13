/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Association;
import org.sonar.plugins.bpm.parser.xpdl.enums.AssociationDirection;

/**
 * @author federicopastore
 *
 */
public class AssociationImpl extends ElementParser implements Association {

	private Element association;

	public AssociationImpl(Element ass) {
		super(ass);
		this.association = ass;
	}


	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Association#getAssociationDirection()
	 */
	@Override
	public AssociationDirection getAssociationDirection() {
		return AssociationDirection.valueOf(this.association.getAttributeValue("AssociationDirection"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Association#getSource()
	 */
	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return getCurrentElement().getAttributeValue("Source");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Association#getTarget()
	 */
	@Override
	public String getTarget() {
		// TODO Auto-generated method stub
		return getCurrentElement().getAttributeValue("Target");
	}


}
