package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ai_project1.LinkedListPractice;

public class Map extends JPanel
{
	JButton backBtn = new JButton("Back");
	 private Timer timer;
	    private int delay = 8;
	public Map() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.SOUTH;
		c.gridy = 1;
		add(backBtn, c);
//		addKeyListener(this);
//        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
//        timer = new Timer(delay, this);
//        timer.start();
        
        BufferedImage myPicture = null;
		try
		{
			myPicture = ImageIO.read(new File("palMap.png"));
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(myPicture != null) {
			
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        c.anchor = GridBagConstraints.NORTH;
        c.gridy = 0;
        add(picLabel, c);
		}
        backBtn.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			Driver.cl.show(Driver.cards, "home");
    		}
        });
	}
	
	
	
	
//	public void paint(Graphics g)
//    {
////        g.setColor(Color.white);
////        g.fillRect(0, 0,super.getWidth(), super.getHeight());
//        
//        ImageIcon bg = new ImageIcon("palMap.png");
////        bg.paintIcon(this, g, 0, 0);
//        
//        Font font = new Font("Arial", 30, 30);
//        g.setFont(font);
//        
//        // Leave at end
////        g.dispose();
//    }
	
}
