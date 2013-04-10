import java.util.ArrayList;


public class MTGCard {
 public String name;
 public String castingCost;
 public String type;
 public String power;
 public String toughness;
 public ArrayList<String> sets;
 public String description;
 
 public MTGCard(String newName, String newcastingCost, String newtype, String newpower, String newtoughness, ArrayList<String> newsets, String newdescription){
	 this.name = newName;
	 this.castingCost = newcastingCost;
	 this.type = newtype;
	 this.power = newpower;
	 this.toughness = newtoughness;
	 this.sets = newsets;
	 this.description = newdescription;
 }
 
 
 
}
