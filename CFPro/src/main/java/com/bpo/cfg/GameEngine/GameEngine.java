package com.bpo.cfg.GameEngine;

import java.time.*;

import java.util.Random;
import java.util.Vector;
import com.bpo.cfg.enums.*;
import com.bpo.cfg.utilities.*;

public class GameEngine {
	
//Constants
	private static int SECONDS_PER_QUARTER = 900;
	private static int FIELDWIDTHPIXELS = 4000;
	private static int ENDZONEWIDTHPIXEL = 400;
	private static int ONEYEARDPIXELWIDTH = 40;
	private static int STARTINGYRDLINE = 20;
	private static int YARDSONFIELD = 100;
	private static int FIELDWINDOWWIDTH = 1200;
	private static int FIELDWINDOWHIEGHT = 500;
	
	private static int PLAYERHIEGHT = 40;
	private static int PLAYERWIDTH = 40;
	
	private static int BALLHEIGHT = 10;
	private static int BALLWIDTH = 10;
	
	private static int PLAYERBLANKYSPACE = 10;
	private static int PLAYERBLANKXSPACE = 10;
	
	private Game_Info gi = null;
	private Vector<Game_Player> HomePlayers = null;
	private Vector<Game_Player> AwayPlayers = null;
	private Game_Ball gb = null;
	
	

	
	public GameEngine(Game_Info gi, Vector<Game_Player> HomePlayers, Vector<Game_Player> AwayPlayers)
	{
		this.gi = gi;
		this.HomePlayers = HomePlayers;
		this.AwayPlayers = AwayPlayers;
		gb = new Game_Ball();
	  
	}
	public void PlayGame(String[] HomePlayers, String[] AwayPlayers) 
	{
		boolean Game_end = false;
		
		gi.setSeconds_Left_in_Quarter(SECONDS_PER_QUARTER);
		gi.setQuarter(1);
		  
		gi.setHomeScore(0);
		gi.setAwayScore(0);
		
		gi.setDown(1);
		gi.setYards_to_go(10);

//Decide which team gets the ball first and remember which team got the ball first.		
		Random rha = new Random();
	    int HA = rha.nextInt(2) + 1;
        if (HA == 1)
        {
        	gi.setHomePosession(true);
        	gi.setFirsthalfHomePosession(true);
        	
        }
        else
        {
        	gi.setHomePosession(false);
        	gi.setFirsthalfHomePosession(false);
        }   
        
        gi.setGame_State(States.KICKOFF);
        
	    
		while (!Game_end)  // the game loop
		{
			
			Execute_Play();
			
//End of Quarter
			if (gi.getSeconds_Left_in_Quarter() == 0)
			{
				int q = gi.getQuarter();
				if (q == 1 || q == 3)
					NewQuarter(q);
				else if (q == 2)
				{
					gi.setGame_State(States.KICKOFF);
					if (gi.isFirsthalfHomePosession())
						gi.setHomePosession(false);
					else
						gi.setHomePosession(true);
					NewQuarter(q);
				}
				else if (q > 4 && gi.isPlayoffGame() && gi.getHomeScore() == gi.getAwayScore())
					NewQuarter(q);
			}
			
//Regular way to end Game one team wins			
			if (gi.getQuarter() == 4 && gi.getSeconds_Left_in_Quarter() == 0 &&  gi.getHomeScore() != gi.getAwayScore())
				Game_end = true;

//Game ends in a tie			
			if (gi.getQuarter() > 4 && !gi.isPlayoffGame() && gi.getHomeScore() == gi.getAwayScore())
				Game_end = true;

			
			if (gi.getGame_State() == States.KICKOFF)
			{
				gi.setDown(1);
				gi.setYards_to_go(10);
				if (gi.isHomePosession())
					gi.setLine_of_Scrimage(STARTINGYRDLINE); 
				else
					gi.setLine_of_Scrimage(YARDSONFIELD - STARTINGYRDLINE); 
			}
	
			
		}// the game loop
		
		
	}
	private void NewQuarter(int q)
	{
		gi.setQuarter(q++);
		gi.setSeconds_Left_in_Quarter(SECONDS_PER_QUARTER);
	}
	public void Execute_Play() 
	{
		int yardsGained;
		boolean PlayEnded = false;

		if (gi.isHomePosession())
		{
//Randomize RBs
			Utility_Functions.ShuffleSpecificElements(HomePlayers, 1, 2); 
//Randomize WRs
			Utility_Functions.ShuffleSpecificElements(HomePlayers, 3, 4); 	
//Randomize OLs
			Utility_Functions.ShuffleSpecificElements(HomePlayers, 5, 9); 	
//Randomize the CBs
			Utility_Functions.ShuffleSpecificElements(AwayPlayers, 10, 11); 
//Randomize the DLs
			Utility_Functions.ShuffleSpecificElements(AwayPlayers, 12, 16); 
		}
		else
		{
//Randomize RBs
			Utility_Functions.ShuffleSpecificElements(AwayPlayers, 1, 2); 
//Randomize WRs
			Utility_Functions.ShuffleSpecificElements(AwayPlayers, 3, 4); 	
//Randomize OLs
			Utility_Functions.ShuffleSpecificElements(AwayPlayers, 5, 9); 		
//Randomize the CBs
			Utility_Functions.ShuffleSpecificElements(HomePlayers, 10, 11); 
//Randomize the DLs
			Utility_Functions.ShuffleSpecificElements(HomePlayers, 12, 16); 
			
		}
		
		
		while (!PlayEnded)
		{
			
		}
		
		
		
		
	}
	public void StartofPlaySetPlayers()
	{
		int m;
		int balllengthfactor;
		Vector<Game_Player> Offense;
		Vector<Game_Player> Defense;
		
		if (gi.isHomePosession())
		{
			m = -1;
			balllengthfactor = BALLWIDTH; 
			Offense = HomePlayers;
			Defense = AwayPlayers;
		}
		else
		{
			m = 1;
			balllengthfactor = 0;
			Offense = AwayPlayers;
			Defense = HomePlayers;
		}
		
		int linep = gi.getLine_of_Scrimage() * ONEYEARDPIXELWIDTH;

//set ball		
		gb.setPlayerPosession(0);  //The ball is free
		gb.setFieldPositionY((FIELDWINDOWHIEGHT  / 2) + (m * ((PLAYERHIEGHT - BALLHEIGHT) / 2)));
		gb.setFieldPositionX((linep) + (m * (balllengthfactor) + ((PLAYERWIDTH - BALLWIDTH) / 2) ));

//Set Offenseive formation
//Center
		int linemenX = linep + (m * (PLAYERBLANKXSPACE + balllengthfactor));
		int centerY = FIELDWINDOWHIEGHT  / 2;
		Offense.get(7).setFieldPositionX(linemenX);
		Offense.get(7).setFieldPositionY(centerY);
		
//Guard 1
		Offense.get(6).setFieldPositionX(linemenX);
		Offense.get(6).setFieldPositionY(centerY - ( 1 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//Guard 2
		Offense.get(8).setFieldPositionX(linemenX);
		Offense.get(8).setFieldPositionY(centerY + ( 1 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//Tackle 1
		Offense.get(5).setFieldPositionX(linemenX);
		Offense.get(5).setFieldPositionY(centerY - ( 2 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//Tackle 2
		Offense.get(9).setFieldPositionX(linemenX);
		Offense.get(9).setFieldPositionY(centerY + ( 2 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		
		
//WR 1
		Offense.get(3).setFieldPositionX(linemenX);
		Offense.get(3).setFieldPositionY(centerY - ( 5 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//WR 2
		Offense.get(4).setFieldPositionX(linemenX);
		Offense.get(4).setFieldPositionY(centerY + ( 5 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));				
		
//QB
		Offense.get(0).setFieldPositionX(linemenX + (m * (PLAYERBLANKXSPACE + PLAYERWIDTH)));
		Offense.get(0).setFieldPositionY(centerY);

//RB 1
		Offense.get(1).setFieldPositionX(linemenX + (m * 2 * (PLAYERBLANKXSPACE + PLAYERWIDTH)));
		Offense.get(1).setFieldPositionY(centerY - ( 1 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));	

//RB 2
		Offense.get(2).setFieldPositionX(linemenX + (m * 2 * (PLAYERBLANKXSPACE + PLAYERWIDTH)));
		Offense.get(2).setFieldPositionY(centerY + ( 1 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));			
		
//Set Defensive Formation	
//Nose Tackle		
		int dlinex = linep + (m*-1 *(BALLWIDTH));
		Defense.get(14).setFieldPositionX(dlinex);
		Defense.get(14).setFieldPositionY(centerY);
		
//DT 1		
		Defense.get(13).setFieldPositionX(dlinex);
		Defense.get(13).setFieldPositionY(centerY - ( 1 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//DT 2		
		Defense.get(15).setFieldPositionX(dlinex);
		Defense.get(15).setFieldPositionY(centerY + ( 1 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//DE 1		
		Defense.get(12).setFieldPositionX(dlinex);
		Defense.get(12).setFieldPositionY(centerY - ( 2 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//DE 2		
		Defense.get(16).setFieldPositionX(dlinex);
		Defense.get(16).setFieldPositionY(centerY + ( 2 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//CB 1		
		Defense.get(10).setFieldPositionX(dlinex);
		Defense.get(10).setFieldPositionY(centerY - ( 5 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		

//CB 2		
		Defense.get(11).setFieldPositionX(dlinex);
		Defense.get(11).setFieldPositionY(centerY + ( 5 * (PLAYERBLANKYSPACE + PLAYERHIEGHT)));		
		
//LB		
		Defense.get(17).setFieldPositionX(dlinex + ((m * -1) * (PLAYERBLANKXSPACE + PLAYERWIDTH)));
		Defense.get(17).setFieldPositionY(centerY);		

		
	}
	public void Send_Grphics_Engine(String GraphicMessage)
	{
//Send a message to the Graphics Engine
//This method should take in a player position and state structure
//that will be combined with the game stats as a message.
	}
	public static void main(String  args[])
	{
		GameEngine ge = new GameEngine(1, "Boston", "Colonials", 2, "Detroit", "Turbos", false, false, "Regualr Season Game","#111111", "#111111", "#111111", "#222222", "#222222", "#222222");

		
		
		
	}
}
