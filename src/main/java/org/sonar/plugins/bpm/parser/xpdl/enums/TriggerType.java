/**
 * 
 */
package org.sonar.plugins.bpm.parser.xpdl.enums;

/**
 * @author federicopastore
 *
 */
public enum TriggerType {
	None,
	Message,
	Timer,
	Error,
	Escalation,
	Cancel,
	Compensation,
	Conditional,
	Link,
	Signal,
	Terminate,
	Multiple,
	ParallelMultiple
}
