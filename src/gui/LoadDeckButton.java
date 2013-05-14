package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import deck.Deck;
import deck.UserInteraction;
import deck.XMLParser;

public class LoadDeckButton extends JButton implements ActionListener{

	private DeckPanel deck;
	private XMLParser parser;
	private CardDisplayPanel cardDisplayPanel;
	public LoadDeckButton(String string, DeckPanel deckPanel, XMLParser parser, CardDisplayPanel cardDP) {
		// TODO Auto-generated constructor stub
		super(string);
		this.deck = deckPanel;	
		this.parser = parser;
		this.cardDisplayPanel = cardDP;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		int rv = fc.showOpenDialog(this);
		if(rv == JFileChooser.APPROVE_OPTION){
			File loadFile = fc.getSelectedFile();
			this.deck.setDeck(UserInteraction.loadDeck(loadFile,  this.parser));
			this.cardDisplayPanel.setListOfCards(this.deck.getDeck().cards);
			this.getParent().getParent().repaint();
		}
	}

}
