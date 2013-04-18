package MTG;
import java.util.ArrayList;


public abstract class RuleSet {
	public int DeckSize;
	public ArrayList<String> sets;
	public abstract boolean DeckValid(Deck deck);
	public abstract boolean canBeAdded(MTGCard card, Deck deck);
}

