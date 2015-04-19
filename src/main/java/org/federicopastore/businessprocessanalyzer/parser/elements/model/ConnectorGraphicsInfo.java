/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

/**
 * @author federicopastore
 * 
 * BorderColor Color of the border, expressed as a string. Tool specific and depends on ToolId.
 * Coordinates X and Y coordinates of points in the path. Tool specific and depends on ToolId.
 * FillColor Color of the border, expressed as a string.
 * ToolId Tool id. This may correspond to the name of the tool generating the XPDL file. Note that multiple ConnectorGraphicsInfo elements may appear in an element. This allows each tool to have its ConnectorGraphicsInfo, allowing for different tools using the same XPDL file to represent the element in totally different ways. Each tool read and writes its own ConnectorGraphicsInfo based on its ToolId, and it leaves untouched the ConnectorGraphicsInfo from other tools.
 * IsVisible True indicates connector should be shown.
 * Page [Deprecated] The name of the page on which this connector should be displayed. Used in XPDL 2.0 without sufficient guidelines to insure consistency and portability.
 * PageId The id of the page on which this node should be displayed. Refers to Pages element described in section 7.1.1.2.
 * Shape Shape, expressed as a string: used to override BPMN shapes.
 * Style LineStyle. Tool specific and depends on ToolId. Should not conflict with BPMN recommended styles for SequenceFlow, MessageFlow and Association.
 */
public interface ConnectorGraphicsInfo extends BaseXpdlElement {

	public String getBorderColor();
	public Coordinates getCoordinates();
	public String getFillColor();
	public String getToolId();
	public boolean getIsVisible();
	public String getPage();
	public String getPageId();
	public String getShape();
	public String getStyle();
}
