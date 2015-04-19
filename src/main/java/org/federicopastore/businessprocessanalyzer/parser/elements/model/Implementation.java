/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.ImplementationType;

/**
 * @author federicopastore
 *
 */
public interface Implementation {
	

	public Task getTask();
	public ImplementationType getType();
	public SubFlow getSubFlow();
}
