/**
 * 
 */
package org.sonar.plugins.bpm.xpdl.checks;

import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.tibcoextension.TibcoBpmRuntimeConfiguration;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

/**
 * @author federicopastore
 *
 */
@Rule(
		name="TIBCO Runtime TimeOut Configuration Check", 
		description="Each process must set TIBCO Configuration Runtime regarding to time out for incoming calls according to Engineering Rules. This setting affect on CLOSE_WAIT thread Issue",
		key="org.sonar.plugins.bpm.xpdl.checks.TIBCORuntimeTimeOutConfigurationCheck"
		)
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.FAULT_TOLERANCE)
@SqaleConstantRemediation("15min")

public class TIBCORuntimeTimeOutConfigurationCheck extends AbstractXpdlCheck {

    public static final String RULE_KEY = "org.sonar.plugins.bpm.xpdl.checks.TIBCORuntimeTimeOutConfigurationCheck";
    private final RuleKey ruleKey = RuleKey.of(XpdlLanguage.KEY, RULE_KEY);
	
    @RuleProperty(key = "message", defaultValue = "Each process must set TIBCO Configuration Runtime regarding to time out for incoming calls and must be greather then 0")
    private String message;
	
    @RuleProperty(key = "DefaultTimeout", defaultValue = "300",description="Default Timeout to set for BPM processes(expressed in secs)")
    private int defaultTimeout;
    
    
    
    public int getDefaultTimeout() {
		return defaultTimeout;
	}

	public void setDefaultTimeout(int defaultTimeout) {
		this.defaultTimeout = defaultTimeout;
	}

	public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

	
	/* (non-Javadoc)
	 * @see org.sonar.plugins.bpm.xpdl.checks.AbstractXpdlCheck#validate(org.sonar.plugins.bpm.xpdl.checks.XpdlSourceCode)
	 */
    
	@Override
	public void validate(XpdlSourceCode xpdlSourceCode) {
		// TODO Auto-generated method stub
		setWebSourceCode(xpdlSourceCode);
        PackageDefinition model = xpdlSourceCode.getModel();
		TibcoBpmRuntimeConfiguration configuration = model.getRuntimeConfiguration();
		if(configuration == null)
			createViolation(message);
		else{
			int timeout= configuration.getIncomingRequestTimeout();
			if(timeout == -1)
				createViolation(configuration.getStartLineNumber(),"Runtime timeout for incoming calls has undefined value, please set this value according with Engineering Rules");
			if(! (timeout >= getDefaultTimeout()))
				createViolation(configuration.getStartLineNumber(),"Runtime timeout for incoming calls it's too low, please set this value according with Engineering Rules");
		}
	}

}
