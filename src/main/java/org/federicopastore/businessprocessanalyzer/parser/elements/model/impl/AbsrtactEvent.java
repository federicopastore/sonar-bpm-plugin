/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.Activity;
import org.federicopastore.businessprocessanalyzer.parser.elements.model.Event;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.ActivityType;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.TriggerType;

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
