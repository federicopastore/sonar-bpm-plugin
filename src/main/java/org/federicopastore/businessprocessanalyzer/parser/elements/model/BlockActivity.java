/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

/**
 * @author federicopastore
 * 
 * ActivitySetId The ActivitySet to be executed.
 * StartActivityId If present, must be the id of a start activity in the ActivitySet referenced by the ActivitySetId attribute of BlockActivity.
	If not present then the start activity is deducible by some other means. See ActivitySet section 7.5.4.
 * View Indicates whether the activity is COLLAPSED or EXPANDED.
 * 
 */
public interface BlockActivity extends BaseXpdlElement {
	public ActivitySet getActivitySetId();
	public Activity getStartActivityId();
}
