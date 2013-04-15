import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class DeckTest {

	@Test
	public void testDeckNotNull() {
		Deck test = new Deck();
		Assert.assertNotNull(test);
	}
	
	@Test
	public void testDefualtDeckIsBasic(){
		Deck test = new Deck();
		RuleSet comp = new Basic();
		Assert.assertEquals(comp, test.rules);
	}
	
	@Test
	public void testDeckCreationCanMakeBasic(){
		Deck test = new Deck("Basic");
		RuleSet comp = new Basic();
		Assert.assertEquals(comp, test.rules);
	}

}
