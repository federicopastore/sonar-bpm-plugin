// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InadequateEventNamingCheck.java

package org.sonar.plugins.bpm.bpmn.checks;

import org.sonar.api.rule.RuleKey;

// Referenced classes of package org.federicopastore.bpmanalyzer.bpmn.checks:
//            AbstractBPMNCheck, BpmnSourceCode

public class InadequateEventNamingCheck extends AbstractBPMNCheck
{

    public InadequateEventNamingCheck()
    {
    }

    public void validate(BpmnSourceCode bpmnsourcecode)
    {
    }

    public static final String RULE_KEY = "InadequateEventNamingCheck";
    private final RuleKey ruleKey = RuleKey.of("bpmn", "InadequateEventNamingCheck");
}
