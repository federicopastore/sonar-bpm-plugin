/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Implementation;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.SubFlow;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Task;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.ImplementationType;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TaskImplementationType;

/**
 * @author federicopastore
 *
 */
public class ImplementationImpl implements Implementation {

	
	private Task task;
	private TaskImplementationType tasktype;
	private ImplementationType type;
	private SubFlow subflow;
	

	public ImplementationImpl(Task task, ImplementationType type) {

		this.task=task;
		this.tasktype= task.getType();
		this.type = type;
		
	}



	public ImplementationImpl(
			SubFlow subflow,
			org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.ImplementationType subflowtype) {
		this.subflow= subflow;
		this.type = subflowtype;
	}



	@Override
	public Task getTask() {
		return this.task;
	}



	@Override
	public ImplementationType getType() {
		return this.type;
	}



	@Override
	public SubFlow getSubFlow() {
		return this.subflow;
	}




}
