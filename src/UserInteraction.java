import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


public class UserInteraction {
	private ArrayList<MTGCard> searchResults;
	private XMLParser parser;
	


	private enum UserCommands{
		SEARCH, DISPLAY
	}
	private enum SearchEnumeration{
		NAME, TYPE, POWER, TOUGHNESS, RULES, COST, DISPLAY 
	}
	
	
	public UserInteraction() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		this.parser = new XMLParser();
		this.searchResults= new ArrayList<MTGCard>();
	}
	
	
	public void userInteraction() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.println("Choose Action: ");
		System.out.println("Search");
		System.out.println("Display");
		while(input.hasNext()){
			
			String command = input.next().toUpperCase();
			UserCommands u;
			try{
				u = UserCommands.valueOf(command);
			}
			catch(IllegalArgumentException e){
				System.out.println("Unknown command: "+command);
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
			}
			System.out.println("Choose Action: ");
			System.out.println("Search");
			System.out.println("Display");
			
			
		}
			
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
