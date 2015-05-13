/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model.impl;

import org.jdom.Element;
import org.sonar.plugins.bpm.parser.elements.model.PackageHeader;

/**
 * @author federicopastore
 *
 */
public class PackageHeaderImpl extends ElementParser implements PackageHeader {

	public PackageHeaderImpl(Element pkg) {
		super(pkg);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getCostUnit()
	 */
	@Override
	public String getCostUnit() {
		return getChildWithName("CostUnit").getText();
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getCreated()
	 */
	@Override
	public String getCreated() {
		return getChildWithName("Created").getText();
	}


	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getLayoutInfo()
	 */
	@Override
	public String getLayoutInfo() {
		return getChildWithName("LayoutInfo").getText();
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getModificationDate()
	 */
	@Override
	public String getModificationDate() {
		return getChildWithName("ModificationDate").getText();
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getPixelsPerMillimeter()
	 */
	@Override
	public String getPixelsPerMillimeter() {
		return getChildWithName("Created").getText();
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getPriorityUnit()
	 */
	@Override
	public String getPriorityUnit() {
		return getChildWithName("PriorityUnit").getText();
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getVendor()
	 */
	@Override
	public String getVendor() {
		return getChildWithName("Vendor").getText();
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getVendorExtensions()
	 */
	@Override
	public String getVendorExtensions() {
		return getChildWithName("VendorExtensions").getText();
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.PackageHeader#getXPDLVersion()
	 */
	@Override
	public String getXPDLVersion() {
		return getChildWithName("XPDLVersion").getText();
	}

}
