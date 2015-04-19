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
public class TaskReceive extends ElementParser implements Task {

	public TaskReceive(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
	}


	@Override
	public TaskImplementationType getType() {
		return TaskImplementationType.TaskReceive;
	}

}
