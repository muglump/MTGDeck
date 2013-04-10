import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

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
		String testQuery = testParser.buildXPathQuery("name", "Voidwalk");
		assertEquals("//card[name='Voidwalk']/*", testQuery);
	}
	

	
	@Test(expected=XPathExpressionException.class)
	public void testForInvalidSearch() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		XMLParser testParser = new XMLParser();
		testParser.searchXML("//cards/card[sriram='thecoolest']/garbage/text()");
			}
	
	 
	@Test
	public void testForSearchingForACardByName() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		XMLParser testParser = new XMLParser();
		ArrayList<MTGCard> cardList = testParser.searchXML("//card[name='Rancor']/*");
		assertEquals("Rancor", cardList.get(0).name);
	}

	@Test
	public void testForSearchingForACardByRules() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		XMLParser testParser = new XMLParser();
		ArrayList<MTGCard> cardList = testParser.searchXML("//card[rules='Put two 2/2 white Knight creature tokens with vigilance onto the battlefield.']/*");
		assertEquals("Knight Watch", cardList.get(0).name);
	}

}
