/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.List;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.Artifact;
import org.sonar.plugins.bpm.parser.elements.model.DataObject;
import org.sonar.plugins.bpm.parser.elements.model.NodeGraphicsInfo;
import org.sonar.plugins.bpm.parser.elements.model.Object;
import org.sonar.plugins.bpm.parser.xpdl.enums.ArtifactType;

/**
 * @author federicopastore
 *
 */
public class ArtifactImpl extends ElementParser implements Artifact{

	public ArtifactImpl(Element element) {
		super(element);
	}

	private Element artifact;



	

	@Override
	public ArtifactType getArtifactType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject getDataObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGroup() {
		return getCurrentElement().getAttributeValue("Group");
	}

	@Override
	public List<NodeGraphicsInfo> getNodeGraphicsInfos() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getTextAnnotation() {
		return getCurrentElement().getAttributeValue("TextAnnotation");
	}

}
