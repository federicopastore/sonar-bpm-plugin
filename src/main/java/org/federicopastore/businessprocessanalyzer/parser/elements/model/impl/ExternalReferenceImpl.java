/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.ExternalReference;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class ExternalReferenceImpl extends ElementParser implements ExternalReference {

	public ExternalReferenceImpl(Element extRef) {
		super(extRef);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ExternalReference#getLocation()
	 */
	@Override
	public URI getLocation(){
		String uri = getCurrentElement().getAttributeValue("location");
		if (uri==null)
			return null;
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ExternalReference#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return getCurrentElement().getAttributeValue("namespace");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.ExternalReference#getXref()
	 */
	@Override
	public String getXref() {
		return getCurrentElement().getAttributeValue("xref");
	}

}
