package step5_DFAnnotation.FrameWork;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ContextParser {
	// Parse : 해석. SAX(순차접근. 불편, 용량이 무한대), DOM(접근 자유롭다. 용량 제한적)
	//public static void main(String[] args) throws Exception {
	public static List<Pair<String, String>> parseContext() throws Exception {
		List<Pair<String, String>> ret = new ArrayList<>();
		//함수로 만들어주었다. main은 아까전에 3개 출력 잘 나오는지 확인을 위한 Test
		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(new File("./src/step5_DFAnnotation/root_context.xml")); //경로를 설정
		document.getDocumentElement().normalize();
		
		NodeList nList = document.getElementsByTagName("Bean");
		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
		/*  System.out.println(node.getNodeValue() + node.getTextContent()); 
			//결과로 3번 출력되는지 확인할건데, Debug해보면 잘 나온다. root_.xml에서 만들어놓은 3가지의 객체에 대하여 */
			Element elEment = (Element) node;
			/*System.out.println(elEment.getElementsByTagName("Name").item(0).getTextContent()); // Name 정보를 읽어올것
			 System.out.println(elEment.getElementsByTagName("Path").item(0).getTextContent()); // Path 정보도 읽어오자
			 */
			ret.add(new Pair<>(elEment.getElementsByTagName("Name").item(0).getTextContent(),
					elEment.getElementsByTagName("Path").item(0).getTextContent()));
			// ret Pair를 만든것에 대하여 선언 출력해보는 다른 방법 
		}
		return ret;
	}
}
