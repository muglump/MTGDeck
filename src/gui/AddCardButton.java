package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import deck.Deck;
import deck.MTGCard;
import deck.XMLParser;

public class AddCardButton extends JButton implements ActionListener{

	private CardDisplayPanel cardDisplay;
	private XMLParser parser;
	private Deck deck;

	public AddCardButton(String string, CardDisplayPanel cardDisplay, XMLParser parser) throws ParserConfigurationException, SAXException, IOException {
		super(string);
		this.cardDisplay = cardDisplay;
		this.addActionListener(this);
		this.parser = parser;
		this.deck = new Deck();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name= JOptionPane.showInputDialog("Enter a Card's Name, Capitalization Matters");
		String number= JOptionPane.showInputDialog("How many?");
		String ruleset = JOptionPane.showInputDialog("What Ruleset?");
		this.deck.setRules(ruleset);
		MTGCard card = this.parser.searchForCardName(name);
		Integer num = Integer.parseInt(number);
		for(int i = 0; i < num.intValue(); i++){
			this.deck.addCardToDeck(card);
		}
		this.cardDisplay.setListOfCards(this.deck.cards);
		this.cardDisplay.repaint();
	}

}
