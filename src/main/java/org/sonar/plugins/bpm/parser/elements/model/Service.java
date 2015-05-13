/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface Service extends BaseXpdlElement {
	public EndPoint getEndPoint();
	public String getPortName();
	public String getServiceName();
}
