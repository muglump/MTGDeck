import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;


public class XMLParserTest {

	@Test
	public void testCompiler() {
		assertTrue("We don't seem to have a compiler working",true);
	}
	
	@Test
	public void testToGetCorrectXPathQuery() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		XMLParser testParser = new XMLParser();
		assertEquals("//cards/card[name='Voidwalk']/name/text()", testParser.buildXPathQuery("name", "Voidwalk", "name"));
	}
	
	@Test
	public void testToGetCardNameFromValidQuery() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		XMLParser testParser = new XMLParser();
		assertEquals("Voidwalk", testParser.parseXML("//cards/card[name='Voidwalk']/name/text()"));
	}
	
	@Test(expected=XPathExpressionException.class)
	public void testForInvalidSearch() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		XMLParser testParser = new XMLParser();
		testParser.parseXML("//cards/card[sriram='thecoolest']/garbage/text()");
			}
	

}
