package deck;
import gui.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


public class MTGDeckMain {
	public static String language;
	public static String country;
	public static Locale currentLocale;
	public static ResourceBundle messages;
	public static Locale aLocale = new Locale("en", "US");
	public static Locale deLocale = new Locale("de", "DE");
	
	public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
	//	UserInteraction user = new UserInteraction();
		//user.userInteraction();
		//For testing purposes setting to english
				currentLocale = aLocale;
				messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		MagicDeckFrame frame = new MagicDeckFrame();
		Deck theDeck = new Deck();
		XMLParser parser = new XMLParser();
		DeckPanel deckPane = new DeckPanel(parser, theDeck);
		SearchPanel searchPane = new SearchPanel(parser, deckPane);
		JTabbedPane cardPanel = new JTabbedPane();
		cardPanel.addTab("Deck", deckPane);
		cardPanel.addTab("Search", searchPane);
		frame.add(cardPanel);
		frame.setVisible(true);
		
	}

}
