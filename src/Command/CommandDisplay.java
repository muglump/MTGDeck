package Command;

import MTG.*;
import java.util.ArrayList;


public class CommandDisplay implements Commands {

	public String displayCommand(ArrayList<MTGCard> searchResults) {
		StringBuilder sb = new StringBuilder();
		
		if(searchResults.isEmpty()){
			sb.append("No current search results");
		}
		else{
			int searchResultIndex = 1;
			for(MTGCard card : searchResults){
				sb.append("Result number " + searchResultIndex +"\n");
				sb.append(card.toString() + "\n");
				sb.append("\n");
				searchResultIndex++;
			}
		}
		return sb.toString();
	
	}
}
