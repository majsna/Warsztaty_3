package pl.coderslab.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution {
	
	private int id = 0;
	private String description;
	private int userId;
	private int exerciseId;
	private String created;
	private String updated;

	public Solution() {
		
	}

	public Solution(int userId, int exerciseId) {
		setUserId(userId);
		setExerciseId(exerciseId);	
	}
	
	public String toString() {
		String sol = this.getId()+" "+this.getDescription();
		return sol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public Solution setDescription(String description) {
		this.description = description;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Solution setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public Solution setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
		return this;
	}
	
	public String getCreated() {
		return created;
	}

	public Solution setCreated(String created) {
		this.created = created;
		return this;
	}

	public String getUpdated() {
		return updated;
	}

	public Solution setUpdated(String updated) {
		this.updated = updated;
		return this;
	}
	


}
