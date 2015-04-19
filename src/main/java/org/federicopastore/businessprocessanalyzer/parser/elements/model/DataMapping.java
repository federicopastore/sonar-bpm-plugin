/**
 * 
 */
package org.federicopastore.businessprocessanalyzer.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface DataMapping extends BaseXpdlElement {
	public static enum DirectionType{
		IN , OUT , INOUT
	}
public Actual getActual();
public DirectionType getDirection();
public String getFormal();
public String getTestValue();

}
