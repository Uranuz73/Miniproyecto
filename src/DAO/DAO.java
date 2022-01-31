package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO extends AbstractDAO {
	
	public DAO() {
		super();
	}
	
	public boolean login(String email, String password) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM usuario " + "WHERE email = '" + email + "'" + " AND password = '"
					+ password + "'";
			ResultSet rs = stmt.executeQuery(sql);

			return rs.next();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return false;
	}
	
	public boolean register(String name, String email, String password) {
		try {
			
			String sql = "INSERT INTO usuario (name,password,email) values (?,?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
		      stmt.setString (1, name);
		      stmt.setString (2, email);
		      stmt.setString (3, password);
		      

			stmt.execute();
			conn.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
}