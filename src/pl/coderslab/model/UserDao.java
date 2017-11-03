package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public static List<User> loadAll(){
		
		List<User> users = new ArrayList<>();
		String query = "Select * from users;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);){
						
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					User tmpUser = new User(rs.getString(3),rs.getString(2),rs.getString(4),rs.getInt(5));
					tmpUser.setId(rs.getInt(1));//TODO rozwiązac problem z podwójnym szyfrowaniem hasła
					users.add(tmpUser);
				}
								
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Cos sie nie powiodło");
			}
			
		return users;
		
	}
	
	public static List<User> loadAllByGroupId(int grId){
		
		List<User> users = new ArrayList<>();
		String query = "Select * from users where person_group_id = ?;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);){
						
				st.setInt(1, grId);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					User tmpUser = new User(rs.getString(3),rs.getString(2),rs.getString(4),rs.getInt(5));
					tmpUser.setId(rs.getInt(1));//TODO rozwiązac problem z podwójnym szyfrowaniem hasła
					users.add(tmpUser);
				}
								
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Cos sie nie powiodło");
			}
				
		return users;
		
	}
	
	public static User loadUserById(int id) {
		
		User user = new User();
		String query = "Select * from users where id = ?;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);){
						
				st.setInt(1, id);
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					user = new User(rs.getString(3),rs.getString(2),rs.getString(4),rs.getInt(5));
					user.setId(rs.getInt(1));//TODO rozwiązac problem z podwójnym szyfrowaniem hasła
				}
								
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Cos sie nie powiodło");
			}
		
		return user;
	}
	
	public static void editUser(User user) {
		
		String query = "Update users set username = ? , email = ? , password = ? , person_group_id = ? where id = ?;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {
			
			st.setString(1, user.getUsername());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setInt(4, user.getGroupId());
			st.setInt(5, user.getId());
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Popsuło się.");
		}
		
	}
	
	public static void addUser(User user) {
		
		String query = "Insert into users values(null, ? , ? , ? , ? );";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {
			
			st.setString(1, user.getEmail());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.setInt(4, user.getGroupId());
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Popsuło się.");
		}
		
		
	}

}
