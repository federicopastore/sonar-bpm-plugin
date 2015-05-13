/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.DataField;
import org.sonar.plugins.bpm.parser.elements.model.DataType;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;

/**
 * @author federicopastore
 *
 */
public class DataFieldImpl extends ElementParser implements DataField {

	private WorkflowProcess parent;

	public DataFieldImpl(Element element, WorkflowProcess parent) {
		super(element);
		this.parent = parent;
	}

	public DataFieldImpl(Element dtaf,
			PackageDefinitionImpl parent) {
		super(dtaf);
		//this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.DataField#getDataType()
	 */
	@Override
	public DataType getDataType() {
		DataTypeImpl datatype = new DataTypeImpl(getChildWithName("DataType"));
		return datatype;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.DataField#getInitialValue()
	 */
	@Override
	public String getInitialValue() {
		return getCurrentElement().getAttributeValue("InitialValue");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.DataField#getIsArray()
	 */
	@Override
	public boolean getIsArray() {
		String attr = getCurrentElement().getAttributeValue("IsArray");
		return attr ==null? false : Boolean.parseBoolean(getCurrentElement().getAttributeValue("IsArray"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.DataField#getLength()
	 */
	@Override
	public String getLength() {
		return getCurrentElement().getAttributeValue("Length");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.DataField#getReadOnly()
	 */
	@Override
	public boolean getReadOnly() {
		String attr = getCurrentElement().getAttributeValue("ReadOnly");
		return attr ==null? false : Boolean.parseBoolean(getCurrentElement().getAttributeValue("ReadOnly"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.DataField#getCorrelation()
	 */
	@Override
	public String getCorrelation() {
		return getCurrentElement().getAttributeValue("Correlation");
	}
	
}
