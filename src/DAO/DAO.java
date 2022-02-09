package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pelicula;

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
	
	public static ArrayList<String> getPelicula() {
		ArrayList<String> PeliculasTabla = new ArrayList<>();
		
		try {
			
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT full_title FROM pelicula;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String name = rs.getString(1);

				PeliculasTabla.add(name);
			}
			
			
			return PeliculasTabla;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
	}
	
	
	public boolean getPeliculaTocho(String id) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM pelicula;";
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
		      stmt.setString (2, password);
		      stmt.setString (3, email);
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean inserpeliculas(Pelicula pelicula) {
		try {
			
			String sql = "INSERT INTO pelicula (id,title,year,duration,description,poster,valoration,director,full_title,image,type,release_date) values (?,?,?,?,?,?,?,?,?,?,?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,pelicula.id);
		      stmt.setString (2, pelicula.title);
		      stmt.setInt (3, pelicula.year);
		      stmt.setInt(4,pelicula.duration);
		      stmt.setString (5, pelicula.description);
		      stmt.setString (6, pelicula.poster);
		      stmt.setDouble (7, pelicula.valoration);
		      stmt.setString (8,pelicula.director);
		      stmt.setString (9,pelicula.fullTitle);
		      stmt.setString (10, pelicula.image);
		      stmt.setString (11, pelicula.type);
		      stmt.setString (12, pelicula.releaseDate);
		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
}