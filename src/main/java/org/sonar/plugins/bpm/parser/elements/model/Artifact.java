/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;

import org.sonar.plugins.bpm.parser.xpdl.enums.ArtifactType;

/**
 * @author federicopastore
 *
 * Id Id of the artifact.
 * Name Name of the artifact.
 * ArtifactType DataObject | Group | Annotation
 * DataObject See section 7.1.9.5.
 * Group Name of the Group. Attribute deprecated in 2.1. Replaced by Group Element. See section 7.1.9.6.
 * NodeGraphicsInfos See section 7.1.1.
 * Object See section 7.1.9.4.
 * TextAnnotation Visible textual description.
 *
 */
public interface Artifact extends BaseXpdlElement {
	public String getId();
	public String getName();
	public ArtifactType getArtifactType();
	public DataObject getDataObject();
	public String getGroup();
	public List<NodeGraphicsInfo> getNodeGraphicsInfos();
	public Object getObject();
	public String getTextAnnotation();
}
