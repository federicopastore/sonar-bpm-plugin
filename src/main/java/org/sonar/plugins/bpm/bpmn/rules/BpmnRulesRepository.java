package org.sonar.plugins.bpm.bpmn.rules;

import java.util.List;

import org.sonar.api.rules.AnnotationRuleParser;
import org.sonar.api.rules.RuleRepository;
import org.sonar.plugins.bpm.bpmn.checks.BpmnCheckRepository;

public class BpmnRulesRepository extends RuleRepository
{

    public BpmnRulesRepository(AnnotationRuleParser annotationRuleParser)
    {
        super("bpmn", "bpmn");
        setName("SonarQube");
        this.annotationRuleParser = annotationRuleParser;
    }

    public List createRules()
    {
        return annotationRuleParser.parse("bpmn", BpmnCheckRepository.getCheckClasses());
    }

    private final AnnotationRuleParser annotationRuleParser;
}
