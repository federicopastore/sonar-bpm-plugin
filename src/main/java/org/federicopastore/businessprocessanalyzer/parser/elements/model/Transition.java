package org.federicopastore.businessprocessanalyzer.parser.elements.model;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.enums.ConditionType;

public interface Transition extends BaseXpdlElement {



	public WorkflowProcess getParentWorkFlow();
	public Activity getFrom();
	public Activity getTo();
	public String getId();
	public String getName();
	public ConditionType getCondition();
	public List<ConnectorGraphicsInfo> getConnectorGraphicsInfos();
}
