package com.bpo.cfg.GameEngine;

public class Game_RB extends Game_Player {
	
	private int RBStrength;
	private int RBSpeed;
	private int RBNotFumble;
	
	private int RBRuns= 0;
	private int RBYards = 0;
	private int RBTDs = 0;
	private int RBFumbles = 0;
	
	public Game_RB(String Position, String Number, int PlayerNumber, String FirstName, String LastName, int RBStrength, int RBSpeed, int RBNotFumble)
	{
		super(Position, Number, PlayerNumber, FirstName, LastName);	
		this.RBStrength = RBStrength;
		this.RBSpeed = RBSpeed;
		this.RBNotFumble = RBNotFumble;
		
	}

	public int getRBRuns() {
		return RBRuns;
	}

	public void setRBRuns(int rBRuns) {
		RBRuns = rBRuns;
	}

	public int getRBYards() {
		return RBYards;
	}

	public void setRBYards(int rBYards) {
		RBYards = rBYards;
	}

	public int getRBTDs() {
		return RBTDs;
	}

	public void setRBTDs(int rBTDs) {
		RBTDs = rBTDs;
	}

	public int getRBFumbles() {
		return RBFumbles;
	}

	public void setRBFumbles(int rBFumbles) {
		RBFumbles = rBFumbles;
	}

	public int getRBStrength() {
		return RBStrength;
	}

	public int getRBSpeed() {
		return RBSpeed;
	}

	public int getRBNotFumble() {
		return RBNotFumble;
	}

}
