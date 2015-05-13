/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import org.sonar.plugins.bpm.parser.xpdl.enums.Mode;

/**
 * @author federicopastore
 *
 * DataType Data type of the formal parameter. See section 7.13.
 * Description Textual description of the formal parameter.
 * Length The length of the data. Used only for strings, to declare maximum length.
 * Id Identifier for the parameter.
 * InitialValue Pre-assignment of data for runtime.
 * Name Name for the parameter.
 * IsArray Indicates if the parameter is an array or a single value parameter.
 * Index Index of the parameter (Deprecated)
 * Mode 
	IN Input Parameters
	OUT Output Parameters
	INOUT Parameters used as input and output
 * ReadOnly The datafield or formal parameter is described as readOnly or as a constant and its value cannot be changed.
 * Required Defines whether the parameter must be supplied, default to false.
 * 
 */
public interface FormalParameter extends BaseXpdlElement {

	public String getDataType();
	public String getDescription();
	public String getLength();
	public String getId();
	public String getInitialValue();
	public String getName();
	public boolean getIsArray();
	public String getIndex();
	public Mode getMode();
	public boolean getReadOnly();
	public boolean getRequired();


}
