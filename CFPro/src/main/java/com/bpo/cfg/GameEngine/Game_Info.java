package com.bpo.cfg.GameEngine;

import com.bpo.cfg.enums.*;

public class Game_Info {

	private int HomeID;
	private int AwayID;
	private String HomeCity;
	private String AwayCity;
	private String HomeName;
	private String AwayName;
	private String HomeHelmetColor;
	private String HomeJerseyColor;
	private String HomePantsColor;
	private String AwayHelmetColor;
	private String AwayJerseyColor;
	private String AwayPantsColor;	
	
	private boolean HomeFieldAdvantage;
	private boolean PlayoffGame;
	private String GameTitle;
	private States Game_State;
	
	private int HomeScore;
	private int AwayScore;
	private int Quarter;
	private int Seconds_Left_in_Quarter;
	private int line_of_Scrimage;
	private int down;
	private int yards_to_go;
	
	private boolean HomePosession;
	private boolean firsthalfHomePosession;
	private int leftScreenStartPos;
	

	public Game_Info(int homeID, int awayID, String homeCity, String awayCity, String homeName, String awayName,
			String homeHelmetColor, String homeJerseyColor, String homePantsColor, String awayHelmetColor,
			String awayJerseyColor, String awayPantsColor, boolean homeFieldAdvantage, boolean playoffGame,
			String gameTitle, States game_State) {
		this.HomeID = homeID;
		this.AwayID = awayID;
		this.HomeCity = homeCity;
		this.AwayCity = awayCity;
		this.HomeName = homeName;
		this.AwayName = awayName;
		this.HomeHelmetColor = homeHelmetColor;
		this.HomeJerseyColor = homeJerseyColor;
		this.HomePantsColor = homePantsColor;
		this.AwayHelmetColor = awayHelmetColor;
		this.AwayJerseyColor = awayJerseyColor;
		this.AwayPantsColor = awayPantsColor;
		this.HomeFieldAdvantage = homeFieldAdvantage;
		this.PlayoffGame = playoffGame;
		this.GameTitle = gameTitle;
		this.Game_State = game_State;
	};

	
	public States getGame_State() {
		return Game_State;
	}



	public void setGame_State(States game_State) {
		Game_State = game_State;
	}



	public int getHomeScore() {
		return HomeScore;
	}



	public void setHomeScore(int homeScore) {
		HomeScore = homeScore;
	}



	public int getAwayScore() {
		return AwayScore;
	}



	public void setAwayScore(int awayScore) {
		AwayScore = awayScore;
	}



	public int getQuarter() {
		return Quarter;
	}



	public void setQuarter(int quarter) {
		Quarter = quarter;
	}



	public int getSeconds_Left_in_Quarter() {
		return Seconds_Left_in_Quarter;
	}



	public void setSeconds_Left_in_Quarter(int seconds_Left_in_Quarter) {
		Seconds_Left_in_Quarter = seconds_Left_in_Quarter;
	}



	public int getLine_of_Scrimage() {
		return line_of_Scrimage;
	}



	public void setLine_of_Scrimage(int line_of_Scrimage) {
		this.line_of_Scrimage = line_of_Scrimage;
	}



	public int getDown() {
		return down;
	}



	public void setDown(int down) {
		this.down = down;
	}



	public int getYards_to_go() {
		return yards_to_go;
	}



	public void setYards_to_go(int yards_to_go) {
		this.yards_to_go = yards_to_go;
	}



	public boolean isHomePosession() {
		return HomePosession;
	}



	public void setHomePosession(boolean homePosession) {
		HomePosession = homePosession;
	}



	public boolean isFirsthalfHomePosession() {
		return firsthalfHomePosession;
	}



	public void setFirsthalfHomePosession(boolean firsthalfHomePosession) {
		this.firsthalfHomePosession = firsthalfHomePosession;
	}



	public int getLeftScreenStartPos() {
		return leftScreenStartPos;
	}



	public void setLeftScreenStartPos(int leftScreenStartPos) {
		this.leftScreenStartPos = leftScreenStartPos;
	}



	public int getHomeID() {
		return HomeID;
	}



	public int getAwayID() {
		return AwayID;
	}



	public String getHomeCity() {
		return HomeCity;
	}



	public String getAwayCity() {
		return AwayCity;
	}



	public String getHomeName() {
		return HomeName;
	}



	public String getAwayName() {
		return AwayName;
	}



	public String getHomeHelmetColor() {
		return HomeHelmetColor;
	}



	public String getHomeJerseyColor() {
		return HomeJerseyColor;
	}



	public String getHomePantsColor() {
		return HomePantsColor;
	}



	public String getAwayHelmetColor() {
		return AwayHelmetColor;
	}



	public String getAwayJerseyColor() {
		return AwayJerseyColor;
	}



	public String getAwayPantsColor() {
		return AwayPantsColor;
	}



	public boolean isHomeFieldAdvantage() {
		return HomeFieldAdvantage;
	}



	public boolean isPlayoffGame() {
		return PlayoffGame;
	}



	public String getGameTitle() {
		return GameTitle;
	}



	
	
}
