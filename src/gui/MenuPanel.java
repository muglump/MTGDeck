package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	
	
	public MenuPanel(){
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,200);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawArtifacts(g);
		
	}

	private void drawArtifacts(Graphics g) {
		/** TODO This method should draw the artifacts of the UI
		*		This includes the:
		*			Deck Button,
		*			Search Button,
		*			Save Button,
		*			Load Button		
		*
		*/       
	}
	
}

