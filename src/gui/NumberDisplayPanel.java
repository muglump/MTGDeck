package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import deck.Deck;
import deck.MTGCard;
import deck.MTGDeckMain;

public class NumberDisplayPanel extends JPanel {
	private DeckPanel deck;
	private JTextArea numberArea;
	public NumberDisplayPanel(Deck deck){
		super();
		this.setLayout(null);
		this.numberArea = new JTextArea();
		this.numberArea.setEditable(true);
		this.numberArea.setLineWrap(true);
		this.numberArea.setWrapStyleWord(true);
		this.add(numberArea);
	}
	
	
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.drawSkeleton(g);
			this.drawNumberOfCards(g);
	}


	private void drawSkeleton(Graphics g) {
		g.drawString("Number of cards in Deck:", 700, 50);
	}
	
	private void drawNumberOfCards(Graphics g) {
		String number = "" + this.deck.cardsInDeck();
		g.drawString(number, 725, 50);
		this.repaint();
	}
}
