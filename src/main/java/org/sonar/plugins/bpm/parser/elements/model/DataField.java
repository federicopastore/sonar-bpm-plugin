/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;

/**
 * @author federicopastore
 * 
 * DataType Data type of the process variable. See Section 7.13.
 * Description Short textual description of the data defined.
 * ExtendedAttributes Optional extensions to meet individual implementation needs.
 * Id Used to identify the relevant data field.
 * InitialValue Pre-assignment of data for run time.
 * IsArray Indicates if it is an array.
 * Length The length of the data.
 * Name Text used to identify the relevant data field.
 * ReadOnly The datafield or formal parameter is described as readOnly or as a constant and its value cannot be changed.
 * Correlation Used in BPMN mapping to BPEL.
 * 
 */
public interface DataField extends BaseXpdlElement {

	public DataType getDataType();
	public String getDescription();
	public List<ExtendedAttribute> getExtendedAttributes();
	public String getId();
	public String getInitialValue();
	public boolean getIsArray();
	public String getLength();
	public String getName();
	public boolean getReadOnly();
	public String getCorrelation();
}
