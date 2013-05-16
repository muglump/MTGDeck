package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
	private LanugaugePanel lang;
	public EnglishButton (String string, CardDisplayPanel cardDP, DeckPanel deck, SearchPanel search, LanugaugePanel langPanel){
		super(string);
		
		this.cardDisplayPanel = cardDP;
		this.deck = deck;
		this.search = search;
		this.lang = langPanel;
		this.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MTGDeckMain.currentLocale = MTGDeckMain.aLocale;
		MTGDeckMain.messages = ResourceBundle.getBundle("MessagesBundle", MTGDeckMain.currentLocale);
		this.lang.reSet();
		try {
			this.deck.reSet();
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
			this.search.reSet();
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
		JOptionPane.showMessageDialog(this,  MTGDeckMain.messages.getString("Language"));
		this.cardDisplayPanel.repaint();
	}
}
