/**
 * 
 */
package org.sonar.plugins.bpm.dashboards;

import java.util.Iterator;

import org.sonar.api.web.Dashboard;
import org.sonar.api.web.DashboardLayout;
import org.sonar.api.web.DashboardTemplate;
import org.sonar.core.issue.db.IssueFilterDao;
import org.sonar.core.issue.db.IssueFilterDto;
import org.sonar.plugins.bpm.widgets.issues.ProcessIssueFilterWidget;

import com.google.common.base.Preconditions;

/**
 * @author federicopastore
 *
 */
public class ProcessIssuesDashboard extends DashboardTemplate {

	  private final IssueFilterDao issueFilterDao;

	  public ProcessIssuesDashboard(IssueFilterDao issueFilterDao) {
	    this.issueFilterDao = issueFilterDao;
	  }
	  
	/* (non-Javadoc)
	 * @see org.sonar.api.web.DashboardTemplate#createDashboard()
	 */
	@Override
	public Dashboard createDashboard() {
	    Dashboard dashboard = Dashboard.create();
	    dashboard.setLayout(DashboardLayout.TWO_COLUMNS);

	   // IssueFilterDto unresolvedIssues = getIssueFilterByName("Unresolved Issues");
	    //IssueFilterDto hiddenDebt = getIssueFilterByName("False Positive and Won't Fix Issues");
	    //IssueFilterDto myUnresolvedIssues = getIssueFilterByName("My Unresolved Issues");

	    //addFirstColumn(dashboard, unresolvedIssues);
	    //addSecondColumn(dashboard, unresolvedIssues, hiddenDebt, myUnresolvedIssues);
	    return dashboard;
	}

	
	  private IssueFilterDto getIssueFilterByName(String name) {
		  IssueFilterDto filter = null;	
		  for (Iterator iterator = issueFilterDao.selectSharedFilters().iterator(); iterator.hasNext();) {
				IssueFilterDto f = (IssueFilterDto) iterator.next();
				if(f.getName().equals(name)){
					filter =f;
					break;
				}
				
			}
		    Preconditions.checkState(filter != null, String.format("Could not find a provided issue filter with name '%s'", name));
		    return filter;
		  }

		  private void addFirstColumn(Dashboard dashboard, IssueFilterDto unresolvedIssues) {
		    // Unresolved issues by status
		    dashboard.addWidget(ProcessIssueFilterWidget.ID, 1)
		      .setProperty(ProcessIssueFilterWidget.FILTER_PROPERTY, Long.toString(unresolvedIssues.getId()))
		      .setProperty(ProcessIssueFilterWidget.DISTRIBUTION_AXIS_PROPERTY, "statuses");
		    // Action plans
		    dashboard.addWidget("action_plans", 1);
		  }

		  private void addSecondColumn(Dashboard dashboard, IssueFilterDto unresolvedIssues, IssueFilterDto hiddenDebt, IssueFilterDto myUnresolvedIssues) {
		    // Unresolved issues by assignee
		    dashboard.addWidget(ProcessIssueFilterWidget.ID, 2)
		      .setProperty(ProcessIssueFilterWidget.FILTER_PROPERTY, Long.toString(unresolvedIssues.getId()))
		      .setProperty(ProcessIssueFilterWidget.DISTRIBUTION_AXIS_PROPERTY, "assignees");
		    // My unresolved issues
		    dashboard.addWidget(ProcessIssueFilterWidget.ID, 2)
		      .setProperty("filter", Long.toString(myUnresolvedIssues.getId()));
		    // False positive and won't fix issues by resolution
		    dashboard.addWidget(ProcessIssueFilterWidget.ID, 2)
		      .setProperty(ProcessIssueFilterWidget.FILTER_PROPERTY, Long.toString(hiddenDebt.getId()))
		      .setProperty(ProcessIssueFilterWidget.DISTRIBUTION_AXIS_PROPERTY, "resolutions");
		  }
	
	
	/* (non-Javadoc)
	 * @see org.sonar.api.web.DashboardTemplate#getName()
	 */
	@Override
	public String getName() {
		return "BusinessProcess Issues";
	}

}
