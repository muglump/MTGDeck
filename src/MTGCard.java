import java.util.ArrayList;


public class MTGCard {
 public String name;
 public String castingCost;
 public String type;
 public String power;
 public String toughness;
 public String sets;
 public String rules;
 
 
 public MTGCard(){
	 name="";
	 castingCost="";
	 type="";
	 power="";
	 toughness="";
	 sets="";
	 rules="";
 }
 
 public MTGCard(String newName, String newcastingCost, String newtype, String newpower, String newtoughness, String newsets, String newrules){
	 this.name = newName;
	 this.castingCost = newcastingCost;
	 this.type = newtype;
	 this.power = newpower;
	 this.toughness = newtoughness;
	 this.sets = newsets;
	 this.rules = newrules;
 }
 
 public String toString(){
	 return "Name " + name + " castingCost " + castingCost + " type " + type + " power " + power + " toughness " + toughness + " rules " + rules + " sets " + sets; 
 }
 
 
 
}
