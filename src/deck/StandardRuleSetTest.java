package deck;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class StandardRuleSetTest {

	@Test
	public void testStandardNotNull() {
		StandardRuleSet test = new StandardRuleSet();
		Assert.assertNotNull(test);
	}
	
	@Test public void testStandardHasCorrectDeckLimit(){
		StandardRuleSet test = new StandardRuleSet();
		Assert.assertEquals(60, test.DeckSize);
	}
	
	@Test
	public void testStandardValidDeck(){
		StandardRuleSet test = new StandardRuleSet();
		Deck testDeck = new Deck();
		assertEquals(true, test.DeckValid(testDeck));
	}
	
	@Test
	public void testStandardInvalidDeck(){
		StandardRuleSet test = new StandardRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "0", "0");
		for(int i = 0; i <= 60; i++){
			testDeck.cards.add(testcard);
		}
		assertEquals(false, test.DeckValid(testDeck));
	}
	
	@Test
	public void testStandardToString(){
		StandardRuleSet test = new StandardRuleSet();
		Deck testDeck = new Deck();
		assertEquals("STANDARD", test.toString());
	}
	
	@Test
	public void testCanBeAddedNoMoreThen4(){
		StandardRuleSet test = new StandardRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "Dragon's Maze", "0");
		for(int i = 0; i < 59; i++){
			testDeck.cards.add(testcard);
		}
		assertEquals(false, test.canBeAdded(testcard, testDeck));
	}
	
	@Test
	public void testCanBeAddedNoMoreThenDeckLimit(){
		StandardRuleSet test = new StandardRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "Dragon's Maze", "0");
		for(int i = 0; i < 59; i++){
			testDeck.cards.add(testcard);
		}
		MTGCard testcard2 = new MTGCard("Test2", "0", "0", "0", "0", "Dragon's Maze", "0");
		assertEquals(true, test.canBeAdded(testcard2, testDeck));
	}
	
	@Test
	public void testCanBeAddedAnyNumberOfLands(){
		StandardRuleSet test = new StandardRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "Land", "0", "0", "Dragon's Maze", "0");
		for(int i = 0; i < 60; i++){
			assertEquals(true, test.canBeAdded(testcard, testDeck));
		}
	}

}
