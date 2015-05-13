package org.sonar.plugins.bpm.bpmn.checks;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.apache.commons.io.FileUtils;
import org.sonar.api.scan.filesystem.ModuleFileSystem;
import org.sonar.api.utils.SonarException;

public class BpmnSourceCode
{

    public BpmnSourceCode(org.sonar.api.resources.File sonarFile, File file)
    {
        model = null;
        bpmnFile = file;
        this.sonarFile = sonarFile;
    }

    public void addViolation(ProcessIssue bpmnIssue)
    {
        bpmnIssues.add(bpmnIssue);
    }

    InputStream createInputStream()
    {
        if(bpmnFile != null)
            try
            {
                return FileUtils.openInputStream(bpmnFile);
            }
            catch(IOException e)
            {
                throw new SonarException(e);
            }
        else
            return new ByteArrayInputStream(code.getBytes());
    }

    protected BpmnModel getModel()
    {
        return model;
    }

    public boolean parseSource(ModuleFileSystem fileSystem)
    {
        try
        {
            model = parseFile();
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch(XMLStreamException e)
        {
            e.printStackTrace();
        }
        return model != null;
    }

    private BpmnModel parseFile()
        throws UnsupportedEncodingException, XMLStreamException
    {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        InputStreamReader in = new InputStreamReader(createInputStream(), "UTF-8");
        javax.xml.stream.XMLStreamReader xtr = xif.createXMLStreamReader(in);
        BpmnModel model = (new BpmnXMLConverter()).convertToBpmnModel(xtr);
        return model;
    }

    public org.sonar.api.resources.File getSonarFile()
    {
        return sonarFile;
    }

    public List getBpmnIssues()
    {
        return bpmnIssues;
    }

    private final List bpmnIssues = new ArrayList();
    private String code;
    private File bpmnFile;
    private BpmnModel model;
    private org.sonar.api.resources.File sonarFile;
}
