package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import deck.Deck;
import deck.MTGDeckMain;
import deck.UserInteraction;
import deck.XMLParser;
public class EnglishButton extends JButton implements ActionListener {
	
	private CardDisplayPanel cardDisplayPanel;
	private DeckPanel deck;
	private SearchPanel search;
	public EnglishButton (String string, CardDisplayPanel cardDP, DeckPanel deck, SearchPanel search){
		super(string);
		
		this.cardDisplayPanel = cardDP;
		this.deck = deck;
		this.search = search;
		this.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MTGDeckMain.currentLocale = MTGDeckMain.aLocale;
		MTGDeckMain.messages = ResourceBundle.getBundle("MessagesBundle", MTGDeckMain.currentLocale);
		this.cardDisplayPanel.repaint();
		try {
			this.deck.setMenu();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.search.Reset();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.deck.repaint();
		this.search.repaint();
	}
}
