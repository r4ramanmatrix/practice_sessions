package readingxml_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main_Class {

	public static void main(String[] args) {
		List<POJO_Class> csv = Main_Class.processInputFile("C:\\Users\\ramankumar\\Desktop\\Random1.csv");
		List<POJO_Class> xml = Main_Class.xmlProcessFile("C:\\Users\\ramankumar\\Desktop\\RANDOM.xml");
		Collections.sort(csv);
		Collections.sort(xml);
		System.out.println(csv.equals(xml));
		csv.removeAll(xml);
		System.out.println(csv);

	}

	private static List<POJO_Class> xmlProcessFile(String xmlPath) {
		try {

			File file = new File(xmlPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(XMLPOJO_Class.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			XMLPOJO_Class que = (XMLPOJO_Class) jaxbUnmarshaller.unmarshal(file);

			/*System.out.println(que.getId() + " " + que.getQuestionname());
			System.out.println("Answers:");*/
			List<POJO_Class> list = que.getPerson();
			System.out.println("From XML: "+list);
			return list;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	private static List<POJO_Class> processInputFile(String inputFilePath) {
		List<POJO_Class> inputList = new ArrayList<POJO_Class>();
		try {
			File inputF = new File(inputFilePath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			// skip the header of the csv

			inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			System.out.println(inputList);
			br.close();
		} catch (IOException e) {
			// ....
		}
		return inputList;

	}

	private static Function<String, POJO_Class> mapToItem = (line) -> {
		String[] p = line.split(",");// a CSV has comma separated lines
		POJO_Class item = new POJO_Class(p);
		return item;
	};

}
