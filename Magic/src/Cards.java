
public class Cards {
	
	String[] cardColors = 
		{
			"White", "Blue", "Black", "Red", "Green", "Multi-Color", "Colorless"
		};
	String[] types = 
		{
			"Spell", "Land"
		};
	
	String[] cardNames = 
		{
			"BrainStorm", "Akroma, Angel of Wrath", "Shock", "Phyrexian Revoker"
		};
	
	String cardName = " ";
	String type = " ";
	String cardColor = " ";
		
	
	
	
	public String getCardColor(int n){
		if(n >= 0 && n <= 6){
			return this.cardColors[n];
		}else{
			return null;
		}
		
	}
	
	public String getType(int n){
		if(n >= 0 && n <= 2){
			return this.types[n];
		}
		return null;
		
	}
	
	public String getCardNames(int n){
		if(n >= 0 && n <= 3){
			return this.cardNames[n];
		}
		return null;
	}
}
	
	


