package org.federicopastore.businessprocessanalyzer.sonarqube;

import java.util.Arrays;
import java.util.List;

import org.federicopastore.businessprocessanalyzer.sonarqube.batch.BpmnSensor;
import org.federicopastore.businessprocessanalyzer.sonarqube.batch.XpdlDecorator;
import org.federicopastore.businessprocessanalyzer.sonarqube.batch.XpdlSensor;
import org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.rules.BPMNSonarWayProfile;
import org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.rules.BpmnRulesRepository;
import org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.rules.XpdlRulesRepository;
import org.federicopastore.businessprocessanalyzer.sonarqube.language.BpmnLanguage;
import org.federicopastore.businessprocessanalyzer.sonarqube.language.XpdlLanguage;
import org.federicopastore.businessprocessanalyzer.sonarqube.metrics.ProcessMetrics;
import org.federicopastore.businessprocessanalyzer.sonarqube.widgets.ProcessMetricsWidget;
import org.sonar.api.SonarPlugin;

public class BPMAnalyzerPlugin extends SonarPlugin
{

    public BPMAnalyzerPlugin()
    {
    }

    public List getExtensions()
    {
        return Arrays.asList(new Class[] {
            BpmnLanguage.class, 
            XpdlLanguage.class, 
            BPMNSonarWayProfile.class, 
            BpmnRulesRepository.class, 
            XpdlRulesRepository.class,
            BpmnSensor.class,
            XpdlSensor.class,
            ProcessMetrics.class,
            ProcessMetricsWidget.class,
            XpdlDecorator.class
        });
    }

    public static final String KEY_PLUGIN_PROPERTY = "sonar.BPMAnalyzerPlugin";
}
