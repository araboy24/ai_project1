package gui;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener, MouseListener
{
    private Timer timer;
    private int delay = 8;
    public static CardLayout cl = new CardLayout();
    final public static JPanel HOME = new Home();

    public Panel()
    {
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        setLayout(cl);
        add(HOME, "Home");
    }
    
    public void setUpPanel() {
    	
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0,super.getWidth(), super.getHeight());
        
//        ImageIcon bg = new ImageIcon("kame bg.png");
//        bg.paintIcon(this, g, 0, 0);
        
        Font font = new Font("Arial", 30, 30);
        g.setFont(font);
        
        // Leave at end
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        timer.start();
        
        
        
        // Keep Last
        repaint();

    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

}
