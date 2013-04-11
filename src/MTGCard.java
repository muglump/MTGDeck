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
	 try{
		 Integer.parseInt(newpower);
		 this.power=newpower;
	 }
	 catch(NumberFormatException e){
		 if(newpower.equals("*")){
			 this.power=newpower;
		 }
		 else{
			 this.power="n/a";
		 }
	 }
	 try{
		 Integer.parseInt(newtoughness);
		 this.toughness=newtoughness;
	 }
	 catch(NumberFormatException e){
		 if(newtoughness.equals("*")){
			 this.toughness=newtoughness;
		 }
		 else{
			 this.toughness="n/a";
		 }
	 }
	 this.sets = newsets;
	 this.rules = newrules;
 }
 
 public String toString(){
	
	 return "Name " + name + "\nCastingCost " + castingCost + "\nType " + type + "\nPower " + power + "\nToughness " + toughness + "\nRules " + rules + "\nSets " + sets; 
 }
 
 
 
}
