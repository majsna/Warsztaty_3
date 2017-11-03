package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {
	
	public static List<Group> loadAll() {
		
		List<Group> groups = new ArrayList<>();
		String query = "Select * from user_group;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Group tmpGr = new Group(rs.getString(2));
				tmpGr.setId(rs.getInt(1));
				groups.add(tmpGr);
			}
			
		}catch(SQLException e) {
			System.out.println("Popsuło się.");
		}
				
		return groups;
	}
	
	public static void editGroup(String newName , int grId) {
		
		String query = "Update user_group set name = ? where id = ? ;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {
			
			st.setString(1, newName);
			st.setInt(2, grId);
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Popsuło się.");
		}
		
	}
	
	public static void addGroup(String newName) {
			
		String query = "Insert into user_group values(null, ?);";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {
			
			st.setString(1, newName);
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Popsuło się.");
		}
					
	}

	
	
}
