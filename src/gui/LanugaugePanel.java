package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import deck.Deck;
import deck.MTGDeckMain;
import deck.XMLParser;
public class LanugaugePanel extends JPanel{
	private XMLParser parser;
	private DeckPanel deck;
	private SearchPanel search;
	private Deck theDeck;
	private JPanel menu;
	private CardDisplayPanel display;
	public LanugaugePanel(DeckPanel deck, SearchPanel search, Deck theDeck){
		super(new BorderLayout());
		this.deck = deck;
		this.search = search;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.display = new CardDisplayPanel();
		this.menu = new JPanel();
		EnglishButton english = new EnglishButton(MTGDeckMain.messages.getString("English"), this.display, deck, search, this);
		GermanButton german = new GermanButton(MTGDeckMain.messages.getString("German"), this.display, deck, search, theDeck, this);
		this.menu.add(english);
		this.menu.add(german);
		this.add(this.menu, BorderLayout.PAGE_START);
	}
	
	public void reSet(){
		this.menu.removeAll();
		this.removeAll();
		EnglishButton english = new EnglishButton(MTGDeckMain.messages.getString("English"), this.display, deck, search, this);
		GermanButton german = new GermanButton(MTGDeckMain.messages.getString("German"), this.display, deck, search, theDeck, this);
		this.menu.add(english);
		this.menu.add(german);
		this.add(this.menu, BorderLayout.PAGE_START);
	}
	
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
