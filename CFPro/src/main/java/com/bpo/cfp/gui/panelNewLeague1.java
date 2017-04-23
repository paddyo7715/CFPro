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
import java.util.Date;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.bpo.cfg.application.CFGApplication;
import com.bpo.cfg.constants.appConstants;
import com.bpo.cfg.enums.callLeagueConfigAction;

import java.awt.Insets;

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
	
//General Setting Controls
	private JLabel lName = null;
	private JTextFieldLimit txtName = null;
	private JLabel lLongName = null;
	private JTextFieldLimit txtLongName = null;
	private JButton btnUploadImage = null;
	private JLabel lLeagueImage = null;
	private JLabel lCommissioner = null;
	private JTextFieldLimit txtCommissionerName = null;
	private JLabel lEmail = null;
	private JTextFieldLimit txtLeagueEmail = null;
	private JButton btnLeaguePassword = null;
	private JLabel lChampionshipGameName = null;
	private JTextFieldLimit txtChampionshipGame = null;
	private JLabel lStartingYear = null;
	private JComboBox comStartingYes = null;
	private JLabel lLeagueType = null;
	private JRadioButton localButton = null;
	private JRadioButton remoteButton = null;
	private ButtonGroup groupLeagueType = null;
	private JLabel lLeagueURL = null;
	private JTextFieldLimit txtLeagueURL = null;

	
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
		
		JPanel panCenter = new JPanel();
		panCenter.setBackground(appConstants.MAINBGCOLOR);
	
		JPanel paneGen = new JPanel();
		paneGen.setLayout(new GridBagLayout());
		
		JLabel spacer1 = new JLabel("");
		spacer1.setForeground(appConstants.MINILABELFG);
		spacer1.setPreferredSize(new Dimension(1,appConstants.ROWHIGHTSPACER));

		JLabel spacer2 = new JLabel("");
		spacer2.setForeground(appConstants.MINILABELFG);
		spacer2.setPreferredSize(new Dimension(1,appConstants.ROWHIGHTSPACER));

		JLabel spacer3 = new JLabel("");
		spacer3.setForeground(appConstants.MINILABELFG);
		spacer3.setPreferredSize(new Dimension(1,appConstants.ROWHIGHTSPACER));

		JLabel spacer4 = new JLabel("");
		spacer4.setForeground(appConstants.MINILABELFG);
		spacer4.setPreferredSize(new Dimension(1,appConstants.ROWHIGHTSPACER));
		
		GridBagConstraints b = new GridBagConstraints();
		b.insets = new Insets(0, 5, 0, 0);

		b.anchor = GridBagConstraints.WEST;
		b.gridx  = 0;
		b.gridy = 0;
		
		TitledBorder bordGeneral = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(appConstants.MINIBORDERCOLOR), "General Settings");
		bordGeneral.setTitleColor(appConstants.MINIBORDERCOLOR);
		bordGeneral.setTitleFont(appConstants.PANETITLEFONT);
		paneGen.setBorder(bordGeneral);

		paneGen.setBackground(appConstants.MINIPANEBGCOLOR);

		lName = new JLabel("League Name:");
		lName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lName,b);

		b.gridx++;
		txtName = new JTextFieldLimit(6);
		txtName.setColumns(6);
		txtName.setBackground(appConstants.MINITXTBACKGROUND);
		txtName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtName,b);
		b.gridx++;
		
		lLongName = new JLabel("Long Name:");
		lLongName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lLongName,b);

		b.gridx++;
		txtLongName = new JTextFieldLimit(50);
		txtLongName.setColumns(18);
		txtLongName.setBackground(appConstants.MINITXTBACKGROUND);
		txtLongName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLongName,b);

		b.gridx++;
		btnUploadImage = new JButton("Upload Image");
		btnUploadImage.setBackground(appConstants.FORMBTNBACKGROUNDCOLOR);
		btnUploadImage.setForeground(appConstants.FORMBTNFOREGROUNDCOLOR);
		btnUploadImage.setFocusable(false);
		btnUploadImage.setPreferredSize(new Dimension(140,20));
		paneGen.add(btnUploadImage,b);

		b.gridx++;
		JLabel lLeagueImage = new JLabel();
		lLeagueImage.setPreferredSize(new Dimension(50, 25));
		paneGen.add(lLeagueImage,b);

		b.gridx++;
		paneGen.add(spacer1,b);
		
		b.gridy++;
		b.gridx =0;
		lCommissioner = new JLabel("Commishener:");
		lCommissioner.setForeground(appConstants.MINILABELFG);
		paneGen.add(lCommissioner,b);

		b.gridx++;
		txtCommissionerName = new JTextFieldLimit(50);
		txtCommissionerName.setColumns(18);
		txtCommissionerName.setBackground(appConstants.MINITXTBACKGROUND);
		txtCommissionerName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtCommissionerName,b);

		b.gridx++;
		lEmail = new JLabel("League Email:");
		lEmail.setForeground(appConstants.MINILABELFG);
		paneGen.add(lEmail,b);

		b.gridx++;
		txtLeagueEmail = new JTextFieldLimit(50);
		txtLeagueEmail.setColumns(18);
		txtLeagueEmail.setBackground(appConstants.MINITXTBACKGROUND);
		txtLeagueEmail.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLeagueEmail,b);
		
		b.gridx++;
		btnLeaguePassword = new JButton("League Password");
		btnLeaguePassword.setBackground(appConstants.FORMBTNBACKGROUNDCOLOR);
		btnLeaguePassword.setForeground(appConstants.FORMBTNFOREGROUNDCOLOR);
		btnLeaguePassword.setFocusable(false);
		btnLeaguePassword.setPreferredSize(new Dimension(140,20));
		paneGen.add(btnLeaguePassword,b);
		
		b.gridx++;
		paneGen.add(spacer2,b);
		
		b.gridy++;
		b.gridx =0;
		lChampionshipGameName = new JLabel("Chanpionship Game:");
		lChampionshipGameName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lChampionshipGameName,b);

		b.gridx++;
		txtChampionshipGame = new JTextFieldLimit(50);
		txtChampionshipGame.setColumns(18);
		txtChampionshipGame.setBackground(appConstants.MINITXTBACKGROUND);
		txtChampionshipGame.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtChampionshipGame,b);

		b.gridx++;
		lStartingYear = new JLabel("Starting Year:");
		lStartingYear.setForeground(appConstants.MINILABELFG);
		paneGen.add(lStartingYear,b);
		
		b.gridx++;			
		@SuppressWarnings("deprecation")
		int thisYear = new Date().getYear() + 1900;
		String[] sYears = new String[thisYear + appConstants.YEARSINTHEFUTURESTARTINGYEAR - appConstants.EARLIESTSTARTINGYEAR];
		for (int i= 0; i < sYears.length; i++) {
			sYears[i] = Integer.toString(i +  appConstants.EARLIESTSTARTINGYEAR);
		}
		
		comStartingYes = new JComboBox(sYears);
		comStartingYes.setSelectedItem(Integer.toString(thisYear));
	
		comStartingYes.setBackground(appConstants.MINITXTBACKGROUND);
		comStartingYes.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(comStartingYes,b);
		
		b.gridx++;
		paneGen.add(spacer3,b);
		
		b.gridx =0;
		b.gridy++;		
		lLeagueType = new JLabel("League Type:");
		lLeagueType.setForeground(appConstants.MINILABELFG);
		paneGen.add(lLeagueType,b);
		
		b.gridx++;
		//Create the radio buttons.
	    localButton = new JRadioButton("Local");
	    localButton.setSelected(true);
	    localButton.setFocusable(false);
	    localButton.addActionListener(this);
	    localButton.setForeground(appConstants.MINIPANERADIOFGCOLOR);
	    localButton.setBackground(appConstants.MINIPANERADIOBGCOLOR);

	    remoteButton = new JRadioButton("Remote");
	    remoteButton.setFocusable(false);
	    remoteButton.addActionListener(this);
	    remoteButton.setForeground(appConstants.MINIPANERADIOFGCOLOR);
	    remoteButton.setBackground(appConstants.MINIPANERADIOBGCOLOR);
	    
	    //Group the radio buttons.
	    groupLeagueType = new ButtonGroup();
	    groupLeagueType.add(localButton);
	    groupLeagueType.add(remoteButton);
	   
	    JPanel pr1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    pr1.setBackground(appConstants.MINIPANEBGCOLOR);
	    pr1.add(localButton);
	    pr1.add(remoteButton);
		paneGen.add(pr1,b);
		
		b.gridx++;
		
		lLeagueURL = new JLabel("League URL:");
		lLeagueURL.setForeground(appConstants.MINILABELFG);
		paneGen.add(lLeagueURL,b);

		b.gridx++;
		b.gridwidth = 2;
		txtLeagueURL = new JTextFieldLimit(100);
		txtLeagueURL.setColumns(31);
		txtLeagueURL.setBackground(appConstants.MINITXTBACKGROUND);
		txtLeagueURL.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLeagueURL,b);

		b.gridwidth = 1;
		b.gridx++;
		paneGen.add(spacer4,b);		
		
		panCenter.add(paneGen);
		
        add(panCenter,  BorderLayout.CENTER);
        
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

//If Save or Cancel buttons are clicked		
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
		
//General Settings Pane event listeners
		if (arg0.getSource() == localButton) {
			txtLeagueURL.setText("");
			txtLeagueURL.setEnabled(false);
			txtLeagueURL.setBackground(appConstants.DISABLEDINPUT);
		} else if (arg0.getSource() == remoteButton) {
			txtLeagueURL.setEnabled(true);
			txtLeagueURL.setBackground(appConstants.MINITXTBACKGROUND);
		}
		
		
		
		
		
	}

	

}
