import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.smartcardio.Card;

import org.junit.Test;


public class TestCard {
	public Cards brainStorm = new Cards();
	public Cards akora = new Cards();
	public ArrayList<Cards> currentHand = new ArrayList<Cards>();
	
	


	@Test
	public void testEmpty(){		
		assertEquals(new ArrayList<Cards>(), currentHand);
	}
	
	@Test
	public void testNullgetColor(){
		makeBrainStorm();
		addCards();
		assertEquals(null, this.currentHand.get(0).getCardColor(20));
	}
	
	@Test
	public void testNullgetName(){
		makeBrainStorm();
		addCards();
		assertEquals(null, this.currentHand.get(0).getCardNames(20));
	}
	
	@Test
	public void testNullgetType(){
		makeBrainStorm();
		addCards();
		assertEquals(null, this.currentHand.get(0).getType(20));
	}
	
	@Test
	public void testDeck1(){
		makeBrainStorm();
		makeAkora();
		addCards();
		assertEquals("Blue",this.currentHand.get(0).cardColor);
		assertEquals("BrainStorm", this.currentHand.get(0).cardName);
		assertEquals("Spell", this.currentHand.get(0).type);
		assertEquals("Multi-Color",this.currentHand.get(1).cardColor);
		assertEquals("Akroma, Angel of Wrath", this.currentHand.get(1).cardName);
		assertEquals("Land", this.currentHand.get(1).type);
	}
	
	public void makeBrainStorm(){
		Cards chooser = new Cards();
		this.brainStorm.cardColor = chooser.getCardColor(1);
		this.brainStorm.cardName = chooser.getCardNames(0);
		this.brainStorm.type = chooser.getType(0);

	}
	
	public void addCards(){
		this.currentHand.add(brainStorm);
		this.currentHand.add(akora);
	}
	

	public void makeAkora(){
		Cards chooser = new Cards();
		this.akora.cardColor = chooser.getCardColor(5);
		this.akora.cardName=  chooser.getCardNames(1);
		this.akora.type = chooser.getType(1);
	}

			
	

}
