package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.GroupDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;


@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("id");
		request.setAttribute("userId", userId);
		getServletContext().getRequestDispatcher("/formEditUser.jsp").forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newName = request.getParameter("newName");
		String newEmail = request.getParameter("newEmail");
		int newGroup = Integer.parseInt(request.getParameter("newGroup"));
		String newPassword = request.getParameter("newPassword");
		int userId = Integer.parseInt(request.getParameter("id"));
		
		User newUser = new User(newName, newEmail, newPassword, newGroup);
		newUser.setId(userId);
		
		UserDao.editUser(newUser);
		
		response.sendRedirect("./AdminUser");
		
	}

}
