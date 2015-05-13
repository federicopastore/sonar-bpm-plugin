/**
 * 
 */
package org.sonar.plugins.bpm.parser.xpdl;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.contrib.input.LineNumberElement;
import org.jdom.contrib.input.LineNumberSAXBuilder;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.elements.model.impl.PackageDefinitionImpl;


/**
 * @author federicopastore
 *
 */

public class XpdlParser {
	
	private LineNumberSAXBuilder builder;
	private File xmlFile;



	public XpdlParser() {
		builder = new LineNumberSAXBuilder();
	}

	

	
	public PackageDefinition parse(String file) throws JDOMException, IOException{
		xmlFile = new File(file);
		Document document = (Document) builder.build(xmlFile);
		LineNumberElement rootNode = (LineNumberElement)document.getRootElement();
		PackageDefinitionImpl pkgDef = new PackageDefinitionImpl(rootNode);
		return pkgDef;
	}




	public PackageDefinition parse(InputStream createInputStream) throws JDOMException, IOException {
		Document document = (Document) builder.build(createInputStream);
		LineNumberElement rootNode = (LineNumberElement)document.getRootElement();
		PackageDefinitionImpl pkgDef = new PackageDefinitionImpl(rootNode);
		return pkgDef;
	}
	








/*

	public boolean hasNextTransition(Transition currentTrans) {
		String next = currentTrans.getTo().getId();
		for (Transition transition : getTransitions()) {
			if (next.equals(transition.getFrom().getId())) {
				return true;
			}
		}
		return false;
	}

	public List<Transition> getNextTransitions(Transition currentTrans) {
		List<Transition> transitions = new ArrayList<Transition>();
		String next = currentTrans.getTo().getId();
		for (Transition transition : getTransitions()) {
			if (next.equals(transition.getFrom().getId())) {
				transitions.add(transition);
			}
		}
		return transitions;
	}	*/
	
}
