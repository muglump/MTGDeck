import java.util.ArrayList;


public class Deck {
	private enum Rules{
		BASIC
	}
	public ArrayList<MTGCard> cards;
	public RuleSet rules;
	public Deck(){
		this.cards = new ArrayList<MTGCard>();
		this.rules = new BasicRuleSet();
	}
	public Deck(String rule){
		this.cards = new ArrayList<MTGCard>();
		this.rules = determineRules(rule);
	}
	
	public String getprintable(String line){
		return UserInteraction.messages.getString(line);
	}
	
	private RuleSet determineRules(String rule) {
		String rules = rule.toUpperCase();
		RuleSet ruleSet = null;
		Rules r;
		try{
			r = Rules.valueOf(rules);
		}
		catch(IllegalArgumentException e){
			System.out.println(getprintable("invalidrule")+ rules);
			r = Rules.BASIC;
		}
		
		switch(r){
		case BASIC:
			ruleSet = new BasicRuleSet();
			break;
		}
		return ruleSet;
	}
	
	public boolean addCardToDeck(MTGCard card){
		boolean valid = rules.canBeAdded(card, this);
		if(valid){
			cards.add(card);
			return true;
		}
		return false;
	}
	
	public void removeCardFromDeck(MTGCard cardToRemove){
		for(MTGCard card : this.cards){
			if(card.equals(cardToRemove)){
				this.cards.remove(card);
				break;
			}
		}
	}
	
//	@Override
//	public String toString(){
//		int i = 1/0;
//		if(this.cards.isEmpty()){
//			return "No Cards currently in Deck";
//		}
//		return this.cards.toString();
//		
//	}
	
	public String displayDeck(){
		String deckString = "";
		if(this.cards.isEmpty()){
			return getprintable("nocards");
		}
		
		for(MTGCard card : cards){
			deckString = deckString + (card.toString());
		}
		System.out.println(deckString);
		
		return deckString;
	}
}
