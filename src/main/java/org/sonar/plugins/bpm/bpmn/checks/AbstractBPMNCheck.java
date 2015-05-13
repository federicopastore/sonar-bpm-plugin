package org.sonar.plugins.bpm.bpmn.checks;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.resources.File;
import org.sonar.api.rules.Rule;
import org.sonar.api.utils.WildcardPattern;

public abstract class AbstractBPMNCheck
{

    public AbstractBPMNCheck()
    {
    }

    protected final void createViolation(Integer linePosition)
    {
        createViolation(linePosition, rule.getDescription());
    }

    protected final void createViolation(Integer linePosition, String message)
    {
        getWebSourceCode().addViolation(new ProcessIssue(getWebSourceCode().getSonarFile(), rule, linePosition.intValue(), message));
    }

    protected final void createViolation(String message)
    {
        getWebSourceCode().addViolation(new ProcessIssue(getWebSourceCode().getSonarFile(), rule, 1, message));
    }

    protected BpmnSourceCode getWebSourceCode()
    {
        return bpmnSourceCode;
    }

    protected boolean isFileIncluded(String filePattern)
    {
        if(filePattern != null)
        {
            String fileName = getWebSourceCode().getSonarFile().getKey();
            WildcardPattern matcher = WildcardPattern.create(filePattern);
            return matcher.match(fileName);
        } else
        {
            return true;
        }
    }

    public final void setRule(Rule rule)
    {
        this.rule = rule;
    }

    protected void setWebSourceCode(BpmnSourceCode bpmnSourceCode)
    {
        this.bpmnSourceCode = bpmnSourceCode;
    }

    public String[] trimSplitCommaSeparatedList(String value)
    {
        String tokens[] = StringUtils.split(value, ",");
        for(int i = 0; i < tokens.length; i++)
            tokens[i] = tokens[i].trim();

        return tokens;
    }

    public abstract void validate(BpmnSourceCode bpmnsourcecode);

    private Rule rule;
    private BpmnSourceCode bpmnSourceCode;
}
