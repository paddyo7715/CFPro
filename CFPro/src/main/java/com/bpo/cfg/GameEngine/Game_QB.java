package com.bpo.cfg.GameEngine;

public class Game_QB extends Game_Player {
	
	private int QBThrowAccuracy;
	private int QBDecisionMaking;
	private int QBNotFumble;
	
	private int QBPassComp = 0;
	private int QBPassAtt = 0;
	private int QBYars = 0;
	private int QBTD = 0;
	private int QBINT = 0;
	private int QBFumb = 0;

	
	public Game_QB(String Position, String Number, int PlayerNumber, String FirstName, String LastName, int QBThrowAccuracy, int QBDecisionMaking, int QBNotFumble)
	{
		super(Position, Number, PlayerNumber, FirstName, LastName);	
		this.QBThrowAccuracy = QBThrowAccuracy;
		this.QBDecisionMaking = QBDecisionMaking;
		this.QBNotFumble = QBNotFumble;
	}

	public int getQBPassComp() {
		return QBPassComp;
	}


	public void setQBPassComp(int QBPassComp) {
		this.QBPassComp = QBPassComp;
	}


	public int getQBPassAtt() {
		return QBPassAtt;
	}


	public void setQBPassAtt(int QBPassAtt) {
		this.QBPassAtt = QBPassAtt;
	}


	public int getQBYars() {
		return QBYars;
	}


	public void setQBYars(int QBYars) {
		this.QBYars = QBYars;
	}


	public int getQBTD() {
		return QBTD;
	}


	public void setQBTD(int QBTD) {
		this.QBTD = QBTD;
	}


	public int getQBINT() {
		return QBINT;
	}


	public void setQBINT(int QBINT) {
		this.QBINT = QBINT;
	}


	public int getQBFumb() {
		return QBFumb;
	}


	public void setQBFumb(int QBFumb) {
		this.QBFumb = QBFumb;
	}


	public int getQBThrowAccuracy() {
		return QBThrowAccuracy;
	}


	public int getQBDecisionMaking() {
		return QBDecisionMaking;
	}


	public int getQBNotFumble() {
		return QBNotFumble;
	}
	
}
