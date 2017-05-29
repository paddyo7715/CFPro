package bpo.cfp.dao;

import java.util.ArrayList;
import java.util.List;

import com.bpo.cfp.entity.LeagueType;

public class LeagueTypeDAOImpl implements LeagueTypeDAO {

	@Override
	public List<LeagueType> getLeagueTypes() {
		ArrayList<LeagueType> lTypes = new ArrayList<LeagueType>() ;
		lTypes.add(new LeagueType(1,"10 Teams, 10 Games, 1 Conference, 2 Divisions, 4 Playoff Teams", 10, 10, 1, 2, 4));
		lTypes.add(new LeagueType(2,"16 Teams, 12 Games, 2 Conference, 4 Divisions, 6 Playoff Teams", 16, 12, 2, 4, 6));
		lTypes.add(new LeagueType(3,"100 Teams, 18 Games, 2 Conference, 20 Divisions, 28 Playoff Teams", 100, 18, 2, 20, 28));
	
		return lTypes;
	}

}
