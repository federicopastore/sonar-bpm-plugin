/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

/**
 * @author federicopastore
 * Name Name of the Object.
 * Categories A list of categories. See section 7.1.8.
 * Documentation Textual Documentation.
 * Id Id of the object.
 */
public interface Object extends BaseXpdlElement {
	public String getName();
	public String getId();
	public String getCategories();
	public String getDocumentation();
}
