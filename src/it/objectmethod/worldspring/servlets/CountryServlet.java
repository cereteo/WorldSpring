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

public class CountryServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String continent = (request.getParameter("selectedContinent") != null) ? request.getParameter("selectedContinent"): (String) session.getAttribute("selectedContinent");
		if(continent != null) {
			session.setAttribute("selectedContinent", continent);
		};

		ICountryDao countryDao = new CountryDaoImpl();
		List<Country> country = (continent == null)? null : countryDao.getAllCountryByContinent(continent);
		
		request.setAttribute("selectedContinent", continent);
		request.setAttribute("country", country);
		request.getRequestDispatcher("CountryTable.jsp").forward(request, response);
		

	}
}
