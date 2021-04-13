package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ai_project1.ItDeepCity;
import ai_project1.IterDeepPrep;
import ai_project1.UnifCost;

import javax.swing.JMenu;
import javax.swing.JMenuItem;;

public class Home extends JPanel
{
	private String startCity = "Jenin";
	private String endCity = "Jenin";
	
	
	private JPanel topPan = new JPanel();
	private JPanel midPan = new JPanel();
	private JPanel botPan = new JPanel();
	private JPanel mlPan = new JPanel();
	private JPanel mrPan = new JPanel();
	private JPanel resultsPan = new JPanel();
	
	
	private JLabel labTitle = new JLabel("Welcome to PalCal");
	private JLabel labStartLoc = new JLabel("Select a Start Location");
	private JLabel labEndLoc = new JLabel("Select an End Location");

	private JButton btnIterativeDeepening = new JButton("Run Iterative Deepening");
	private JButton btnUniformCost = new JButton("Run Uniform Cost Driving");
	private JButton btnUniformCostAreal = new JButton("Run Uniform Cost Areal");
	private JButton btnOptimal1 = new JButton("Run Optimal 1");
	private JButton btnViewMap = new JButton("View Map");
	

	private String[] cities = {"Jenin", "Ramallah", "Toulkarem", "Jerusalem", "Jericho", 
	                           "Qalqillia", "Bethlehem", "Tubas", "Hebron", "Nablus", "Salfeit", "North Gaza",
	                           "Gaza", "Deir Al Balah", "Khan Yunis", "Rafah", "Safad", "Haifa" , "Jaffa", "Ramla", "Nazareth"};
	
	private JComboBox startComboBox = new JComboBox(cities);
	private JComboBox endComboBox = new JComboBox(cities);
	
	private JMenuItem jeninMenSel = new JMenuItem("Jenin");
	private JMenuItem ramallahMenSel = new JMenuItem("Ramallah");
	private JMenuItem toulMenSel = new JMenuItem("Toulkarem");
	private JMenuItem jerusalemMenSel = new JMenuItem("Jerusalem");
	private JMenuItem jerichoMenSel = new JMenuItem("Jericho");
	private JMenuItem qalqMenSel = new JMenuItem("Qalqillia");
	private JMenuItem bethMenSel = new JMenuItem("Bethlehem");
	private JMenuItem tubasMenSel = new JMenuItem("Tubas");
	private JMenuItem hebronMenSel = new JMenuItem("Hebron");
	private JMenuItem nablusMenSel = new JMenuItem("Nablus");
	private JMenuItem salfMenSel = new JMenuItem("Salfeit");
	
	public void setTopPanel() {
		topPan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		topPan.add(labTitle, c);
		
		c.gridy = 1;
		topPan.add(btnViewMap, c);
	}
	public void setMiddlePanel() {
		midPan.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.ipadx = 25;
        labStartLoc.setAlignmentX(CENTER_ALIGNMENT);
        midPan.add(labStartLoc, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 25;
        c.anchor = GridBagConstraints.CENTER;
        midPan.add(startComboBox, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 25;
        c.anchor = GridBagConstraints.CENTER;
        labEndLoc.setAlignmentX(CENTER_ALIGNMENT);
        midPan.add(labEndLoc, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.35;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 25;
        midPan.add(endComboBox, c);
	}
    
    public Home() {
    	formatLabels();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setMiddlePanel();
        setTopPanel();
        botPan.setLayout(new GridLayout(4,1));
        botPan.add(btnIterativeDeepening);
        botPan.add(btnUniformCost);
        botPan.add(btnUniformCostAreal);
        botPan.add(btnOptimal1);
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .1;
        c.anchor = GridBagConstraints.NORTH;
        add(topPan, c);

        c.weightx = 1;
        c.weighty = .45;
        c.gridy = 1;
        add(midPan, c);
        
        c.weightx = 1;
        c.weighty = .45;
        c.gridy = 2;
        add(botPan, c);
        
        c.gridy = 3;
        add(resultsPan, c);
        
        btnIterativeDeepening.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				IterDeepPrep l = new IterDeepPrep(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString());
				l.runIterativeDeepening();
			}
        });
        
        btnUniformCost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UnifCost uc = new UnifCost(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString(), true);
			}
        });
        
        btnUniformCostAreal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UnifCost uc = new UnifCost(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString(), false);
			}
        });
        
        btnViewMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Driver.cl.show(Driver.cards, "map");
			}
        });
        
        

    }
    
    public void formatLabels() {
    	labTitle.setFont(new Font("Sanserif", Font.BOLD, 25));
    	labTitle.setHorizontalAlignment(JLabel.CENTER);

    }
    

}
