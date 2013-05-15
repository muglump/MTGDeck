package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import deck.MTGDeckMain;

public class AddResultButton extends JButton implements ActionListener{

	private DeckPanel deckPanel;
	private CardDisplayPanel cardDisplay;

	public AddResultButton(){
		super();
	}

	public AddResultButton(String string, CardDisplayPanel cardDisplay,
			DeckPanel deck) {
		// TODO Auto-generated constructor stub
		super(string);
		this.cardDisplay = cardDisplay;
		this.deckPanel = deck;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!this.cardDisplay.cardsEmpty()){
			int number = Integer.parseInt(JOptionPane.showInputDialog(MTGDeckMain.messages.getString("NumToAdd")));
			for(int i=0; i<number; i++){
				try{
					this.deckPanel.addCardToDeck(this.cardDisplay.getCurrentCard());
				}catch(CardNotInRulesetException e){
					JOptionPane.showMessageDialog(this, MTGDeckMain.messages.getString("RuleVio"));
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "No Results");
		}
		this.deckPanel.getCardDisplay().setListOfCards(this.deckPanel.getDeck().cards);
		this.deckPanel.repaint();
	}
}
