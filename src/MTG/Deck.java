package MTG;
import java.util.ArrayList;


class Deck {
	private enum Rules{
		BASIC
	}
	public ArrayList<MTGCard> cards;
	public RuleSet rules;
	public Deck(){
		this.cards = new ArrayList<MTGCard>();
		this.rules = new Basic();
	}
	public Deck(String rule){
		this.cards = new ArrayList<MTGCard>();
		this.rules = determineRules(rule);
	}
	private RuleSet determineRules(String rule) {
		String rules = rule.toUpperCase();
		RuleSet ruleSet = null;
		Rules r;
		try{
			r = Rules.valueOf(rules);
		}
		catch(IllegalArgumentException e){
			System.out.println("Invalid Rule Default to Basic "+ rules);
			r = Rules.BASIC;
		}
		
		switch(r){
		case BASIC:
			ruleSet = new Basic();
		}
		return ruleSet;
	}
	
	public boolean addCardToDeck(MTGCard card){
		boolean valid = rules.canBeAdded(card, this);
		if(valid == true){
			cards.add(card);
			return true;
		}
		return false;
	}
}
