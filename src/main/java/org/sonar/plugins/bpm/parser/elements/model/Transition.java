package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;

import org.sonar.plugins.bpm.parser.elements.enums.ConditionType;

public interface Transition extends BaseXpdlElement {



	public WorkflowProcess getParentWorkFlow();
	public Activity getFrom();
	public Activity getTo();
	public String getId();
	public String getName();
	public ConditionType getCondition();
	public List<ConnectorGraphicsInfo> getConnectorGraphicsInfos();
}
