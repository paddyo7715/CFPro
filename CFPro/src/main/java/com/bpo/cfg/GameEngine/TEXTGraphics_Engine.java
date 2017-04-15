package com.bpo.cfg.GameEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TEXTGraphics_Engine {
	
	private String HomeCity;
	private String HomeName;
	private String HomeScore;
	private String AwayCity;
	private String AwayName;
	private String AwayScore;
	private String GameTitle;
	private String HomeHelmetColr;
	private String HomeJerseyColor;
	private String HomePantsColor;
	private String AwayHelmetColr;
	private String AwayJerseyColor;
	private String AwayPantsColor;	
	private boolean HomePosession;
	private int leftScreenStartPos;
	
	
	private BufferedWriter out = null;
	
	public TEXTGraphics_Engine(String HomeCity, String HomeName, String HomeScore, String AwayCity, String AwayName, String AwayScore,String GameTitle, String HomeHelmetColr, String HomeJerseyColor, String HomePantsColor, String AwayHelmetColr, String AwayJerseyColor, String AwayPantsColor)
	{
		this.HomeCity = HomeCity;
		this.HomeName = HomeName;
		this.HomeScore = HomeScore;
		this.AwayCity = AwayCity;
		this.AwayName = AwayName;
		this.AwayScore = AwayScore;
		this.GameTitle = GameTitle;
		this.HomeHelmetColr = HomeHelmetColr;
		this.HomeJerseyColor = HomeJerseyColor;
		this.HomePantsColor = HomePantsColor;
		this.AwayHelmetColr = AwayHelmetColr;
		this.AwayJerseyColor = AwayJerseyColor;
		this.AwayPantsColor = AwayPantsColor;	
		
		
		try  
		{
			String msg = "** Begin Game " + HomeCity + " " + HomeName + " versus " + AwayCity + " " + AwayName + " **";
		    FileWriter fstream = new FileWriter("gamelog.txt", false); //true tells to append data.
		    out = new BufferedWriter(fstream);
		    out.write(msg);
		}
		catch (IOException e)
		{
		    System.err.println("Error: " + e.getMessage());
		}
/*
		finally
		{
		    if(out != null) {
		        try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
*/		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
