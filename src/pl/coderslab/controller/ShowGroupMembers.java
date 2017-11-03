package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;


@WebServlet("/ShowGroupMembers")
public class ShowGroupMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int grId = Integer.parseInt(request.getParameter("grId"));
		List<User>users = UserDao.loadAllByGroupId(grId);
		
		request.setAttribute("groupId", grId);
		request.setAttribute("users", users);
		getServletContext().getRequestDispatcher("/viewUsersByGroupId.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
