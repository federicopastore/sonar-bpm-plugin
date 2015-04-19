/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.AssociationDirection;

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
