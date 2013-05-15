package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import deck.Deck;
import deck.MTGCard;
import deck.MTGDeckMain;
import deck.XMLParser;

public class DeckPanel extends JPanel implements ActionListener{
	private XMLParser parser;
	private Deck deck;
	private CardDisplayPanel cardDisplayPanel;
	private NextButton nextButton;
	private PreviousButton previousButton;
	private String[] rulesetStrings = { "BASIC", "STANDARD", "DRAFT" };
	private JPanel menu;
	
	public DeckPanel(XMLParser parser, Deck deck) throws ParserConfigurationException, SAXException, IOException{
		super(new BorderLayout());
		this.parser = parser;
		this.deck = deck;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		CardDisplayPanel cardDisplay = new CardDisplayPanel();
		this.cardDisplayPanel = cardDisplay;
		this.nextButton = new NextButton(MTGDeckMain.messages.getString("Next"), cardDisplay);
		this.previousButton = new PreviousButton(MTGDeckMain.messages.getString("Previous"), cardDisplay);
		this.menu = new JPanel();
		AddCardButton addButton = new AddCardButton(MTGDeckMain.messages.getString("Add"), cardDisplay, this.parser, this);
		SaveDeckButton saveButton = new SaveDeckButton(MTGDeckMain.messages.getString("deckcommands6"), this.deck);
		LoadDeckButton loadButton = new LoadDeckButton(MTGDeckMain.messages.getString("deckcommands7"), this, this.parser, cardDisplay);
		RemoveCardButton removeButton = new RemoveCardButton(MTGDeckMain.messages.getString("deckcommands5"), this, cardDisplay);
		JComboBox deckRulesetBox = new JComboBox(this.rulesetStrings);
		deckRulesetBox.addActionListener(this);
		this.add(cardDisplay, BorderLayout.CENTER);
		this.add(this.nextButton, BorderLayout.LINE_END);
		this.add(this.previousButton, BorderLayout.LINE_START);
		this.menu.add(addButton);
		this.menu.add(removeButton);
		this.menu.add(saveButton);
		this.menu.add(loadButton);
		this.menu.add(deckRulesetBox);
		this.add(this.menu, BorderLayout.PAGE_START);
		
	}
	
	public void reSet() throws ParserConfigurationException, SAXException, IOException{
		this.menu.removeAll();
		this.removeAll();
		this.nextButton = new NextButton(MTGDeckMain.messages.getString("Next"), this.cardDisplayPanel);
		this.previousButton = new PreviousButton(MTGDeckMain.messages.getString("Previous"), this.cardDisplayPanel);
		AddCardButton addButton = new AddCardButton(MTGDeckMain.messages.getString("Add"), this.cardDisplayPanel, this.parser, this);
		SaveDeckButton saveButton = new SaveDeckButton(MTGDeckMain.messages.getString("deckcommands6"), this.deck);
		LoadDeckButton loadButton = new LoadDeckButton(MTGDeckMain.messages.getString("deckcommands7"), this, this.parser, this.cardDisplayPanel);
		RemoveCardButton removeButton = new RemoveCardButton(MTGDeckMain.messages.getString("deckcommands5"), this, this.cardDisplayPanel);
		JComboBox deckRulesetBox = new JComboBox(this.rulesetStrings);
		deckRulesetBox.addActionListener(this);
		this.add(this.cardDisplayPanel, BorderLayout.CENTER);
		this.add(this.nextButton, BorderLayout.LINE_END);
		this.add(this.previousButton, BorderLayout.LINE_START);
		this.menu.add(addButton);
		this.menu.add(removeButton);
		this.menu.add(saveButton);
		this.menu.add(loadButton);
		this.menu.add(deckRulesetBox);
		this.add(this.menu, BorderLayout.PAGE_START);
		this.repaint();
	}
	
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setNavButtons();
	}

	private void setNavButtons() {
		if(this.cardDisplayPanel.noMoreToTheRight()){
			this.nextButton.setEnabled(false);
		}
		else{
			this.nextButton.setEnabled(true);
		}
		if(this.cardDisplayPanel.noMoreToTheLeft()){
			this.previousButton.setEnabled(false);
		}
		else{
			this.previousButton.setEnabled(true);
		}
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox rulesetBox = (JComboBox) arg0.getSource();
		try {
			this.deck.setRules((String) rulesetBox.getSelectedItem());
		} catch (CardNotInRulesetException e) {
			JOptionPane.showMessageDialog(this, MTGDeckMain.messages.getString("InvDeck"));
		}
		this.repaint();
		
	}

	

	
}
