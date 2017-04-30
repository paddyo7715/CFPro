package com.bpo.cfp.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import com.bpo.cfg.utilities.Utility_Functions;


public class IconListRenderer 
	extends DefaultListCellRenderer {
	
	private ImageIcon imgFolder = null;
	private customFileChooser cfc;


	
	public IconListRenderer(ImageIcon imgFolder, customFileChooser cfc) {
		this.imgFolder = imgFolder;
		this.cfc = cfc;
	}
	
	@Override
	public Component getListCellRendererComponent(
		JList list, Object value, int index, 
		boolean isSelected, boolean cellHasFocus) {
		
		// Get the renderer component from parent class
		
		JLabel label = 
			(JLabel) super.getListCellRendererComponent(list, 
				value, index, isSelected, cellHasFocus);
				
		
		if (Utility_Functions.isFolder(cfc.getPath() + "/" + value)) 
			label.setIcon(imgFolder);
//		label.setPreferredSize(new Dimension(20,20));
		return label;
	}


}
