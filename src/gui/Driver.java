package gui;


import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver
{	
	public static JPanel cards = new JPanel();
    public static CardLayout cl = new CardLayout();
    final public static JPanel HOME = new Home();
    final public static JPanel MAP = new Map();
    public static void main(String[] args)
    {    	
        JFrame a = new JFrame();
        cards.setLayout(cl);
        a.add(cards);
        cards.add(HOME, "home");
        cards.add(MAP, "map");
        a.setResizable(false);
        a.setBackground(Color.lightGray);
        a.setTitle("AI Project");
        a.setSize(400, 600); //Set Size
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
        a.revalidate();
    }

}
