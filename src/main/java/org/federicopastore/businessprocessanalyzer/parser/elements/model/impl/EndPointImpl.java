/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.EndPoint;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.ExternalReference;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class EndPointImpl extends ElementParser implements EndPoint {

	public EndPointImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.EndPoint#getEndPointType()
	 */
	@Override
	public String getEndPointType() {
		
		return getCurrentElement().getAttributeValue("EndPointType");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.EndPoint#getExternalReference()
	 */
	@Override
	public ExternalReference getExternalReference() {
		Element erElem = getChildWithName("ExternalReference");
		ExternalReference er= null;
		if(erElem!=null)
			er = new ExternalReferenceImpl(erElem);
		return er;
	}

}
