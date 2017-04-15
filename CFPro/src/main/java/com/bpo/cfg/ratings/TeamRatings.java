package com.bpo.cfg.ratings;

public class TeamRatings implements Comparable<TeamRatings> {
	public String Team;
	public float overall;
	public float offense;
	public float defense;
	
	public TeamRatings(String team, float overall, float offense, float defense) {
		super();
		Team = team;
		this.overall = overall;
		this.offense = offense;
		this.defense = defense;
	}

	@Override
	public int compareTo(TeamRatings arg0) {
		int r = 0;
		
		if (this.overall > arg0.overall)
			r = -1;
		else if (this.overall < arg0.overall)
			r = 1;
		
		return r;
	}
	
	
	
	
}
