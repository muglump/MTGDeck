package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import deck.Deck;
import deck.MTGCard;
import deck.MTGDeckMain;
import deck.XMLParser;

public class DeckPanel extends JPanel{
	private XMLParser parser;
	private Deck deck;
	private CardDisplayPanel cardDisplayPanel;
	
	public DeckPanel(XMLParser parser, Deck deck) throws ParserConfigurationException, SAXException, IOException{
		super(new BorderLayout());
		this.parser = parser;
		this.deck = deck;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		CardDisplayPanel cardDisplay = new CardDisplayPanel();
		this.cardDisplayPanel = cardDisplay;
		NextButton nextButton = new NextButton(MTGDeckMain.messages.getString("Next"), cardDisplay);
		PreviousButton previousButton = new PreviousButton(MTGDeckMain.messages.getString("Previous"), cardDisplay);
		JPanel menuButtonPanel = new JPanel();
		AddCardButton addButton = new AddCardButton(MTGDeckMain.messages.getString("Add"), cardDisplay, this.parser, this);
		SaveDeckButton saveButton = new SaveDeckButton("Save", this.deck);
		LoadDeckButton loadButton = new LoadDeckButton("Load", this, this.parser, cardDisplay);
		RemoveCardButton removeButton = new RemoveCardButton("Remove", this, cardDisplay);
		this.add(cardDisplay, BorderLayout.CENTER);
		this.add(nextButton, BorderLayout.LINE_END);
		this.add(previousButton, BorderLayout.LINE_START);
		menuButtonPanel.add(addButton);
		menuButtonPanel.add(removeButton);
		menuButtonPanel.add(saveButton);
		menuButtonPanel.add(loadButton);
		this.add(menuButtonPanel, BorderLayout.PAGE_START);
		
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public Deck getDeck(){
		return this.deck;
	}
	
	public void setDeck(Deck deck){
		this.deck = deck;
	}

	public void addCardToDeck(MTGCard currentCard) throws CardNotInRulesetException {
		// TODO Auto-generated method stub
		this.deck.addCardToDeck(currentCard);
	}

	public CardDisplayPanel getCardDisplay() {
		// TODO Auto-generated method stub
		return this.cardDisplayPanel;
	}
	
}
