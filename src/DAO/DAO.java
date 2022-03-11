package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Actor;
import models.ActorFilm;
import models.Company;
import models.CompanyPelicula;
import models.Director;
import models.DirectorPelicula;
import models.GenreFilm;
import models.Genres;
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
			String sql = "SELECT id,image,full_title FROM pelicula;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String id = rs.getString(1);
				String url = rs.getString(2);
				String title = rs.getString(3);

				PeliculasTabla.add(id);
				PeliculasTabla.add(url);
				PeliculasTabla.add(title);
			}
			
			
			return PeliculasTabla;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
	}
	
	
	public static Pelicula getPeliculaTocho(String id) {
		Pelicula peli = null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM pelicula where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String idp = rs.getString(1);
				String titlep = rs.getString(2);
				int year = rs.getInt(3);
				int duration = rs.getInt(4);
				
				
				String desc = rs.getString(5);
				String poster = rs.getString(6);
				
				double valoration = rs.getDouble(7);
				
				String director = rs.getString(8);
				String full = rs.getString(9);
				String image = rs.getString(10);
				String type = rs.getString(11);
				String release = rs.getString(12);
				
				
				
				
				
				
				Pelicula p = new Pelicula(idp, titlep, year, duration, desc , poster, valoration, director, full, image, type, release) ;
				peli = p;
			}

			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return peli;
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
	
	public static boolean insertpeliculas(Pelicula pelicula) {
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
	
	
	public static boolean insertCompany(Company company) {
		try {
			
			String sql = "INSERT INTO company (idcompany,name) values (?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,company.idcompany);
		      stmt.setString (2,company.name);

		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean insertCP(CompanyPelicula cp) {
		try {
			
			String sql = "INSERT INTO company_pelicula (idcompany,id) values (?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,cp.companyid);
		      stmt.setString (2,cp.peliculaid);

		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean insertDirector(Director director) {
		try {
			
			String sql = "INSERT INTO director (iddirector,name) values (?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,director.iddirector);
		      stmt.setString (2,director.name);

		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean insertDP(DirectorPelicula dp) {
		try {
			
			String sql = "INSERT INTO director_pelicula (id,iddirector) values (?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,dp.peliculaid);
		      stmt.setString (2,dp.directorid);

		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean insertActor(Actor actor) {
		try {
			
			String sql = "INSERT INTO actor (idactor,name,image) values (?,?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,actor.idactor);
		      stmt.setString (2,actor.name);
		      stmt.setString(3, actor.image);

		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
		
		
		
	}
	
	public static boolean insertAP(ActorFilm ap) {
		try {
			
			String sql = "INSERT INTO actor_film (id,idactor,character_film) values (?,?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,ap.peliculaid);
		      stmt.setString (2,ap.actorid);
		      stmt.setString (3,ap.character);

		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean insertGenre(Genres genre) {
		try {
			
			String sql = "INSERT INTO genres (idgenre,name) values (?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,genre.idgenre);
		      stmt.setString (2,genre.name);

		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean insertGP(GenreFilm gp) {
		try {
			
			String sql = "INSERT INTO genre_film (idgenre,peliculaid) values (?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		      stmt.setString (1,gp.genres);
		      stmt.setString (2,gp.pelicula);


		      
		      

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	
	 public static ArrayList<ActorFilm> getActor (String id) {
	        ArrayList<ActorFilm> listaactores = new ArrayList<>();
	        
	        try {
	            Statement stmt = conn.createStatement();
	            String sql = "SELECT actor.name, actor.idactor, Actor_film.character_film, actor.image "+
	                      "FROM (pelicula join actor_film on pelicula.id = actor_film.id) join actor on actor_film.idactor = actor.idactor " +
	                      "where pelicula.id  ='" + id + "';";
	            
	            System.out.println(sql);
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()) {

	                String actorname = rs.getString(1);
	                String actorid = rs.getString(2);
	                String actorcharacter = rs.getString(3);
	                String imageActor = rs.getString(4); 
	                
	                
	                ActorFilm actor = new ActorFilm(id, actorid , actorcharacter, imageActor, actorname);
	                listaactores.add(actor);
	            }

	            

	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	        
	        return listaactores;
	    }
	 
	 
	 public static ArrayList<DirectorPelicula> getDirector (String id) {
         ArrayList<DirectorPelicula> listadirectores = new ArrayList<>();
         
         try {
             Statement stmt = conn.createStatement();
                 //cambiar estos datos por los campos de las tablas
             String sql = "SELECT director.name "+
                       "FROM (pelicula join director_pelicula on pelicula.id = director_pelicula.id) join director on director_pelicula.iddirector = director.iddirector " +
                       "where pelicula.id  ='" + id + "';";
             
             System.out.println(sql);
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()) {
             //los campos de la BD que da la query
                 String iddirector = rs.getString(1); 
                 
                                         //campos y cambiar el constructor para que entren
                 DirectorPelicula dire = new DirectorPelicula(iddirector,id );
                 listadirectores.add(dire);
                 System.out.println(dire);
             }

             

         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
         
         return listadirectores;
     }
	 
	 
	 
	 public static ArrayList<CompanyPelicula> getCompany (String id) {
         ArrayList<CompanyPelicula> listacompany = new ArrayList<>();
         
         try {
             Statement stmt = conn.createStatement();
                 //cambiar estos datos por los campos de las tablas
             String sql = "SELECT company.name "+
                       "FROM (pelicula join company_pelicula on pelicula.id = company_pelicula.id) join company on company_pelicula.idcompany = company.idcompany " +
                       "where pelicula.id  ='" + id + "';";
             
             System.out.println(sql);
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()) {
             //los campos de la BD que da la query
                 String name = rs.getString(1);
                 
                                         //campos y cambiar el constructor para que entren
                 CompanyPelicula comp = new CompanyPelicula(id, name);
                 listacompany.add(comp);
                 System.out.println(comp );
             }

             

         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
         
         return listacompany;
     }
	 
	 public static ArrayList<String> filtrado (String nombre) {
         ArrayList<String> listapelicula = new ArrayList<>();
         
         try {
             Statement stmt = conn.createStatement();
                 //cambiar estos datos por los campos de las tablas
             
             //TODO 
            String sql = "SELECT id,image,full_title FROM pelicula where title like '%" + nombre + "%';";

             
             System.out.println(sql);
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()) {

 				String id = rs.getString(1);
 				String url = rs.getString(2);
 				String title = rs.getString(3);

 				listapelicula.add(id);
 				listapelicula.add(url);
 				listapelicula.add(title);
                 
                                         
                
                 
                 	
             }



         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
         
         return listapelicula;

	 }
}