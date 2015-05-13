/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.DataAssociation;

/**
 * @author federicopastore
 *
 */
public class DataAssociationImpl extends ElementParser implements
		DataAssociation {

	public DataAssociationImpl(Element element) {
		super(element);
	}

}
