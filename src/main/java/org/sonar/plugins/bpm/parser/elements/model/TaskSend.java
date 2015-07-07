/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface TaskSend extends Task {
	public String getExtendedAttributeValue(String attribute);
}
