package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDao;


@WebServlet("/EditExercise")
public class EditExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int exId = Integer.parseInt(request.getParameter("exId"));
		request.setAttribute("exId", exId);
		getServletContext().getRequestDispatcher("/formEditExercise.jsp").forward(request, response);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newTitle = request.getParameter("title");
		String newDescription = request.getParameter("description");
		int exId = Integer.parseInt(request.getParameter("exId"));				
		Exercise exercise = new Exercise(newTitle, newDescription);
		exercise.setId(exId);		
		ExerciseDao.edit(exercise);		
		response.sendRedirect("./AdminExercise");
		
	}

}
