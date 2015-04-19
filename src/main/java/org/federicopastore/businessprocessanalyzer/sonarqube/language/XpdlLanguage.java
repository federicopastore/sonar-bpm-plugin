package org.federicopastore.businessprocessanalyzer.sonarqube.language;

import org.sonar.api.resources.AbstractLanguage;

public class XpdlLanguage extends AbstractLanguage
{

    public XpdlLanguage()
    {
        super("xpdl", "xpdl");
    }

    public String[] getFileSuffixes()
    {
        return (new String[] {
            ".xpdl"
        });
    }

    public static final String KEY = "xpdl";
    public static final String NAME = "xpdl";
}
