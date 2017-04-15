package com.bpo.cfg.schedule;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

public class Game_Schedule {
	
	private String League;
	private int Teams;
	private int TeamsperDiv;
	private int Conferences;
	private int Weeks;
	private int byes;
	private int nonDivConfGames;
	private int nonConfgames;
	
	Vector sched = null;
	
	public Game_Schedule(String league, int Teams, int TeamsperDiv, int Conferences, int Weeks, int byes)
	{
		this.League = League;
		this.Teams = Teams;
		this.TeamsperDiv = TeamsperDiv;
		this.Conferences = Conferences;
		this.Weeks = Weeks;
		this.byes = byes;
		
	}
	
	private int getDivision(int Team)
	{
		return ((Team - 1) / TeamsperDiv) + 1;
	}
	private int getConference(int Team)
	{
		return (Team-1) / (Teams / Conferences) + 1;
	}
	private int[] game_types(int T)
	{
		int home_games = 0;
		int away_games = 0;
		int nondiv_conf_games = 0;
		int nonconf_games = 0;
		
		ListIterator lv = sched.listIterator();
		while (lv.hasNext())
		{
			String g = (String) lv.next();
			String[] m = g.split(",");
			if (m[0].equals(Integer.toString(T)))
			{
				home_games++;
				if (getConference(Integer.parseInt(m[0])) == getConference(Integer.parseInt(m[1])) && getDivision(Integer.parseInt(m[0])) != getDivision(Integer.parseInt(m[1])))
					nondiv_conf_games++;
				if (getConference(Integer.parseInt(m[0])) != getConference(Integer.parseInt(m[1])))
					nonconf_games++;
				
			}
			if (m[1].equals(Integer.toString(T)))
			{
				away_games++;
				if (getConference(Integer.parseInt(m[1])) == getConference(Integer.parseInt(m[0])) && getDivision(Integer.parseInt(m[1])) != getDivision(Integer.parseInt(m[0])))
					nondiv_conf_games++;
				if (getConference(Integer.parseInt(m[1])) != getConference(Integer.parseInt(m[0])))
					nonconf_games++;
				
			}
		}

		return new int[] {home_games, away_games, nondiv_conf_games, nonconf_games};
	}
	public boolean DupeGame(int Home, int Away)
	{
		boolean r = false;
		ListIterator lv = sched.listIterator();
		while (lv.hasNext())
		{
			String g = (String) lv.next();
			String[] m = g.split(",");
			if ((m[0].equals(Integer.toString(Home))  || m[0].equals(Integer.toString(Away))) &&  (m[1].equals(Integer.toString(Home))  || m[1].equals(Integer.toString(Away))) )
			{
				r = true;
				break;
			}
		}
		return r;
	}
	
	public Vector Generate_Regular_Schedule()
	{
		sched = new Vector(360);
		int max_weeks = 100;
		Vector Weekly_sched = new Vector(max_weeks);
		Weekly_sched.add("Week Number,Home Team ID,Away Team ID");
		int expected_home_games = Weeks / 2;
		int expected_away_games = expected_home_games;
		int[] gt = null;
		
		for (int i=1; i <= Teams; i++)
		{
//Create division games
			int cur_div = getDivision(i);
			int beg_div = (cur_div*TeamsperDiv) + 1 - TeamsperDiv;
			int cur_conf = getConference(i);

//			System.out.println(i + " - " + cur_div);
			for (int x=beg_div;x < beg_div + TeamsperDiv; x++ )
			{
				if (i==x) continue;
				if (DupeGame(i,x)) continue;
				
				sched.add(Integer.toString(i) + "," + Integer.toString(x));
				sched.add(Integer.toString(x) + "," + Integer.toString(i));
			}
		}
			System.out.println("Finished scheduling div games");
//Create if we should start scheduling home or away

		    
//Create all other games		 
		for (int wg_count=0; wg_count < 10 ; wg_count++)
		{
    	   	int t;
	     	int i;
//	   	int tries = 0;
	     	int wgcount = (Teams/2);
	     	String wgames[] = new String[wgcount];
	     	int wg_now = 0;
//clear the weekly games	   	
	     	for (String s: wgames)
	     	{
	     		s = null;
	   	    }
	     	int tries = 0;
	     	while (true)
	    	{
		    	Random rha = new Random();
	        	int home = 0;
	    	    int away = 0;
		    		
	
		    	
		    	
//					Random rt = new Random();
	     	    i = rha.nextInt(Teams) + 1;
		        t = rha.nextInt(Teams) + 1;
				    
	    	    if (i==t) continue;

//if same division then pick new teams.
		    	tries++;
		    	if (tries == 2000)
		    	{
			     	wgames = new String[wgcount];
			     	wg_now = 0;
			     	tries=0;
		    	}
	    	    if (getDivision(i) == getDivision(t)) continue;

		        gt = game_types(i);
		        int a= gt[0] - gt[1];
		        gt = game_types(t);
		        int b = gt[0] - gt[1];
		    
		        if (a < b)
		        {
		   	  	  home = i; away = t;
		        }
		        else
		        {
		   		  home = t; away = i;
		        }
		        
		        String pgame = home + "," + away;
		        
		        if (!dupe_weekly_game(wgames, pgame))
		        {
		        	wgames[wg_now] = pgame;
		        	wg_now++;
		        }
		        
		        if (wg_now == wgcount )  
		        	break;
		        

    	}   	//while true
			    	
//	    	sched.add(Integer.toString(home) + "," + Integer.toString(away));
	     	sched.addAll(Arrays.asList(wgames));
	        
	    	System.out.println("Number of Games Scheduled " + sched.size());
	    	
//	    	if (sched.size() >= ((Weeks) *  (Teams/2)))
//	    			break;
			    	
			    	

		}
		    		
			System.out.println("Finished scheduling all other games sched size " + sched.size());

//Print out game totals for each team
			System.out.println("Game totals:");
			for (int yyu = 1; yyu <= 40; yyu++)
			{
	    		int[] zt = game_types(yyu);
	    		System.out.println(yyu + " " + zt[0] + " " + zt[1] + " " + zt[2] + " " +zt[3]);
			}			
		

//schedule weekly games			
			for (int w = 1; w <= (Weeks + byes); w++)
			{
				if (sched.size() == 0) break;
				
				System.out.println("Week " + w);
				int games = 16;
				if (w <= 5 || w >= 16) games = 20;
				games = 20;

				
				int wi = 0;
				String[] week_arr = new String[games]; 
				String pg = null;
				
				int tries = 0;
				
				while (true)
				{
					tries++;
					if (tries >= 50000)
					{
						tries = 0;
						break;
						
/*						for (int w2 = 0; w2 < week_arr.length; w2++)
						{
							if (week_arr[w2] != null)
							{
								String[] z = week_arr[w2].split(",");
								sched.add(z[0] + "," + z[1]);
								week_arr[w2] = null;
								wi--;
							}
							
						}
*/						
					}
					
					Random rha = new Random();
				    int gg = rha.nextInt(sched.size()) + 1;
				    gg--;
//				    System.out.println(gg);
				    pg =  (String) sched.get(gg);
				    if (!dupe_weekly_game(week_arr,pg))
				 	{
				    	sched.removeElementAt(gg);
				    	week_arr[wi] = pg;
				    	wi++;
				    	tries = 0;
				 	}
				    if (wi == games || sched.size() == 0) break;
				    
				}
//Move week to overall sched vector
				for (String wkq : week_arr)
				{
					if (wkq != null)
						Weekly_sched.add(w + "," + wkq);					
				}
				


		}
		    
	
		System.out.println("Scheduling left over games");	
		while (sched.size() > 0)
		{
			System.out.println("Left over games: " + sched.size());

			Random r2 = new Random();
		    int lo_rand = r2.nextInt(sched.size());
			String lo_game = (String) sched.get(lo_rand);
			
OUTER_FOR:			for (int w3=1; w3 <= Weeks+byes;w3++)
			{
				if (sched_games_for_week(w3, Weekly_sched) == Teams /2)
					continue;
				
				String t2[] = lo_game.split(",");
				
				String h = sched_weekly_team_game(w3, t2[0], Weekly_sched, true);
				String a = sched_weekly_team_game(w3, t2[1], Weekly_sched, false);
				
				if (h == null || a == null)
				{
					int bw = r2.nextInt(2) + 1;
					if (bw == 2) continue;
					
					String ng = (h != null) ? h : a;
						
					int n_index = sched_game_index(ng, Weekly_sched);
					swap_game(w3, lo_game, ng, sched, lo_rand, Weekly_sched, n_index);
					
					for (int w=Weeks+byes; w > 0; w--)
					{
						String yy[] = ng.split(",");
						String hh = sched_weekly_team_game(w, yy[1], Weekly_sched, true);
						String aa = sched_weekly_team_game(w, yy[2], Weekly_sched, false);
						if (hh == null && aa == null)
						{
							add_game_to_weekly_sched(Weekly_sched, w, ng);
						    sched.remove(lo_rand);	
							break OUTER_FOR;
						}
					}
				}
			}
		}
			
			
			
//		for (int y=0; y< Weeks+byes; y++)
//			Weekly_sched.add(w + "," + week_arr[y]);		
	
		return Weekly_sched;
//		return sched;

	}
	
	private void add_game_to_weekly_sched(Vector v, int w, String game)
	{
		
		String u[] = game.split(",");
		
		for (int qei = 0; qei < v.size(); qei++)
		{
			String q = (String) v.get(qei);
			String gt[] = q.split(",");
			
            if (gt[0].equals(String.valueOf(w)   ))
            {
            	v.insertElementAt((String) gt[0] + "," + u[1] + "," + u[2] , qei);
            	break;
            }
		}
		
	}
	
	private void swap_game(int week, String lef_over_game, String scheded_game, Vector sched,int sched_index, Vector weekly_sched, int ws_index)
	{
		String gt[] = scheded_game.split(",");
		sched.set(sched_index, gt[1] + "," + gt[2]);	    
	    weekly_sched.set(ws_index, week + "," + lef_over_game);
	    
	}
	
	private int sched_game_index(String g, Vector v)
	{
		int r = -1;
		
		for (int qei = 0; qei < v.size(); qei++)
		{
			String q = (String) v.get(qei);
            if (g.equals(q))
            {
            	r = qei;
            	break;
            }
		}
		
		return r;
	}

	
	
	private String sched_weekly_team_game(int x,String t, Vector v, boolean home)
	{
		String r = null;
		
		for (int qei = 0; qei < v.size(); qei++)
		{
			String q = (String) v.get(qei);
			String qt[] = q.split(",");
			if (qt[0].equals("Week Number")) continue;			
			if (Integer.parseInt(qt[0]) == x && (qt[1].equals(t) ||  qt[2].equals(t)))
			{
				r = q;
				break;
			}
		}
		
		return r;
	}

	private int sched_games_for_week(int x, Vector v)
	{
		int r = 0;
		
		for (int qei = 0; qei < v.size(); qei++)
		{
			String q = (String) v.get(qei);
			String qt[] = q.split(",");
			if (qt[0].equals("Week Number")) continue;
			if (Integer.parseInt(qt[0]) == x)
				r++;
		}
		
		return r;
	}
	private boolean dupe_weekly_game(String[] w,String g)
	{
		boolean r = false;
		
		String[] m = g.split(",");
		int g1 = Integer.parseInt(m[0]);
		int g2 = Integer.parseInt(m[1]);
		
		for (int i = 0; i < w.length; i++)
		{
			if (w[i] == null)
				break;
			
			String[] m2 = w[i].split(",");
			int w1 = Integer.parseInt(m2[0]);
			int w2 = Integer.parseInt(m2[1]);

			if (g1 == w1 || g1 == w2)
			{
				r = true;
				break;
			}
			
			if (g2 == w1 || g2 == w2)
			{
				r = true;
				break;
			}

		}
		return r;
	}
	public static void main(String[] args) 
	{
		
		Game_Schedule gs = new Game_Schedule("APFL",40,5,2,18,2);
		Vector v = gs.Generate_Regular_Schedule();
		ListIterator lv = v.listIterator();
		int i = 0;
		int[] gt = null;
		
//		while (lv.hasNext())
//		{
//			i++;
//			String s = (String) lv.next();
//			System.out.println(i + " - " + s);
//		}

//		for (int j = 1; j <= gs.Teams ; j++)
//		{
//   		gt = gs.game_types(j);
//			System.out.println("game " + j + " " + gt[0] + " " + gt[1] + " " + gt[2] + " " + gt[3]);
//		}
		
		while (lv.hasNext())
		{
			String g = (String) lv.next();
			System.out.println(g);
		}
        
        int hh = 0;
	}	

}
