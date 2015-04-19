/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Task;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TaskImplementationType;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class TaskSend extends ElementParser implements Task {

	public TaskSend(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Task#getType()
	 */
	@Override
	public TaskImplementationType getType() {
		return TaskImplementationType.TaskSend;
	}

}
