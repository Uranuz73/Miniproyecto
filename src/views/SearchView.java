package views;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import API.API;
import DAO.DAO;
import models.Actor;
import models.ActorFilm;
import models.Company;
import models.CompanyPelicula;
import models.Director;
import models.DirectorPelicula;
import models.GenreFilm;
import models.Genres;
import models.Pelicula;

public class SearchView {

	private JFrame frame;
	private JButton btnSerach_bar;
	private JButton btnlog_out;
	private JSONArray results;
	private JSONObject support;
	private JTable table;
	private JButton btnSerach_bar3;
	private JSONObject add;
	ArrayList<String> Resultados = new ArrayList<>();
	ArrayList<Pelicula> lista = new ArrayList <>();
	private JButton btnlog_out_1;


	public SearchView(String name) {
		this.results = API.Consulta(name);
		initialize();

		API.Consulta(name); 
	}

	
	
	private void initialize() {
		
		
		

		String[][] tabla = new String[results.length()][5];
		for (int i = 0; i < tabla.length; i++) {

				support = results.getJSONObject(i);
				
				tabla[i][0] = String.valueOf(i+1);
				tabla[i][1] = support.getString("image");
				tabla[i][2] = support.getString("title");
				tabla[i][3] = support.getString("description");
				
				
				Resultados.add(support.getString("id"));
				
				

		}

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100,100,1256,835);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(30, 30, 30, 200));
		table.setModel(new DefaultTableModel(
			tabla,
			new String[] {
				"Poster", "Titulo", "Year", "Add"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(156);
		table.getColumnModel().getColumn(2).setPreferredWidth(155);
		table.getColumnModel().getColumn(3).setPreferredWidth(243);
		table.setBounds(150, 46, 1031, 692);
		frame.getContentPane().add(table);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 30, 250));
		panel.setBounds(0, 0, 105, 796);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnSerach_bar = new JButton("Search");

		btnSerach_bar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = JOptionPane.showInputDialog("Type your film name");
				
				frame.setVisible(false);
				new SearchView(name);
				
			}
		});
		
		
		btnlog_out = new JButton("Logout");

		btnlog_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new LoginView();
			}
		});
		btnlog_out.setBounds(0, 708, 105, 65);
		panel.add(btnlog_out);
		btnSerach_bar.setBounds(0, 25, 105, 65);
		panel.add(btnSerach_bar);
		
		btnSerach_bar3 = new JButton("Add");
		btnSerach_bar3.setBounds(0, 119, 105, 65);
		panel.add(btnSerach_bar3);
		
		btnlog_out_1 = new JButton("Return");
		btnlog_out_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				
				new PeliculasView(0);
				
			}
		});
		btnlog_out_1.setBounds(0, 612, 105, 65);
		panel.add(btnlog_out_1);
		btnSerach_bar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> companies = new ArrayList<String>();
				
				ArrayList<String> actors = new ArrayList<String>();
				ArrayList<String> characters = new ArrayList<String>();
				
				ArrayList<String> directors = new ArrayList<String>();
				
				ArrayList<String> genres = new ArrayList<String>();
				
				String idaux = JOptionPane.showInputDialog("Introduzca el índice de la pelicula a añadir");
				System.out.println(Resultados.get(Integer.parseInt(idaux)-1));
				
				
				
				 add =  API.Consulta2(Resultados.get(Integer.parseInt(idaux)-1));
				System.out.println(add);
				
				
				String id = add.getString("id");	
				System.out.println(id);

				String title = add.getString("title");

				 Integer year = add.getInt("year");

				 Integer duration = add.getInt("runtimeMins");

				 String description = add.getString("plot");

				 String poster = add.getString("image");

				 Double valoration = Double.parseDouble(add.getString("imDbRating"));
				 								
				 JSONArray dir = (JSONArray) add.get("directorList");
				 
				 JSONObject dire = dir.getJSONObject(0);
				 
				 String director =dire.getString("name");
				 


				 String fullTitle = add.getString("fullTitle");

				 String image = add.getString("image");

				 String type = add.getString("type");

				 String releaseDate = add.getString("releaseDate");
				
				 
					Pelicula a = new Pelicula(id,title,year,duration,description,poster,valoration,director,fullTitle,image,type,releaseDate);
					System.out.println(a);

					DAO.insertpeliculas(a);
					
					JSONArray com = (JSONArray) add.get("companyList");

					for (int i = 0; i < com.length(); i++) {
						
						JSONObject comp = com.getJSONObject(i);
						
						String id_company = comp.getString("id");
						companies.add(id_company);
						String name_company = comp.getString("name");
						
						Company c = new Company(id_company,name_company);
						System.out.println(c);
						DAO.insertCompany(c);
						
					}
					
					for (int i = 0; i < companies.size(); i++) {
						
						CompanyPelicula cp = new CompanyPelicula(companies.get(i),id);
						
						DAO.insertCP(cp);
						
					}
					
					JSONArray direc = (JSONArray) add.get("directorList");
					
					for (int i = 0; i < direc.length(); i++) {
						
						JSONObject direct = direc.getJSONObject(i);
						
						String id_director = direct.getString("id");
						directors.add(id_director);
						String director_name = direct.getString("name");
						
						Director d = new Director (id_director,director_name);
						System.out.println(d);
						DAO.insertDirector(d);
						
					}
					
					for (int i = 0; i < directors.size(); i++) {
						
						DirectorPelicula dp = new DirectorPelicula(directors.get(i),id);
						
						DAO.insertDP(dp);
						
					}
					
					JSONArray act = (JSONArray) add.get("actorList");
					
					
					for (int i = 0; i < act.length(); i++) {
						
						JSONObject actr = act.getJSONObject(i);
						
						String id_actor = actr.getString("id");
						actors.add(id_actor);
						String actor_name = actr.getString("name");
						String actor_image = actr.getString("image");
						characters.add(actr.getString("asCharacter"));
						
						Actor d = new Actor (id_actor,actor_name,actor_image);
						
						System.out.println(d);
						DAO.insertActor(d);
						
					}
					
					for (int i = 0; i < actors.size(); i++) {
						
						ActorFilm ap = new ActorFilm(actors.get(i),id,characters.get(i));
						
						DAO.insertAP(ap);
						
					}
					
					JSONArray genr = (JSONArray) add.get("genreList");
					
					
					for (int i = 0; i < genr.length(); i++) {
						
						JSONObject genre = genr.getJSONObject(i);
						
						String id_genre = genre.getString("key");
						genres.add(id_genre);
						String genre_name = genre.getString("value");

						
						Genres g = new Genres (id_genre,genre_name);
						
						System.out.println(g);
						DAO.insertGenre(g);
						
					}
					
					for (int i = 0; i < genres.size(); i++) {
						
						GenreFilm ap = new GenreFilm(genres.get(i),id);
						
						DAO.insertGP(ap);
						
					}
					 
					
					
					
					
					
					
				
				
				
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg")));
		lblNewLabel.setBounds(0, 0, 1256, 796);
		frame.getContentPane().add(lblNewLabel);
	}
}
