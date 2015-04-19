
package org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.checks;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;


public class BpmnCheckRepository
{

    private BpmnCheckRepository()
    {
    }

    public static List getChecks()
    {
        return ImmutableList.of(/*
        		new TaskNameLenghtCheck(), 
        		new SizeOfModelCheck(), 
        		new ControlFlowComplexityCheck(), 
        		new ImplicitProcessEventsCheck(), 
        		new InadequateEventNamingCheck(), 
        		new EqualEventsCheck()*/
        		);
    }

    public static List getCheckClasses()
    {
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        AbstractBPMNCheck check;
        for(Iterator iterator = getChecks().iterator(); iterator.hasNext(); builder.add(check.getClass()))
            check = (AbstractBPMNCheck)iterator.next();

        return builder.build();
    }

    public static final String REPOSITORY_KEY = "bpmn";
    public static final String REPOSITORY_NAME = "SonarQube";
    public static final String SONAR_WAY_PROFILE_NAME = "Sonar way";
}
