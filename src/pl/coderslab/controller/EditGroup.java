package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.GroupDao;


@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String grId = request.getParameter("grId");
		request.setAttribute("grId", grId);
		getServletContext().getRequestDispatcher("/formEditGroups.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newName = request.getParameter("name");
		int grId = Integer.parseInt(request.getParameter("grId"));		
		GroupDao.editGroup(newName, grId);
		response.sendRedirect("./AdminGroup");

	}

}
