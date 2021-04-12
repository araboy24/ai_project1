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
import ai_project1.LinkedListPractice;

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
//	private JLabel ins = new JLabel("<html>Create an Account to Get Started<br>Or Login if you're already registered</html>");
	private JLabel labStartLoc = new JLabel("Select a Start Location");
	private JLabel labEndLoc = new JLabel("Select an End Location");
    
//    private JButton btnHome = new JButton("Home");
//    private JButton btnAddMeal = new JButton("Add Meal");
//    private JButton btnAddUser = new JButton("Create Account");
//    private JButton btnViewMeals = new JButton("View Meals");
//    private JButton btnLogin = new JButton("Login");
	
	private JButton btnIterativeDeepening = new JButton("Run Iterative Deepening");
	private JButton btnUniformCost = new JButton("Run Uniform Cost");
	private JButton btnAlgorithm2 = new JButton("Run Algorithm 2");
	private JButton btnViewMap = new JButton("View Map");
	
//	private JMenu startMenu = new JMenu("Start Location");
//	private JMenu endMenu = new JMenu("End Location");
	
	
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
//		c.weightx = .8;
		c.gridy = 0;
		topPan.add(labTitle, c);
		
//		c.weightx = .2;
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
        
//        midPan.setLayout(new GridBagLayout());
//        GridBagConstraints d = new GridBagConstraints();
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
//    	setBackground(Color.white);
//    	for(int i = 0; i < cities.length; i++) {
//    		cities[i] = LinkedListPractice.getCities()[i].getCity();
//    	}
    	formatLabels();
//        GridLayout layout = new GridLayout(3, 1, 0, 10);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
//        topPan.add(labTitle);
        setMiddlePanel();
        setTopPanel();
//        attachMenuItems();
//        mlPan.setLayout(new GridLayout(2, 1));
//        mrPan.setLayout(new GridLayout(2, 1));
//        mrPan.add(labEndLoc);
//        mrPan.add(endComboBox);
//        mlPan.add(labStartLoc);
//        mlPan.add(startComboBox);
//        midPan.setLayout(new GridLayout(1, 3, 0,0));
//        midPan.add(mlPan);
//        midPan.add(new JPanel());
//        midPan.add(mrPan);
//        midPan.add(endComboBox);
        botPan.setLayout(new GridLayout(3,1));
        botPan.add(btnIterativeDeepening);
        botPan.add(btnUniformCost);
        botPan.add(btnAlgorithm2);
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .1;
        c.anchor = GridBagConstraints.NORTH;
//        add(labTitle, c);
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
        
//        botPan.add(btnViewMap);
//        add(ins);
        //add(btnHome);
     //   add(btnAddMeal);
//        add(btnAddUser);
       // add(btnViewMeals);
//        add(btnLogin);
        
        
        btnIterativeDeepening.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
//				main.cl.show(main.cards, "add meal");
				LinkedListPractice l = new LinkedListPractice(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString());
			}
        });
        
        btnUniformCost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
//				Driver.cl.show(Driver.cards, "map");
//				LinkedListPractice l = new LinkedListPractice(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString());
			}
        });
        
        btnViewMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Driver.cl.show(Driver.cards, "map");
//				LinkedListPractice l = new LinkedListPractice(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString());
			}
        });
        
        
//        btnAddMeal.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
////				main.cl.show(main.cards, "add meal");				
//			}
//        });
//        
//        btnAddUser.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
////				main.cl.show(main.cards, "add user");				
//			}
//        });
//        
//        btnViewMeals.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
////				ViewMeals.updateTotals();
////				main.cl.show(main.cards, "view meals");	
//				
//			}
//        });
//        
//        btnLogin.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
////				main.cl.show(main.cards, "login");				
//			}
//        });
    }
    
    public void formatLabels() {
    	labTitle.setFont(new Font("Sanserif", Font.BOLD, 25));
    	labTitle.setHorizontalAlignment(JLabel.CENTER);
//    	ins.setFont(new Font("Sanserif", Font.PLAIN, 15));
//    	ins.setHorizontalAlignment(JLabel.CENTER);
    }
    
//    public void attachMenuItems() {
//    	startMenu.add(jeninMenSel);
//    	endMenu.add(jeninMenSel);
//    	
//    	startMenu.add(ramallahMenSel);
//    	endMenu.add(ramallahMenSel);
//
//    	startMenu.add(qalqMenSel);
//    	endMenu.add(qalqMenSel);
//
//    	startMenu.add(salfMenSel);
//    	endMenu.add(salfMenSel);
//
//    	startMenu.add(jerusalemMenSel);
//    	endMenu.add(jerusalemMenSel);
//
//    	startMenu.add(bethMenSel);
//    	endMenu.add(bethMenSel);
//
//    	startMenu.add(hebronMenSel);
//    	endMenu.add(hebronMenSel);
//
//    	startMenu.add(jerichoMenSel);
//    	endMenu.add(jerichoMenSel);
//
//    	startMenu.add(nablusMenSel);
//    	endMenu.add(nablusMenSel);
//    	
//    	startMenu.add(tubasMenSel);
//    	endMenu.add(tubasMenSel);
//    	
//    }
}
