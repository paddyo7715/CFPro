package com.bpo.cfg.GameEngine;

public class Game_DL extends Game_Player {
	private int DLStrength;
	
	private int DLSacks = 0;
	
	public Game_DL(String Position, String Number, int PlayerNumber, String FirstName, String LastName, int DLStrength)
	{
		super(Position, Number, PlayerNumber, FirstName, LastName);	
		this.DLStrength = DLStrength;
	}

	public int getDLSacks() {
		return DLSacks;
	}

	public void setDLSacks(int dLSacks) {
		DLSacks = dLSacks;
	}

	public int getDLStrength() {
		return DLStrength;
	}
	

}
