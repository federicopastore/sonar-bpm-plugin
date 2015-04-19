/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Message;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Task;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.WebServiceFaultCatch;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.WebServiceOperation;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TaskImplementationType;
import org.jdom.Element;

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
