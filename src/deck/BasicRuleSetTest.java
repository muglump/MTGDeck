package deck;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class BasicRuleSetTest {

	@Test
	public void testBasicNotNull() {
		BasicRuleSet test = new BasicRuleSet();
		Assert.assertNotNull(test);
	}
	
	@Test public void testBasicHasCorrectDeckLimit(){
		BasicRuleSet test = new BasicRuleSet();
		Assert.assertEquals(60, test.DeckSize);
	}
	
	@Test
	public void testBasicValidDeck(){
		BasicRuleSet test = new BasicRuleSet();
		Deck testDeck = new Deck();
		assertEquals(true, test.DeckValid(testDeck));
	}
	
	@Test
	public void testBasicInvalidDeck(){
		BasicRuleSet test = new BasicRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "0", "0");
		for(int i = 0; i <= 60; i++){
			testDeck.cards.add(testcard);
		}
		assertEquals(false, test.DeckValid(testDeck));
	}
	
	@Test
	public void testBasicToString(){
		BasicRuleSet test = new BasicRuleSet();
		Deck testDeck = new Deck();
		assertEquals("BASIC", test.toString());
	}
	
	@Test
	public void testCanBeAddedNoMoreThen4(){
		BasicRuleSet test = new BasicRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "0", "0");
		for(int i = 0; i < 59; i++){
			testDeck.cards.add(testcard);
		}
		assertEquals(false, test.canBeAdded(testcard, testDeck));
	}
	
	@Test
	public void testCanBeAddedNoMoreThenDeckLimit(){
		BasicRuleSet test = new BasicRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "0", "0", "0", "0", "0");
		for(int i = 0; i < 59; i++){
			testDeck.cards.add(testcard);
		}
		MTGCard testcard2 = new MTGCard("Test2", "0", "0", "0", "0", "0", "0");
		assertEquals(true, test.canBeAdded(testcard2, testDeck));
	}
	
	@Test
	public void testCanBeAddedAnyNumberOfLands(){
		BasicRuleSet test = new BasicRuleSet();
		Deck testDeck = new Deck();
		MTGCard testcard = new MTGCard("Test", "0", "Land", "0", "0", "0", "0");
		for(int i = 0; i < 60; i++){
			assertEquals(true, test.canBeAdded(testcard, testDeck));
		}
	}

}
