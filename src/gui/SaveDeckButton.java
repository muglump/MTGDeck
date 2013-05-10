package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import deck.Deck;
import deck.UserInteraction;

public class SaveDeckButton extends JButton implements ActionListener{

	private Deck deck;

	public SaveDeckButton(String string, Deck deck) {
		// TODO Auto-generated constructor stub
		super(string);
		this.deck = deck;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		int rv = fc.showSaveDialog(this);
		if(rv==JFileChooser.APPROVE_OPTION){
			File saveFile = fc.getSelectedFile();
			UserInteraction.saveDeck(this.deck, saveFile);
		}
		
		
	}

}
