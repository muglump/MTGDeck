package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PreviousButton extends JButton implements ActionListener{

	private CardDisplayPanel cardDisplay;

	public PreviousButton(String string, CardDisplayPanel cardDisplay) {
		super(string);
		this.cardDisplay = cardDisplay;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cardDisplay.shiftCardIndex(-1);
		this.getParent().repaint();
	}
	
}
