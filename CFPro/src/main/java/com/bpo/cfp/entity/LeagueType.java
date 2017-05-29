package com.bpo.cfp.entity;

public class LeagueType {

	private int id;
	private String name = null;
	private int Teams;
	private int Games;
	private int Conferences;
	private int Divisions;
	private int PlayoffTeams;
	
	public LeagueType() {
		super();
	}
	
	public LeagueType(int id,String name, int teams, int games, int conferences, int divisions, int playoffTeams) {
		super();
		this.id = id;
		this.name = name;
		Teams = teams;
		Games = games;
		Conferences = conferences;
		Divisions = divisions;
		PlayoffTeams = playoffTeams;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeams() {
		return Teams;
	}

	public void setTeams(int teams) {
		Teams = teams;
	}

	public int getGames() {
		return Games;
	}

	public void setGames(int games) {
		Games = games;
	}

	public int getConferences() {
		return Conferences;
	}

	public void setConferences(int conferences) {
		Conferences = conferences;
	}

	public int getDivisions() {
		return Divisions;
	}

	public void setDivisions(int divisions) {
		Divisions = divisions;
	}

	public int getPlayoffTeams() {
		return PlayoffTeams;
	}

	public void setPlayoffTeams(int playoffTeams) {
		PlayoffTeams = playoffTeams;
	}

		
	
}
