package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import deck.MTGCard;

public class CardDisplayPanel extends JPanel {
	
	private ArrayList<MTGCard> listOfCards;
	private int currentCardIndex;
	private JTextArea rulesArea;

	public CardDisplayPanel(){
		super();
		this.setLayout(null);
		this.currentCardIndex = 0;
		this.listOfCards = new ArrayList<MTGCard>();
		this.rulesArea = new JTextArea();
		this.rulesArea.setEditable(false);
		this.rulesArea.setLineWrap(true);
		this.rulesArea.setWrapStyleWord(true);
		this.rulesArea.setBounds(110, 380, 370, 150);
		this.add(rulesArea);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawSkeleton(g);
		this.drawlistOfCards(g);
	}
	
	private void drawSkeleton(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(50, 50, 500, 600);
		g.drawRect(100, 350, 400, 200);
		g.drawString("Name:", 60, 70);
		g.drawString("Type:", 60, 90);
		g.drawString("Rules:", 110, 370);
		g.drawString("Cost:", 400, 70);
		g.drawString("Sets:", 60, 120);
		g.drawString("P/T:", 400, 600);
	}
	
	private void drawlistOfCards(Graphics g) {
		if(!this.listOfCards.isEmpty()){
			String name = this.listOfCards.get(this.currentCardIndex).name;
			String type = this.listOfCards.get(this.currentCardIndex).type;
			String rules = this.listOfCards.get(this.currentCardIndex).rules;
			String sets = this.listOfCards.get(this.currentCardIndex).sets;
			String cost = this.listOfCards.get(this.currentCardIndex).castingCost;
			String pt = this.listOfCards.get(this.currentCardIndex).power + "/" + this.listOfCards.get(this.currentCardIndex).toughness;
			this.rulesArea.setText(rules);
			g.drawString(name, 100, 70);
			g.drawString(type, 90, 90);
			//drawRules(g, rules, 150, 370);
			drawSets(g, sets, 90, 120);
			g.drawString(cost, 440, 70);
			g.drawString(pt, 440, 600);
		}
	}

	private void drawSets(Graphics g, String sets, int i, int j) {
		int spacing = 0;
		for(String part: sets.split("[,\n]")){
			g.drawString(part, i, j+20*spacing);
			spacing++;
		}
	}
	private void drawRules(Graphics g, String rules, int i, int j) {
		int spacing = 0;
		for(String part: rules.split("[,\n]")){
			g.drawString(part, i, j+20*spacing);
			spacing++;
		}
	}

	public void setListOfCards(ArrayList<MTGCard> listOfCards){
		this.listOfCards=  listOfCards;
	}
	
	public void shiftCardIndex(int i){
		if((this.currentCardIndex == 0 && i <0) || (this.currentCardIndex == this.listOfCards.size()-1 && i>0)){
			return;
		}
		else{
			this.currentCardIndex = this.currentCardIndex+ i;
		}
	}
	
	public MTGCard getCurrentCard(){
		return this.listOfCards.get(this.currentCardIndex);
		
	}
	
	public boolean cardsEmpty(){
		return this.listOfCards.isEmpty();
	}
	
	public boolean noMoreToTheRight(){
		return this.currentCardIndex>=this.listOfCards.size()-1;
		
	}
	
	public boolean noMoreToTheLeft(){
		return this.currentCardIndex==0;
		
	}
	
}
