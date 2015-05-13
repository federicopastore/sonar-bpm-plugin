/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Route;
import org.sonar.plugins.bpm.parser.xpdl.enums.ExclusiveType;
import org.sonar.plugins.bpm.parser.xpdl.enums.GatewayType;

/**
 * @author federicopastore
 *
 */
public class RouteImpl extends ElementParser implements Route {

	public RouteImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getGatewayType()
	 */
	@Override
	public GatewayType getGatewayType() {
		return GatewayType.valueOf(getCurrentElement().getAttributeValue("GatewayType"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getExclusiveType()
	 */
	@Override
	public ExclusiveType getExclusiveType() {
		// TODO Auto-generated method stub
		return ExclusiveType.valueOf(getCurrentElement().getAttributeValue("ExclusiveType"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getMarkerVisible()
	 */
	@Override
	public boolean getMarkerVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getXORType()
	 */
	@Override
	public String getXORType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getInstantiate()
	 */
	@Override
	public boolean getInstantiate() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getParallelEventBased()
	 */
	@Override
	public boolean getParallelEventBased() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getIncomingCondition()
	 */
	@Override
	public String getIncomingCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.Route#getOutgoingCondition()
	 */
	@Override
	public String getOutgoingCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
