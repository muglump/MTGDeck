package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import deck.MTGDeckMain;

public class NextButton extends JButton implements ActionListener {

	private CardDisplayPanel cardDisplay;

	public NextButton(String string, CardDisplayPanel cardDisplay) {
		super(string);
		this.cardDisplay = cardDisplay;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.cardDisplay.shiftCardIndex(1);
		this.getParent().repaint();
	}

}
