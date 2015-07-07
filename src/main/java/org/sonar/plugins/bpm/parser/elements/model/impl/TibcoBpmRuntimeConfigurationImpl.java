/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.tibcoextension.TibcoBpmRuntimeConfiguration;

/**
 * @author federicopastore
 *
 */
public class TibcoBpmRuntimeConfigurationImpl extends ElementParser implements
		TibcoBpmRuntimeConfiguration{

	
	public TibcoBpmRuntimeConfigurationImpl(Element tibcoBpmRuntimeConfiguration) {
		super(tibcoBpmRuntimeConfiguration);
		
	}

	/* (non-Javadoc)
	 * @see org.sonar.plugins.bpm.parser.elements.model.tibcoextension.TibcoBpmRuntimeConfiguration#getIncomingRequestTimeout()
	 */
	@Override
	public int getIncomingRequestTimeout() {
		int result = 0;
		try{
		String timeout=this.getCurrentElement().getAttributeValue("IncomingRequestTimeout");
		result = Integer.parseInt(timeout);
		}
		catch(NumberFormatException nfe){
			result=-1;
		}
		
		return result;
	}

}
