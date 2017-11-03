package pl.coderslab.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class User {
	
	private int id = 0;
	private String username;
	private String email;
	protected String password;
	private int groupId;

	public User() {
		
	}

	public User(String username, String email, String password, int groupId) {
		setUsername(username);
		setEmail(email);
		setPassword(password);
		setGroupId(groupId);
	}
	
	public int getGroupId() {
		return groupId;
	}

	public User setGroupId(int groupId) {
		this.groupId = groupId;
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = BCrypt.hashpw(password,	BCrypt.gensalt());
		return this;
	}
	
	
}
