package com.bpo.cfg.GameEngine;

public class Game_WR extends Game_Player {
	
	private int WRSpeed;
	private int WRHands;
	private int WRNotFumble;
	
	private int WRCatches;
	private int WRYards;
	private int WRTDs;
	private int WRFumbles;
	
	public Game_WR(String Position, String Number, int PlayerNumber, String FirstName, String LastName, int WRSpeed, int WRHands, int WRNotFumble)
	{
		super(Position, Number, PlayerNumber, FirstName, LastName);	
		this.WRSpeed = WRSpeed;
		this.WRHands = WRHands;
		this.WRNotFumble = WRNotFumble;
	}

	public int getWRCatches() {
		return WRCatches;
	}

	public void setWRCatches(int wRCatches) {
		WRCatches = wRCatches;
	}

	public int getWRYards() {
		return WRYards;
	}

	public void setWRYards(int wRYards) {
		WRYards = wRYards;
	}

	public int getWRTDs() {
		return WRTDs;
	}

	public void setWRTDs(int wRTDs) {
		WRTDs = wRTDs;
	}

	public int getWRFumbles() {
		return WRFumbles;
	}

	public void setWRFumbles(int wRFumbles) {
		WRFumbles = wRFumbles;
	}

	public int getWRSpeed() {
		return WRSpeed;
	}

	public int getWRHands() {
		return WRHands;
	}

	public int getWRNotFumble() {
		return WRNotFumble;
	}

	
}
