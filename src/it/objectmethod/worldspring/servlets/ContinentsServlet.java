package it.objectmethod.worldspring.servlets;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.worldspring.dao.ICityDao;
import it.objectmethod.worldspring.dao.IContinentsDao;
import it.objectmethod.worldspring.dao.ICountryDao;
import it.objectmethod.worldspring.dao.impl.CityDaoImpl;
import it.objectmethod.worldspring.dao.impl.ContinentsDaoImpl;
import it.objectmethod.worldspring.dao.impl.CountryDaoImpl;
import it.objectmethod.worldspring.model.City;
import it.objectmethod.worldspring.model.Continents;
import it.objectmethod.worldspring.model.Country;

public class ContinentsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		IContinentsDao continentsDao = new ContinentsDaoImpl();
		List<Continents> continents = continentsDao.getAllContinents();
		request.setAttribute("continents", continents);
		request.getRequestDispatcher("TableDB.jsp").forward(request, response);
	}

} 
