package pl.coderslab.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Group {
	
	private int id = 0;
	private String groupName;

	public Group() {
		
	}

	public Group(String groupName) {
		setGroupName(groupName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public Group setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	
	
}
