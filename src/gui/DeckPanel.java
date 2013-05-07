package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import deck.XMLParser;

public class DeckPanel extends JPanel{
	XMLParser parser;
	
	public DeckPanel(XMLParser parser) throws ParserConfigurationException, SAXException, IOException{
		super(new BorderLayout());
		this.parser = parser;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		CardDisplayPanel cardDisplay = new CardDisplayPanel();
		NextButton nextButton = new NextButton("Next", cardDisplay);
		PreviousButton previousButton = new PreviousButton("Previous", cardDisplay);
		AddCardButton addButton = new AddCardButton("Add Card", cardDisplay, this.parser);
		this.add(cardDisplay, BorderLayout.CENTER);
		this.add(nextButton, BorderLayout.LINE_END);
		this.add(previousButton, BorderLayout.LINE_START);
		this.add(addButton, BorderLayout.PAGE_START);
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

		
	
}
