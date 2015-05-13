/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.jdom.Namespace;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.Application;
import org.sonar.plugins.bpm.parser.elements.model.Artifact;
import org.sonar.plugins.bpm.parser.elements.model.Association;
import org.sonar.plugins.bpm.parser.elements.model.DataField;
import org.sonar.plugins.bpm.parser.elements.model.DataType;
import org.sonar.plugins.bpm.parser.elements.model.MessageFlow;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.PackageHeader;
import org.sonar.plugins.bpm.parser.elements.model.Participant;
import org.sonar.plugins.bpm.parser.elements.model.PartnerLinkType;
import org.sonar.plugins.bpm.parser.elements.model.Pool;
import org.sonar.plugins.bpm.parser.elements.model.RedefinableHeader;
import org.sonar.plugins.bpm.parser.elements.model.WorkflowProcess;

/**
 * @author federicopastore
 *
 */
public class PackageDefinitionImpl extends ElementParser implements PackageDefinition{
private Element root;
private List<Application> applicationList;
private List<Artifact> artifacts;
private List<Association> associations;
private List<WorkflowProcess> processes;
private List<DataField> datafields;

	public PackageDefinitionImpl(Element rootNode) {
		super(rootNode);
		this.root= rootNode;
		this.applicationList = new ArrayList<Application>();
		this.artifacts = new ArrayList<Artifact>();
		this.associations = new ArrayList<Association>();
		this.processes = new ArrayList<WorkflowProcess>();
		buildProcesses();
		buildApplications();
		buildArtifacts();
		buildAssociations();
		datafields = new ArrayList<DataField>();
		buildDataFields();
	}

	private void buildDataFields() {
		Element child = getChildWithName("DataFields");
		if(child!=null){
			List dataflds =child.getChildren();
			for (Iterator iterator = dataflds.iterator(); iterator.hasNext();) {
				Element dtaf = (Element) iterator.next();
				DataFieldImpl datafield = new DataFieldImpl(dtaf,this);
				datafields.add(datafield);
			}
			}
	}
	
	private void buildApplications() {
		
		List applications = getCurrentElement().getChildren("Applications");
		for (Iterator iterator = applications.iterator(); iterator.hasNext();) {
			Element app = (Element) iterator.next();
			ApplicationImpl application = new ApplicationImpl(app);
			this.applicationList.add(application);
		}
	}	
	@Override
	public List<Application> getApplications() {
		return this.applicationList;
	}

	
	private void buildArtifacts() {
		List artifacts = getCurrentElement().getChildren("Artifacts");
		for (Iterator iterator = artifacts.iterator(); iterator.hasNext();) {
			Element artifact = (Element) iterator.next();
			ArtifactImpl artImpl = new ArtifactImpl(artifact);
			this.artifacts.add(artImpl);
		}
	}
	
	@Override
	public List<Artifact> getArtifacts() {
		return this.artifacts;
	}

	private void buildAssociations() {
		List associations = getCurrentElement().getChildren("Associations");
		for (Iterator iterator = associations.iterator(); iterator.hasNext();) {
			Element ass = (Element) iterator.next();
			AssociationImpl assImpl = new AssociationImpl(ass);
			this.associations.add(assImpl);
		}
	}
	@Override
	public List<Association> getAssociations() {
		return this.associations;
	}

	@Override
	public String getConformanceClass() {
		// TODO Auto-generated method stub
		return this.getCurrentElement().getAttributeValue("ConformanceClass");
	}

	@Override
	public List<DataField> getDataFields() {
		
		return this.datafields;
	}



	@Override
	public PackageDefinition getExternalPackages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getGlobalActivities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLanguage() {
		// TODO Auto-generated method stub
		return getCurrentElement().getAttributeValue("Language");
	}

	@Override
	public List<MessageFlow> getMessageFlows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PackageHeader getPackageHeader() {
		return new PackageHeaderImpl(getChildWithName("PackageHeader"));
	}

	@Override
	public List<Participant> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartnerLinkType getPartnerLinkTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pool> getPools() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueryLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RedefinableHeader getRedefinableHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getScript() {
		// TODO Auto-generated method stub
		return this.getCurrentElement().getAttributeValue("Script");
	}

	@Override
	public List<DataType> getTypeDeclarations() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void buildProcesses() {
		Element wfprocs = getChildWithName("WorkflowProcesses");
		List<Element> procs = wfprocs.getChildren();
		for (Iterator<Element> iterator = procs.iterator(); iterator.hasNext();) {
			Element process =  iterator.next();
			WorkflowProcessImpl proc = new WorkflowProcessImpl(process);
			processes.add(proc);
		}
	}
	@Override
	public List<WorkflowProcess> getProcesses() {
		return processes;
	}

}
