/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import org.sonar.plugins.bpm.parser.xpdl.enums.ImplementationType;

/**
 * @author federicopastore
 *
 */
public interface Implementation {
	

	public Task getTask();
	public ImplementationType getType();
	public SubFlow getSubFlow();
}
