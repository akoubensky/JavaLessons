package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteXML {
    private static final DocumentBuilder builder;
    private static final Transformer transformer;

    static {
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Student> readStudents(Element root) {
        NodeList studentsNodes = root.getElementsByTagName("student");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentsNodes.getLength(); i++) {
            Element studentElement = (Element)studentsNodes.item(i);
            students.add(readStudent(studentElement));
        }
        return students;
    }

    private static Student readStudent(Element studentElement) {
        String firstName = studentElement.getAttribute("firstname");
        String name = studentElement.getAttribute("name");
        Student student = new Student(name, firstName);
        NodeList marksList = studentElement.getElementsByTagName("mark");
        for (int i = 0; i < marksList.getLength(); i++) {
            Element mark = (Element)marksList.item(i);
            student.addMark(readMark(mark));
        }
        return student;
    }

    private static Mark readMark(Element mark) {
        return new Mark(mark.getAttribute("subject"), Integer.parseInt(mark.getAttribute("mark")));
    }

    @SuppressWarnings("SameParameterValue")
    private static void writeStudents(List<Student> students, String fileName)
            throws TransformerException, IOException {
        Document studentsDoc = builder.newDocument();
        studentsDoc.appendChild(createStudentsElement(studentsDoc, students));
        DOMSource source = new DOMSource(studentsDoc);
        StreamResult result = new StreamResult(Files.newOutputStream(Paths.get(fileName)));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
    }

    private static Element createStudentsElement(Document doc, List<Student> students) {
        Element studentsElement = doc.createElement("students");
        for (Student student : students) {
            studentsElement.appendChild(createStudentElement(doc, student));
        }
        return studentsElement;
    }

    private static Element createStudentElement(Document doc, Student student) {
        Element studentElement = doc.createElement("student");
        studentElement.setAttribute("name", student.getName());
        studentElement.setAttribute("firstname", student.getFirstName());
        for (Mark mark : student.getMarks()) {
            studentElement.appendChild(createMarkElement(doc, mark));
        }
        return studentElement;
    }

    private static Element createMarkElement(Document doc, Mark mark) {
        Element markElement = doc.createElement("mark");
        markElement.setAttribute("subject", mark.getSubject());
        markElement.setAttribute("mark", String.valueOf(mark.getMark()));
        return markElement;
    }

    public static void main(String[] args)
            throws IOException, SAXException, TransformerException {
        Document studentsDoc = builder.parse(ReadWriteXML.class.getClassLoader().getResourceAsStream("students.xml"));
        List<Student> students = readStudents(studentsDoc.getDocumentElement());

        writeStudents(students, "students.xml");
    }
}
