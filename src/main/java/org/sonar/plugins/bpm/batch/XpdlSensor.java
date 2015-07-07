package org.sonar.plugins.bpm.batch;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.issue.Issuable;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.rules.ActiveRuleParam;
import org.sonar.api.scan.filesystem.FileQuery;
import org.sonar.api.scan.filesystem.ModuleFileSystem;
import org.sonar.api.utils.SonarException;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.bpm.bpmn.checks.ProcessIssue;
import org.sonar.plugins.bpm.xpdl.checks.AbstractXpdlCheck;
import org.sonar.plugins.bpm.xpdl.checks.XpdlRulesDefinition;
import org.sonar.plugins.bpm.xpdl.checks.XpdlSourceCode;

public class XpdlSensor
    implements Sensor
{
    private static final Logger LOG = LoggerFactory.getLogger(XpdlSensor.class);
    private final ModuleFileSystem fileSystem;
    private final ResourcePerspectives resourcePerspectives;
	private RulesProfile ruleProfile;
    //private final AnnotationCheckFactory annotationCheckFactory;
    
    public XpdlSensor(RulesProfile profile, ModuleFileSystem fileSystem, ResourcePerspectives resourcePerspectives)
    {
        this.fileSystem = fileSystem;
        this.resourcePerspectives = resourcePerspectives;
       // List rules = ruleProfile.getActiveRulesByRepository(XpdlCheckRepository.REPOSITORY_NAME);
        //rules.addAll(c)
       // annotationCheckFactory = AnnotationCheckFactory.create(profile, "xpdl", XpdlCheckRepository.getCheckClasses());
        this.ruleProfile= profile;
    }

    public boolean shouldExecuteOnProject(Project project)
    {
        return !fileSystem.files(FileQuery.onSource().onLanguage(new String[] {
            "xpdl"
        })).isEmpty();
    }

    public void analyse(Project project, SensorContext sensorcontext)
    {
    	
    	List<ActiveRule> rules =this.ruleProfile.getActiveRulesByRepository(XpdlRulesDefinition.REPOSITORY_KEY);
        //Collection checks = annotationCheckFactory.getChecks();
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
                	System.out.println(" rules size: "+rules.size());
/*                    
                    for(Iterator iterator1 = checks.iterator(); iterator1.hasNext(); check.validate(sourceCode))
                    {
                        check = (AbstractXpdlCheck)iterator1.next();
                        check.setRule(annotationCheckFactory.getActiveRule(check).getRule());
                    }*/
                	for (Iterator iterator2 = rules.iterator(); iterator2
							.hasNext();check.validate(sourceCode)) {
						ActiveRule activeRule = (ActiveRule) iterator2.next();
						//System.out.println("creating check for rule: "+activeRule.getRuleKey());
						check = ((AbstractXpdlCheck)createCheck(activeRule));
						check.setRule(activeRule.getRule());
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

    
    protected Object createCheck(ActiveRule activeRule) throws ClassNotFoundException {
        Class clazz = Class.forName(activeRule.getConfigKey());
        if (clazz != null) {
          return instantiate(activeRule, clazz);
        }
        return null;
      }

      private Object instantiate(ActiveRule activeRule, Class clazz) {
        try {
          Object check = clazz.newInstance();
          configureFields(activeRule, check);
          return check;

        } catch (InstantiationException e) {
          throw new SonarException("Can not instantiate the check related to the rule " + activeRule, e);

        } catch (IllegalAccessException e) {
          throw new SonarException("Can not instantiate the check related to the rule " + activeRule, e);
        }
      }
      
      private void configureFields(ActiveRule activeRule, Object check) {
    	    for (ActiveRuleParam param : activeRule.getActiveRuleParams()) {
    	      Field field = getField(check, param.getKey());
    	      if (field == null) {
    	        throw new SonarException("The field " + param.getKey() + " does not exist or is not annotated with @RuleProperty in the class " + check.getClass().getName());
    	      }
    	      if (StringUtils.isNotBlank(param.getValue())) {
    	        configureField(check, field, param.getValue());
    	      }
    	    }

    	  }

    	  private void configureField(Object check, Field field, String value) {
    	    try {
    	      field.setAccessible(true);

    	      if (field.getType().equals(String.class)) {
    	        field.set(check, value);

    	      } else if (field.getType().getSimpleName().equals("int")) {
    	        field.setInt(check, Integer.parseInt(value));

    	      } else if (field.getType().getSimpleName().equals("short")) {
    	        field.setShort(check, Short.parseShort(value));

    	      } else if (field.getType().getSimpleName().equals("long")) {
    	        field.setLong(check, Long.parseLong(value));

    	      } else if (field.getType().getSimpleName().equals("double")) {
    	        field.setDouble(check, Double.parseDouble(value));

    	      } else if (field.getType().getSimpleName().equals("boolean")) {
    	        field.setBoolean(check, Boolean.parseBoolean(value));

    	      } else if (field.getType().getSimpleName().equals("byte")) {
    	        field.setByte(check, Byte.parseByte(value));

    	      } else if (field.getType().equals(Integer.class)) {
    	        field.set(check, new Integer(Integer.parseInt(value)));

    	      } else if (field.getType().equals(Long.class)) {
    	        field.set(check, new Long(Long.parseLong(value)));

    	      } else if (field.getType().equals(Double.class)) {
    	        field.set(check, new Double(Double.parseDouble(value)));

    	      } else if (field.getType().equals(Boolean.class)) {
    	        field.set(check, Boolean.valueOf(Boolean.parseBoolean(value)));

    	      } else {
    	        throw new SonarException("The type of the field " + field + " is not supported: " + field.getType());
    	      }
    	    } catch (IllegalAccessException e) {
    	      throw new SonarException("Can not set the value of the field " + field + " in the class: " + check.getClass().getName());
    	    }
    	  }

    	  private Field getField(Object check, String key) {
    	    Field[] fields = check.getClass().getDeclaredFields();
    	    for (Field field : fields) {
    	      RuleProperty propertyAnnotation = field.getAnnotation(RuleProperty.class);
    	      if (propertyAnnotation != null) {
    	        if (StringUtils.equals(key, field.getName()) || StringUtils.equals(key, propertyAnnotation.key())) {
    	          return field;
    	        }
    	      }
    	    }
    	    return null;
    	  }

}
