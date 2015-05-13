/**
 * 
 */
package org.sonar.plugins.bpm.xpdl.checks;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.activiti.bpmn.model.BpmnModel;
import org.apache.commons.io.FileUtils;
import org.jdom.JDOMException;
import org.sonar.api.resources.Resource;
import org.sonar.api.scan.filesystem.ModuleFileSystem;
import org.sonar.api.utils.SonarException;
import org.sonar.plugins.bpm.bpmn.checks.ProcessIssue;
import org.sonar.plugins.bpm.parser.elements.model.PackageDefinition;
import org.sonar.plugins.bpm.parser.xpdl.XpdlParser;


/**
 * @author federicopastore
 *
 */
public class XpdlSourceCode {

    private final List processIssues = new ArrayList();
    private String code;
    private File xpdlFile;
    private org.sonar.api.resources.File sonarFile;
	private PackageDefinition model;
   
	public XpdlSourceCode(org.sonar.api.resources.File sonarFile, File file)
	    {

	        xpdlFile = file;
	        this.sonarFile = sonarFile;
	    }


		public void addViolation(ProcessIssue processIssue)
	    {
	    	processIssues.add(processIssue);
	    }

	    private InputStream createInputStream()
	    {
	        if(xpdlFile != null)
	            try
	            {
	                return FileUtils.openInputStream(xpdlFile);
	            }
	            catch(IOException e)
	            {
	                throw new SonarException(e);
	            }
	        else
	            return new ByteArrayInputStream(code.getBytes());
	    }




	    public PackageDefinition getModel()
	    {
	        return model;
	    }
	    
	    
	    public org.sonar.api.resources.File getSonarFile()
	    {
	        return sonarFile;
	    }

	    public List getProcessIssues()
	    {
	        return processIssues;
	    }

		public boolean parseSource(ModuleFileSystem fileSystem) {
			try
	        {
	            model = parseFile();
	        }
	        catch(JDOMException e)
	        {
	            e.printStackTrace();
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        return model != null;
		}

private PackageDefinition parseFile() throws JDOMException, IOException{
   	XpdlParser parser = new XpdlParser();
	PackageDefinition pkg = parser.parse(createInputStream());
	return pkg;
}
}
