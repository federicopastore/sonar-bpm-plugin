/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.EndPoint;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Service;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class ServiceImpl extends ElementParser implements Service {

	public ServiceImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Service#getEndPoint()
	 */
	@Override
	public EndPoint getEndPoint() {
		Element epElem = getChildWithName("EndPoint");
		EndPoint ep = null;
		if(epElem!=null)
			ep = new EndPointImpl(epElem);
		
		return ep;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Service#getPortName()
	 */
	@Override
	public String getPortName() {
		return getCurrentElement().getAttributeValue("PortName");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Service#getServiceName()
	 */
	@Override
	public String getServiceName() {
		return getCurrentElement().getAttributeValue("ServiceName");
	}

}
