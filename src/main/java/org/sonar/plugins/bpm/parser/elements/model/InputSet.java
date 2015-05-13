/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;

/**
 * @author federicopastore
 * 
 * ArtifactId See section 6.4.7. and 7.1.9. Deprecated in BPMN2.0
 * ArtifactInputs A list of Artifacts. Deprecated in BPMN2.0
 * DataObjectId Reference the Id of a DataObject defined in the same scope.
 * PropertyInputs A list of Properties.
 * RequiredForStart The default value for this attribute is True. This means that the Input is required for an activity to start. If set to False, then the activity MAY start with the input if it is available, but MAY accept the input (more than once) after the activity has started. An InputSet may have some ArtifactInputs that have this attribute set to True and some that are set to False.
 */
public interface InputSet extends BaseXpdlElement {

	public String getArtifactId();
	public List<Artifact> getArtifactInputs();
	public String getDataObjectId();
	public List<Property> getPropertyInputs();
	public boolean getRequiredForStart();
}
