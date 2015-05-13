/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

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

}
