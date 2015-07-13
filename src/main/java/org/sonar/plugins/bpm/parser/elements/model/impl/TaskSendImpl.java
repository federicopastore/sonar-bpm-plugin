/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Task;
import org.sonar.plugins.bpm.parser.elements.model.TaskSend;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 *
 */
public class TaskSendImpl extends ElementParser implements TaskSend {

	public TaskSendImpl(Element element) {
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
