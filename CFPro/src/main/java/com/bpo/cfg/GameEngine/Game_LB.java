package com.bpo.cfg.GameEngine;

public class Game_LB extends Game_Player {
	private int LBTackle;
	
	private int LBRunAtt = 0;
	private int LBRunYrds = 0;
	
	public Game_LB(String Position, String Number, int PlayerNumber, String FirstName, String LastName, int LBTackle)
	{
		super(Position, Number, PlayerNumber, FirstName, LastName);	
		this.LBTackle = LBTackle;
	}

	public int getLBRunAtt() {
		return LBRunAtt;
	}

	public void setLBRunAtt(int lBRunAtt) {
		LBRunAtt = lBRunAtt;
	}

	public int getLBRunYrds() {
		return LBRunYrds;
	}

	public void setLBRunYrds(int lBRunYrds) {
		LBRunYrds = lBRunYrds;
	}

	public int getLBTackle() {
		return LBTackle;
	}
	
}
