package org.sonar.plugins.bpm;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.SonarPlugin;
import org.sonar.plugins.bpm.batch.BpmnSensor;
import org.sonar.plugins.bpm.batch.XpdlDecorator;
import org.sonar.plugins.bpm.batch.XpdlSensor;
import org.sonar.plugins.bpm.bpmn.rules.BPMNSonarWayProfile;
import org.sonar.plugins.bpm.bpmn.rules.BpmnRulesRepository;
import org.sonar.plugins.bpm.dashboards.ProcessIssuesDashboard;
import org.sonar.plugins.bpm.language.BpmnLanguage;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.metrics.ProcessMetrics;
import org.sonar.plugins.bpm.widgets.ProcessMetricsWidget;
import org.sonar.plugins.bpm.widgets.issues.ProcessIssueFilterWidget;
import org.sonar.plugins.bpm.widgets.issues.XpdlToBpmnTransformer;
import org.sonar.plugins.bpm.xpdl.rules.XpdlRulesRepository;

public class BPMAnalyzerPlugin extends SonarPlugin
{

    public BPMAnalyzerPlugin()
    {
    }

    public List getExtensions()
    {
        return Arrays.asList(new Class[] {
        		//Bpmn language
            //BpmnLanguage.class, 
            //BPMNSonarWayProfile.class, 
            //BpmnRulesRepository.class, 
            //BpmnSensor.class,
        		
        		//XPDL language
        	XpdlLanguage.class, 
            XpdlRulesRepository.class,
            XpdlSensor.class,
            ProcessMetrics.class,
            ProcessMetricsWidget.class,
            XpdlDecorator.class,
        	
        	//
        	ProcessIssuesDashboard.class,
        	ProcessIssueFilterWidget.class,
        	
        	//Components
        	XpdlToBpmnTransformer.class
        });
    }

    public static final String KEY_PLUGIN_PROPERTY = "sonar.BPMAnalyzerPlugin";
}
