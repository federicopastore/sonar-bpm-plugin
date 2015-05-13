/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.List;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Message;
import org.sonar.plugins.bpm.parser.elements.model.Task;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

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
