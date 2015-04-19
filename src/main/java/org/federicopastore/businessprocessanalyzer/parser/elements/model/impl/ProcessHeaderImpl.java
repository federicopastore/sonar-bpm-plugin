/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model.impl;

import java.util.Date;

import org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader;
import org.jdom.Element;

/**
 * @author federicopastore
 *
 */
public class ProcessHeaderImpl extends ElementParser implements ProcessHeader {

	public ProcessHeaderImpl(Element element) {
		super(element);
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getCreated()
	 */
	@Override
	public Date getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getDuration()
	 */
	@Override
	public long getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getDurationUnit()
	 */
	@Override
	public String getDurationUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getLimit()
	 */
	@Override
	public long getLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getPriority()
	 */
	@Override
	public String getPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getTimeEstimation()
	 */
	@Override
	public String getTimeEstimation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getValidFrom()
	 */
	@Override
	public Date getValidFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getValidTo()
	 */
	@Override
	public Date getValidTo() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getWaitingTime()
	 */
	@Override
	public long getWaitingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.federicopastore.businessprocessanalyzer.parser.elements.model.ProcessHeader#getWorkingTime()
	 */
	@Override
	public long getWorkingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

}
