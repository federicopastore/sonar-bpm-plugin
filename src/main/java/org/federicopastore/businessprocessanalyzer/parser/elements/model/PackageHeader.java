/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;


/**
 * @author federicopastore
 * CostUnit Units used in Simulation Data (Usually expressed in terms of a currency). The currency codes specified by ISO 4217 are recommended.
 * Created Creation date of Package Definition. Should be stored in either the Basic or Extended forms specified by ISO 8601. For example: 1985-04-12T10:15:30Z is the extended form of the 3:30 pm on the 12th April 1985 GMT.
 * Description Textual description of the package.
 * Documentation Operating System specific path- and filename of help file/description file.
 * LayoutInfo All co-ordinates (in NodeGraphicsInfos) have origin of 'top-left, relative to parent container'. Co-ordinate units are in pixels. However it would be nice to give other applications a hint as to the scale of a 'pixel' when the XPDL file was saved (i.e. the XPDL writer specifies co-ordinates and sizes in pixels but can also specify 'pixels to the millimeter' - the reading application can then, if it wishes, take this into account and scale to its pixel size appropriately). See PixelsPerMillimeter below.
 * ModificationDate This defines the date on which the Diagram was last modified (for this Version). Should be stored in either the Basic or Extended forms specified by ISO 8601. For example: 1985-04-12T10:15:30Z is the extended form of the 3:30 pm on the 12th April 1985 GMT.
 * PixelsPerMillimeter The default unit should be Pixels. The transformation of whatever measurement unit is used internally is left up to the implementing tool.
 * PriorityUnit A text string with user defined semantics.
 * Vendor Defines the origin of this model definition and contains vendor's name, vendor's product name and product's release number.
 * VendorExtensions List of extensions by vendors. There is a vendor extension entry for each tool that provides extensions in this XPDL content.
 * XPDLVersion Version of this specification. The current value, for this specification, is “2.2”.
 */
public interface PackageHeader extends BaseXpdlElement{

	public String getCostUnit();
	public String getCreated();
	public String getDescription();
	public String getDocumentation();
	public String getLayoutInfo();
	public String getModificationDate();
	public String getPixelsPerMillimeter();
	public String getPriorityUnit();
	public String getVendor();
	public String getVendorExtensions();
	public String getXPDLVersion();
	
}
