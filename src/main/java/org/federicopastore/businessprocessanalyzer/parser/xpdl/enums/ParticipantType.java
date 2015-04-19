/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.xpdl.enums;

/**
 * @author federicopastore
 *
 */
public enum ParticipantType {

	RESOURCE_SET,
	//A set of resources.
	RESOURCE,
	//A specific resource agent.
	ROLE,
	//This type allows performer addressing by a role or skill set. A role in this context is a function a human has within an organization. As a function isn’t necessarily unique, a coordinator may be defined (for administrative purposes or in case of exception handling) and a list of humans the role is related to.
	ORGANIZATIONAL_UNIT,
	//A department or any other unit within an organizational model.
	HUMAN,
	//A human interacting with the system via an application presenting a user interface to the participant.
	SYSTEM,
	//An automatic agent.
}
