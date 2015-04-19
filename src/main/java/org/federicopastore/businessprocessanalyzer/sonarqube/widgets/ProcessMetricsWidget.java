/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.sonarqube.widgets;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;

/**
 * @author federicopastore
 *
 */
@UserRole(UserRole.USER)
@Description("Shows BPM Metrics for the project")

public class ProcessMetricsWidget extends AbstractRubyTemplate implements
		RubyRailsWidget {

	/* (non-Javadoc)
	 * @see org.sonar.api.web.View#getId()
	 */
	@Override
	public String getId() {
		return "process-metadata";
	}

	/* (non-Javadoc)
	 * @see org.sonar.api.web.View#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Process Metadata";
	}

	/* (non-Javadoc)
	 * @see org.sonar.api.web.AbstractRubyTemplate#getTemplatePath()
	 */
	@Override
	protected String getTemplatePath() {
		return "/Bpm-Analyzer/sonar/processmetadata/processmetadata_widget.html.erb";
	}

}
