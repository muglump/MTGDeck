package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import deck.Deck;
import deck.MTGDeckMain;
import deck.XMLParser;
public class StatsPanel extends JPanel {
	private Deck deck;
	private JPanel menu;
	public StatsPanel(Deck theDeck){
		this.deck = theDeck;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		CardDisplayPanel cardDisplay = new CardDisplayPanel();
		this.menu = new JPanel();
		StatsButton stats = new StatsButton(MTGDeckMain.messages.getString("deckcommands8"), deck);
		this.menu.add(stats);
		this.add(this.menu, BorderLayout.PAGE_START);
		this.repaint();
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
