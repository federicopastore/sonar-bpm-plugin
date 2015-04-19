package org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.rules;

import org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.checks.BpmnCheckRepository;
import org.federicopastore.businessprocessanalyzer.sonarqube.language.BpmnLanguage;
import org.sonar.api.profiles.*;
import org.sonar.api.utils.ValidationMessages;

public class BPMNSonarWayProfile extends ProfileDefinition
{

    public BPMNSonarWayProfile(AnnotationProfileParser parser)
    {
        annotationProfileParser = parser;
    }

    public RulesProfile createProfile(ValidationMessages validation)
    {
        return annotationProfileParser.parse(BpmnCheckRepository.REPOSITORY_KEY, BpmnCheckRepository.SONAR_WAY_PROFILE_NAME, BpmnLanguage.KEY, BpmnCheckRepository.getCheckClasses(), validation);
    }

    private final AnnotationProfileParser annotationProfileParser;
}
