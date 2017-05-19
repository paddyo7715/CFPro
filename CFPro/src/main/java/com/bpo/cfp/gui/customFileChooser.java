package com.bpo.cfp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import com.bpo.cfg.constants.appConstants;
import com.bpo.cfg.utilities.Utility_Functions;
import com.sun.prism.Graphics;

import javafx.scene.control.ScrollBar;
import javafx.scene.text.Font;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class customFileChooser extends JDialog {

	private JLabel lTitle = null;
	private JLabel lDrive = new JLabel("Drive");
	private JComboBox cboDrive = null;
	private JList lstFiles = null;
    private JButton btnOK;
    private JButton btnCancel;
    private String path = null;
    private DefaultListModel model = null;
    private JLabel lerrorMessage;
    private ArrayList ad = null;
    private ArrayList<String> fileexts = null;
	
	public String getPath() {
		return path;
	}
	
	private void setToMainDrive()
	{
		ad = Utility_Functions.getalldrives();
	    String fulldrive = (String) ad.get(0);
	    String drive = (String) fulldrive.subSequence(0, fulldrive.indexOf(":") + 1);
	    path = drive + "\\";
	}

	private void changeList()
	{
	    String[] f = Utility_Functions.getFilesandFolders(path, fileexts);
	    
	    model = new DefaultListModel();
	    for (String ff : f)
	    	model.addElement(ff);  
	    lstFiles.setModel(model);

	}
	public customFileChooser(Frame parent, int xloc, int yloc, boolean bjustfolders, String Title, ImageIcon imgFoldedr, ArrayList<String> fileexts)
	{
	    super(parent, Title, true);

	    this.fileexts = fileexts;
	    
	    setToMainDrive();
	    
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
	    cboDrive.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	            JComboBox cb = (JComboBox)e.getSource();
	            String fulldrive = (String)cb.getSelectedItem();
	    	    String drive = (String) fulldrive.subSequence(0, fulldrive.indexOf(":") + 1);
	    	    path = drive + "\\";
	    	    try {
	    	    	changeList();
	    	    }
	    	    catch (Exception ex)
	    	    {
//	    	    	model.clear();
	    	        cboDrive.setSelectedIndex(0);
	    	    	setToMainDrive();
	    	    	changeList();
	    	    }
	        }
	    });

	    panel.add(cboDrive, cs);
	    
	    cs.gridx = 0;
	    cs.gridy++;
	    cs.gridwidth = 2;
	    model = new DefaultListModel();

	    
	    lstFiles = new JList(model);
	    lstFiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    lstFiles.setForeground(appConstants.MINIBORDERCOLOR);
	    lstFiles.setBackground(appConstants.MAINBGCOLOR);
	    JScrollPane listScroller = new JScrollPane(lstFiles);
	    listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    lstFiles.setVisibleRowCount(10);
	    lstFiles.setCellRenderer(new IconListRenderer(imgFoldedr, this));
	    changeList();
	    
	    
	    lstFiles.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent evt) {
	            JList list = (JList)evt.getSource();
	            if (evt.getClickCount() == 2) {
	                int index = list.locationToIndex(evt.getPoint());
	        	    String p = path + list.getSelectedValue().toString().trim() ;
	        	    
	        	    if (!Utility_Functions.isFolder(p)) return;
	        	    path = path + list.getSelectedValue().toString().trim() ;
	        	    path = path		+ "\\";
	        	    changeList();
	            }
	        }
	    });

	    panel.add(listScroller, cs);
	    cs.gridwidth = 1;
	    
	    lerrorMessage = new JLabel("      ");
	    lerrorMessage.setForeground(appConstants.ALERTCOLOR);
	    cs.gridx = 0;
	    cs.gridy++;
	    cs.gridwidth = 3;
	    panel.add(lerrorMessage, cs);
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
