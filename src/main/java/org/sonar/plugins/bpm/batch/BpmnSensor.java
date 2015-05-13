package org.sonar.plugins.bpm.batch;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.checks.AnnotationCheckFactory;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.issue.Issuable;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.rules.Rule;
import org.sonar.api.scan.filesystem.FileQuery;
import org.sonar.api.scan.filesystem.ModuleFileSystem;
import org.sonar.plugins.bpm.bpmn.checks.AbstractBPMNCheck;
import org.sonar.plugins.bpm.bpmn.checks.BpmnCheckRepository;
import org.sonar.plugins.bpm.bpmn.checks.BpmnSourceCode;
import org.sonar.plugins.bpm.bpmn.checks.ProcessIssue;

public class BpmnSensor
    implements Sensor
{

    public BpmnSensor(RulesProfile profile, ModuleFileSystem fileSystem, ResourcePerspectives resourcePerspectives)
    {
        this.fileSystem = fileSystem;
        this.resourcePerspectives = resourcePerspectives;
        annotationCheckFactory = AnnotationCheckFactory.create(profile, "bpmn", BpmnCheckRepository.getCheckClasses());
    }

    public boolean shouldExecuteOnProject(Project project)
    {
        return !fileSystem.files(FileQuery.onSource().onLanguage(new String[] {
            "bpmn"
        })).isEmpty();
    }

    public void analyse(Project project, SensorContext sensorcontext)
    {
        Collection checks = annotationCheckFactory.getChecks();
        for(Iterator iterator = fileSystem.files(FileQuery.onSource().onLanguage(new String[] {
    "bpmn"
})).iterator(); iterator.hasNext();)
        {
            File file = (File)iterator.next();
            try
            {
                org.sonar.api.resources.File resource = org.sonar.api.resources.File.fromIOFile(file, project);
                BpmnSourceCode sourceCode = new BpmnSourceCode(resource, file);
                if(sourceCode.parseSource(fileSystem))
                {
                    AbstractBPMNCheck check;
                    for(Iterator iterator1 = checks.iterator(); iterator1.hasNext(); check.validate(sourceCode))
                    {
                        check = (AbstractBPMNCheck)iterator1.next();
                        check.setRule(annotationCheckFactory.getActiveRule(check).getRule());
                    }

                    saveIssue(sourceCode);
                }
            }
            catch(Exception e)
            {
                LOG.error((new StringBuilder("Could not analyze the file ")).append(file.getAbsolutePath()).toString(), e);
            }
        }

    }

    public void saveIssue(BpmnSourceCode sourceCode)
    {
        for(Iterator iterator = sourceCode.getBpmnIssues().iterator(); iterator.hasNext();)
        {
            ProcessIssue bpmnIssue = (ProcessIssue)iterator.next();
            Issuable issuable = (Issuable)resourcePerspectives.as(Issuable.class, sourceCode.getSonarFile());
            if(issuable != null)
            {
                org.sonar.api.issue.Issue issue = issuable.newIssueBuilder().ruleKey(bpmnIssue.getRule().ruleKey()).line(Integer.valueOf(bpmnIssue.getLine())).message(bpmnIssue.getMessage()).build();
                issuable.addIssue(issue);
            }
        }

    }

    private static final Logger LOG = LoggerFactory.getLogger(BpmnSensor.class);
    private final ModuleFileSystem fileSystem;
    private final ResourcePerspectives resourcePerspectives;
    private final AnnotationCheckFactory annotationCheckFactory;

}
