/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

/**
 * @author federicopastore
 *
 */

public interface SubFlow extends BaseXpdlElement {
	public static enum ExecutionType {
		ASYNCHR, SYNCHR
	}
 public List<DataMapping> getDataMappings();
 public String getPackageRef();
 public String getEndPointRef();
 public ExecutionType getExecution();
 public List<ExtendedAttribute> getExtendedAttributes();
 public String getId();
 public String getInstanceDataField();
 public String getName();
 public Activity getStartActivityId();
 public ActivitySet getStartActivitySetId();
 public WorkflowProcess getParentWorkFlow();
 public Activity getParentActivity();
 
}
