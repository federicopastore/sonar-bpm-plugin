/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.PublicationStatus;


/**
 * @author federicopastore
 *
 *
 * Author Name of the author of this package definition.
 * Codepage The codepage used for the text parts. If codepage is omitted, then UTF-8 is assumed.
 * Countrykey Country code based on ISO 3166. It could be either the three digits country code number, or the two alpha characters country codes.
 * PublicationStatus Status of the Process Definition.
	UNDER_REVISION
	RELEASED
	UNDER_TEST
 * Responsible(s) Participant, who is responsible for this process; the supervisor during run time.
	Link to entity participant. Participant, who is responsible for this workflow of this Model definition (usually an Organisational Unit or a Human). It is assumed that the responsible is the supervisor during run time. Default: Initiating participant.
 * Version Version of this Package Definition.
 */
public interface RedefinableHeader extends BaseXpdlElement{

	public String getAuthor();
	public String getCodepage();
	public String getCountryKey();
	public PublicationStatus getPublicationStatus();
	public String getResponsible();
	public String getVersion();
}
