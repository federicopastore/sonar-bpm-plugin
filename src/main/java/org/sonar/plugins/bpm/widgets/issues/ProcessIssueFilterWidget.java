/**
 * 
 */
package org.sonar.plugins.bpm.widgets.issues;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.WidgetCategory;
import org.sonar.api.web.WidgetProperties;
import org.sonar.api.web.WidgetProperty;
import org.sonar.api.web.WidgetPropertyType;
import org.sonar.api.web.WidgetScope;

import static org.sonar.api.web.WidgetScope.PROJECT;
/**
 * @author federicopastore
 * REplacement of original ProjectIssueFilter for processes usage
 */

@WidgetCategory({"Filters", "Issues"})
@WidgetScope(PROJECT)
@WidgetProperties({
  @WidgetProperty(key = ProcessIssueFilterWidget.FILTER_PROPERTY, type = WidgetPropertyType.ISSUE_FILTER, optional = false),
  @WidgetProperty(key = ProcessIssueFilterWidget.DISTRIBUTION_AXIS_PROPERTY, type = WidgetPropertyType.SINGLE_SELECT_LIST, defaultValue = "severities",
          options = {"severities", "resolutions", "statuses", "rules", "tags", "assignees", "reporters", "authors",
                  "languages", "actionPlans", "createdAt"}),
  @WidgetProperty(key = ProcessIssueFilterWidget.DISPLAY_FILTER_DESCRIPTION, type = WidgetPropertyType.BOOLEAN, defaultValue = "false")
})
public class ProcessIssueFilterWidget extends AbstractRubyTemplate implements
		RubyRailsWidget {

	public static final String FILTER_PROPERTY = "filter";
	  public static final String DISTRIBUTION_AXIS_PROPERTY = "distributionAxis";
	  public static final String DISPLAY_FILTER_DESCRIPTION = "displayFilterDescription";
	  public static final String ID = "process_issue_filter";
	/* (non-Javadoc)
	 * @see org.sonar.api.web.View#getId()
	 */
	@Override
	public String getId() {
		return ID;
	}

	/* (non-Javadoc)
	 * @see org.sonar.api.web.View#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Process Issue Filter";
	}

	/* (non-Javadoc)
	 * @see org.sonar.api.web.AbstractRubyTemplate#getTemplatePath()
	 */
	@Override
	protected String getTemplatePath() {
		return "/org/sonar/plugins/xpdl/widgets/issues/process_issue_filter.html.erb";
	}

}
