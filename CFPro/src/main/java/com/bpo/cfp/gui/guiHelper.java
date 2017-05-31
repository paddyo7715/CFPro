package com.bpo.cfp.gui;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bpo.cfp.entity.LeagueType;

public class guiHelper {
	
	public static LeagueType getLeagueTypefromName(String s, List<LeagueType> ltypes) 
	{
		LeagueType r = null;
		
		for (LeagueType lt : ltypes) {
			if (s.equals(lt.getName())) {
				r = lt;
				break;
			}
		}
		return r;
		
	}
	public static void enableDisableConfDivLabels(LeagueType lt, JLabel lc1, JLabel lc2, JLabel ld1, JLabel ld2,  JTextField c1, JTextField c2, List<JTextField> divs1, List<JTextField> divs2) 
	{
		c1.setText("");
		c2.setText("");
		
		switch (lt.getConferences()) {
		case 0:
			lc1.setVisible(false);
			lc2.setVisible(false);
			ld1.setVisible(true);
			ld2.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			break;
		case 1:
			lc1.setVisible(true);
			lc2.setVisible(false);
			ld1.setVisible(true);
			ld2.setVisible(false);
			c1.setVisible(true);
			c2.setVisible(false);
			break;
		case 2:
			lc1.setVisible(true);
			lc2.setVisible(true);
			ld1.setVisible(true);
			ld2.setVisible(true);
			c1.setVisible(true);
			c2.setVisible(true);
			break;			
		}
		
		setDivtxts(1,lt.getConferences(),lt.getDivisions(), divs1);
		setDivtxts(2,lt.getConferences(),lt.getDivisions(), divs2);
		
	}
	public static void setDivtxts(int confnum, int confs, int divs, List<JTextField> divslist) 
	{
		
		boolean bAllowDivs = true;
		
		if (confnum == 2 && confs < 2) bAllowDivs = false;
		
		int i = 1;
		for (JTextField txt : divslist) {
			txt.setText("");
			if (i <= divs && bAllowDivs)
				txt.setVisible(true);
			else
				txt.setVisible(false);
			i++;
		}
		
	}

}
