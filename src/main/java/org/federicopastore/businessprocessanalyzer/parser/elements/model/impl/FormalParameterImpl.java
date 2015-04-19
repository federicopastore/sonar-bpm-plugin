/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.FormalParameter;
import org.federicopastore.businessprocessanalyzer.parser.xpdl.enums.Mode;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class FormalParameterImpl extends ElementParser implements FormalParameter {

	private Element param;

	public FormalParameterImpl(Element param) {
		super(param);
		this.param = param;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getDataType()
	 */
	@Override
	public String getDataType() {
		// TODO Auto-generated method stub
		return this.getCurrentElement().getAttributeValue("DataType");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.getCurrentElement().getAttributeValue("Description");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getLength()
	 */
	@Override
	public String getLength() {
		return this.getCurrentElement().getAttributeValue("Length");
	}


	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getInitialValue()
	 */
	@Override
	public String getInitialValue() {
		return this.getCurrentElement().getAttributeValue("InitialValue");
	}



	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getIsArray()
	 */
	@Override
	public boolean getIsArray() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getIndex()
	 */
	@Override
	public String getIndex() {
		// TODO Auto-generated method stub
		return this.getCurrentElement().getAttributeValue("Index");
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getMode()
	 */
	@Override
	public Mode getMode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getReadOnly()
	 */
	@Override
	public boolean getReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.bpmanalyzer.parser.elements.model.FormalParameter#getRequired()
	 */
	@Override
	public boolean getRequired() {
		// TODO Auto-generated method stub
		return false;
	}

}
