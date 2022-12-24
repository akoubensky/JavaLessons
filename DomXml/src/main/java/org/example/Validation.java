package org.example;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

public class Validation {
    public static void main(String[] args) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(Validation.class.getClassLoader().getResource("students.xsd"));
        Validator validator = schema.newValidator();
        try {
            validator.validate(new StreamSource(Validation.class.getClassLoader().getResourceAsStream("students.xml")));
        } catch (SAXParseException e) {
            System.out.printf("Error during validation in line %d, column %d: %s\n",
                    e.getLineNumber(), e.getColumnNumber(), e.getMessage());
        }
    }
}
