package deck;
import gui.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


public class MTGDeckMain {

	
	public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
	//	UserInteraction user = new UserInteraction();
		//user.userInteraction();
		MagicDeckFrame frame = new MagicDeckFrame();
		SearchPanel searchPane = new SearchPanel();
		DeckPanel deckPane = new DeckPanel();
		JTabbedPane cardPanel = new JTabbedPane();
		cardPanel.addTab("Deck", deckPane);
		cardPanel.addTab("Search", searchPane);
		frame.add(cardPanel);
		frame.setVisible(true);
	}

}
