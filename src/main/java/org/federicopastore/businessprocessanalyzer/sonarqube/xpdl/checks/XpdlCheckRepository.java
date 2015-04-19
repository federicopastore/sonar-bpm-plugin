
package org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;


public class XpdlCheckRepository
{

    private XpdlCheckRepository()
    {
    }

    public static List getChecks()
    {
        return ImmutableList.of(
        		new ActivityNameNotNullCheck(),
        		//new ProcessDataSizeCheck(),
        		new NextActivityDuplicatedCheck(),
        		new ScriptTaskAfterTaskCheck()
        		);
    }

    public static List getCheckClasses()
    {
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        AbstractXpdlCheck check;
        for(Iterator<AbstractXpdlCheck> iterator = getChecks().iterator(); iterator.hasNext(); builder.add(check.getClass()))
            check = iterator.next();
        return builder.build();
    }

    public static final String REPOSITORY_KEY = "xpdl";
    public static final String REPOSITORY_NAME = "SonarQube";
    public static final String SONAR_WAY_PROFILE_NAME = "Sonar way";
}
