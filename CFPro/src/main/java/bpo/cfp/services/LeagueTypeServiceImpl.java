package bpo.cfp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpo.cfp.entity.LeagueType;
import bpo.cfp.dao.LeagueTypeDAO;



@Service
public class LeagueTypeServiceImpl implements LeagueTypeService {
	@Autowired
	private LeagueTypeDAO lTypeDAO;
	
	
	@Override
	public List<LeagueType> getLeagueTypes() {
		return lTypeDAO.getLeagueTypes();
	}
	
	
}
