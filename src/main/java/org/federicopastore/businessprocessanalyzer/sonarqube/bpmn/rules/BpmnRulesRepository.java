package org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.rules;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.checks.BpmnCheckRepository;
import org.sonar.api.rules.AnnotationRuleParser;
import org.sonar.api.rules.RuleRepository;

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
