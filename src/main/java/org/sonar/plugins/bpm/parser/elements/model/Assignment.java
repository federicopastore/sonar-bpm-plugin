/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 * Target Lvalue expression, normally the Id of a Data Field or Formal Parameter.
 * Expression Rvalue expression in the scripting language specified for the package.
 * AssignTime Specifies time of evaluation and assignment: Start or End of Process or Activity. Not relevant to transition/sequence flow or to actual parameters.
 */
public interface Assignment extends BaseXpdlElement {
	public String getTarget();
	public String getExpression();
	public String getAssignTime();
}
