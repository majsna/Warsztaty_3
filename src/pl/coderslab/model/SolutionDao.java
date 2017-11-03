package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {
	
	public static List<Solution> loadAll(int limit){
		
		List<Solution> solutions = new ArrayList<>();
		String query = "Select * from solution order by updated desc limit ?;";
		
		try(Connection conn = DbUtil.getConn();
			PreparedStatement st = conn.prepareStatement(query);){
					
			st.setInt(1, limit);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Solution tmpSol = new Solution(rs.getInt(5),rs.getInt(6));
				tmpSol.setId(rs.getInt(1));
				tmpSol.setCreated(rs.getString(2));
				tmpSol.setUpdated(rs.getString(3));
				tmpSol.setDescription(rs.getString(4));
				solutions.add(tmpSol);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cos sie nie powiodło");
		}
		
		return solutions;
	}
	
	public static Solution loadById(int id) {
		
		Solution solution = new Solution();
		String query = "Select * from solution where id = ?;";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);){
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				solution.setUserId(rs.getInt(5));
				solution.setExerciseId(rs.getInt(6));
				solution.setId(rs.getInt(1));
				solution.setCreated(rs.getString(2));
				solution.setUpdated(rs.getString(3));
				solution.setDescription(rs.getString(4));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cos sie nie powiodło");
		}
		
		return solution;
		
	}
	
	public static List<Solution> loadAllByUserId(int id){

		List<Solution> solutions = new ArrayList<>();
		String query = "Select * from solution where users_id = ? order by updated desc;";

		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);){

			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Solution tmpSol = new Solution(rs.getInt(5),rs.getInt(6));
				tmpSol.setId(rs.getInt(1));
				tmpSol.setCreated(rs.getString(2));
				tmpSol.setUpdated(rs.getString(3));
				tmpSol.setDescription(rs.getString(4));
				solutions.add(tmpSol);
			}


		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cos sie nie powiodło");
		}

		return solutions;
	}
	
	public static void add(Solution solution) {
		
		String query = "Insert into solution values(null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?, ? );";
		
		try(Connection conn = DbUtil.getConn();
				PreparedStatement st = conn.prepareStatement(query);) {
			
			st.setString(1, solution.getDescription());
			st.setInt(2, solution.getUserId());
			st.setInt(3, solution.getExerciseId());
			st.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Popsuło się.");
		}
		
		
	}

}
