package com.bpo.cfp.gui;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.bpo.cfg.application.CFGApplication;
import com.bpo.cfg.constants.appConstants;
import com.bpo.cfg.enums.MSGBOX_IMAGE;


public class customerMSQBox extends JDialog  {


    private JLabel lImage;
    private JLabel lMessage;
    private JButton btnOK;

	
	public customerMSQBox(Frame parent, String msq, CFGApplication app, MSGBOX_IMAGE mi)
	{
	    super(parent, "Error", true);
	    
	    ImageIcon msgimg = null;
	    switch (mi)
	    {
	    case INFO:
	    	msgimg = app.getAi().getImgMSGInfo();
	    	break;
	    case QUESTION:
	    	msgimg = app.getAi().getImgMSGQuestion();
	    	break;
	    case WARNING:
	    	msgimg = app.getAi().getImgMSGWarning();
	    	break;
	    case ERROR:
	    	msgimg = app.getAi().getImgMSGError();
	    	break;
	    }

	    JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(appConstants.MINIPANERADIOBGCOLOR);
	    GridBagConstraints cs = new GridBagConstraints();
	    
	    
	 
	    cs.fill = GridBagConstraints.HORIZONTAL;
	    cs.insets = new Insets(5, 15, 5, 15);
	    cs.gridx = 0;
	    cs.gridy = 0;	 
	    cs.gridwidth = 3;
	    panel.add(new JLabel("  "), cs);	    
	    cs.gridwidth = 1;
	    
	    lImage = new JLabel();
	    lImage.setIcon(msgimg);
	    lImage.setForeground(appConstants.MINILABELFG);
	    cs.gridx = 0;
	    cs.gridy++;
	    cs.gridwidth = 1;
	    panel.add(lImage, cs);
	 
	    lMessage = new JLabel(msq);
	    lMessage.setForeground(appConstants.MINILABELFG);
	    cs.gridx = 1;
	    cs.gridwidth = 2;
	    panel.add(lMessage, cs);
	 
	    getRootPane().setBorder( BorderFactory.createRaisedBevelBorder());
	    
	    btnOK = new JButton("OK");
	    btnOK.setBackground(appConstants.MAINBGCOLOR);
	    btnOK.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
	    btnOK.addActionListener(new ActionListener() {
	   	@Override
        public void actionPerformed(ActionEvent e) {
               dispose();
        }
        });
        
        JPanel bp = new JPanel();
        
        bp.add(btnOK);

        bp.setBackground(appConstants.MINIPANERADIOBGCOLOR);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
	    setUndecorated(true); 
        pack();
        setResizable(false);
        
        setLocationRelativeTo(parent);
		}


	
}
