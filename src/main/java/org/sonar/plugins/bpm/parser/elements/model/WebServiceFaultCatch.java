/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface WebServiceFaultCatch extends BaseXpdlElement {

	public Message getMessage();
	public BlockActivity getBlockActivity();
	public Transition getTransitionRef();
	public String getFaultName();
}
