
public class Basic extends RuleSet {
	public int DeckSize;
	public Basic(){
		this.DeckSize = 60;
	}
	@Override
	public boolean DeckValid(Deck deck) {
		if(deck.cards.size() > DeckSize){
			return false;
		}
		return true;
	}

	@Override
	public boolean canBeAdded(MTGCard card, Deck deck) {
		if(card.type.contains("Land")){
			return true;
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

}
