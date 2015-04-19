/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

/**
 * @author federicopastore
 * 
 * Id Id of the message.
Name Text description of the Message.
From Optional, but if present must be the name of a Participant (see section 7.4.1) /Process.
To Optional, but if present must be the name of a Participant (see section 7.4.1) /Process.
Actual Parameters Deprecated in XPDL2.2, use the Actual OParameters at the Activitiy Level.
	A list of parameters that compose the message. See section 7.1.6.1.
DataMappings Deprecated in XPDL2.2, use the Actual OParameters at the Activitiy Level.
	Alternative approach to build the message. See section 7.6.5.4.7.
FaultName When the message is an error message (for example an error response to a request), the FaultName corresponds to the fault (exception). See WebServiceFaultCatch to handle the error in the receiving end.
 */
public interface Message extends BaseXpdlElement {
public String getId();
public String getName();
public String getFrom();
public String getTo();
public List<DataMapping> getDataMappings();
}
