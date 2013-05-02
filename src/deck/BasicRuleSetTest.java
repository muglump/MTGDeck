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

}
