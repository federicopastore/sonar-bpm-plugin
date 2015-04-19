/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Association;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.AssociationDirection;
import org.jdom.Element;

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
