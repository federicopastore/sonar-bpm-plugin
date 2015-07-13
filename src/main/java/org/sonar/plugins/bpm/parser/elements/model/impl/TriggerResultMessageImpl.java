/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Message;
import org.sonar.plugins.bpm.parser.elements.model.TriggerResultMessage;
import org.sonar.plugins.bpm.parser.elements.model.WebServiceOperation;

/**
 * @author federicopastore
 *
 */
public class TriggerResultMessageImpl extends ElementParser implements
		TriggerResultMessage {

	public TriggerResultMessageImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.TriggerResultMessage#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = null;
		Element msgElem = getChildWithName("Message");
		if(msgElem!=null)
			msg = new MessageImpl(getChildWithName("Message"));
		return msg;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.TriggerResultMessage#getWebServiceOperation()
	 */
	@Override
	public WebServiceOperation getWebServiceOperation() {
		return new WebServiceOperationImpl(getChildWithName("WebServiceOperation"));
	}

	@Override
	public boolean getTibcoReplyImmediate() {
		
		String res = getExtendedAttributeValue("ReplyImmediate");
		return Boolean.parseBoolean(res);
	}
	
/*	private String getExtendedAttributeValue(String attributeKey){
		//System.out.println("getdReplyActivityId: "+this.getCurrentElement().getName());
		String result="";
		List<Attribute> listAtt=this.getCurrentElement().getAttributes();
		for (Iterator iterator = listAtt.iterator(); iterator.hasNext();) {
			Attribute attribute = (Attribute) iterator.next();
			//System.out.println("attrs: "+attribute.getName()+"="+attribute.getValue());
			if(attribute.getName().equals(attributeKey))
				result=attribute.getValue();
		}
		return result;
	}*/
}
