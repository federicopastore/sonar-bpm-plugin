/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Script;
import org.sonar.plugins.bpm.parser.elements.model.Task;
import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 * 
 */
public class TaskScript extends ElementParser implements Task {

	public TaskScript(Element element) {
		super(element);
	}

	public Script getScript() {
		Element scriptElement = getChildWithName("Script");
		if (scriptElement != null) {
			Script script = new ScriptImpl(scriptElement);
			return script;
		} else
			return null;
	}

	@Override
	public TaskImplementationType getType() {
		return TaskImplementationType.TaskScript;
	}
}
