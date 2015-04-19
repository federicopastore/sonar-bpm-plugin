/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Activity;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Event;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Message;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.TriggerResultMessage;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.EventType;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TriggerType;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class IntermediateEvent extends ElementParser implements Event {

	private EventType type;

	public IntermediateEvent(Element element) {
		super(element);
		this.type= EventType.valueOf(element.getName());
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getActivity()
	 */
	@Override
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getErrorCode()
	 */
	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getInterrupting()
	 */
	@Override
	public boolean getInterrupting() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getType()
	 */
	@Override
	public EventType getType() {
		// TODO Auto-generated method stub
		return type;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getMessage()
	 */
	@Override
	public Message getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getResult()
	 */
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTriggerResultCompensation()
	 */
	@Override
	public String getTriggerResultCompensation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTriggerMultiple()
	 */
	@Override
	public String getTriggerMultiple() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTriggerResultMessage()
	 */
	@Override
	public TriggerResultMessage getTriggerResultMessage() {
		TriggerResultMessage trm = null;
		Element trmElem = getChildWithName("TriggerResultMessage");
		if(trmElem!=null){
			trm = new TriggerResultMessageImpl(trmElem);
		}
		return trm;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getResultError()
	 */
	@Override
	public String getResultError() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getResultMultiple()
	 */
	@Override
	public String getResultMultiple() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTriggerConditional()
	 */
	@Override
	public String getTriggerConditional() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTriggerResultSignal()
	 */
	@Override
	public String getTriggerResultSignal() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTriggerTimer()
	 */
	@Override
	public String getTriggerTimer() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getConditionName()
	 */
	@Override
	public String getConditionName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTarget()
	 */
	@Override
	public Activity getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTimeCycle()
	 */
	@Override
	public String getTimeCycle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTimeDate()
	 */
	@Override
	public String getTimeDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getTrigger()
	 */
	@Override
	public TriggerType getTrigger() {
		String trigger = getCurrentElement().getAttributeValue("Trigger");
		if (trigger==null)
			trigger= "None";
		return TriggerType.valueOf(trigger);
	}

}
