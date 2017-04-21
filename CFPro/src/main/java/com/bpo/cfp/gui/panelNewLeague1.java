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
		paneGen.setLayout(new GridBagLayout());
		
		GridBagConstraints b = new GridBagConstraints();
		b.anchor = GridBagConstraints.WEST;
		b.gridx  = 0;
		b.gridy = 0;
		
		TitledBorder bordGeneral = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(appConstants.MINIBORDERCOLOR), "General");
		bordGeneral.setTitleColor(appConstants.MINIBORDERCOLOR);
		paneGen.setBorder(bordGeneral);

		paneGen.setBackground(appConstants.MINIPANEBGCOLOR);

		JLabel lName = new JLabel("League Name:");
		lName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lName,b);

		b.gridx++;
		JTextFieldLimit txtName = new JTextFieldLimit(6);
		txtName.setColumns(6);
		txtName.setBackground(appConstants.MINITXTBACKGROUND);
		txtName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtName,b);
		b.gridx++;
		
		JLabel lLongName = new JLabel("Long Name:");
		lLongName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lLongName,b);

		b.gridx++;
		JTextFieldLimit txtLongName = new JTextFieldLimit(50);
		txtLongName.setColumns(18);
		txtLongName.setBackground(appConstants.MINITXTBACKGROUND);
		txtLongName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLongName,b);

		b.gridx++;
		final JButton btnUploadImage = new JButton("Upload Image");
		btnUploadImage.setBackground(appConstants.FORMBTNBACKGROUNDCOLOR);
		btnUploadImage.setForeground(appConstants.FORMBTNFOREGROUNDCOLOR);
		btnUploadImage.setFocusable(false);
		btnUploadImage.setPreferredSize(new Dimension(120,20));
		paneGen.add(btnUploadImage,b);

		b.gridx++;
		JLabel lLeagueImage = new JLabel();
		lLeagueImage.setPreferredSize(new Dimension(30, 25));
		paneGen.add(lLeagueImage,b);
		
		b.gridy++;
		b.gridx =0;
		JLabel lCommissioner = new JLabel("Commishener:");
		lCommissioner.setForeground(appConstants.MINILABELFG);
		paneGen.add(lCommissioner,b);

		b.gridx++;
		JTextFieldLimit txtCommissionerName = new JTextFieldLimit(50);
		txtCommissionerName.setColumns(18);
		txtCommissionerName.setBackground(appConstants.MINITXTBACKGROUND);
		txtCommissionerName.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtCommissionerName,b);

		b.gridx++;
		JLabel lEmail = new JLabel("League Email:");
		lEmail.setForeground(appConstants.MINILABELFG);
		paneGen.add(lEmail,b);

		b.gridx++;
		JTextFieldLimit txtLeagueEmail = new JTextFieldLimit(50);
		txtLeagueEmail.setColumns(18);
		txtLeagueEmail.setBackground(appConstants.MINITXTBACKGROUND);
		txtLeagueEmail.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtLeagueEmail,b);
		
		b.gridy++;
		b.gridx =0;
		JLabel lChampionshipGameName = new JLabel("Chanpionship Game:");
		lChampionshipGameName.setForeground(appConstants.MINILABELFG);
		paneGen.add(lChampionshipGameName,b);

		b.gridx++;
		JTextFieldLimit txtChampionshipGame = new JTextFieldLimit(50);
		txtChampionshipGame.setColumns(18);
		txtChampionshipGame.setBackground(appConstants.MINITXTBACKGROUND);
		txtChampionshipGame.setForeground(appConstants.MINITXTFOREGROUND);
		paneGen.add(txtChampionshipGame,b);

		b.gridx++;
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

	    paneGen.add(localButton,b);
		b.gridx++;
	    paneGen.add(remoteButton,b);

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
