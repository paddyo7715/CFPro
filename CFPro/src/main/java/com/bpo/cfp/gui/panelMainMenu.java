package com.bpo.cfp.gui;

import java.awt.BorderLayout;
import com.bpo.cfg.enums.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.bpo.cfg.application.CFGApplication;
import com.bpo.cfg.constants.appConstants;
import com.bpo.cfg.utilities.SoundPlayer;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class panelMainMenu extends JPanel implements ActionListener,  MouseListener
{
	private JLabel lblHeader;
	private JLabel imgMonBase;
	private ImageIcon imgMain;
	private ImageIcon imgMonitorBase;
	private JLabel lblHeaderImage;
	private JLabel lblMiniTitle;
	private JButton btnMMNewButton;
	private JButton btnMMExitButton;
	private JButton btnMMLoadButton;
	private JButton btnMMremotegameButton;
	private JButton btnMMRemoteLeaguesButton;
	
	@Autowired
	private CFGApplication cApp;
	

	public panelMainMenu()
	{
		super();
  
	}
	@PostConstruct
	public void postConstruct()
	{
		setLayout(new GridBagLayout());
		
		setForeground(Color.GRAY);
		setBackground(new Color(appConstants.MBACKGROUNDRED, appConstants.MBACKGROUNDGREEN, appConstants.MBACKGROUNDBLUE));
		
		GridBagConstraints b = new GridBagConstraints();
		
		lblHeader = new JLabel();
		ImageIcon imgtitle = cApp.getAi().getImgMainTitle();
		lblHeader.setIcon(imgtitle);
		add( lblHeader, b);
		
		
		b.gridx  = 0;
		b.gridy = 0;
		
		add(lblHeader,b);
		
		b.gridy++;
		add(new JLabel("  "),b);
		
		Border imageBorder = BorderFactory.createLineBorder(Color.black, 10);
		imgMain = cApp.getAi().getImgdefaultImage();

		lblHeaderImage = new JLabel();
		lblHeaderImage.setIcon(imgMain);
		lblHeaderImage.setPreferredSize(new Dimension(appConstants.MAINIMAGEWIDTH, appConstants.MAINIMAGEHEIGHT));
		lblHeaderImage.setBorder(imageBorder);
		
		b.gridx  = 0;
		b.gridy = 1;
		b.gridwidth = 1;
		b.gridheight = 7;
		
		
		add(lblHeaderImage,b);
		

		b.gridwidth = 1;
		b.gridheight = 1;
		b.gridx  = 1;
		


		ImageIcon imgMini = cApp.getAi().getImgMiniTitle();
		lblMiniTitle = new JLabel();
		lblMiniTitle.setIcon(imgMini);
		add( lblMiniTitle, b);

		
		btnMMNewButton = new JButton("New League");
		btnMMNewButton.setBackground(new Color(appConstants.MBUTBACKGROUNDRED, appConstants.MBUTBACKGROUNDGREEN, appConstants.MBUTBACKGROUNDBLUE));
		btnMMNewButton.setForeground(appConstants.MFORGROUNDCOLOR);
		btnMMNewButton.setFocusable(false);
		btnMMNewButton.setPreferredSize(new Dimension(appConstants.BIGBTNWIDTH, appConstants.BIGBTNHEIGHT));
		btnMMNewButton.addMouseListener(this);
		btnMMNewButton.addActionListener(this);
		b.gridx  = 1;
		b.gridy++;
		
		
		add(btnMMNewButton,b);

		
		btnMMLoadButton = new JButton("Load League");
		btnMMLoadButton.setBackground(new Color(appConstants.MBUTBACKGROUNDRED, appConstants.MBUTBACKGROUNDGREEN, appConstants.MBUTBACKGROUNDBLUE));
		btnMMLoadButton.setForeground(appConstants.MFORGROUNDCOLOR);
		btnMMLoadButton.setFocusable(false);
		btnMMLoadButton.setPreferredSize(new Dimension(appConstants.BIGBTNWIDTH, appConstants.BIGBTNHEIGHT));
		btnMMLoadButton.addMouseListener(this);
		b.gridx  = 1;
		b.gridy++;
		
		add(btnMMLoadButton,b);
				
		
		btnMMremotegameButton = new JButton("Play Remote Game");
		btnMMremotegameButton.setBackground(new Color(appConstants.MBUTBACKGROUNDRED, appConstants.MBUTBACKGROUNDGREEN, appConstants.MBUTBACKGROUNDBLUE));
		btnMMremotegameButton.setForeground(appConstants.MFORGROUNDCOLOR);
		btnMMremotegameButton.setFocusable(false);
		btnMMremotegameButton.setPreferredSize(new Dimension(appConstants.BIGBTNWIDTH, appConstants.BIGBTNHEIGHT));
		btnMMremotegameButton.addMouseListener(this);

		
		b.gridx  = 1;
		b.gridy++;
		
		add(btnMMremotegameButton,b);

		
		btnMMRemoteLeaguesButton = new JButton("Remote Leagues");
		btnMMRemoteLeaguesButton.setBackground(new Color(appConstants.MBUTBACKGROUNDRED, appConstants.MBUTBACKGROUNDGREEN, appConstants.MBUTBACKGROUNDBLUE));
		btnMMRemoteLeaguesButton.setForeground(appConstants.MFORGROUNDCOLOR);
		btnMMRemoteLeaguesButton.setFocusable(false);
		btnMMRemoteLeaguesButton.setPreferredSize(new Dimension(appConstants.BIGBTNWIDTH, appConstants.BIGBTNHEIGHT));
		btnMMRemoteLeaguesButton.addMouseListener(this);
		
		
		b.gridx  = 1;
		b.gridy++;
		
		add(btnMMRemoteLeaguesButton,b);
		
			
		
		btnMMExitButton = new JButton("Exit");
		btnMMExitButton.setBackground(new Color(appConstants.MBUTBACKGROUNDRED, appConstants.MBUTBACKGROUNDGREEN, appConstants.MBUTBACKGROUNDBLUE));
		btnMMExitButton.setForeground(appConstants.MFORGROUNDCOLOR);
		btnMMExitButton.setFocusable(false);
		btnMMExitButton.setPreferredSize(new Dimension(appConstants.BIGBTNWIDTH, appConstants.BIGBTNHEIGHT));
		btnMMExitButton.addMouseListener(this);
		btnMMExitButton.addActionListener(this);
		
		b.gridx  = 1;
		b.gridy++;

		
		add(btnMMExitButton,b);
		
		

		
		b.gridx  = 0;
		b.gridy =8;
		imgMonitorBase = cApp.getAi().getImgMonitorBase();
		imgMonBase = new JLabel();
		imgMonBase.setIcon(imgMonitorBase);		

		add(imgMonBase,b);		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == btnMMExitButton)
		{
			cfpJFrame cfgf = (cfpJFrame)SwingUtilities.getAncestorOfClass(cfpJFrame.class, panelMainMenu.this);
			cfgf.endAppliction();
		}
		else if (arg0.getSource() == btnMMNewButton)
		{
			cfpJFrame cfgf = (cfpJFrame)SwingUtilities.getAncestorOfClass(cfpJFrame.class, panelMainMenu.this);
			CardLayout cardLayout = (CardLayout) cfgf.cards.getLayout();
			cfgf.pConfig.newLeague(true);
			cardLayout.show(cfgf.cards, "League Config 1");
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {

		ImageIcon img = null;
		if (arg0.getSource() == btnMMNewButton)
			img = cApp.getAi().getImgNewLeague(); 		  
		else if (arg0.getSource() == btnMMLoadButton)
            img = cApp.getAi().getImgLoadLeague();
		else if (arg0.getSource() == btnMMremotegameButton)
            img = cApp.getAi().getImgRemoteGame();
		else if (arg0.getSource() == btnMMRemoteLeaguesButton)
            img = cApp.getAi().getImgRemoteLeague();
		else if (arg0.getSource() == btnMMExitButton)
            img = cApp.getAi().getImgExit();

		lblHeaderImage.setIcon(img); 
    	SoundPlayer sp = new SoundPlayer();
    	sp.playSound(cApp.getSp().getSndfmouseoverbtn());
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		lblHeaderImage.setIcon(cApp.getAi().getImgdefaultImage()); 	
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
}
