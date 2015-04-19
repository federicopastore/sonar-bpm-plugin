/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.Orientation;

/**
 * @author federicopastore
 * 
 * BoundaryVisible This attribute defines if the rectangular boundary for the Pool is visible. Only one Pool on a page MAY have the attribute set to False.
 * Id The id of the Pool.
 * Lanes The lanes in the pool. See section 7.4.2.
 * MainPool This attribute defines if the Pool is the “main” Pool or the focus of the diagram. Only one Pool in the Diagram MAY have the attribute set to True.
 * MultiInstance Default: false. True means a Pool with a multiple participant.
 * Name The name of the pool.
 * NodeGraphicsInfos See section 7.1.1.
 * Object See section 7.1.9.4
 * Orientation HORIZONTAL | VERTICAL
 * Participant The Modeler MAY define the Participant for a Pool. The Participant can be either a Role or an Entity. This defines the role that the Pool will play in a Diagram that includes collaboration. Note that the term Participant in the context of Pools is a BPMN concept that differs from the same term used in XPDL Participant Declaration, Participant Assignment and Performer expressions. Within a Pool, the Lane organizes activities by role/entity & a performer expression identifies the Performer(s) (i.e. role/entity) that are performing the tasks in a Lane.
 * Process ProcessRef in BPMN The Process attribute defines the Process that is contained within the Pool. Each Pool MAY have a Process.
 */
public interface Pool extends BaseXpdlElement {

	public String getName();
	public String getId();
	public boolean getBoundaryVisible();
	public List<Lane> getLanes();
	public boolean getMainPool();
	public boolean getMultiInstance();
	public NodeGraphicsInfo getNodeGraphicsInfos();
	public Object getObject();
	public Orientation getOrientation();
	public Participant getParticipant();
	public String getProcess();
}
