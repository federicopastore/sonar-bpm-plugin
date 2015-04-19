/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

/**
 * @author federicopastore
 * Name Used to identify the Extended Attribute.
 * Value Value of the extension.
 */
public interface ExtendedAttribute extends BaseXpdlElement {
	public String getName();
	public String getValue();
}
