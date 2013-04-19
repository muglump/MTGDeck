/**
 * 
 * @author whiteaj
 * @Description This rule set makes the max deck size 60,
 *  makes sure that you don't have more than 4 cards, unless its a Basic Land 
 */
public class BasicRuleSet extends RuleSet {
	public int DeckSize;
	public BasicRuleSet(){
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
		if (deck.cards.size() == this.DeckSize){
			return false;
		}
		if(card.type.contains("Basic Land")){
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
