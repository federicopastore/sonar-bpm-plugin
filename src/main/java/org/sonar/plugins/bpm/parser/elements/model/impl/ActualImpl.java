/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Actual;

/**
 * @author federicopastore
 *
 */
public class ActualImpl extends ElementParser implements Actual {

	public ActualImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Actual#getScriptGrammar()
	 */
	@Override
	public String getScriptGrammar() {
		return getCurrentElement().getAttributeValue("ScriptGrammar");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Actual#getContent()
	 */
	@Override
	public String getContent() {
		return getCurrentElement().getText();
	}

}
