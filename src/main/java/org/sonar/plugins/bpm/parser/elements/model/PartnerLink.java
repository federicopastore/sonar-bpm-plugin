/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 * 
 * MyRole Defines the role the process is playing in the interaction with the partner.
 * MyRole RoleName Must match one of the two roles defined in the partner link type.
 * PartnerRole Defines the role the partner is playing in the interaction with this process.
 * EndPoint The end point for the partner. It may be the WSDL end point or the partner service listener end point.
 * PartnerRole RoleName Must match one of the two roles defined in the partner link type.
 * ServiceName The service name implemented by the partner and defined in the WSDL.
 * PortName The port name implemented by the partner and defined in the WSDL.
 * Name Name of this partner link. It may correspond to the name of the partner link type, but it is not required to be the same.
 * Id Id of the partner link.
 */
public interface PartnerLink extends BaseXpdlElement {

	public String getRole();
	public String getRoleName();
	public String getPartnerRole();
	public String getEndPoint();
	public String getPartnerRoleName();
	public String getServiceName();
	public String getPortName();
	public String getName();
	public String getId();
}
