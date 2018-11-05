package it.objectmethod.worldspring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp.ConnectionFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.worldspring.dao.ICityDao;
import it.objectmethod.worldspring.model.City;

public class CityDaoImpl extends NamedParameterJdbcDaoSupport implements ICityDao{

	@Override
	public List<City> getAllCities(String country) {
		String sql = "SELECT  c.Name, c.District, c.Population, c.Id\n" + 
				"		, CASE WHEN cc.Capital is not null THEN 1 ELSE 0 END isCapital \n" + 
				"		FROM  world.city c left join world.country cc  on c.ID = cc.Capital \n" + 
				"		where c.CountryCode = :country\n" + 
				"		ORDER BY c.Population DESC";
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("country", country);
		List<City> cities = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return cities;
	}
	
	public City getCityById(int citiesCode) {
		String sql = "SELECT  c.Name, c.District, c.Population, c.Id\n" + 
				"		, CASE WHEN cc.Capital is not null THEN 1 ELSE 0 END isCapital \n" + 
				"		FROM  world.city c left join world.country cc  on c.ID = cc.Capital \n" + 
				"		where c.Id = :citiesCode";
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("citiesCode", citiesCode);
		City city = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return city;
	}
	
	@Override
	public List<City> getSearchCity(String city) {
		String sql = "SELECT  c.Name, c.District, c.Population, c.Id\n" + 
				"		, CASE WHEN cc.Capital is not null THEN 1 ELSE 0 END isCapital\n" + 
				"		FROM  world.city c left join world.country cc  on c.ID = cc.Capital\n" + 
				"		Where c.Name LIKE :cityName\n" + 
				"		ORDER BY c.Population DESC";
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("cityName", city);
		List<City> cities = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return cities;
	}
	
	public boolean addCity(String cityName, int population, String Nation){
//		
//		Connection conn = ConnectionFactory.getConnection();
//		PreparedStatement stmt = null;
//		boolean rs = false;
//		try{
//			
//			String sql = "INSERT INTO city (Name, Population, CountryCode) VALUES (?, ?, (SELECT  Code FROM  world.country c  WHERE c.Code = ?));";
//			stmt = conn.prepareStatement(sql);
//
//			stmt.setString(1, cityName);
//			stmt.setInt(2, population);
//			stmt.setString(3, Nation);
//			
//			System.out.println(sql+"  "+Nation);
//			rs = stmt.execute();
//			
//			System.out.println(rs);
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
//		return rs;
		return false;
	}
//
	public boolean modCity(String cityName, int population, String Nation, int id){
//		
//		Connection conn = ConnectionFactory.getConnection();
//		PreparedStatement stmt = null;
//		boolean rs = false;
//		try{
//			
//			String sql = "UPDATE world.city SET name= ? , population = ?, CountryCode = ? WHERE ID = ?;";
//			stmt = conn.prepareStatement(sql);
//
//			stmt.setString(1, cityName);
//			stmt.setInt(2, population);
//			stmt.setString(3, Nation);
//			stmt.setInt(4, id);
//			
//			System.out.println(sql+"  "+id);
//			rs = stmt.execute();
//			
//			System.out.println(rs);
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
//		return rs;
		return false;
	}
//
	public boolean movCity(String countryTo, int citiesCode) {
//		Connection conn = ConnectionFactory.getConnection();
//		PreparedStatement stmt = null;
//		boolean rs = false;
//		try{
//			
//			String sql = "UPDATE world.city c LEFT JOIN world.country cc ON c.ID = cc.Capital\n" + 
//					"SET c.CountryCode=? , cc.Capital = null\n" + 
//					"where c.Id = ?;";
//			stmt = conn.prepareStatement(sql);
//
//			stmt.setString(1, countryTo);
//			stmt.setInt(2, citiesCode);
//			
//			rs = stmt.execute();
//			
//			System.out.println(rs);
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
		return false;
	}
//	
	public void movCities(String countryTo, int[] citiesCode) {
//		for(int i=0; i<citiesCode.length; i++) {
//			movCity(countryTo, citiesCode[i]);
//		}
	}
//	
public boolean delCity(int id){
	String sql = "DELETE FROM world.city WHERE ID = :cityCode;";
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("cityCode", id);
	int cities = getNamedParameterJdbcTemplate().update(sql, params);
	return (cities > 0)?true:false;
	}

}
