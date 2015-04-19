/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.DataMapping;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Message;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class MessageImpl extends ElementParser implements Message {

	public MessageImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Message#getFrom()
	 */
	@Override
	public String getFrom() {
		return getCurrentElement().getAttributeValue("From");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Message#getTo()
	 */
	@Override
	public String getTo() {
		return getCurrentElement().getAttributeValue("To");
	}


}
