package com.bpo.cfp.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.bpo.cfg.application.CFGApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;

@Component
public class cfpJFrame extends JFrame 
{
	
	public JPanel cards; 
	@Autowired
	CFGApplication cfgApplicaiton;
	@Autowired
	public panelMainMenu pMain;
	@Autowired
	public panelNewLeague1 pConfig;
	
	@PostConstruct
	public void postConstruct()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
//		setUndecorated(false);
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cards = new JPanel(new CardLayout());

		
		getContentPane().add(cards); 
	}
	
	
	public cfpJFrame()
	{
		
	}
	public void endAppliction()
	{
		this.dispose();
		System.exit(0);
	}

//Starting point for the applicaiton	
	public static void main(String[] args) 
	{
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		cfpJFrame frame = (cfpJFrame) ctx.getBean(cfpJFrame.class);
		
		frame.cards.add(frame.pMain, "main Menu");
		frame.cards.add(frame.pConfig, "League Config 1");
			
		CardLayout cardLayout = (CardLayout) frame.cards.getLayout();

		cardLayout.show(frame.cards, "main Menu");
	    frame.setVisible(true);  				
	}
}
