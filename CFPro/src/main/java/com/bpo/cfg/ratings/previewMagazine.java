package com.bpo.cfg.ratings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Vector;

public class previewMagazine {
	
	private final float qbr = .30f;
	private final float rb = .15f;
	private final float fb = .05f;
	private final float ol = .04f;
	private final float te = .05f;
	private final float wr = .125f;
	
	private final float cb = .09f ;
	private final float lb = .08f;
	private final float dl = .09f;
	private final float s = .08f;
	
	

	public Vector genTeamRankings(Vector v)
	{
		Vector r = new Vector();
		Vector p = new Vector();
		
	    for (Object l: v)
	    {
	    	String sp[] = ((String)l).split(",");
	    	float o = Float.parseFloat(sp[1]) * qbr + 
	    			Float.parseFloat(sp[2]) * rb +
	    			Float.parseFloat(sp[3]) * fb +
	    			Float.parseFloat(sp[4]) * ol +
	    			Float.parseFloat(sp[5]) * ol +
	    			Float.parseFloat(sp[6]) * ol +
	    			Float.parseFloat(sp[7]) * ol +
	    			Float.parseFloat(sp[8]) * ol +
	    			Float.parseFloat(sp[9]) * te +
	    			Float.parseFloat(sp[10]) * wr +
	    			Float.parseFloat(sp[11]) * wr;
	    	
	    	float d = Float.parseFloat(sp[12]) * cb + 
	    			Float.parseFloat(sp[13]) * cb +
	    			Float.parseFloat(sp[14]) * lb +
	    			Float.parseFloat(sp[15]) * lb +
	    			Float.parseFloat(sp[16]) * lb +
	    			Float.parseFloat(sp[17]) * lb +
	    			Float.parseFloat(sp[18]) * dl +
	    			Float.parseFloat(sp[19]) * dl +
	    			Float.parseFloat(sp[18]) * dl +
	    			Float.parseFloat(sp[19]) * dl +
	    			Float.parseFloat(sp[21]) * s +
	    			Float.parseFloat(sp[22]) * s;
	    	
	    	float ol = (o + d) / 2.0f;
	    	TeamRatings tr = new TeamRatings(sp[0], ol, o, d);
	    	p.add(tr);
	    }
	    Collections.sort(p);
	   
	    for (Object so: p)
	    {
	    	TeamRatings ptr = (TeamRatings) so;
	    	r.add(ptr.Team + String.format("%.2f", ptr.overall) + " " + String.format("%.2f", ptr.offense) + " " + String.format("%.2f", ptr.defense));
	    }
	    
	    
		return r;
	}
	
	
	public static void main(String[] args) 
	{
		String file = "c:/file/1985Ratings.txt";
		Vector v = new Vector();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		      if (!line.startsWith("Team"))
		    	  v.add(line);
		    }
		    
		    previewMagazine m = new previewMagazine();
		    Vector tr = m.genTeamRankings(v);
		    int i = 0;
		    for (Object s: tr)
		    	System.out.println(++i + " " + (String) s);
		    
		    
		}
		catch (Exception e)
		{
			System.out.println("Error reading file " + e.getMessage());
		}
	}
}
