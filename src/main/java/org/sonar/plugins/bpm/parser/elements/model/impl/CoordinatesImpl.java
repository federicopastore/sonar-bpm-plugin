/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Coordinates;

/**
 * @author federicopastore
 *
 */
public class CoordinatesImpl extends ElementParser implements Coordinates {

	public CoordinatesImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Coordinates#getXCoordinate()
	 */
	@Override
	public String getXCoordinate() {
		return getCurrentElement().getAttributeValue("XCoordinate");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.Coordinates#getYCoordinate()
	 */
	@Override
	public String getYCoordinate() {
		return getCurrentElement().getAttributeValue("YCoordinate");
	}

}
