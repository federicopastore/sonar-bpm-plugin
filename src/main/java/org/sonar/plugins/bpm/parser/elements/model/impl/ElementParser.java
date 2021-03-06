/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.contrib.input.LineNumberElement;
import org.sonar.plugins.bpm.parser.elements.model.Activity;
import org.sonar.plugins.bpm.parser.elements.model.DataMapping;
import org.sonar.plugins.bpm.parser.elements.model.ExtendedAttribute;
import org.sonar.plugins.bpm.parser.elements.model.NodeGraphicsInfo;
import org.sonar.plugins.bpm.parser.elements.model.Object;
import org.sonar.plugins.bpm.parser.elements.model.Transition;

/**
 * @author federicopastore
 *
 */
public class ElementParser {
	
	private Element element;
	private List<ExtendedAttribute> extAttrs;
	private List<NodeGraphicsInfo> nodeGraphicsInfos;
	private List<DataMapping> datamappings;
	
	public ElementParser(Element element) {
		this.element=element;
		nodeGraphicsInfos = new ArrayList<NodeGraphicsInfo>();
		datamappings = new ArrayList<DataMapping>();
		this.extAttrs = new ArrayList<ExtendedAttribute>();
	}

	protected Element getCurrentElement(){
		return element;
	}
	
	protected Element getChildWithName(String name) {
		for (java.lang.Object activityChild : element.getChildren()) {
			if (activityChild instanceof Element) {
				Element child = (Element) activityChild;
				if (child.getName().equals(name)) {
					return child;
				}
			}
		}
		return null;
	}
	
	protected Element getChildWithName(Element elem, String name) {
		for (java.lang.Object activityChild : elem.getChildren()) {
			if (activityChild instanceof Element) {
				Element child = (Element) activityChild;
				if (child.getName().equals(name)) {
					return child;
				}
			}
		}
		return null;
	}

	public String getId() {
		return this.element.getAttributeValue("Id");
	}


	public String getName() {
		return this.element.getAttributeValue("Name");
	}
	
private void buildExtendedAttributes(){
	Element child = getChildWithName("ExtendedAttributes");
	if(child!=null){
	List attrs = element.getChildren();
	for (Iterator iterator = attrs.iterator(); iterator.hasNext();) {
		Element attr = (Element) iterator.next();
		ExtendedAttributeImpl attrImpl = new ExtendedAttributeImpl(attr);
		this.extAttrs.add(attrImpl);
	}
	}
}

	public List<ExtendedAttribute> getExtendedAttributes() {
		return this.extAttrs;
	}
	

	public String getDescription() {
		return getCurrentElement().getAttributeValue("Description");
	}

	public String getDocumentation() {
		return getCurrentElement().getAttributeValue("Documentation");
	}


	public Object getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<NodeGraphicsInfo> getNodeGraphicsInfos() {
		List nodeinfos = getCurrentElement().getChildren("NodeGraphicsInfo");
		for (Iterator iterator = nodeinfos.iterator(); iterator.hasNext();) {
			Element nodeinfo = (Element) iterator.next();
			NodeGraphicsInfoImpl nodeimpl = new NodeGraphicsInfoImpl(nodeinfo);
			nodeGraphicsInfos.add(nodeimpl);
		}
		return nodeGraphicsInfos;
	}
	
	
	public int getStartLineNumber(){
		return ((LineNumberElement)this.element).getStartLine();
	}
	
	public int getEndLineNumber(){
		return ((LineNumberElement)this.element).getEndLine();
	}
	
	public List<DataMapping> getDataMappings() {
		
		Element dmlElem = getChildWithName("DataMappings");
		List<Element> dmList = dmlElem.getChildren();
		for (Iterator iterator = dmList.iterator(); iterator.hasNext();) {
			Element dmElem = (Element) iterator.next();
			DataMapping dm = new DataMappingImpl(dmElem);
			datamappings.add(dm);
		}
		return datamappings;
	}
	
	public String getExtendedAttributeValue(String attributeKey){
		//System.out.println("getdReplyActivityId: "+this.getCurrentElement().getName());
		String result="";
		List<Attribute> listAtt=this.getCurrentElement().getAttributes();
		for (Iterator iterator = listAtt.iterator(); iterator.hasNext();) {
			Attribute attribute = (Attribute) iterator.next();
			//System.out.println("attrs: "+attribute.getName()+"="+attribute.getValue());
			if(attribute.getName().equals(attributeKey))
				result=attribute.getValue();
		}
		return result;
	}
}
