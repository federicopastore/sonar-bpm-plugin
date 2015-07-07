/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.tibcoextension;

import org.sonar.plugins.bpm.parser.elements.model.BaseXpdlElement;

/**
 * @author federicopastore
 *
 */
public interface TibcoBpmRuntimeConfiguration extends BaseXpdlElement  {

	public int getIncomingRequestTimeout();
}
