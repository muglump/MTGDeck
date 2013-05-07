package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class MagicDeckFrame extends JFrame{
	
	
	
	public MagicDeckFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Magic the Gathering Deck Builder");
		this.setSize(800, 800);
		//this line is just to ensure that it works will replace later
		
	}
	
	public void setVisible(){
		this.setVisible(true);
	}
	
	
	
	
	
}
