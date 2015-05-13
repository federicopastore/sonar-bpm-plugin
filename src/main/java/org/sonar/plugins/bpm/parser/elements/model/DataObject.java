/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;

/**
 * @author federicopastore
 * 
 * DataFieldRef A list of data fields.
Id Id of the data object. Type is xpdlId.
Name Name is an attribute that is a text description of the object.
NodeGraphicsInfos Needed for BPMN2.0 DataObjects, which are not artifacts and therefore require a sub-element for graphical information. See section 7.1.9.7 for BPMN2.0 DataObject and section 7.1.1 for discussion of NodeGraphicsInfos.
Object Used to associate categories and documentation with flow object.
State State is an optional attribute that indicates the impact the Process has had on the Data Object. Multiple Data Objects with the same name MAY share the same state within one Process.
 */
public interface DataObject extends BaseXpdlElement {
	public String getId();
	public String getName();
	public List<NodeGraphicsInfo> getNodeGraphicsInfos();
	public Object getObject();
	public String getState();
}
