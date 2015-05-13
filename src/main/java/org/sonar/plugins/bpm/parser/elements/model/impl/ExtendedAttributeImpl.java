/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.ExtendedAttribute;

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
