/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Script;

/**
 * @author federicopastore
 *
 */
public class ScriptImpl extends ElementParser implements Script {

	public ScriptImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Script#getScriptGrammar()
	 */
	@Override
	public String getScriptGrammar() {
		return getCurrentElement().getAttributeValue("ScriptGrammar");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Script#getContent()
	 */
	@Override
	public String getContent() {
		return getCurrentElement().getTextNormalize();
	}

}
