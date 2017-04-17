package com.bpo.cfp.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.bpo.cfg.application.CFGApplication;
import com.bpo.cfg.constants.appConstants;
import com.bpo.cfg.enums.callLeagueConfigAction;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class panelNewLeague1 extends JPanel  implements ActionListener {
	
	private boolean bnewLeague;  
	private JLabel ltitle = new JLabel();
	private JPanel configfields = new JPanel();
	private JButton butSave = new JButton("Save");
	private JButton butCancel = new JButton("Cancel");
	private JPanel painOKCancel = new JPanel();
	
	
	@Autowired
	private CFGApplication cApp;
	
	public panelNewLeague1()
	{
		super();
	
	}
	@PostConstruct
	public void postConstruct()
	{
		
		setLayout(new BorderLayout());
		setForeground(Color.GRAY);
		setBackground(new Color(appConstants.MBACKGROUNDRED, appConstants.MBACKGROUNDGREEN, appConstants.MBACKGROUNDBLUE));

		
		ltitle.setFont(appConstants.formTitleFont);
		ltitle.setForeground(appConstants.MFORGROUNDCOLOR);
		ltitle.setHorizontalAlignment(SwingConstants.CENTER);


		butCancel.setPreferredSize(new Dimension(appConstants.NORMALBTNWIDTH, appConstants.NORMALBTNHEIGHT));
		butCancel.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
		butCancel.setBackground(appConstants.NORMALBTNBACKGROUNDCOLOR);
		butCancel.setFocusable(false);
		butCancel.addActionListener(this);
		
		butSave.setPreferredSize(new Dimension(appConstants.NORMALBTNWIDTH, appConstants.NORMALBTNHEIGHT));
		butSave.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
		butSave.setBackground(appConstants.NORMALBTNBACKGROUNDCOLOR);
		butSave.setFocusable(false);
		butSave.addActionListener(this);
		
		add(ltitle, BorderLayout.NORTH);
		painOKCancel.setLayout(new FlowLayout());
		painOKCancel.add(butCancel);
		painOKCancel.add(butSave);
		painOKCancel.setBackground(new Color(appConstants.MBACKGROUNDRED, appConstants.MBACKGROUNDGREEN, appConstants.MBACKGROUNDBLUE));
		add(painOKCancel, BorderLayout.SOUTH);
		
		
	}
//This method decides if this is a configuration for a new league or an existing league and sets the availability
//of the various input fields
	void newLeague(boolean bnewLeague)
	{
		this.bnewLeague = bnewLeague;
		if (bnewLeague)
		{
			ltitle.setText("Create New League");
			//clear out all of the fields
		}
		else
		{
			ltitle.setText("Change League Settings");
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == butCancel)
		{
			cfpJFrame cfgf = (cfpJFrame)SwingUtilities.getAncestorOfClass(cfpJFrame.class, this);
			CardLayout cardLayout = (CardLayout) cfgf.cards.getLayout();
			if (bnewLeague)
				cardLayout.show(cfgf.cards, "main Menu");			
		} else 	if (arg0.getSource() == butSave)
		{
			cfpJFrame cfgf = (cfpJFrame)SwingUtilities.getAncestorOfClass(cfpJFrame.class, this);
			CardLayout cardLayout = (CardLayout) cfgf.cards.getLayout();
			if (bnewLeague)
			{
//create league file				
				cardLayout.show(cfgf.cards, "main Menu");		
			}
		}
		
		
	}

	

}
