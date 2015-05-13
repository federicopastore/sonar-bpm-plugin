/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Actual;
import org.sonar.plugins.bpm.parser.elements.model.DataMapping;

/**
 * @author federicopastore
 *
 */
public class DataMappingImpl extends ElementParser implements DataMapping {

	public DataMappingImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.DataMapping#getActual()
	 */
	@Override
	public Actual getActual() {
		Actual actual =null;
		Element act = getChildWithName("Actual");
		if(act !=null)
			actual = new ActualImpl(act);
		return actual;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.DataMapping#getDirection()
	 */
	@Override
	public DirectionType getDirection() {
		return DirectionType.valueOf(getCurrentElement().getAttributeValue("Direction"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.DataMapping#getFormal()
	 */
	@Override
	public String getFormal() {
		return getCurrentElement().getAttributeValue("Formal");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.DataMapping#getTestValue()
	 */
	@Override
	public String getTestValue() {
		return getCurrentElement().getAttributeValue("TestValue");
	}

}
