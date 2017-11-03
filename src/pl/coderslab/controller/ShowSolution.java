package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;


@WebServlet("/ShowSolution")
public class ShowSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));	
		Solution sol = SolutionDao.loadById(id);
		List<Solution> solutions = new ArrayList<>();
		solutions.add(sol);
		
		request.setAttribute("solutions", solutions); 
        getServletContext().getRequestDispatcher("/solutionDetails.jsp").forward(request, response);
	}
	

}
