package it.objectmethod.worldspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.worldspring.dao.IContinentsDao;
import it.objectmethod.worldspring.model.Continents;

@Controller
public class HomeController {

	//	@RequestMapping("/index")
	//	@RequestMapping(value="/index", method=RequestMethod.GET) 
	
	@Autowired
	private IContinentsDao continentsDao;
	
	@RequestMapping("/index")
	public String continents(ModelMap model) {
		List<Continents> continents = continentsDao.getAllContinents();
		model.addAttribute("continents", continents);
		return "Continents";
	}
	
//	@GetMapping("/welcome")
//	public String welcomePage(ModelMap model) {
//		
//		model.addAttribute("benvenuto", "Benvenuto nella pagina di tutorial!!");
//		return "main";
//	}
//	
//	@GetMapping("/pagina/{numeroPagina}")
//	public String paginaNumerata(@PathVariable("numeroPagina") Integer numero, ModelMap model) {
//		model.addAttribute("num", numero);
//		return "pagina";
//	}
//	
//	@PostMapping("/login")
//	public String login(@RequestParam("username") String username, ModelMap model) {
//		model.addAttribute("user", username);
//		return "forward:/landing-control";
//	}
//	
//	@RequestMapping("/landing-control")
//	public String landingCheck(ModelMap model) {
//		model.addAttribute("passato", "Sono passato da landing!");
//		return "landing";
//	}
	

}
