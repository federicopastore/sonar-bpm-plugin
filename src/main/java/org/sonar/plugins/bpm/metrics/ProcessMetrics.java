/**
 * 
 */
package org.sonar.plugins.bpm.metrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Formula;
import org.sonar.api.measures.FormulaContext;
import org.sonar.api.measures.FormulaData;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

/**
 * @author federicopastore
 *
 */
public class ProcessMetrics implements Metrics {

	public static final String DOMAIN_BPM = "Business Process Management";
	public static final String DOMAIN_BPM_TASKS = "Business Process Management - Tasks";
	public static final Metric PROCESSES =
		    new Metric.Builder("processes", "Total Processes", Metric.ValueType.INT) 
		    .setDescription("Total number of processes inside a bpm project")
		    .setDirection(Metric.DIRECTION_BETTER)
		    .setQualitative(false)
		    .setDomain(ProcessMetrics.DOMAIN_BPM)
		    .create();	
	public static final Metric PROCESSES_ON_PKG =
		    new Metric.Builder("processes_on_pkg", "WorkFlows", Metric.ValueType.INT) 
		    .setDescription("Total number of processes inside a bpm process file")
		    .setDirection(Metric.DIRECTION_BETTER)
		    .setQualitative(false)
		    .setDomain(ProcessMetrics.DOMAIN_BPM)    
		    .create();
	public static final Metric ACTIVITIES_ON_PKG = new Metric.Builder("activities_on_pkg", "Activities", Metric.ValueType.INT) 
		    .setDescription("Total number of Activities inside a bpm process file")
		    .setDirection(Metric.DIRECTION_BETTER)
		    .setQualitative(false)
		    .setDomain(ProcessMetrics.DOMAIN_BPM)    
		    .create();	

	public static final Metric TASKS_ON_PKG = new Metric.Builder("tasks_on_pkg", "Tasks", Metric.ValueType.INT) 
    .setDescription("Total number of Tasks inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM)    
    .create();
	
	public static final Metric EVENTS_ON_PKG = new Metric.Builder("events_on_pkg", "Events", Metric.ValueType.INT) 
    .setDescription("Total number of Events inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM)    
    .create();

	public static final Metric ROUTES_ON_PKG = new Metric.Builder("routes_on_pkg", "Gateways", Metric.ValueType.INT) 
    .setDescription("Total number of Gateways inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM)    
    .create();	
	
	public static final Metric SUBFLOWS_ON_PKG = new Metric.Builder("subflows_on_pkg", "SubFlows", Metric.ValueType.INT) 
    .setDescription("Total number of SubFlows inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM)    
    .create();

	public static final Metric NO_ON_PKG = new Metric.Builder("no_on_pkg", "No Activity", Metric.ValueType.INT) 
    .setDescription("Total number of No Activity inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM)    
    .create();

	public static final Metric REFERENCE = new Metric.Builder("reference_on_pkg", "Reference", Metric.ValueType.INT) 
    .setDescription("Total number of Reference inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM)    
    .create();





	public static final Metric SCRIPTTASKS_ON_PKG = new Metric.Builder("scripttasks_on_pkg", "Script Tasks", Metric.ValueType.INT) 
    .setDescription("Total number of Script Tasks inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM_TASKS)    
    .create();	
	public static final Metric USERTASKS_ON_PKG = new Metric.Builder("usertasks_on_pkg", "User Tasks", Metric.ValueType.INT) 
    .setDescription("Total number of User Tasks inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM_TASKS)    
    .create();
	public static final Metric SERVICETASKS_ON_PKG = new Metric.Builder("servicetasks_on_pkg", "Service Tasks", Metric.ValueType.INT) 
    .setDescription("Total number of Service Tasks inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM_TASKS)    
    .create();
	public static final Metric RECEIVETASKS_ON_PKG = new Metric.Builder("receivetasks_on_pkg", "Receive Tasks", Metric.ValueType.INT) 
    .setDescription("Total number of Receive Tasks inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM_TASKS)    
    .create();
	public static final Metric SENDTASKS_ON_PKG =new Metric.Builder("sendtasks_on_pkg", "Send Tasks", Metric.ValueType.INT) 
    .setDescription("Total number of Send Tasks inside a bpm process file")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(ProcessMetrics.DOMAIN_BPM_TASKS)    
    .create();
	/*
	 * 
	 * 
	 * */
	
	/* (non-Javadoc)
	 * @see org.sonar.api.measures.Metrics#getMetrics()
	 */
	@Override
	public List<Metric> getMetrics() {
		return Arrays.asList( 
				PROCESSES, 
				PROCESSES_ON_PKG,
				ACTIVITIES_ON_PKG,
				TASKS_ON_PKG,
				EVENTS_ON_PKG,
				USERTASKS_ON_PKG,
				SERVICETASKS_ON_PKG,
				RECEIVETASKS_ON_PKG,
				SENDTASKS_ON_PKG,
				SCRIPTTASKS_ON_PKG,
				ROUTES_ON_PKG,
				SUBFLOWS_ON_PKG,
				NO_ON_PKG,
				REFERENCE
				);
	}

}
