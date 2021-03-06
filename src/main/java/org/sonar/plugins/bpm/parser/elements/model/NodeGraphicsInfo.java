/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface NodeGraphicsInfo extends BaseXpdlElement {
	public String getBorderColor();
	public String getHeight();
	public String getLaneId();
	public String getWidth();
	public Coordinates getCoordinates();
}
