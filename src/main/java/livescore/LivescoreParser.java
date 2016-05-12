package livescore;
/**
 * File LivescoreParser.java
 * Created on 5/11/2016, 5:23 PM.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import livescore.bean.ContactMark;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 * TODO: Document me
 *
 * @author Adrian Iasinschi (aiasinschi@gmail.com)
 */
public class LivescoreParser {

	public static List<ContactMark> parse(){
		List<ContactMark> res = new ArrayList<ContactMark>();
		try {
			File inputFile = new File("data_file.xml");

			SAXBuilder saxBuilder = new SAXBuilder();

			Document document = saxBuilder.build(inputFile);
			System.out.println("Root element :"
					+ document.getRootElement().getName());

			Element classElement = document.getRootElement();

			List<Element> studentList = classElement.getChildren();
			System.out.println("----------------------------");

			for (int temp = 0; temp < studentList.size(); temp++) {
				Element student = studentList.get(temp);
				System.out.println("\nCurrent Element :"
						+ student.getName());
				Attribute attribute =  student.getAttribute("rollno");
				System.out.println("Student roll no : "
						+ attribute.getValue() );
				res.add(new ContactMark(
						student.getChild("firstname").getText(),
						student.getChild("lastname").getText(),
						student.getChild("nickname").getText(),
						student.getChild("marks").getText()
						));
				System.out.println("First Name : " + student.getChild("firstname").getText());
				System.out.println("Last Name : "+ student.getChild("lastname").getText());
				System.out.println("Nick Name : "+ student.getChild("nickname").getText());
				System.out.println("Marks : "+ student.getChild("marks").getText());
			}
		}catch(JDOMException e){
			e.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return res;
	}
}
