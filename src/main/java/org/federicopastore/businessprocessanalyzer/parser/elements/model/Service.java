/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface Service extends BaseXpdlElement {
	public EndPoint getEndPoint();
	public String getPortName();
	public String getServiceName();
}
