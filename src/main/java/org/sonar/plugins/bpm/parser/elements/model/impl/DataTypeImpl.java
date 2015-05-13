/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.DataType;

/**
 * @author federicopastore
 * 
 */
public class DataTypeImpl extends ElementParser implements DataType {

	private Type type;

	public DataTypeImpl(Element element) {
		super(element);
		this.buildType();
	}

	private void buildType() {
		if (type == null) {
			type = Type.Undefined;
			Type[] types = Type.values();
			for (int i = 0; i < types.length; i++) {
				Element child = getChildWithName(types[i].name());
				if (child != null) {
					type = types[i];
				}
			}
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.federicopastore.businessprocessanalyzer.parser.elements.model.DataType
	 * #getType()
	 */
	@Override
	public Type getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.federicopastore.businessprocessanalyzer.parser.elements.model.DataType
	 * #
	 * isTypeOf(org.federicopastore.businessprocessanalyzer.parser.elements.model
	 * .DataType.Type)
	 */
	@Override
	public boolean isTypeOf(Type type) {
		return this.type.equals(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.federicopastore.businessprocessanalyzer.parser.elements.model.DataType
	 * #getBasicType()
	 */
	@Override
	public BasicType getBasicType() {
		if(isTypeOf(Type.BasicType))
			return BasicType.valueOf(getChildWithName("BasicType").getAttributeValue("type"));
		else
		    return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.federicopastore.businessprocessanalyzer.parser.elements.model.DataType
	 * #getDataTypeAttribute()
	 */
	@Override
	public String getDataTypeAttribute(String attr) {
		return getChildWithName(type.name()).getAttributeValue("type");
	}

}
