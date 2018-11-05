package it.objectmethod.worldspring.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.worldspring.dao.ICountryDao;
import it.objectmethod.worldspring.model.City;
import it.objectmethod.worldspring.model.Country;

public class CountryDaoImpl extends NamedParameterJdbcDaoSupport implements ICountryDao{

	@Override
	public List<Country> getAllCountryByContinent(String continent) {
		
		String sql = "SELECT Name, SurfaceArea, Population, Code countryCode FROM world.country where Continent = :continent";
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("continent", continent);
		List<Country> country = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return country;
	}

	public List<Country> getAllCountry() {
		String sql = "SELECT Name, SurfaceArea, Population, Code FROM world.country";
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		List<Country> country = getJdbcTemplate().query(sql, rm);
		return country;
	};

	public String getCountryCodeByCity(String id) {
		String sql = "select CountryCode from world.city c\n" + 
				"where ID = :id";
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		Country country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return country.getCountryCode();
	}
	
	public List<Country> MoveCountry(String CodeTo, String CodeFrom) {
//		Connection conn = ConnectionFactory.getConnection();
//		PreparedStatement stmt = null;
//		List<Country> ret = new ArrayList<Country>();
//		try{
//			String sql = "UPDATE\n" + 
//					"world.city c\n" + 
//					"INNER JOIN\n" + 
//					"world.country cc\n" + 
//					"ON\n" + 
//					"c.ID = cc.Capital\n" + 
//					"SET\n" + 
//					"c.CountryCode=?, cc.Capital = null\n" + 
//					"WHERE\n" + 
//					"c.CountryCode=?;";
//			
//			stmt = conn.prepareStatement(sql);
//			
//			stmt.setString(1, CodeTo);
//			stmt.setString(2, CodeFrom);
//			
//			stmt.executeUpdate();
//			stmt.close();
//			conn.close();
//			
//		}catch(SQLException se){
//			se.printStackTrace();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			try{
//				if(stmt!=null)
//					stmt.close();
//			}catch(SQLException se2){
//				se2.printStackTrace();
//			}
//			try{
//
//				if(conn!=null) {
//					conn.close();
//				}
//
//			}catch(SQLException se){
//				se.printStackTrace();
//			}
//		}
//
		return null;
	};

}
