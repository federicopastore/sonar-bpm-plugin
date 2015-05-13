/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Task;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

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
