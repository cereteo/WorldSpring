package it.objectmethod.worldspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.worldspring.dao.IContinentsDao;
import it.objectmethod.worldspring.model.Continents;

@Controller
public class ContinentsController {

	@Autowired
	private IContinentsDao continentsDao;
	
	@RequestMapping("/index")
	public String continents(ModelMap model) {
		List<Continents> continents = continentsDao.getAllContinents();
		model.addAttribute("continents", continents);
		return "Continents";
	}
}
