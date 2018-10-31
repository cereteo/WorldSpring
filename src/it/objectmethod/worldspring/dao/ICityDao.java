package it.objectmethod.worldspring.dao;

import java.util.List;

import it.objectmethod.worldspring.model.City;
import it.objectmethod.worldspring.model.Country;

public interface ICityDao {
	
	public List<City> getAllCities(String country);
	
	public City getCityById(int id);
	
	public List<City> getSearchCity(String city);
	
	public boolean addCity(String cityName, int population, String Nation);
	
	public boolean modCity(String cityName, int population, String Nation, int id);
	
	public void movCities(String countryTo, int[] citiesCode);
	
	public boolean delCity(int id);

}
