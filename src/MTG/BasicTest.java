package MTG;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class BasicTest {

	@Test
	public void testBasicNotNull() {
		Basic test = new Basic();
		Assert.assertNotNull(test);
	}
	
	@Test public void testBasicHasCorrectDeckLimit(){
		Basic test = new Basic();
		Assert.assertEquals(60, test.DeckSize);
	}

}
