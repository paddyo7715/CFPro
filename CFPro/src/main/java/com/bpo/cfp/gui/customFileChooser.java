package com.bpo.cfp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.bpo.cfg.constants.appConstants;
import com.bpo.cfg.utilities.Utility_Functions;
import com.sun.prism.Graphics;

import javafx.scene.text.Font;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class customFileChooser extends JDialog {

	private JLabel lTitle = null;
	private JLabel lDrive = new JLabel("Drive");
	private JComboBox cboDrive = null;
	private JList lstFiles = null;
    private JButton btnOK;
    private JButton btnCancel;
	
	public customFileChooser(Frame parent, int xloc, int yloc, boolean bjustfolders, String Title)
	{
	    super(parent, Title, true);
	    
	    ArrayList ad = Utility_Functions.getalldrives();
	    String fulldrive = (String) ad.get(0);
	    String drive = (String) fulldrive.subSequence(0, fulldrive.indexOf(":") + 1);
	    String[] f = Utility_Functions.getFilesandFolders(drive);
	    
	    JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(appConstants.MINIPANERADIOBGCOLOR);
	    GridBagConstraints cs = new GridBagConstraints();
	 
	    cs.fill = GridBagConstraints.HORIZONTAL;
	    cs.insets = new Insets(5, 15, 5, 15);
	    cs.gridx = 0;
	    cs.gridy = 0;	 
	    cs.gridwidth = 2;
	    lTitle = new JLabel(Title);
	    lTitle.setForeground(appConstants.MINIBORDERCOLOR);
	    lTitle.setBackground(appConstants.MAINBGCOLOR);

	    panel.add(lTitle, cs);	    
	    cs.gridwidth = 1;
	    
	    cs.gridx = 0;
	    cs.gridy++;
	    lDrive.setForeground(appConstants.MINIBORDERCOLOR);
	    lDrive.setBackground(appConstants.MAINBGCOLOR);
	    panel.add(lDrive, cs);
	    
	    cs.gridx = 1;
	    cboDrive = new JComboBox(ad.toArray());
	    cboDrive.setPreferredSize(new Dimension(70,30));
	    cboDrive.setForeground(appConstants.MINIBORDERCOLOR);
	    cboDrive.setBackground(appConstants.MAINBGCOLOR);
	    cboDrive.setFocusable(false);

	    panel.add(cboDrive, cs);
	    
	    cs.gridx = 0;
	    cs.gridy++;
	    cs.gridwidth = 2;
	    lstFiles = new JList(f);
	    lstFiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    lstFiles.setPreferredSize(new Dimension(300,200));
	    lstFiles.setForeground(appConstants.MINIBORDERCOLOR);
	    lstFiles.setBackground(appConstants.MAINBGCOLOR);
	    JScrollPane listScroller = new JScrollPane();
	    listScroller.setViewportView(lstFiles);
	    lstFiles.setLayoutOrientation(JList.VERTICAL);

	    panel.add(listScroller, cs);
	    cs.gridwidth = 1;
	    
	    getRootPane().setBorder( BorderFactory.createRaisedBevelBorder());
	    
	    
	    btnOK = new JButton("OK");
	    btnOK.setBackground(appConstants.MAINBGCOLOR);
	    btnOK.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
	    
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(appConstants.MAINBGCOLOR);
        btnCancel.setForeground(appConstants.NORMALBTNFOREGROUNDCOLOR);
        btnCancel.addActionListener(new ActionListener() {
	   	@Override
        public void actionPerformed(ActionEvent e) {
               dispose();
        }
        });
	    
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
