package com.bpo.cfp.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.accessibility.AccessibleContext;
import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JComponent;

import com.bpo.cfg.application.CFGApplication;
import com.bpo.cfg.constants.appConstants;
import com.bpo.cfg.enums.MSGBOX_IMAGE;
import com.bpo.cfg.enums.callLeagueConfigAction;
import com.bpo.cfg.utilities.Utility_Functions;
import com.bpo.cfp.entity.LeagueType;
import com.sun.xml.internal.ws.api.server.Container;

import java.awt.Insets;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;

import bpo.cfp.services.LeagueTypeServiceImpl;

@Component
public class panelNewLeague1 extends JPanel  implements ActionListener {
	
	@Autowired
	LeagueTypeServiceImpl leagueTypeService;
	
	private boolean bnewLeague;  
	private JLabel ltitle = new JLabel();
	private JPanel configfields = new JPanel();
	private JButton butSave = new JButton("Save");
	private JButton butCancel = new JButton("Cancel");
	private JPanel painOKCancel = new JPanel();
	
	private List<LeagueType> lTypes = null;
	
//General Setting Controls
	private JLabel lName = null;
	private customTextField txtName = null;
	private JLabel lLongName = null;
	private customTextField txtLongName = null;
	private JButton btnUploadImage = null;
	private JLabel lLeagueImage = null;
	private JLabel lCommissioner = null;
	private customTextField txtCommissionerName = null;
	private JLabel lEmail = null;
	private customTextField txtLeagueEmail = null;
	private JButton btnLeaguePassword = null;
	private JLabel lChampionshipGameName = null;
	private customTextField txtChampionshipGame = null;
	private JLabel lStartingYear = null;
	private customJComboBox comStartingYes = null;
	private JLabel lLeagueType = null;
	private JRadioButton localButton = null;
	private JRadioButton remoteButton = null;
	private ButtonGroup groupLeagueType = null;
	private JLabel lLeagueURL = null;
	private customTextField txtLeagueURL = null;
	private String LeaguePassword = null;
	
//Options Controls
	private JCheckBox cbPenalties = null;
	private JCheckBox cbInjuries = null;
	private JCheckBox cbNewXP = null;
	private JCheckBox cb2PointConv = null;
	private JCheckBox cbTrades = null;
	private JLabel lTradeDeadline = null;
	private customJComboBox comTradeDeadLine = null;
	
//League Structure
	private JLabel lLeagueFormat = null;
	private customJComboBox comLeagueFormat = null;
	private JLabel lConference1 = null;
	private JLabel lDivisions1 = null;
	private JLabel lConference2 = null;
	private JLabel lDivisions2 = null;
	private JTextField txtConference1 = new JTextField(20);
	private JTextField txtDivone1, txtDivone2, txtDivone3, txtDivone4, txtDivone5, txtDivone6, txtDivone7, txtDivone8, txtDivone9, txtDivone10 = new JTextField(20); 
	private JTextField txtConference2 = new JTextField(20);
	private JTextField txtDivtwo1, txtDivtwo2, txtDivtwo3, txtDivtwo4, txtDivtwo5, txtDivtwo6, txtDivtwo7, txtDivtwo8, txtDivtwo9, txtDivtwo10 = new JTextField(20); 
	private JButton btnRealignTeams = null;
	
	
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

		
//Gernal Settings	
		JPanel paneGen = new JPanel();

		TitledBorder bordGeneral = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(appConstants.MINIBORDERCOLOR), "General Settings");
		bordGeneral.setTitleColor(appConstants.MINIBORDERCOLOR);
		bordGeneral.setTitleFont(appConstants.PANETITLEFONT);
		paneGen.setBorder(bordGeneral);

		paneGen.setBackground(appConstants.MINIPANEBGCOLOR);
		paneGen.setLayout(new GridBagLayout());
		
		GridBagConstraints b = new GridBagConstraints();
		b.insets = new Insets(0, 5, 0, 0);

		b.anchor = GridBagConstraints.WEST;
		b.gridx  = 0;
		b.gridy = 0;

		lName = new JLabel("League Name:");
		lName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lName,b);

		b.gridx++;
		txtName = new customTextField(6, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
		txtName.setColumns(6);
		txtName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtName,b);
		b.gridx++;
		
		lLongName = new JLabel("Long Name:");
		lLongName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lLongName,b);

		b.gridx++;
		txtLongName = new customTextField(50, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
		txtLongName.setColumns(18);
		txtLongName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLongName,b);

		b.gridx++;
		btnUploadImage = new JButton("Upload Image");
		btnUploadImage.setBackground(appConstants.FORMBTNBACKGROUNDCOLOR);
		btnUploadImage.setForeground(appConstants.FORMBTNFOREGROUNDCOLOR);
		btnUploadImage.setFocusable(false);
		btnUploadImage.setPreferredSize(new Dimension(140,20));
		btnUploadImage.addActionListener(this);
		paneGen.add(btnUploadImage,b);

		b.gridx++;
		lLeagueImage = new JLabel();
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
		txtCommissionerName = new customTextField(50, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
		txtCommissionerName.setColumns(18);
		txtCommissionerName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtCommissionerName,b);

		b.gridx++;
		lEmail = new JLabel("League Email:");
		lEmail.setForeground(appConstants.MINILABELFG);
		paneGen.add(lEmail,b);

		b.gridx++;
		txtLeagueEmail = new customTextField(50, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
		txtLeagueEmail.setColumns(18);
		txtLeagueEmail.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLeagueEmail,b);
		
		b.gridx++;
		btnLeaguePassword = new JButton("League Password");
		btnLeaguePassword.setBackground(appConstants.FORMBTNBACKGROUNDCOLOR);
		btnLeaguePassword.setForeground(appConstants.FORMBTNFOREGROUNDCOLOR);
		btnLeaguePassword.setFocusable(false);
		btnLeaguePassword.setPreferredSize(new Dimension(140,20));
		btnLeaguePassword.addActionListener(this);
		paneGen.add(btnLeaguePassword,b);
		
		b.gridx++;
		paneGen.add(spacer2,b);
		
		b.gridy++;
		b.gridx =0;
		lChampionshipGameName = new JLabel("Chanpionship Game:");
		lChampionshipGameName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lChampionshipGameName,b);

		b.gridx++;
		txtChampionshipGame = new customTextField(50, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
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
		
		comStartingYes = new customJComboBox(sYears, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
		comStartingYes.setSelectedItem(Integer.toString(thisYear));
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
		txtLeagueURL = new customTextField(100, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
		txtLeagueURL.setColumns(31);
		txtLeagueURL.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLeagueURL,b);

		b.gridwidth = 1;
		b.gridx++;
		paneGen.add(spacer4,b);		
		
		panCenter.add(paneGen);
        
//Options panel
		JPanel paneOpt = new JPanel();
				
		TitledBorder bordOptions = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(appConstants.MINIBORDERCOLOR), "Options");
		bordOptions.setTitleColor(appConstants.MINIBORDERCOLOR);
		bordOptions.setTitleFont(appConstants.PANETITLEFONT);
		paneOpt.setBorder(bordOptions);
		
		paneOpt.setBackground(appConstants.MINIPANEBGCOLOR);
		paneOpt.setLayout(new GridBagLayout());
        
		GridBagConstraints bOpt = new GridBagConstraints();
		bOpt.insets = new Insets(0, 0, 0, 29);
        
		bOpt.anchor = GridBagConstraints.WEST;
		bOpt.gridx  = 0;
		bOpt.gridy = 0;
		cbPenalties = new JCheckBox("Penalties", true);
		cbPenalties.setForeground(appConstants.MINILABELFG);
		cbPenalties.setBackground(appConstants.MINIPANERADIOBGCOLOR);
		paneOpt.add(cbPenalties,bOpt);

		bOpt.gridx++;
		cbInjuries  = new JCheckBox("Injuries", true);
		cbInjuries .setForeground(appConstants.MINILABELFG);
		cbInjuries.setBackground(appConstants.MINIPANERADIOBGCOLOR);
		paneOpt.add(cbInjuries ,bOpt);        
		
		bOpt.gridx++;
		cbNewXP  = new JCheckBox("New Extra Point", false);
		cbNewXP .setForeground(appConstants.MINILABELFG);
		cbNewXP.setBackground(appConstants.MINIPANERADIOBGCOLOR);
		paneOpt.add(cbNewXP ,bOpt);  
        
		bOpt.gridx++;
		cb2PointConv  = new JCheckBox("Two Point Conversion", true);
		cb2PointConv .setForeground(appConstants.MINILABELFG);
		cb2PointConv.setBackground(appConstants.MINIPANERADIOBGCOLOR);
		paneOpt.add(cb2PointConv ,bOpt);        
		
		bOpt.gridx++;
		cbTrades  = new JCheckBox("Trades", true);
		cbTrades .setForeground(appConstants.MINILABELFG);
		cbTrades.setBackground(appConstants.MINIPANERADIOBGCOLOR);  
		cbTrades.addActionListener(this);
		paneOpt.add(cbTrades ,bOpt);
		
		JPanel tp = new JPanel(); 
		tp.setBackground(appConstants.MINIPANEBGCOLOR);
		lTradeDeadline = new JLabel("Trade Deadline Week:");
		lTradeDeadline.setForeground(appConstants.MINILABELFG);
		lTradeDeadline.setBackground(appConstants.MINIPANERADIOBGCOLOR);
		tp.add(lTradeDeadline);
		
		bOpt.gridx++;		
		String[] sWeeks = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
		comTradeDeadLine = new customJComboBox(sWeeks, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
		comTradeDeadLine.setSelectedItem(Integer.toString(thisYear));
		comTradeDeadLine.setForeground(appConstants.MINITXTFOREGROUND);
		tp.add(comTradeDeadLine);		
		paneOpt.add(tp,bOpt);
        
		painOKCancel.setLayout(new FlowLayout());
		painOKCancel.add(butCancel);
		painOKCancel.add(butSave);
		painOKCancel.setBackground(new Color(appConstants.MBACKGROUNDRED, appConstants.MBACKGROUNDGREEN, appConstants.MBACKGROUNDBLUE));
		add(painOKCancel, BorderLayout.SOUTH);
		
		panCenter.add(paneOpt);

//League Structure		
		JPanel paneStruct = new JPanel();
		
		TitledBorder bordStructure = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(appConstants.MINIBORDERCOLOR), "League Structure");
		bordStructure.setTitleColor(appConstants.MINIBORDERCOLOR);
		bordStructure.setTitleFont(appConstants.PANETITLEFONT);
		paneStruct.setBorder(bordStructure);
		
		paneStruct.setBackground(appConstants.MINIPANEBGCOLOR);
		paneStruct.setLayout(new GridBagLayout());
		
		GridBagConstraints bStruct = new GridBagConstraints();
		bStruct.insets = new Insets(0, 0, 0, 29);
        
		bStruct.anchor = GridBagConstraints.WEST;
		bStruct.gridx  = 0;
		bStruct.gridy = 0;
//		bStruct.gridwidth = 130;
	    JPanel pstruct1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    pstruct1.setBackground(appConstants.MINIPANEBGCOLOR);
	    lLeagueFormat = new JLabel("League Format:");
	    lLeagueFormat.setForeground(appConstants.MINILABELFG);
	    
//Get all League format types
	    try {
	    	lTypes = leagueTypeService.getLeagueTypes();	
	    	if (lTypes.size() == 0)
	    		throw new Exception("0 League Format Types Returned from DB!");
	    } 
	    catch (Exception e) {
			cfpJFrame cfgf = (cfpJFrame)SwingUtilities.getAncestorOfClass(cfpJFrame.class, this);
	    	String err = "Error Getting League Format Types.   Error: " + e.getMessage();
			customerMSQBox cm = new customerMSQBox(cfgf, err, cApp, MSGBOX_IMAGE.ERROR);
			cm.setVisible(true);
	    }
	    
	    int i = 0;
	    String[] formats = new String[lTypes.size()];
	    for (LeagueType lt : lTypes)
	    	formats[i++] = lt.getName();
	    
		comLeagueFormat = new customJComboBox(formats, appConstants.MINITXTBACKGROUND, appConstants.DISABLEDINPUT);
//		comLeagueFormat.setSelectedItem(Integer.toString(thisYear));
		comLeagueFormat.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct1.add(lLeagueFormat);
	    pstruct1.add(comLeagueFormat);
	    paneStruct.add(pstruct1,bStruct);
		
		bStruct.gridx  = 0;
		bStruct.gridy = 1;
//		bStruct.gridwidth = 130;
	    JPanel pstruct2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    pstruct2.setBackground(appConstants.MINIPANEBGCOLOR);
	    lConference1 = new JLabel("Conference 1:");
	    lConference1.setForeground(appConstants.MINILABELFG);		
	    pstruct2.add(lConference1);
	    txtConference1.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtConference1);
	    lDivisions1 = new JLabel("Division(s):");
	    lDivisions1.setForeground(appConstants.MINILABELFG);		
	    pstruct2.add(lDivisions1);	   
	    
	    txtDivone1.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone1);
	    pstruct2.add(txtDivone1);	
	    pstruct2.add(txtDivone1);
	    txtDivone2.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone2);
	    pstruct2.add(txtDivone2);	    
	    pstruct2.add(txtDivone2);
	    txtDivone3.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone3);
	    pstruct2.add(txtDivone3);
	    pstruct2.add(txtDivone3);
	    txtDivone4.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone4);
	    pstruct2.add(txtDivone4);
	    pstruct2.add(txtDivone4);
	    txtDivone5.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone5);
	    pstruct2.add(txtDivone5);
	    pstruct2.add(txtDivone6);
	    txtDivone6.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone6);
	    pstruct2.add(txtDivone6);
	    pstruct2.add(txtDivone6);
	    txtDivone7.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone7);
	    pstruct2.add(txtDivone7);
	    pstruct2.add(txtDivone7);
	    txtDivone8.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone8);
	    pstruct2.add(txtDivone8);
	    pstruct2.add(txtDivone8);
	    txtDivone9.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone9);
	    pstruct2.add(txtDivone9);
	    pstruct2.add(txtDivone9);
	    txtDivone10.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct2.add(txtDivone10);
	    pstruct2.add(txtDivone10);
	    pstruct2.add(txtDivone10);
	    paneStruct.add(pstruct2,bStruct);    
	    
	    bStruct.gridx  = 0;
	    bStruct.gridy = 2;
	    JPanel pstruct3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    pstruct3.setBackground(appConstants.MINIPANEBGCOLOR);
	    lConference2 = new JLabel("Conference 2:");
	    lConference2.setForeground(appConstants.MINILABELFG);		
	    pstruct3.add(lConference2);
	    txtConference2.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtConference2);
	    lDivisions2 = new JLabel("Division(s):");
	    lDivisions2.setForeground(appConstants.MINILABELFG);		
	    pstruct3.add(lDivisions2);	   
	    
	    txtDivone2.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone2);
	    pstruct3.add(txtDivone2);	
	    pstruct3.add(txtDivone2);
	    txtDivone2.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone2);
	    pstruct3.add(txtDivone2);	    
	    pstruct3.add(txtDivone2);
	    txtDivone3.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone3);
	    pstruct3.add(txtDivone3);
	    pstruct3.add(txtDivone3);
	    txtDivone4.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone4);
	    pstruct3.add(txtDivone4);
	    pstruct3.add(txtDivone4);
	    txtDivone5.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone5);
	    pstruct3.add(txtDivone5);
	    pstruct3.add(txtDivone6);
	    txtDivone6.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone6);
	    pstruct3.add(txtDivone6);
	    pstruct3.add(txtDivone6);
	    txtDivone7.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone7);
	    pstruct3.add(txtDivone7);
	    pstruct3.add(txtDivone7);
	    txtDivone8.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone8);
	    pstruct3.add(txtDivone8);
	    pstruct3.add(txtDivone8);
	    txtDivone9.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone9);
	    pstruct3.add(txtDivone9);
	    pstruct3.add(txtDivone9);
	    txtDivone10.setForeground(appConstants.MINITXTFOREGROUND);
	    pstruct3.add(txtDivone10);
	    pstruct3.add(txtDivone10);
	    pstruct3.add(txtDivone10);
	    paneStruct.add(pstruct3,bStruct); 
	    
		bStruct.gridx  = 0;
		bStruct.gridy = 3;
		btnRealignTeams = new JButton("Realign Teams");
		btnRealignTeams.setBackground(appConstants.FORMBTNBACKGROUNDCOLOR);
		btnRealignTeams.setForeground(appConstants.FORMBTNFOREGROUNDCOLOR);
		btnRealignTeams.setFocusable(false);
		btnRealignTeams.setPreferredSize(new Dimension(140,20));
		btnRealignTeams.addActionListener(this);
		paneGen.add(btnRealignTeams,bStruct);
	    
        add(panCenter,  BorderLayout.CENTER);
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
			if (!localButton.getModel().isSelected())
			txtLeagueURL.setText("");
			txtLeagueURL.setEnabled(false);
		} else if (arg0.getSource() == remoteButton) {
			txtLeagueURL.setEnabled(true);
		}

//Enable or Disable Trades		
		if (arg0.getSource() == cbTrades)  {
			if (!cbTrades.getModel().isSelected()) {
			comTradeDeadLine.setSelectedIndex(-1);
			comTradeDeadLine.setEnabled(false);
		} else 
			comTradeDeadLine.setEnabled(true);
		}
		
		if (arg0.getSource() == btnLeaguePassword) {
			cfpJFrame cfgf = (cfpJFrame)SwingUtilities.getAncestorOfClass(cfpJFrame.class, panelNewLeague1.this);
			customPasswordDialog custpw = new customPasswordDialog(cfgf, btnLeaguePassword.getX(), btnLeaguePassword.getY());
			custpw.setVisible(true);
			if (custpw.getErrormsg() == null || custpw.getPassword() != null)
				LeaguePassword = custpw.getPassword();
			
		}		
//Upload league image		
		if (arg0.getSource() == btnUploadImage) {
			cfpJFrame cfgf = (cfpJFrame)SwingUtilities.getAncestorOfClass(cfpJFrame.class, panelNewLeague1.this);
			ArrayList<String> fe = new ArrayList();
			fe.add(".png");
			fe.add(".bnp");
			fe.add(".jpeg");
			fe.add(".jpg");
			fe.add(".gif");
			customFileChooser chooser = new customFileChooser(cfgf, btnUploadImage.getX(), btnUploadImage.getY(), false,"Upload League Image", cApp.getAi().getImgFolder(),fe);
			chooser.setVisible(true);
			String f = chooser.getsFile();
			
			f = f.replaceFirst("/", "//");
			
			if (!f.equals(""))
			{
				String err = Utility_Functions.validateImageFile(f, 1048576L);  //1 meg max league image size
				if (err == null) {
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(f).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
					lLeagueImage.setIcon(imageIcon);
				}
				else {
					customerMSQBox cm = new customerMSQBox(cfgf, err, cApp, MSGBOX_IMAGE.ERROR);
					cm.setVisible(true);
					//					JOptionPane.showMessageDialog(cfgf,err,"Error Uploading Image",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			



		}
		
		
		
		
	}

	

}
