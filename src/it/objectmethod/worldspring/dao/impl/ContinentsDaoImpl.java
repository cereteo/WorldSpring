package it.objectmethod.worldspring.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.worldspring.config.ConnectionFactory;
import it.objectmethod.worldspring.dao.ICityDao;
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
