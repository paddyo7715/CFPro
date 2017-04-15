package com.bpo.cfg.GameEngine;

public class Game_OL extends Game_Player {

	private int Strength;
	
	private int Pancakes;
	private int Flattened;
	
	public Game_OL(String Position, String Number, int PlayerNumber, String FirstName, String LastName, int Pancakes, int Flattened)
	{
		super(Position, Number, PlayerNumber, FirstName, LastName);	
		this.Pancakes = Pancakes;
		this.Flattened = Flattened;
	}

	public int getStrength() {
		return Strength;
	}

	public void setStrength(int strength) {
		Strength = strength;
	}

	public int getPancakes() {
		return Pancakes;
	}

	public int getFlattened() {
		return Flattened;
	}
	
}
