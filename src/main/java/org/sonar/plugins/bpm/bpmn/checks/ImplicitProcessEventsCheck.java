// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplicitProcessEventsCheck.java

package org.sonar.plugins.bpm.bpmn.checks;

import java.util.Iterator;
import java.util.List;

import org.activiti.bpmn.model.*;
import org.activiti.bpmn.model.Process;
import org.sonar.api.rule.RuleKey;

// Referenced classes of package org.federicopastore.bpmanalyzer.bpmn.checks:
//            AbstractBPMNCheck, BpmnSourceCode

public class ImplicitProcessEventsCheck extends AbstractBPMNCheck
{

    public ImplicitProcessEventsCheck()
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

    public void validate(BpmnSourceCode bpmnSourceCode)
    {
        setWebSourceCode(bpmnSourceCode);
        BpmnModel model = bpmnSourceCode.getModel();
        List processes = model.getProcesses();
        for(Iterator iterator = processes.iterator(); iterator.hasNext();)
        {
            Process process = (Process)iterator.next();
            if(process.findFlowElementsOfType(StartEvent.class).isEmpty() || process.findFlowElementsOfType(EndEvent.class).isEmpty())
                createViolation(Integer.valueOf(process.getXmlRowNumber()), message);
        }

    }

    public static final String RULE_KEY = "ImplicitProcessEventsCheck";
    private final RuleKey ruleKey = RuleKey.of("bpmn", "ImplicitProcessEventsCheck");
    private String message;
}
