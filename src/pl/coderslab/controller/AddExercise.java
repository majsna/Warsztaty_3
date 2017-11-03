package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDao;
import pl.coderslab.model.GroupDao;


@WebServlet("/AddExercise")
public class AddExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Exercise exercise = new Exercise(title, description);
		ExerciseDao.add(exercise);		
		response.sendRedirect("./AdminExercise");
		
	}

}
