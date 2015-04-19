package org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.rules;

import java.util.List;

import org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.XpdlCheckRepository;
import org.sonar.api.rules.AnnotationRuleParser;
import org.sonar.api.rules.RuleRepository;

public class XpdlRulesRepository extends RuleRepository
{

    public XpdlRulesRepository(AnnotationRuleParser annotationRuleParser)
    {
        super("xpdl", "xpdl");
        setName("SonarQube");
        this.annotationRuleParser = annotationRuleParser;
    }

    public List createRules()
    {
        return annotationRuleParser.parse("xpdl", XpdlCheckRepository.getCheckClasses());
    }

    private final AnnotationRuleParser annotationRuleParser;
}
