/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.Event;
import org.sonar.plugins.bpm.parser.xpdl.enums.ActivityType;
import org.sonar.plugins.bpm.parser.xpdl.enums.TriggerType;

/**
 * @author federicopastore
 *
 */
public abstract class AbsrtactEvent implements Event {

	protected Activity activity;
	
public Activity getActivity(){
	return this.activity;
}
public abstract boolean isInterrupting();


}
