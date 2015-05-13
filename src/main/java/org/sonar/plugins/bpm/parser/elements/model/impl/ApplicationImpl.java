package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Application;
import org.sonar.plugins.bpm.parser.elements.model.ExtendedAttribute;
import org.sonar.plugins.bpm.parser.elements.model.ExternalReference;
import org.sonar.plugins.bpm.parser.elements.model.FormalParameter;
import org.sonar.plugins.bpm.parser.xpdl.enums.ApplicationType;

public class ApplicationImpl extends ElementParser implements Application{

	private Element application;
	
	public ApplicationImpl(Element app) {
		super(app);
		this.application=app;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.application.getAttributeValue("Description");
	}



	@Override
	public ExternalReference getExternalReference() {
		Element extRef = this.getChildWithName(application, "ExternalReference");
		if(extRef==null)
			return null;
		return new ExternalReferenceImpl(extRef);
	}

	@Override
	public List<FormalParameter> getFormalParameters() {
		List attrs = application.getChildren("FormalParameter");
		for (Iterator iterator = attrs.iterator(); iterator.hasNext();) {
			Element param = (Element) iterator.next();
			FormalParameterImpl paramImpl = new FormalParameterImpl(param);
			
		}
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.application.getAttributeValue("Id");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.application.getAttributeValue("Name");
	}

	@Override
	public ApplicationType getType() {

		return null;
	}

}
