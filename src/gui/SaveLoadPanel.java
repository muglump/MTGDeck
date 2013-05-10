package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import deck.MTGDeckMain;
import deck.XMLParser;

public class SaveLoadPanel extends JPanel {
	
	private XMLParser parser;

	public SaveLoadPanel(XMLParser parser){
		super();
		this.parser = parser;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		CardDisplayPanel cardDisplay = new CardDisplayPanel();
		SaveDeckButton saveButton = new SaveDeckButton(MTGDeckMain.messages.getString("Add"), cardDisplay, this.parser);
		
	}
}
