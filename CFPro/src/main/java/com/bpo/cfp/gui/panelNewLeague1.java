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
		
		JPanel panCenter = new JPanel();
		panCenter.setBackground(appConstants.MAINBGCOLOR);
		
		JPanel paneGen = new JPanel();
		paneGen.setLayout(new BoxLayout(paneGen,BoxLayout.Y_AXIS));
		
		JPanel pGen1 = new JPanel();
		JPanel pGen2 = new JPanel();
		JPanel pGen3 = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);

		pGen1.setLayout(fl);
		pGen2.setLayout(fl);
		pGen3.setLayout(fl);
		
		TitledBorder bordGeneral = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(appConstants.MINIBORDERCOLOR), "General");
		bordGeneral.setTitleColor(appConstants.MINIBORDERCOLOR);
		paneGen.setBorder(bordGeneral);

		pGen1.setBackground(appConstants.MINIPANEBGCOLOR);		
		pGen2.setBackground(appConstants.MINIPANEBGCOLOR);
		pGen3.setBackground(appConstants.MINIPANEBGCOLOR);
		paneGen.setBackground(appConstants.MINIPANEBGCOLOR);

		JLabel lName = new JLabel("League Name:");
		lName.setForeground(appConstants.MINILABELFG);
		pGen1.add(lName);

		JTextFieldLimit txtName = new JTextFieldLimit(6);
		txtName.setColumns(6);
		txtName.setBackground(appConstants.MINITXTBACKGROUND);
		txtName.setForeground(appConstants.MINITXTFOREGROUND);
		pGen1.add(txtName);

		JLabel lLongName = new JLabel("Long Name:");
		lLongName.setForeground(appConstants.MINILABELFG);
		pGen1.add(lLongName);

		JTextFieldLimit txtLongName = new JTextFieldLimit(50);
		txtLongName.setColumns(30);
		txtLongName.setBackground(appConstants.MINITXTBACKGROUND);
		txtLongName.setForeground(appConstants.MINITXTFOREGROUND);
		pGen1.add(txtLongName);

		final JButton btnUploadImage = new JButton("League Image");
		pGen1.add(btnUploadImage);

		JLabel lLeagueImage = new JLabel();
		lLeagueImage.setPreferredSize(new Dimension(30, 40));
		pGen1.add(lLeagueImage);
		
		JLabel lCommissioner = new JLabel("Commishener Name:");
		lCommissioner.setForeground(appConstants.MINILABELFG);
		pGen2.add(lCommissioner);

		JTextFieldLimit txtCommissionerName = new JTextFieldLimit(50);
		txtCommissionerName.setColumns(30);
		txtCommissionerName.setBackground(appConstants.MINITXTBACKGROUND);
		txtCommissionerName.setForeground(appConstants.MINITXTFOREGROUND);
		pGen2.add(txtCommissionerName);

		JLabel lEmail = new JLabel("League Email:");
		lEmail.setForeground(appConstants.MINILABELFG);
		pGen2.add(lEmail);

		JTextFieldLimit txtLeagueEmail = new JTextFieldLimit(50);
		txtLeagueEmail.setColumns(20);
		txtLeagueEmail.setBackground(appConstants.MINITXTBACKGROUND);
		txtLeagueEmail.setForeground(appConstants.MINITXTFOREGROUND);
		pGen2.add(txtLeagueEmail);
		
		JLabel lChampionshipGameName = new JLabel("Chanpionship Game Name:");
		lChampionshipGameName.setForeground(appConstants.MINILABELFG);
		pGen3.add(lChampionshipGameName);

		JTextFieldLimit txtChampionshipGame = new JTextFieldLimit(50);
		txtChampionshipGame.setColumns(30);
		txtChampionshipGame.setBackground(appConstants.MINITXTBACKGROUND);
		txtChampionshipGame.setForeground(appConstants.MINITXTFOREGROUND);
		pGen3.add(txtChampionshipGame);

		//Create the radio buttons.
	    JRadioButton localButton = new JRadioButton("Local");
	    localButton.setSelected(true);
	    localButton.setForeground(appConstants.MINIPANERADIOFGCOLOR);
	    localButton.setBackground(appConstants.MINIPANERADIOBGCOLOR);

	    JRadioButton remoteButton = new JRadioButton("Remote");
	    remoteButton.setForeground(appConstants.MINIPANERADIOFGCOLOR);
	    remoteButton.setBackground(appConstants.MINIPANERADIOBGCOLOR);
	    
	    //Group the radio buttons.
	    ButtonGroup groupLeagueType = new ButtonGroup();
	    groupLeagueType.add(localButton);
	    groupLeagueType.add(remoteButton);

		pGen3.add(localButton);
		pGen3.add(remoteButton);

		paneGen.add(pGen1);
		paneGen.add(pGen2);
		paneGen.add(pGen3);
		
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
