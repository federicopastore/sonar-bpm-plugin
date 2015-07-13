package org.sonar.plugins.bpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sonar.api.CoreProperties;
import org.sonar.api.PropertyType;
import org.sonar.api.SonarPlugin;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.plugins.bpm.batch.BpmnSensor;
import org.sonar.plugins.bpm.batch.XpdlDecorator;
import org.sonar.plugins.bpm.batch.XpdlSensor;
import org.sonar.plugins.bpm.bpmn.rules.BPMNSonarWayProfile;
import org.sonar.plugins.bpm.bpmn.rules.BpmnRulesRepository;
import org.sonar.plugins.bpm.dashboards.ProcessIssuesDashboard;
import org.sonar.plugins.bpm.language.BpmnLanguage;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.metrics.ProcessMetrics;
import org.sonar.plugins.bpm.widgets.ProcessViewerWidget;
import org.sonar.plugins.bpm.widgets.issues.ProcessIssueFilterWidget;
import org.sonar.plugins.bpm.widgets.issues.XpdlToBpmnTransformer;
import org.sonar.plugins.bpm.xpdl.rules.XpdlRulesRepository;

import com.google.common.collect.ImmutableList;

public class BPMAnalyzerPlugin extends SonarPlugin
{

    public BPMAnalyzerPlugin()
    {
    }
    private static List<PropertyDefinition> technicalDebtProperties() {
        
        return ImmutableList.of(
        		PropertyDefinition.builder(CoreProperties.SIZE_METRIC)
                .defaultValue("" + CoreMetrics.NCLOC_KEY)
                .name("Size metric")
                .description("Metric used to estimate artifact's development cost.")
                .type(PropertyType.METRIC)
                .options("key:^(ncloc|complexity|noa)$")
                .category(CoreProperties.CATEGORY_TECHNICAL_DEBT)
                .deprecatedKey("sizeMetric")
                .build()
        		);
    }

    public List getExtensions()
    {
    	List<Object> l = new ArrayList<Object>();
    	
        //return Arrays.asList(new Class[] {
        		//Bpmn language
            //BpmnLanguage.class, 
            //BPMNSonarWayProfile.class, 
            //BpmnRulesRepository.class, 
            //BpmnSensor.class,
        		
        		//XPDL language
        	l.add(XpdlLanguage.class); 
        	l.add(XpdlRulesRepository.class);
        	l.add(XpdlSensor.class);
        	l.add(ProcessMetrics.class);
        	l.add(ProcessViewerWidget.class);
        	l.add(XpdlDecorator.class);
        	
        	//
        	l.add(ProcessIssuesDashboard.class);
        	l.add(ProcessIssueFilterWidget.class);
        	
        	//Components
        	l.add(XpdlToBpmnTransformer.class);
        	
        	l.add(technicalDebtProperties());
        	
        return l;
    }

    public static final String KEY_PLUGIN_PROPERTY = "sonar.BPMAnalyzerPlugin";
}
