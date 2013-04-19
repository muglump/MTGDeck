import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


public class UserInteraction {
	private ArrayList<MTGCard> searchResults;
	private XMLParser parser;
	private Deck currentDeck;
	


	private enum UserCommands{
		SEARCH, DISPLAY, DECK, EXIT
	}
	private enum SearchEnumeration{
		NAME, TYPE, POWER, TOUGHNESS, RULES, COST, DISPLAY 
	}
	
	private enum DeckEnum{
		DISPLAY, NEW, ADD, REMOVE, EXIT
	}
	
	private enum Rules{
		BASIC
	}
	
	public UserInteraction() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		this.parser = new XMLParser();
		this.searchResults= new ArrayList<MTGCard>();
		this.currentDeck = new Deck();
	}
	
	
	public void userInteraction() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome");
		printUICommands();
		while(input.hasNext()){
			
			String command = input.next().toUpperCase();
			UserCommands u;
			try{
				u = UserCommands.valueOf(command);
			}
			catch(IllegalArgumentException e){
				System.out.println("Unknown command: "+command);
				printUICommands();
				continue;
			}
			
			switch(u){
			case SEARCH:
				this.searchCommand(input);
				break;
			case DISPLAY:
				String display = this.displayCommand();
				System.out.println(display);
				break;
			case DECK:
				this.deckCommands(input);
				break;
			case EXIT:
				return;
				
			}
			printUICommands();
			
			
		}
			
	}


	private void printUICommands() {
		System.out.println("Choose Action: ");
		System.out.println("Search");
		System.out.println("Display");
		System.out.println("Deck");
		System.out.println("Exit");
	}
	
	
	private void deckCommands(Scanner input) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		printDeckCommands();
		String result = "";
		while(input.hasNext()){
			String command = input.next();
			command = command.toUpperCase();
			DeckEnum c;
			try {
				c = DeckEnum.valueOf(command);
			}
			catch(IllegalArgumentException e){
				System.out.println("Unknown command: "+ command);
				printDeckCommands();
				continue;
			}
			
			switch(c){
			case DISPLAY:
				System.out.println(this.currentDeck);
				break;
			case NEW:
				result = newDeck(input);
				break;
			case ADD:
				addCard(input);
				break;
			case REMOVE:
				removeCard(input);
				break;
			case EXIT:
				return;
			}
			printDeckCommands();
		}
		System.out.println(result);
	}

private String newDeck(Scanner input){
	String result = "";
	System.out.println("Choose RuleSet");
	for(Rules value: Rules.values()){
		System.out.println("    "+value);
	}
	
	String command = input.next();
	command = command.toUpperCase();
	this.currentDeck = new Deck(command);
	result = this.currentDeck.toString();
	
	return result;
}

	private void addCard(Scanner input) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		System.out.println("Enter number to add and the card's name (Capitalization matters), type 0 to quit");
		System.out.println("example: 4 Rancor");
		int numberToAdd=0;
		while(input.hasNext()){
			String numberInput = input.next();
			try{
				numberToAdd = Integer.parseInt(numberInput);
			}
			catch(NumberFormatException e){
				System.out.println("Please enter the number and then the card name");
				continue;
			}
			if(numberToAdd == 0){
				break;
			}
			input.skip(" ");
			String cardName = input.nextLine();
			MTGCard card = parser.searchForCardName(cardName);
			for(int i=0; i < numberToAdd; i++){
				this.currentDeck.addCardToDeck(card);
			}
			System.out.println("Card(s) Added Successfully.");
			System.out.println("Enter number to add and the card's name (Capitalization matters), type 0 to quit");
			System.out.println("example: 4 Rancor");
		}
	}
	

	private void removeCard(Scanner input) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {

		System.out.println("Enter number to remove and the card's name (Capitalization matters), type 0 to quit");
		System.out.println("example: 4 Rancor");
		int numberToRemove=0;
		while(input.hasNext()){
			String numberInput = input.next();
			try{
				numberToRemove = Integer.parseInt(numberInput);
			}
			catch(NumberFormatException e){
				System.out.println("Please enter the number and then the card name");
				continue;
			}
			if(numberToRemove == 0){
				break;
			}
			input.skip(" ");
			String cardName = input.nextLine();
			MTGCard card = parser.searchForCardName(cardName);
			for(int i=0; i < numberToRemove; i++){
				this.currentDeck.removeCardFromDeck(card);
			}
			System.out.println("Card(s) Removed Successfully.");
			System.out.println("Enter number to add and the card's name (Capitalization matters), type 0 to quit");
			System.out.println("example: 4 Rancor");
		}
	}



private void printDeckCommands() {
	System.out.println("Choose Deck Command");
	System.out.println("New");
	System.out.println("Display");
	System.out.println("Add");
	System.out.println("Remove");
	System.out.println("Exit");
}


private void searchCommand(Scanner input) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
		String searchType = "";
		String searchTerm = "";
		System.out.println("Choose a search type ");
		System.out.println("Name <Term>");
		System.out.println("Type <Term>");
		System.out.println("Power <Term>");
		System.out.println("Toughness <Term>");
		System.out.println("Rules <Term>");
		System.out.println("Cost <Term>");
		System.out.print("> ");
		while(input.hasNext()){
			
			
			String command = input.next();
			command = command.toUpperCase();
			SearchEnumeration c;
			try{
				c = SearchEnumeration.valueOf(command);
			}
			catch(IllegalArgumentException e){
				System.out.println("Unknown command: "+ command);
				System.out.println("Choose a search type ");
				System.out.println("Name <Term>");
				System.out.println("Type <Term>");
				System.out.println("Power <Term>");
				System.out.println("Toughness <Term>");
				System.out.println("Rules <Term>");
				System.out.println("Cost <Term>");
				System.out.print("> ");
				continue;
			}
		
			switch(c){
			case NAME:
				searchType = "name";
				break;
			case TYPE:
				searchType = "type";
				break;
			case POWER:
				searchType = "power";
				break;
			case TOUGHNESS:
				searchType = "toughness";
				break;
			case RULES:
				searchType = "rules";
				break;
			case COST:
				searchType = "cost";
				break;
			}
			break;
		}
		input.skip(" ");
		searchTerm = input.nextLine();
		
		this.searchResults = search(this.parser, searchType, searchTerm);
		System.out.println("Search Concluded with "+ this.searchResults.size() + " results");
		
	}
	public String displayCommand() {
		StringBuilder sb = new StringBuilder();
		
		if(this.searchResults.isEmpty()){
			sb.append("No current search results");
		}
		else{
			int searchResultIndex = 1;
			for(MTGCard card : this.searchResults){
				sb.append("Result number " + searchResultIndex +"\n");
				sb.append(card.toString() + "\n");
				sb.append("\n");
				searchResultIndex++;
			}
		}
		return sb.toString();
	
	}


	


	public static ArrayList<MTGCard> search(XMLParser parser,
			String searchType, String searchTerm)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		String searchQuery = parser.buildXPathQuery(searchType, searchTerm);
		
		ArrayList<MTGCard> searchResults = parser.searchXML(searchQuery);
		return searchResults;
	}
	
	
//getters
	public ArrayList<MTGCard> getSearchResults() {
		return this.searchResults;
	}
	
	public void setSearchResults(ArrayList<MTGCard> searchResults){
		this.searchResults = searchResults;
	}

	public XMLParser getParser() {
		return parser;
	}

}
