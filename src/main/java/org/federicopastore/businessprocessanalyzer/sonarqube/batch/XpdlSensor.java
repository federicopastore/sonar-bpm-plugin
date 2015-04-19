package org.federicopastore.businessprocessanalyzer.sonarqube.batch;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import org.federicopastore.businessprocessanalyzer.sonarqube.bpmn.checks.ProcessIssue;
import org.federicopastore.businessprocessanalyzer.sonarqube.metrics.ProcessMetrics;
import org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.AbstractXpdlCheck;
import org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.XpdlCheckRepository;
import org.federicopastore.businessprocessanalyzer.sonarqube.xpdl.checks.XpdlSourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.checks.AnnotationCheckFactory;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.issue.Issuable;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Measure;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Project;
import org.sonar.api.scan.filesystem.FileQuery;
import org.sonar.api.scan.filesystem.ModuleFileSystem;

public class XpdlSensor
    implements Sensor
{
    private static final Logger LOG = LoggerFactory.getLogger(XpdlSensor.class);
    private final ModuleFileSystem fileSystem;
    private final ResourcePerspectives resourcePerspectives;
    private final AnnotationCheckFactory annotationCheckFactory;
    
    public XpdlSensor(RulesProfile profile, ModuleFileSystem fileSystem, ResourcePerspectives resourcePerspectives)
    {
        this.fileSystem = fileSystem;
        this.resourcePerspectives = resourcePerspectives;
        annotationCheckFactory = AnnotationCheckFactory.create(profile, "xpdl", XpdlCheckRepository.getCheckClasses());
    }

    public boolean shouldExecuteOnProject(Project project)
    {
        return !fileSystem.files(FileQuery.onSource().onLanguage(new String[] {
            "xpdl"
        })).isEmpty();
    }

    public void analyse(Project project, SensorContext sensorcontext)
    {
    	
        Collection checks = annotationCheckFactory.getChecks();
        for(Iterator iterator = fileSystem.files(FileQuery.onSource().onLanguage(new String[] {
    "xpdl"
})).iterator(); iterator.hasNext();)
        {
            File file = (File)iterator.next();
            try
            {
                org.sonar.api.resources.File resource = org.sonar.api.resources.File.fromIOFile(file, project);
                XpdlSourceCode sourceCode = new XpdlSourceCode(resource, file);
                if(sourceCode.parseSource(fileSystem))
                {
                    AbstractXpdlCheck check;
                    for(Iterator iterator1 = checks.iterator(); iterator1.hasNext(); check.validate(sourceCode))
                    {
                        check = (AbstractXpdlCheck)iterator1.next();
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

    public void saveIssue(XpdlSourceCode sourceCode)
    {
        for(Iterator iterator = sourceCode.getProcessIssues().iterator(); iterator.hasNext();)
        {
            ProcessIssue processIssue = (ProcessIssue)iterator.next();
            Issuable issuable = (Issuable)resourcePerspectives.as(Issuable.class, sourceCode.getSonarFile());
            if(issuable != null)
            {
                org.sonar.api.issue.Issue issue = issuable.newIssueBuilder().ruleKey(processIssue.getRule().ruleKey()).line(Integer.valueOf(processIssue.getLine())).message(processIssue.getMessage()).build();
                issuable.addIssue(issue);
            }
        }

    }

}
