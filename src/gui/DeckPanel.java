package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DeckPanel extends JPanel{
	
	
	public DeckPanel(){
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(500,500);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawArtifacts(g);
		this.drawName(g);
		this.drawType(g);
		this.drawRules(g);
		this.drawPT(g);
		this.drawMC(g);
		this.drawSets(g);
		
	}

	private void drawSets(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	private void drawArtifacts(Graphics g) {
		/** TODO This method should draw the artifacts of the UI
		*		This includes the:
		*			Card List Navigation buttons,
		*			Card UI layout,
		*			Deck Type Area
		*			
		*		
		*
		*/       
	}

	private void drawName(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	private void drawType(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	private void drawRules(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	private void drawPT(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	private void drawMC(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
