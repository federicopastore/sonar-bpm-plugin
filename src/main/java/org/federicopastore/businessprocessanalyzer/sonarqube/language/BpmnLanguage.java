package org.federicopastore.businessprocessanalyzer.sonarqube.language;

import org.sonar.api.resources.AbstractLanguage;

public class BpmnLanguage extends AbstractLanguage
{

    public BpmnLanguage()
    {
        super("bpmn", "Bpmn");
    }

    public String[] getFileSuffixes()
    {
        return (new String[] {
            ".bpmn"
        });
    }

    public static final String KEY = "bpmn";
    public static final String NAME = "Bpmn";
}
