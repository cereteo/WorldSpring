package it.objectmethod.worldspring.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Icon;

import it.objectmethod.worldspring.dao.ICityDao;
import it.objectmethod.worldspring.dao.ICountryDao;
import it.objectmethod.worldspring.dao.impl.CityDaoImpl;
import it.objectmethod.worldspring.dao.impl.CountryDaoImpl;

public class MovFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] cities = request.getParameterValues("city");
		int[] citiesCode = new int[cities.length];
		
		for(int i=0; i<cities.length; i++) {
			citiesCode[i] = Integer.parseInt(cities[i].replaceAll("\\s+",""));
		}
		
		String codeTo = request.getParameter("nationTo");
		
		ICityDao cityDao = new CityDaoImpl();
		cityDao.movCities(codeTo, citiesCode);
		request.getRequestDispatcher("CitiesTable.jsp").forward(request, response);
	}
}