/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;

import org.sonar.plugins.bpm.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 *
 */
public interface Task extends BaseXpdlElement {
	


TaskImplementationType getType();


}
