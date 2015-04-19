/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Message;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Task;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TaskImplementationType;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class TaskUser extends ElementParser implements Task {
	public TaskUser(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
	}	
	public static enum ImplementationType{
		WebService , Other , Unspecified, HumanTaskWebService
	}

	public Message getMessageIn(){
		return null;
	}
	public Message getMessageOut(){
		return null;
	}
	public List<String> getPerformers(){
		return null;
	}
	public String getWebServiceOperation(){
		return null;
	}
	@Override
	public TaskImplementationType getType() {
		return TaskImplementationType.TaskUser;
	}
}
