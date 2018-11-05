package it.objectmethod.worldspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.worldspring.dao.ICityDao;
import it.objectmethod.worldspring.model.City;
import it.objectmethod.worldspring.model.Country;

@Controller
public class CitiesController {

	@Autowired
	private ICityDao cityDao;
	@Autowired
	CountryController countrycontroller;
	
	@RequestMapping("/cities/{code}")
	public String citiesByCountry(@PathVariable("code") String country, ModelMap model) {
		List<City> cities = cityDao.getAllCities(country);
		model.addAttribute("cities", cities);
		return "Cities";
	}
	
	@RequestMapping("/add-city")
	public String addingCity(ModelMap model) {
		List<Country> country = countrycontroller.allCountry();
		model.addAttribute("country", country);
		return "cityForm";
	}
	
	@RequestMapping("{countryCode}/del-city/{code}")
	public String deleteCity(@PathVariable("code") int id, @PathVariable("countryCode") String countryCode, ModelMap model) {
		boolean isDel = cityDao.delCity(id);
		System.out.println("cc"+countryCode);
		return "Cities";
	}
	
	@RequestMapping("/mod-city/{code}")
	public String modifyCity(@PathVariable("code") int id, ModelMap model) {
		
		City cities = cityDao.getCityById(id);
		List<Country> country = countrycontroller.allCountry();
		
		model.addAttribute("country", country);
		model.addAttribute("city", cities);
		return "cityForm";
	}
}
