package org.sonar.plugins.bpm.xpdl.rules;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.plugins.bpm.language.XpdlLanguage;
import org.sonar.plugins.bpm.xpdl.checks.XpdlRulesDefinition;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

public class XpdlRulesRepository implements RulesDefinition
{
    public static final String REPOSITORY_KEY = "xpdl";
    public static final String REPOSITORY_NAME = "SonarQube Xpdl Repository";
    public static final String SONAR_WAY_PROFILE_NAME = "Sonar way Xpdl Profile";
	

	@Override
	public void define(Context context) {
		NewRepository repository = context.
	    	      createRepository(REPOSITORY_KEY, XpdlLanguage.KEY).
	    	      setName(REPOSITORY_NAME);
		AnnotationBasedRulesDefinition.load(repository, XpdlLanguage.KEY, XpdlRulesDefinition.getChecks());
		//RulesDefinitionAnnotationLoader loader = new RulesDefinitionAnnotationLoader();
		//loader.load(repository, (Class[]) XpdlRulesDefinition.getChecks().toArray(new Class[XpdlRulesDefinition.getChecks().size()]));
	    	    for (NewRule rule : repository.rules()) {
	    	      //FIXME: set internal key to key to ensure rule templates works properly : should be removed when SONAR-6162 is fixed.
	    	      rule.setInternalKey(rule.key());
	    	    }
	    repository.done();
  }

}
