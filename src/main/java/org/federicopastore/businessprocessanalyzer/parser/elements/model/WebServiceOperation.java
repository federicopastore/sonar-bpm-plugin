/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface WebServiceOperation extends BaseXpdlElement {

	public String getPartner();
	public String getPartnerLinkId();
	public String getRoleType();
	public String getOperationName();
	public Service getService();
	public String getServiceName();
	public String getPortName();
	
	
}
