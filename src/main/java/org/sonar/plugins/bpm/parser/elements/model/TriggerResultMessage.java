/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface TriggerResultMessage extends BaseXpdlElement {

	public Message getMessage();
	public WebServiceOperation getWebServiceOperation();
}
