package org.sonar.plugins.bpm.xpdl.rules;

import java.util.ArrayList;

import org.sonar.api.profiles.*;
import org.sonar.api.utils.ValidationMessages;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.xpdl.checks.XpdlRulesDefinition;

public class XpdlSonarWayProfile extends ProfileDefinition
{

    public XpdlSonarWayProfile(AnnotationProfileParser parser)
    {
        annotationProfileParser = parser;
    }

    public RulesProfile createProfile(ValidationMessages validation)
    {
        return annotationProfileParser.parse(XpdlRulesDefinition.REPOSITORY_KEY, XpdlRulesDefinition.SONAR_WAY_PROFILE_NAME, XpdlLanguage.KEY,XpdlRulesDefinition.getChecks(), validation);
    }

    private final AnnotationProfileParser annotationProfileParser;
}
