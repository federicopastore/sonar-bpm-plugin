/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Coordinates;
import org.sonar.plugins.bpm.parser.elements.model.NodeGraphicsInfo;

/**
 * @author federicopastore
 *
 */
public class NodeGraphicsInfoImpl extends ElementParser implements
		NodeGraphicsInfo {

	public NodeGraphicsInfoImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.NodeGraphicsInfo#getBorderColor()
	 */
	@Override
	public String getBorderColor() {
		return getCurrentElement().getAttributeValue("BorderColor");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.NodeGraphicsInfo#getHeight()
	 */
	@Override
	public String getHeight() {
		return getCurrentElement().getAttributeValue("Height");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.NodeGraphicsInfo#getLaneId()
	 */
	@Override
	public String getLaneId() {
		return getCurrentElement().getAttributeValue("LaneId");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.NodeGraphicsInfo#getWidth()
	 */
	@Override
	public String getWidth() {
		return getCurrentElement().getAttributeValue("Width");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.NodeGraphicsInfo#getCoordinates()
	 */
	@Override
	public Coordinates getCoordinates() {
		Element coords =getCurrentElement().getChild("Coordinates");
		return new CoordinatesImpl(coords);
	}

}
