package gui;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import deck.MTGCard;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SearchPanel extends JPanel{
	
	
	public SearchPanel(){
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(800,600);
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
		*			Search Button
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
