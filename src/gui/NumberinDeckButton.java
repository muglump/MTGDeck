package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import deck.Deck;
import deck.MTGDeckMain;

public class NumberinDeckButton extends JButton implements ActionListener {
	
	private Deck deck;
	
	public NumberinDeckButton(String string, Deck deck) {
		// TODO Auto-generated constructor stub
		super(string);
		this.deck = deck;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, this.deck.cards.size());
		
		
	}

}
