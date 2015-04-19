/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Script;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Task;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TaskImplementationType;
import org.jdom.Element;

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
