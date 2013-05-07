package deck;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class DraftRuleSetTest {

	@Test
	public void testDraftNotNull() {
		DraftRuleSet test = new DraftRuleSet();
		Assert.assertNotNull(test);
	}
	
	@Test public void testDraftHasCorrectDeckLimit(){
		DraftRuleSet test = new DraftRuleSet();
		Assert.assertEquals(40, test.DeckSize);
	}
	
	@Test
	public void testDraftValidDeck(){
		DraftRuleSet test = new DraftRuleSet();
		Deck testDeck = new Deck();
		assertEquals(true, test.DeckValid(testDeck));
	}
	
	@Test
	public void testDraftInvalidDeck(){
		DraftRuleSet test = new DraftRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "Dragon's Maze", "0");
		for(int i = 0; i <= 60; i++){
			testDeck.cards.add(testcard);
		}
		assertEquals(false, test.DeckValid(testDeck));
	}
	
	@Test
	public void testDraftToString(){
		DraftRuleSet test = new DraftRuleSet();
		assertEquals("DRAFT", test.toString());
	}
	
	@Test
	public void testCanBeAddedNoMoreThen4(){
		DraftRuleSet test = new DraftRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "Dragon's Maze", "0");
		for(int i = 0; i < 59; i++){
			testDeck.cards.add(testcard);
		}
		assertEquals(false, test.canBeAdded(testcard, testDeck));
	}
	
	@Test
	public void testCanBeAddedNoMoreThenDeckLimit(){
		DraftRuleSet test = new DraftRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "Dragon's Maze", "0");
		for(int i = 0; i < 39; i++){
			testDeck.cards.add(testcard);
		}
		System.out.println(testDeck.cards.size());
		MTGCard testcard2 = new MTGCard("Test2", "1", "2", "3", "0", "Dragon's Maze", "0");
		assertEquals(true, test.canBeAdded(testcard2, testDeck));
	}
	
	@Test
	public void testCanBeAddedAnyNumberOfLands(){
		DraftRuleSet test = new DraftRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "Basic Land", "0", "0", "Dragon's Maze", "0");
		for(int i = 0; i < 60; i++){
			assertEquals(true, test.canBeAdded(testcard, testDeck));
		}
	}

}
