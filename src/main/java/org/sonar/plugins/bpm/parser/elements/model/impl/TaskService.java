/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.List;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Message;
import org.sonar.plugins.bpm.parser.elements.model.Task;
import org.sonar.plugins.bpm.parser.elements.model.WebServiceFaultCatch;
import org.sonar.plugins.bpm.parser.elements.model.WebServiceOperation;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 *
 */
public class TaskService extends ElementParser implements Task {

	public TaskService(Element element) {
		super(element);
	}
	
	public static enum ImplementationType{
		WebService , Other , Unspecified
	}
	public ImplementationType getImplementation(){
		if(getCurrentElement().getAttributeValue("Implementation")!=null)
			return ImplementationType.valueOf(getCurrentElement().getAttributeValue("Implementation"));
		else
			return ImplementationType.Unspecified;
	}
	public Message getMessageIn(){
		Element msgElem = getChildWithName("MessageIn");
		Message msg = null;
		if(msgElem!=null)
			msg = new MessageImpl(msgElem);
		return msg;
	}
	
	public Message getMessageOut(){
		Element msgElem = getChildWithName("MessageOut");
		Message msg = null;
		if(msgElem!=null)
			msg = new MessageImpl(msgElem);
		return msg;
	}
	
	public List<String> getPerformers(){
		return null;
	}
	public WebServiceOperation getWebServiceOperation(){
		Element wsElem = getChildWithName("WebServiceOperation");
		WebServiceOperation ws=null;
		if(wsElem!=null)
			ws = new WebServiceOperationImpl(wsElem);
		return ws;
	}
	
	public WebServiceFaultCatch getWebServiceFaultCatch(){
		return null;
	}
	@Override
	public TaskImplementationType getType() {
		return TaskImplementationType.TaskService;
	}

}
