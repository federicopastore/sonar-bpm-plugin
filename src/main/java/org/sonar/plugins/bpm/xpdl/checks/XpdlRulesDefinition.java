
package org.sonar.plugins.bpm.xpdl.checks;

import java.util.List;

import com.google.common.collect.ImmutableList;


//@Deprecated
public class XpdlRulesDefinition
{


	private XpdlRulesDefinition(){
    }

    public static List<Class> getChecks()
    {
    	//System.out.println("°°°°°°°°° XpdlCheckRepository.getChecks()");
    	return ImmutableList.<Class>of(
    			ActivityNameNotNullCheck.class,
        		NextActivityDuplicatedCheck.class,
        		ScriptTaskAfterTaskCheck.class,
        		TIBCORuntimeTimeOutConfigurationCheck.class,
        		ReplyToActivityCheck.class
    	);
        
    }



    public static final String REPOSITORY_KEY = "xpdl";
    public static final String REPOSITORY_NAME = "SonarQube Xpdl Repository";
    public static final String SONAR_WAY_PROFILE_NAME = "Sonar way Xpdl Profile";

}
