package pl.coderslab.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Exercise {
	
	private int id = 0;
	private String title;
	private String description;

	public Exercise() {
		
	}

	public Exercise(String title, String description) {
		setTitle(title);
		setDescription(description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public Exercise setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Exercise setDescription(String description) {
		this.description = description;
		return this;
	}
	
	
}
