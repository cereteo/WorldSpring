package it.objectmethod.worldspring.dao;
import java.util.List;

import it.objectmethod.worldspring.model.City;
import it.objectmethod.worldspring.model.Country;

public interface ICountryDao {

	public List<Country> getAllCountryByContinent(String continent);
	
	public List<Country> getAllCountry();
	
	public String getCountryCodeByCity(City city);
	
	public List<Country> MoveCountry(String CodeTo, String CodeFrom);
}
