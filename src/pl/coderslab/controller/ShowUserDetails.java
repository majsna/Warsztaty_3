package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;


@WebServlet("/ShowUserDetails")
public class ShowUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		User user = UserDao.loadUserById(id);		
		List<Solution> solutions = SolutionDao.loadAllByUserId(id);
		request.setAttribute("solutions", solutions);
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/viewUser.jsp").forward(request, response);
	}

}
