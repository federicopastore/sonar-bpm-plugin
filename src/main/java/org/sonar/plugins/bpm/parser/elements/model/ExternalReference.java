/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.net.URI;

/**
 * @author federicopastore
 * 
 * Location It specifies the URI of the document that defines the type.
 * Namespace It allows specification of the scope in which the entity is defined.
 * Xref It specifies the identity of the entity within the external document.
 * 
 */
public interface ExternalReference extends BaseXpdlElement {
	
	public URI getLocation();
	public String getNamespace();
	public String getXref();
}
