package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RemoveCardButton extends JButton implements ActionListener {

	private DeckPanel deckPanel;
	private CardDisplayPanel cardDisplay;

	public RemoveCardButton(String string, DeckPanel deckPanel, CardDisplayPanel cardDisplay){
		super(string);
		this.deckPanel = deckPanel;
		this.cardDisplay = cardDisplay;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.deckPanel.getDeck().removeCardFromDeck(this.cardDisplay.getCurrentCard());
		this.cardDisplay.setListOfCards(this.deckPanel.getDeck().cards);
		this.cardDisplay.repaint();
	}
}
