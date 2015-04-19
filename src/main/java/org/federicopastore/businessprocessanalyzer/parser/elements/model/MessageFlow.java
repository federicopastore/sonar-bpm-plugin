/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

/**
 * @author federicopastore
 * 
 * ConnectorGraphicsInfo See section 7.1.1.5.
 * Description Short textual description of the Message.
 * ExtendedAttributes Optional extensions to meet individual implementation needs
 * Source Determines the source of a MessageFlow (Activity or Pool).
 * Id Used to identify the MessageFlow.
 * Message Message is an optional attribute that identifies the Message that is being sent. See section 7.9.4.
 * Name Text used to identify the MessageFlow.
 * Object See section 7.1.9.4.
 * Target Determines the target of a MessageFlow (Activity or Pool).
 */
public interface MessageFlow extends BaseXpdlElement {

	public ConnectorGraphicsInfo getConnectorGraphicsInfo();
	public String getDescription();
	public List<ExtendedAttribute> getExtendedAttributes();
	public String getSource();
	public String getId();
	public String getMessage();
	public String getName();
	public String getObject();
	public String getTarget();
	
}
