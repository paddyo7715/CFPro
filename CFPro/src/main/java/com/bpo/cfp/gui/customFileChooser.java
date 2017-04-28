package com.bpo.cfp.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.bpo.cfg.constants.appConstants;

import java.awt.Insets;

public class customFileChooser extends JDialog {

	private JLabel lDrive = new JLabel("Drive");
	private JComboBox cboDrive = null;
	private JList lstFiles = null;
    private JButton btnOK;
    private JButton btnCancel;
	
	public customFileChooser(Frame parent, int xloc, int yloc, boolean bjustfolders, String Title)
	{
	    super(parent, Title, true);
	    
	    JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(appConstants.MINIPANERADIOBGCOLOR);
	    GridBagConstraints cs = new GridBagConstraints();
	 
	    cs.fill = GridBagConstraints.HORIZONTAL;
	    cs.insets = new Insets(5, 15, 5, 15);
	    cs.gridx = 0;
	    cs.gridy = 0;	 
	    cs.gridwidth = 2;
	    panel.add(new JLabel("  "), cs);	    
	    cs.gridwidth = 1;
	    
	    cs.gridx = 0;
	    cs.gridy++;
	    panel.add(lDrive, cs);
	    
	    cs.gridx = 1;
	    panel.add(cboDrive, cs);
	    
	    cs.gridx = 0;
	    cs.gridy++;
	    panel.add(lstFiles);

	    getRootPane().setBorder( BorderFactory.createRaisedBevelBorder());
	    
	    
	    btnOK = new JButton("OK");
	    btnOK.setBackground(appConstants.MAINBGCOLOR);
	    btnOK.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
	    
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(appConstants.MAINBGCOLOR);
        btnCancel.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
	    
       JPanel bp = new JPanel();
        
        bp.add(btnCancel);
        bp.add(btnOK);	    
	    
        bp.setBackground(appConstants.MINIPANERADIOBGCOLOR);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
	    setUndecorated(true); 
        pack();
        setResizable(false);
        
        setLocationRelativeTo(parent);
	    setLocation(xloc, yloc);
	    
	    
	}
}
