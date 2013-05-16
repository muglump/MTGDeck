package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import deck.MTGDeckMain;

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
		if(this.deckPanel.getDeck().cards.size()==0){
			return;
		}
		else{
			this.deckPanel.getDeck().removeCardFromDeck(this.cardDisplay.getCurrentCard());
			if (this.cardDisplay.noMoreToTheRight()){
				this.cardDisplay.shiftCardIndex(-1);
			}
			this.cardDisplay.setListOfCards(this.deckPanel.getDeck().cards);
			JOptionPane.showMessageDialog(this,  MTGDeckMain.messages.getString("removecompletion1"));
			cardDisplay.cleartext();
			this.getParent().getParent().repaint();
		}
	}
}
