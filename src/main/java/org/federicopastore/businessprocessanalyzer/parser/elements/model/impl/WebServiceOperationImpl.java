/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Service;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.WebServiceOperation;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class WebServiceOperationImpl extends ElementParser implements
		WebServiceOperation {

	public WebServiceOperationImpl(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WebServiceOperation#getPartner()
	 */
	@Override
	public String getPartner() {
		return getCurrentElement().getAttributeValue("Partner");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WebServiceOperation#getPartnerLinkId()
	 */
	@Override
	public String getPartnerLinkId() {
		return getCurrentElement().getAttributeValue("PartnerLinkId");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WebServiceOperation#getRoleType()
	 */
	@Override
	public String getRoleType() {
		return getCurrentElement().getAttributeValue("RoleType");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WebServiceOperation#getOperationName()
	 */
	@Override
	public String getOperationName() {
		return getCurrentElement().getAttributeValue("OperationName");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WebServiceOperation#getService()
	 */
	@Override
	public Service getService() {
		Element wsElem = getChildWithName("Service");
		Service service =null;
		if(wsElem!=null)
			service = new ServiceImpl(wsElem);
		
		return service;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WebServiceOperation#getServiceName()
	 */
	@Override
	public String getServiceName() {
		return getCurrentElement().getAttributeValue("ServiceName");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.WebServiceOperation#getPortName()
	 */
	@Override
	public String getPortName() {
		return getCurrentElement().getAttributeValue("PortName");
	}

}
