/**
 * 
 */
package org.sonar.plugins.bpm.widgets;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;

/**
 * @author federicopastore
 *
 */
@UserRole(UserRole.USER)
@Description("Shows BPM representation for the project")

public class ProcessViewerWidget extends AbstractRubyTemplate implements
		RubyRailsWidget {

	/* (non-Javadoc)
	 * @see org.sonar.api.web.View#getId()
	 */
	@Override
	public String getId() {
		return "process-viewer";
	}

	/* (non-Javadoc)
	 * @see org.sonar.api.web.View#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Process Viewer";
	}

	/* (non-Javadoc)
	 * @see org.sonar.api.web.AbstractRubyTemplate#getTemplatePath()
	 */
	@Override
	protected String getTemplatePath() {
		return "/Bpm-Analyzer/sonar/processmetadata/process_viewer_widget.html.erb";
	}

}
