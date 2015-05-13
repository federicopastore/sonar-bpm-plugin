package org.sonar.plugins.bpm.bpmn.checks;

import org.sonar.api.resources.File;
import org.sonar.api.rules.Rule;

public class ProcessIssue
{

    public ProcessIssue(File file, Rule rule, int line, String message)
    {
        this.file = file;
        this.rule = rule;
        this.line = line;
        this.message = message;
    }

    public Rule getRule()
    {
        return rule;
    }

    public int getLine()
    {
        return line;
    }

    public String getMessage()
    {
        return message;
    }

    private final Rule rule;
    private final int line;
    private final String message;
    private final File file;
}
