package it.objectmethod.worldspring.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import it.objectmethod.worldspring.config.ConnectionFactory;
import it.objectmethod.worldspring.dao.ICountryDao;
import it.objectmethod.worldspring.model.Country;

public class CountryDaoImpl implements ICountryDao{

	@Override
	public List<Country> getAllCountryByContinent(String continent) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Country> ret = new ArrayList<Country>();
		try{
			String sql = "SELECT Name, SurfaceArea, Population, Code FROM world.country where Continent = ?";
			stmt = conn.prepareStatement(sql);		
			stmt.setString(1, continent);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){

				Country c = new Country();
				c.setName(rs.getString("Name"));
				c.setSurfaceArea(Double.parseDouble(rs.getString("SurfaceArea")));
				c.setPopulation(Integer.parseInt(rs.getString("Population")));
				c.setCountryCode(rs.getString("Code"));
				ret.add(c);
				
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{

				if(conn!=null) {
					conn.close();
				}

			}catch(SQLException se){
				se.printStackTrace();
			}
		}

		return ret;
	}

	public List<Country> getAllCountry() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Country> ret = new ArrayList<Country>();
		try{
			String sql = "SELECT Name, SurfaceArea, Population, Code FROM world.country";
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){

				Country c = new Country();
				c.setName(rs.getString("Name"));
				c.setSurfaceArea(Double.parseDouble(rs.getString("SurfaceArea")));
				c.setPopulation(Integer.parseInt(rs.getString("Population")));
				c.setCountryCode(rs.getString("Code"));
				ret.add(c);
				
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{

				if(conn!=null) {
					conn.close();
				}

			}catch(SQLException se){
				se.printStackTrace();
			}
		}

		return ret;
	};
	
	public List<Country> MoveCountry(String CodeTo, String CodeFrom) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Country> ret = new ArrayList<Country>();
		try{
			String sql = "UPDATE\n" + 
					"world.city c\n" + 
					"INNER JOIN\n" + 
					"world.country cc\n" + 
					"ON\n" + 
					"c.ID = cc.Capital\n" + 
					"SET\n" + 
					"c.CountryCode=?, cc.Capital = null\n" + 
					"WHERE\n" + 
					"c.CountryCode=?;";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, CodeTo);
			stmt.setString(2, CodeFrom);
			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{

				if(conn!=null) {
					conn.close();
				}

			}catch(SQLException se){
				se.printStackTrace();
			}
		}

		return ret;
	};

}
