package com.bpo.cfg.GameEngine;

public class Game_Ball {
	private int FieldPositionX;
	private int FieldPositionY;
//A 0 means the ball is free
	private int PlayerPosession;
	
	
	public int getFieldPositionX() {
		return FieldPositionX;
	}
	public void setFieldPositionX(int fieldPositionX) {
		FieldPositionX = fieldPositionX;
	}
	public int getFieldPositionY() {
		return FieldPositionY;
	}
	public void setFieldPositionY(int fieldPositionY) {
		FieldPositionY = fieldPositionY;
	}
	public int getPlayerPosession() {
		return PlayerPosession;
	}
	public void setPlayerPosession(int playerPosession) {
		PlayerPosession = playerPosession;
	}

	
}
