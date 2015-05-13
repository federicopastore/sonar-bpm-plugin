/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 * 
 * Role A partner link may have one or two roles. In most cases they will correspond to the name of the two pools (or lanes) that are interchanging messages.
 * RoleName The name of the role.
 * PortType The port type implemented by the role. Corresponds to the WSDL port type.
 * Name Name of the partner link type.
 * Id Id of the partner link.
 */
public interface PartnerLinkType extends BaseXpdlElement {

	public String getRole();
	public String getRoleName();
	public String getPortType();
	public String getName();
	public String getId();
}
