package readingxml_csv;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="information")
public class XMLPOJO_Class {
	
	public XMLPOJO_Class()
	{
		
	}
	private String information;
	private List<POJO_Class> person;

	@XmlElement
	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@XmlElement
	public List<POJO_Class> getPerson() {
		return person;
	}

	public void setPerson(List<POJO_Class> person) {
		this.person = person;
	}

	public XMLPOJO_Class(String information, List<POJO_Class> person) {
		super();
		this.information = information;
		this.person = person;
	}

	
}
