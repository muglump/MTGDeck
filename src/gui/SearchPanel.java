package gui;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import deck.Deck;
import deck.MTGCard;
import deck.MTGDeckMain;
import deck.XMLParser;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SearchPanel extends JPanel{
	
	
	private XMLParser parser;
	private DeckPanel deck;
	
	public SearchPanel(XMLParser parser, DeckPanel deck) throws ParserConfigurationException, SAXException, IOException{
		super(new BorderLayout());
		this.deck = deck;
		this.parser = parser;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		CardDisplayPanel cardDisplay = new CardDisplayPanel();
		JPanel menuButtonPanel = new JPanel();
		NextButton nextButton = new NextButton(MTGDeckMain.messages.getString("Next"), cardDisplay);
		PreviousButton previousButton = new PreviousButton(MTGDeckMain.messages.getString("Previous"), cardDisplay);
		SearchButton searchButton = new SearchButton(MTGDeckMain.messages.getString("SearchButton1"), cardDisplay, this.parser);
		AddResultButton addResultButton = new AddResultButton("Add This Card", cardDisplay, deck);
		this.add(cardDisplay, BorderLayout.CENTER);
		this.add(nextButton, BorderLayout.LINE_END);
		this.add(previousButton, BorderLayout.LINE_START);
		menuButtonPanel.add(searchButton);
		menuButtonPanel.add(addResultButton);
		this.add(menuButtonPanel, BorderLayout.PAGE_START);
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

		
	
}
