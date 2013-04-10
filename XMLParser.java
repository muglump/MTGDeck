import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class XMLParser {

	public XMLParser(){
		
	}
	
	public String buildXPathQuery(String searchType, String searchTerm, String searchResultType) {
		String query = "//cards/card["+searchType+ "=\'" + searchTerm + "\']/"+searchResultType+"/text()";
		//example query     "//cards/card[name='Voidwalk']/name/text()"
		
		return query;
		
	}

	public String parseXML(String query) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("CardInfo.xml");
		
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		
		Object result = expr.evaluate(doc, XPathConstants.STRING);
		if(result.equals("")){
			throw new XPathExpressionException("Invalid XPath Query");
		}
		else{
			return (String) result;
		}
	}
	
	

}
