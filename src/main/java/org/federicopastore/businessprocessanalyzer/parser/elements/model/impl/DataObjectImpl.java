/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import java.util.Iterator;
import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.DataObject;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.NodeGraphicsInfo;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class DataObjectImpl extends ElementParser implements DataObject {

	

	public DataObjectImpl(Element element) {
		super(element);
	}



	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.DataObject#getState()
	 */
	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return getCurrentElement().getAttributeValue("State");
	}

}
