/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

import java.util.List;



/**
 * @author federicopastore
 * Applications A list of Application Declarations. See section 7.3.
 * Artifacts A list of Artifacts that can be linked to the existing Flow Objects through Associations. See
	sections 6.4.7. and 7.1.9.
 * Associations A list of Associations which associate information and Artifacts with Flow Objects. See section
	7.10.
 * ConformanceClass Structural restriction on process definitions in this package. See section 7.2.3.
 * DataFields A list of Relevant data fields defined for the package. See section 7.12.
 * DataStores A list of DataStore elements.
 * ExtendedAttributes A list of vendor-defined extensions that may be added to the package. See section 7.1.1.
 * ExternalPackages Reference to another Package definition defined in a separate document.
 * GlobalActivities List of Task Activities that are global.
 * Id Used to identify the package.
 * Language This holds the code for the language in which text is written as specified by ISO 639-2.
 	Optionally this may be suffixed with a country code as specified by ISO 3166 to permit
	distinction between national dialects of the given language. The default is ‘en_US’.
 * MessageFlows A list of MessageFlows which go between Pools or activities in two pools. See section 7.8.
 * Name Text. Used to provide a name for the Package.
 * PackageHeader A set of elements specifying package characteristics.
 * Participants A list of resources used in implementing processes in the package. See section 7.11.
 * PartnerLinkTypes Partner link types for this package. See section 7.8.1.
 * Pools A list of Pools for the Package. See section 7.4.
 * QueryLanguage A Language MAY be provided so that the syntax of queries used in the Diagram can be
	understood. [Editors Note: Is this different than Scripting Language? TBD by BPMN.]
 * RedefinableHeader A set of elements and attributes used by both the Package and Process definitions.
 * Script Identifies the scripting language used in expressions.
 * TypeDeclarations A list of Data Types used in the package. See section 7.13.
 * Processes A list of the Processes that comprise this package. See section 7.5.
 */
public interface PackageDefinition extends BaseXpdlElement {

	public List<Application> getApplications();
	public List<Artifact> getArtifacts();
	public List<Association> getAssociations();
	public String getConformanceClass();
	public List<DataField> getDataFields();
	//public List<DataStore> getDataStores();
	public List<ExtendedAttribute> getExtendedAttributes();
	public PackageDefinition getExternalPackages();
	public List<Activity> getGlobalActivities();
	public String getId();
	public String getLanguage();
	public List<MessageFlow> getMessageFlows();
	public String getName();
	public PackageHeader getPackageHeader();
	public List<Participant> getParticipants();
	public PartnerLinkType getPartnerLinkTypes();
	public List<Pool> getPools();
	public String getQueryLanguage();
	public RedefinableHeader getRedefinableHeader();
	public String getScript();
	public List<DataType> getTypeDeclarations();
	public List<WorkflowProcess> getProcesses();
	
}
