/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Activity;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.PackageDefinition;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.WorkflowProcess;
import org.federicopastore.businessprocessanalyzer.sonarqube.language.XpdlLanguage;
import org.sonar.api.rule.RuleKey;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;

/**
 * @author federicopastore
 *
 */
@Rule(
		name="ActivityNameNotNullCheck", 
		description="The task name is used to identify a migration point. This means that all tasks must have names."
					+"\n Note: By default, gateways do not have names. This means that you must specify a name for all gateways in your process if you want them to be valid migration points.",
		key="ActivityNameLenghtCheck"
		)
public class ActivityNameNotNullCheck extends AbstractXpdlCheck {

    public static final String RULE_KEY = "ActivityNameNotNullCheck";
    private final RuleKey ruleKey = RuleKey.of(XpdlLanguage.KEY, "ActivityNameNotNullCheck");
    
    @RuleProperty(key = "message", defaultValue = "The task name is used to identify a migration point. This means that all tasks must have names")
    private String message;
    
    
	   public ActivityNameNotNullCheck()
	    {
	    }


	    public String getMessage()
	    {
	        return message;
	    }

	    public void setMessage(String message)
	    {
	        this.message = message;
	    }

	    public void validate(XpdlSourceCode xpdlSourceCode)
	    {
	        setWebSourceCode(xpdlSourceCode);
	        PackageDefinition model = xpdlSourceCode.getModel();
	        List<WorkflowProcess> processes = model.getProcesses();
	        for (Iterator iterator = processes.iterator(); iterator.hasNext();) {
	        	WorkflowProcess process = (WorkflowProcess) iterator.next();
				Collection<Activity> tasks = process.getActivities();
		        for(Iterator<Activity> iterator2 = tasks.iterator(); iterator2.hasNext();)
		        {
		        	Activity element = iterator2.next();
		        	if(element.getName()==null)
		        		createViolation(element.getStartLineNumber(),message);
		        }
			}
	        

	    }

	    
}
