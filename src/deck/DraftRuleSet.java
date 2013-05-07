package deck;

import java.util.ArrayList;


public class DraftRuleSet extends RuleSet {
	public int DeckSize;
	public ArrayList<String> setsD;
	public DraftRuleSet(){
		this.DeckSize = 40;
		setsD = new ArrayList<String>();
		setsD.add("Innistrad");
		setsD.add("Dark Ascension");
		setsD.add("Avacyn Restored");
		setsD.add("Magic 2013");
		setsD.add("Return to Ravnica");
		setsD.add("Gatecrash");
		setsD.add("Dragon's Maze");
	}
	@Override
	public boolean DeckValid(Deck deck){
		if(deck.cards.size() > DeckSize){
			return false;
		}
		for(MTGCard card: deck.cards){
			for(String set : setsD){
				if(!(card.sets.contains(set))){
					return false;
				}
			}
		}
		return true;
	}
	@Override
	public boolean canBeAdded(MTGCard card, Deck deck) {
		if(deck.cards.size() == this.DeckSize){
			return false;
		}
		if(card.type.contains("Basic Land")){
			return true;
		}
		ArrayList<Boolean> hold = new ArrayList<Boolean>();
		for(String set : setsD){
			if((card.sets.contains(set))){
				hold.add(true);
			}
			else{
				hold.add(false);
			}
		}
		if(!(hold.contains(true))){
			return false;
		}
		
		int cardCounter = 4;
		for(MTGCard cards : deck.cards){
			if(card.name == cards.name){
				cardCounter--;
			}
		}
		if(cardCounter <= 0){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "DRAFT";
	}
	
}
