/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 *
 */
public interface Task extends BaseXpdlElement {
	


TaskImplementationType getType();


}
