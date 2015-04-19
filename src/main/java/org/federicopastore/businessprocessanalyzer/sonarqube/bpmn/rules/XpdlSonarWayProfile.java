package org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.rules;

import org.federicopastore.businessprocessanalyzer.sonarqube.language.XpdlLanguage;
import org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.XpdlCheckRepository;
import org.sonar.api.profiles.*;
import org.sonar.api.utils.ValidationMessages;

public class XpdlSonarWayProfile extends ProfileDefinition
{

    public XpdlSonarWayProfile(AnnotationProfileParser parser)
    {
        annotationProfileParser = parser;
    }

    public RulesProfile createProfile(ValidationMessages validation)
    {
        return annotationProfileParser.parse(XpdlCheckRepository.REPOSITORY_KEY, XpdlCheckRepository.SONAR_WAY_PROFILE_NAME, XpdlLanguage.KEY, XpdlCheckRepository.getCheckClasses(), validation);
    }

    private final AnnotationProfileParser annotationProfileParser;
}
