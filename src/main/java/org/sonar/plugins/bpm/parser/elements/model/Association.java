/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import org.sonar.plugins.bpm.parser.xpdl.enums.AssociationDirection;

/**
 * @author federicopastore
 *
 */
public interface Association {
	public String getId();
	public String getName();
	public String getDescription();
	public AssociationDirection getAssociationDirection();
	public String getSource();
	public String getTarget();
	public Object getObject();

}
