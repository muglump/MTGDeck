package deck;

import static org.junit.Assert.*;

import gui.CardNotInRulesetException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

	@Test
	public void testForDisplayOutput() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		UserInteraction testUI = new UserInteraction();
		ArrayList<MTGCard> results = testUI.search(testUI.getParser(), "name", "Voidwalk");
		testUI.setSearchResults(results);
		testUI.setLocale("English");
		//System.out.println(results.toString());
		assertEquals("Results 1\nName Voidwalk\nCastingCost 3U\nType Sorcery\nPower n/a\nToughness n/a\nRules Exile target creature. Return it to the battlefield under its owner's control at the beginning of the next end step.\nCipher (Then you may exile this spell card encoded on a creature you control. Whenever that creature deals combat damage to a player, its controller may cast a copy of the encoded card without paying its mana cost.)\nSets Gatecrash Uncommon\n\n", testUI.displayCommand());
	}

	@Test
	public void testAddCardCommand() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		UserInteraction testUI = new UserInteraction();
		Deck testDeck = new Deck();
		ArrayList<MTGCard> results = testUI.search(testUI.getParser(), "name", "Rancor");
		assertEquals(1, testUI.addCards(1, "Rancor"));
	}
	@Test
	public void testSaveCardCommandandCreateFile() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, CardNotInRulesetException{
		UserInteraction testUI = new UserInteraction();
		Deck testSaveDeck = new Deck();
		Scanner input = new Scanner(System.in);
		ArrayList<MTGCard> results = testUI.search(testUI.getParser(), "name", "Rancor");
		testSaveDeck.addCardToDeck(results.get(0));
		String fileName = input.nextLine();
		File file = new File(fileName);
	//	assertTrue(file.createNewFile());
		testUI.saveDeck(testSaveDeck, file);
		assertTrue(file.exists());

		
	}
//	@Test
//	public void testLoadCardCommand() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
//		Scanner input = new Scanner(System.in);
//		String fileName = input.nextLine();
//		UserInteraction testUI = new UserInteraction();
//		Deck testLoadDeck = testUI.loadDeck(fileName);
//		ArrayList<MTGCard> results = testUI.search(testUI.getParser(), "name", "Rancor");
//		assertEquals(testLoadDeck.cards.get(0).name, results.get(0).name);
//		assertEquals(testLoadDeck.cards.size(), results.size());
//	}
		
	
}

