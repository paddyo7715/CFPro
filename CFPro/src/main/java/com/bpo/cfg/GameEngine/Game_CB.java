package com.bpo.cfg.GameEngine;

public class Game_CB extends Game_Player {
	private int CBSpeed;
	private int CBHands;
	
	private int CBInts = 0;
	
	public Game_CB(String Position, String Number, int PlayerNumber, String FirstName, String LastName, int CBSpeed, int CBHands)
	{
		super(Position, Number, PlayerNumber, FirstName, LastName);	
		this.CBHands = CBHands;
		this.CBSpeed = CBSpeed;
	}

	public int getCBInts() {
		return CBInts;
	}

	public void setCBInts(int cBInts) {
		CBInts = cBInts;
	}

	public int getCBSpeed() {
		return CBSpeed;
	}

	public int getCBHands() {
		return CBHands;
	}
	
}
