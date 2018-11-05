package it.objectmethod.worldspring.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.worldspring.dao.IContinentsDao;
import it.objectmethod.worldspring.model.Continents;

public class ContinentsDaoImpl extends NamedParameterJdbcDaoSupport implements IContinentsDao{

	public List<Continents> getAllContinents() {
		//List<Continents> continents = new ArrayList<Continents>();
		String sql = "SELECT Continent, sum(SurfaceArea) totSurfaceArea, sum(Population) totPopulation FROM world.country\n" + 
				"GROUP BY Continent;";
		BeanPropertyRowMapper<Continents> rm = new BeanPropertyRowMapper<Continents>(Continents.class);
		List<Continents> continents = getJdbcTemplate().query(sql, rm);
		return continents;
	}
}
