/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 * 
 * Id The id of the Lane.
 * NestedLane This element identifies any Lanes that are nested within the current Lane.
 * Name The name of the Lane.
 * NodeGraphicsInfos See section 7.1.1.
 * Object See section 7.1.9.4.
 * Performers A Swim Lane in a Pool is often used to designate the default 'Role' required to perform any of the activities in the lane. This optional element provides the ability to specify the default performers for all activities in
 */
public interface Lane extends BaseXpdlElement {
	public String getName();
	public String getId();
	public Lane getNestedLane();
	public NodeGraphicsInfo getNodeGraphicsInfos();
	public Object getObject();
	public String getPerformers();
}