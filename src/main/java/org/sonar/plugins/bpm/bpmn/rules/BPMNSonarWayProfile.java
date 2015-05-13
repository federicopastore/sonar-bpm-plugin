package org.sonar.plugins.bpm.bpmn.rules;

import org.sonar.api.profiles.*;
import org.sonar.api.utils.ValidationMessages;
import org.sonar.plugins.bpm.bpmn.checks.BpmnCheckRepository;
import org.sonar.plugins.bpm.language.BpmnLanguage;

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
