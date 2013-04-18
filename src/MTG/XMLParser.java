package MTG;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParser {

	
	
	public XMLParser(){
	
	}
	
	public String buildXPathQuery(String searchType, String searchTerm) {
		String query = "//card["+searchType+"=\'"+searchTerm+"\']/*";
		//example query     "//card[name='Voidwalk']/*
		
		return query;
		
	}
	
	public ArrayList<MTGCard> searchXML(String query) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("CardInfo.xml");
		
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		XPathExpression expr = xpath.compile(query);
		
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		
		NodeList nodes = (NodeList) result;
		ArrayList<MTGCard> searchResults = populateListOfCards(nodes);
		
		
		
		if(nodes.getLength()==0){
			throw new XPathExpressionException("Invalid XPath Query");
		}
		else{
			return searchResults;
		}
	}

	private ArrayList<MTGCard> populateListOfCards(NodeList nodes) {
		int numberOfCards = nodes.getLength()/21;
		ArrayList<MTGCard> cards = new ArrayList<MTGCard>();
		
		int nameNodeIndex = 2;
		int costNodeIndex = 4;
		int typeNodeIndex = 6;
		int powerNodeIndex = 9;
		int toughnessNodeIndex = 10;
		int rulesNodeIndex = 11;
		int setsNodeIndex = 19;
		int cardNodesSize = 21;
		
		MTGCard currentCard = new MTGCard();
		for(int i=0; i < numberOfCards; i++){
			
			currentCard.name = nodes.item(nameNodeIndex + cardNodesSize*i).getTextContent();
			currentCard.castingCost = nodes.item(costNodeIndex+cardNodesSize*i).getTextContent();
			currentCard.type = nodes.item(typeNodeIndex+cardNodesSize*i).getTextContent();
			currentCard.power = nodes.item(powerNodeIndex+cardNodesSize*i).getTextContent();
			currentCard.toughness = nodes.item(toughnessNodeIndex+cardNodesSize*i).getTextContent();
			currentCard.rules = nodes.item(rulesNodeIndex+cardNodesSize*i).getTextContent();
			currentCard.sets = nodes.item(setsNodeIndex+cardNodesSize*i).getTextContent();
			
			cards.add(currentCard);
			
		
		}
		return cards;
		
	}



}
