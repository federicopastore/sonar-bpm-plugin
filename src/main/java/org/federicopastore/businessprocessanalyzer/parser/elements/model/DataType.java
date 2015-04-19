/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.BasicType;

/**
 * @author federicopastore
 *
 * 
 * ArrayType A fixed size set of data all of the same data type (deprecated).
 * BasicType A simple type: STRING, INTEGER, FLOAT, DATETIME, DATE, TIME, REFERENCE, BOOLEAN, or PERFORMER.
 * DeclaredType A reference to a data type declared in a TypeDeclaration element.
 * EnumerationType A set of legal values of a variable or parameter (deprecated).
 * ExternalReference A reference to a type defined in an external document. See Section 7.1.5.
 * ListType An unbounded set of data all of the same data type (deprecated).
 * RecordType A set of members that may be of different types (deprecated).
 * SchemaType A data type defined using an XML schema.
 * UnionType A set of members only one of which will be used for an instance of the data (deprecated).
 */
public interface DataType extends BaseXpdlElement {

	public static enum Type{
		ArrayType, BasicType, DeclaredType, EnumerationType, ExternalReference, ListType, RecordType, SchemaType, UnionType, Undefined
	}
	public static enum BasicType{
		STRING, INTEGER, FLOAT, DATETIME, DATE, TIME, REFERENCE, BOOLEAN, PERFORMER
	}
	
	public Type getType();
	public boolean isTypeOf(Type type);
	public BasicType getBasicType();
	public String getDataTypeAttribute(String attr);
}
