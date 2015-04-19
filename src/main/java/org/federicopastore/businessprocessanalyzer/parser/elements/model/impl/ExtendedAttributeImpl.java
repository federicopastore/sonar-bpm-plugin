/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.ExtendedAttribute;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class ExtendedAttributeImpl extends ElementParser implements ExtendedAttribute {


	public ExtendedAttributeImpl(Element attr) {
		super(attr);
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return getCurrentElement().getAttributeValue("Value");
	}

}
