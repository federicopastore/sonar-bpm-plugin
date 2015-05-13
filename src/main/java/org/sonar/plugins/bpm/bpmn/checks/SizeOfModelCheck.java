// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SizeOfModelCheck.java

package org.sonar.plugins.bpm.bpmn.checks;

import java.util.Collection;
import org.activiti.bpmn.model.*;
import org.sonar.api.rule.RuleKey;

// Referenced classes of package org.federicopastore.bpmanalyzer.bpmn.checks:
//            AbstractBPMNCheck, BpmnSourceCode

public class SizeOfModelCheck extends AbstractBPMNCheck
{

    public SizeOfModelCheck()
    {
    }

    public String getLength()
    {
        return length;
    }

    public void setLength(String length)
    {
        this.length = length;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void validate(BpmnSourceCode bpmnSourceCode)
    {
        setWebSourceCode(bpmnSourceCode);
        BpmnModel model = bpmnSourceCode.getModel();
        Collection tasks = model.getMainProcess().findFlowElementsOfType(Task.class);
        if(tasks.size() > Integer.parseInt(getLength()))
            if(message != null)
                createViolation(Integer.valueOf(1), message);
            else
                createViolation(Integer.valueOf(1));
    }

    public static final String RULE_KEY = "SizeOfModelCheck";
    private final RuleKey ruleKey = RuleKey.of("bpmn", "SizeOfModelCheck");
    private String length;
    private String message;
}
