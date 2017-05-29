package com.bpo.cfp.gui;
//I created this class since the JCombox does not have a settier for disabled background color and I needed one.

import java.awt.Color;

import javax.swing.JComboBox;

public class customJComboBox extends JComboBox {
	
	private Color custEnabledBGColor = null;
	private Color custDisabledBGColor = null;
	
	public customJComboBox(String[] sValues, Color custEnabledBGColor ,Color custDisabledBGColor) {
		super(sValues);
		this.custEnabledBGColor = custEnabledBGColor;
		this.custDisabledBGColor = custDisabledBGColor;
	}
	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		if (b)
			this.setBackground(custEnabledBGColor);
		else
			this.setBackground(custDisabledBGColor);
	}
	

}
