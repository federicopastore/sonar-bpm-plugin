/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 * 
 * ArtifactId See section 6.4.7. and 7.1.9. Deprecated in BPMN2.0.
 * Output DataObjectId.
 */
public interface OutputSet extends BaseXpdlElement {
	public String getArtifactId();
	public String getOutput();
}
