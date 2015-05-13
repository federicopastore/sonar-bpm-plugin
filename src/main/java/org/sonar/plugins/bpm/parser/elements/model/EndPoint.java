package org.sonar.plugins.bpm.parser.elements.model;

public interface EndPoint extends BaseXpdlElement {
public String getEndPointType();
public ExternalReference getExternalReference();
}
