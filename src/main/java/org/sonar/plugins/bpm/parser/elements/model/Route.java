/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import org.sonar.plugins.bpm.parser.xpdl.enums.ExclusiveType;
import org.sonar.plugins.bpm.parser.xpdl.enums.GatewayType;

/**
 * @author federicopastore
 *
 */
public interface Route extends BaseXpdlElement {
	public GatewayType getGatewayType();
	public ExclusiveType getExclusiveType();
	public boolean getMarkerVisible();
	public String getXORType();
	public boolean getInstantiate();
	public boolean getParallelEventBased();
	public String getIncomingCondition();
	public String getOutgoingCondition();
}
