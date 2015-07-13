/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.Event;
import org.sonar.plugins.bpm.parser.elements.model.Message;
import org.sonar.plugins.bpm.parser.elements.model.TriggerResultMessage;
import org.sonar.plugins.bpm.parser.xpdl.enums.EventType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TriggerType;

/**
 * @author federicopastore
 *
 */
public class StartEvent extends ElementParser implements Event {

	private EventType type;

	public StartEvent(Element element) {
		super(element);
		this.type=EventType.valueOf(element.getName());
	}

	
	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getType()
	 */
	@Override
	public EventType getType() {
		return type;
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
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Event#getMessage()
	 */
	@Override
	public Message getMessage() {
		return new MessageImpl(getChildWithName("Message"));
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


	@Override
	public TriggerResultMessage getTriggerResultMessage() {
		TriggerResultMessage trm = null;
		//System.out.println("Element event "+ getCurrentElement().getName());
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
