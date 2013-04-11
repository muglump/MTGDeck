import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;


public class UserInteractionTest {

	@Test
	public void testForSearchByName() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		UserInteraction testUI = new UserInteraction();
		ArrayList<MTGCard> results = testUI.search(testUI.getParser(), "name", "Rancor");
		assertEquals("Rancor", results.get(0).name);
	}

}
