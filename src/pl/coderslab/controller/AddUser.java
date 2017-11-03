package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;


@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newName = request.getParameter("newName");
		String newEmail = request.getParameter("newMail");
		int newGroup = Integer.parseInt(request.getParameter("newGroup"));
		String newPassword = request.getParameter("newPassword");
		
		User newUser = new User(newName, newEmail, newPassword, newGroup);
		UserDao.addUser(newUser);
		response.sendRedirect("./AdminUser");

	}

}
