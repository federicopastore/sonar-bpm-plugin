/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.RedefinableHeader;
import org.sonar.plugins.bpm.parser.xpdl.enums.PublicationStatus;

/**
 * @author federicopastore
 *
 */
public class RedefinableHeaderImpl extends ElementParser implements
		RedefinableHeader {

	public RedefinableHeaderImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.RedefinableHeader#getAuthor()
	 */
	@Override
	public String getAuthor() {
		return getCurrentElement().getAttributeValue("Author");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.RedefinableHeader#getCodepage()
	 */
	@Override
	public String getCodepage() {
		return getCurrentElement().getAttributeValue("Codepage");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.RedefinableHeader#getCountryKey()
	 */
	@Override
	public String getCountryKey() {
		return getCurrentElement().getAttributeValue("Codepage");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.RedefinableHeader#getPublicationStatus()
	 */
	@Override
	public PublicationStatus getPublicationStatus() {
		// TODO Auto-generated method stub
		return PublicationStatus.valueOf(getCurrentElement().getAttributeValue("PublicationStatus"));
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.RedefinableHeader#getResponsible()
	 */
	@Override
	public String getResponsible() {
		return getCurrentElement().getAttributeValue("Responsible");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.RedefinableHeader#getVersion()
	 */
	@Override
	public String getVersion() {
		return getCurrentElement().getAttributeValue("Version");
	}

}
