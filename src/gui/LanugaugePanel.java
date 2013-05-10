package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import deck.Deck;
import deck.XMLParser;
public class LanugaugePanel extends JPanel{
	private XMLParser parser;
	private DeckPanel deck;
	private SearchPanel search;
	private Deck theDeck;
	public LanugaugePanel(XMLParser parser2, DeckPanel deck, SearchPanel search, Deck theDeck){
		super(new BorderLayout());
		this.parser = parser;
		this.deck = deck;
		this.search = search;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		CardDisplayPanel cardDisplay = new CardDisplayPanel();
		JPanel menuButtonPanel = new JPanel();
		EnglishButton english = new EnglishButton("English", cardDisplay, deck, search);
		GermanButton german = new GermanButton("German", cardDisplay, deck, search, theDeck);
		menuButtonPanel.add(english);
		menuButtonPanel.add(german);
		this.add(menuButtonPanel, BorderLayout.PAGE_START);
	}
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
