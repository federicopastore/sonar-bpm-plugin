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
