package deck;

import java.util.ArrayList;

public class StandardRuleSet extends RuleSet {
	public int DeckSize;
	public ArrayList<String> sets;
	public StandardRuleSet(){
		this.DeckSize = 60;
		sets = new ArrayList<String>();
		sets.add("Innistrad");
		sets.add("Dark Ascension");
		sets.add("Avacyn Restored");
		sets.add("Magic 2013");
		sets.add("Return to Ravnica");
		sets.add("Gatecrash");
		sets.add("Dragon's Maze");
	}
	@Override
	public boolean DeckValid(Deck deck){
		if(deck.cards.size() > DeckSize){
			return false;
		}
		for(MTGCard card: deck.cards){
			for(String set : sets){
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
		for(String set : sets){
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
		return "STANDARD";
	}
	
}
