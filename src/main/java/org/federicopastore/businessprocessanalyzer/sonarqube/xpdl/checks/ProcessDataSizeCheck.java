/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Activity;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.DataField;
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
		name="ProcessDataSizeCheck", 
		description="Size of data being passed around the process and passed to work items can have a marked impact on performance",
		key="ProcessDataSizeCheck"
		)
public class ProcessDataSizeCheck extends AbstractXpdlCheck {
	
	public static final String RULE_KEY = "ActivityNameNotNullCheck";
    private final RuleKey ruleKey = RuleKey.of(XpdlLanguage.KEY, "ActivityNameNotNullCheck");

    @RuleProperty(
    		key = "sizeTreshold", 
    		defaultValue = "20.0"
    		)
    private double sizeTreshold = 20.0;
    
    public double getSizeTreshold() {
		return sizeTreshold;
	}

	public void setSizeTreshold(double sizeTreshold) {
		this.sizeTreshold = sizeTreshold;
	}

	@RuleProperty(key = "message", defaultValue = "Size of data being passed around the process can have a marked impact on performance; refactor data to improve Performance")
    private String message;
    
	public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
	
	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.AbstractXpdlCheck#validate(org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.XpdlSourceCode)
	 */
	@Override
	public void validate(XpdlSourceCode xpdlSourceCode) {
		
		setWebSourceCode(xpdlSourceCode);
        PackageDefinition model = xpdlSourceCode.getModel();
        List<WorkflowProcess> processes = model.getProcesses();
        for (Iterator iterator = processes.iterator(); iterator.hasNext();) {
        	WorkflowProcess process = (WorkflowProcess) iterator.next();
        	List<DataField> datafields= process.getDataFields();
        	int size = datafields.size();
        	int length=0;
        	for (Iterator iterator2 = datafields.iterator(); iterator2
					.hasNext();) {
				DataField dataField = (DataField) iterator2.next();
				length += Integer.parseInt(dataField.getLength());
			}
        	double avg = length/size;
        	if(avg >= this.sizeTreshold){
	        		createViolation(process.getStartLineNumber(),message);
        	}
		}

	}

}
