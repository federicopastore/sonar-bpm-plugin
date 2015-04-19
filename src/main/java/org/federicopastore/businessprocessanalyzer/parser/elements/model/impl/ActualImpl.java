/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Actual;
import org.jdom.Element;

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
