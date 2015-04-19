/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.ApplicationType;

/**
 * @author federicopastore
 * Description Short textual description of the application.
 * ExtendedAttributes Optional vendor-defined extensions to meet implementation needs. See section 7.1.3.
 * ExternalReference A reference to an external specification of the application signature. See section 7.1.5.
 * FormalParameters A list of parameters that are interchanged with the application via the invocation interface. See section 7.1.4.
 * Id Used to identify the application definition.
 * Name Text used to identify an application (may be interpreted as a generic name of the tool).
 * Type There are a number of standard Application Types. See section 7.3.2.
 */
public interface Application extends BaseXpdlElement {

	public String getDescription();
	public List<ExtendedAttribute> getExtendedAttributes();
	public ExternalReference getExternalReference();
	public List<FormalParameter> getFormalParameters();
	public String getId();
	public String getName();
	public ApplicationType getType();
}
