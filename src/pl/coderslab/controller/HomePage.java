package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;



@WebServlet(urlPatterns = "/home", initParams = 
	{ @WebInitParam(name = "number-solutions", value = "5") })
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int limit = Integer.parseInt(getInitParameter("number-solutions"));
		
		List<Solution> solutions = SolutionDao.loadAll(limit);
		
		request.setAttribute("solutions", solutions); 
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}