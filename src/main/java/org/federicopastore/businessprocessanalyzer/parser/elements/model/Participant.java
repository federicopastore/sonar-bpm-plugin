/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.ParticipantType;

/**
 * @author federicopastore
 * Description Short textual description of a participant.
 * ExternalReference A reference to an external specification of a participant. See section 7.1.5.
 * ExtendedAttributes Optional extensions to meet individual implementation needs.
 * Id Used to identify the participant definition.
 * Name Text used to identify a performer.
 * ParticipantType Definition of the type of participant entity.
 */
public interface Participant extends BaseXpdlElement {

	public String getDescription();
	public ExternalReference getExternalReference();
	public List<ExtendedAttribute> getExtendedAttributes();
	public String getId();
	public String getName();
	public ParticipantType getParticipantType();
}
