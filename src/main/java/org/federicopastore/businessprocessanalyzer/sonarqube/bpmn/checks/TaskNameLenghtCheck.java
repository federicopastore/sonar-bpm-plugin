// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TaskNameLenghtCheck.java

package org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.checks;

import java.util.Collection;
import java.util.Iterator;
import org.activiti.bpmn.model.*;

// Referenced classes of package org.federicopastore.bpmanalyzer.bpmn.checks:
//            AbstractBPMNCheck, BpmnSourceCode

public class TaskNameLenghtCheck extends AbstractBPMNCheck
{

    public TaskNameLenghtCheck()
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
        Collection tasks = model.getMainProcess().findFlowElementsOfType(ServiceTask.class);
        for(Iterator iterator = tasks.iterator(); iterator.hasNext();)
        {
            ServiceTask element = (ServiceTask)iterator.next();
            if(element.getName().length() < Integer.parseInt(getLength()))
                if(message != null)
                    createViolation(Integer.valueOf(element.getXmlRowNumber()), message);
                else
                    createViolation(Integer.valueOf(element.getXmlRowNumber()));
        }

    }

    private String length;
    private String message;
}
