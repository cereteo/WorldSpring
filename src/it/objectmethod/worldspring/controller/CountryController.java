package it.objectmethod.worldspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.worldspring.dao.ICountryDao;
import it.objectmethod.worldspring.model.Country;

@Controller
public class CountryController {

	@Autowired
	private ICountryDao countryDao;
	
	@RequestMapping("/country/{code}")
	public String continents(@PathVariable("code") String continent, ModelMap model) {
		List<Country> country = countryDao.getAllCountryByContinent(continent);
		model.addAttribute("country", country);
		return "Country";
	}
}
