package com.bpo.cfp.gui;

//This class was created because the jtextfield does not have a set disabled background setter method, and I needed one.

import java.awt.Color;

public class customTextField extends JTextFieldLimit {
	
	private Color custEnabledBGColor = null;
	private Color custDisabledBGColor = null;
	
	public customTextField(int c, Color custEnabledBGColor ,Color custDisabledBGColor) {
		super(c);
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
