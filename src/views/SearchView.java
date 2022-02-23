package views;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
import java.awt.Font;
import javax.swing.SwingConstants;

public class SearchView {

	private JFrame frame;
	private JButton btnSerach_bar;
	private JButton btnlog_out;
	private JSONArray results;
	private JSONObject support;
	private JButton btnSerach_bar3;
	private JSONObject add;
	//ArrayList<String> Resultados = new ArrayList<>();
	ArrayList<Pelicula> lista = new ArrayList <>();
	private JButton btnlog_out_1;
	private int pagina;
	Color transparent = new Color(30, 30, 30, 250);
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblName_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblImg_1;
	private JLabel lblImg_2;
	private JLabel lblImg_3;
	private JLabel lblImg_4;
	private JLabel lblImg_5;
	private JLabel lblImg_6;
	private JLabel lblImg_7;
	private JLabel lblImg_8;
	private JLabel lblImg_9;
	private JButton btnAdd_1;
	private JButton btnAdd_2;
	private JButton btnAdd_3;
	private JButton btnAdd_4;
	private JButton btnAdd_5;
	private JButton btnAdd_6;
	private JButton btnAdd_7;
	private JButton btnAdd_8;
	private JButton btnAdd_9;



	public SearchView(String name, int pagina) {
		this.pagina = pagina;
		this.results = API.Consulta(name);
		initialize();

		API.Consulta(name); 
	}

	
	
	private void initialize() {
		
		ImageIcon image = new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg"));
		
		int size = results.length();
		
		String[][] tabla = new String[size][3];
		for (int i = 0; i < tabla.length; i++) {

				support = results.getJSONObject(i);
				
				tabla[i][0] = support.getString("image");
				tabla[i][1] = support.getString("title");
				tabla[i][2] = support.getString("id");
				
				
		//		Resultados.add(support.getString("id"));
				
				

		}

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0,0,1920,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		if(size > 8+pagina) {
			panel_9 = new JPanel();
			panel_9.setBackground(new Color(30, 30, 30, 250));
			panel_9.setBounds(1224, 687, 450, 260);
			frame.getContentPane().add(panel_9);
			panel_9.setLayout(null);
			
			lblNewLabel_9 = new JLabel(tabla[pagina+8][1]);
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setForeground(Color.WHITE);
			lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_9.setBounds(213, 23, 227, 25);
			panel_9.add(lblNewLabel_9);
			
			ImageIcon img9 = descargar(tabla[pagina+8][0]);

			lblImg_9 = new JLabel("");
			lblImg_9.setBounds(10, 11, 178, 229);
			Icon icono9 = new ImageIcon(img9.getImage().getScaledInstance(lblImg_9.getWidth(), lblImg_9.getHeight(), Image.SCALE_DEFAULT));
			lblImg_9.setIcon(icono9);
			panel_9.add(lblImg_9);
			
			btnAdd_9 = new JButton("Add");
			btnAdd_9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					add(tabla[pagina+8][2]);

				}
			});
			btnAdd_9.setBounds(266, 217, 89, 23);
			panel_9.add(btnAdd_9);
		}
		if(size > 7+pagina) {
			panel_8 = new JPanel();
			panel_8.setBackground(new Color(30, 30, 30, 250));
			panel_8.setBounds(1224, 364, 450, 260);
			frame.getContentPane().add(panel_8);
			panel_8.setLayout(null);
			
			lblNewLabel_8 = new JLabel(tabla[pagina+7][1]);
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setForeground(Color.WHITE);
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_8.setBounds(213, 25, 227, 25);
			panel_8.add(lblNewLabel_8);
			
			ImageIcon img8 = descargar(tabla[pagina+7][0]);

			lblImg_8 = new JLabel("");
			lblImg_8.setBounds(10, 11, 178, 229);
			Icon icono8 = new ImageIcon(img8.getImage().getScaledInstance(lblImg_8.getWidth(), lblImg_8.getHeight(), Image.SCALE_DEFAULT));
			lblImg_8.setIcon(icono8);
			panel_8.add(lblImg_8);
			
			btnAdd_8 = new JButton("Add");
			btnAdd_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					add(tabla[pagina+7][2]);

				}
			});
			btnAdd_8.setBounds(280, 214, 89, 23);
			panel_8.add(btnAdd_8);
			
		}
		
		if(size > 6+pagina) {
			panel_7 = new JPanel();
			panel_7.setBackground(new Color(30, 30, 30, 250));
			panel_7.setBounds(1224, 44, 450, 260);
			frame.getContentPane().add(panel_7);
			panel_7.setLayout(null);
			
			lblNewLabel_7 = new JLabel(tabla[pagina+6][1]);
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setForeground(Color.WHITE);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_7.setBounds(213, 22, 227, 25);
			panel_7.add(lblNewLabel_7);
			
			ImageIcon img7 = descargar(tabla[pagina+6][0]);

			lblImg_7 = new JLabel("");
			lblImg_7.setBounds(10, 11, 178, 229);
			Icon icono7 = new ImageIcon(img7.getImage().getScaledInstance(lblImg_7.getWidth(), lblImg_7.getHeight(), Image.SCALE_DEFAULT));
			lblImg_7.setIcon(icono7);
			panel_7.add(lblImg_7);
			
			btnAdd_7 = new JButton("Add");
			btnAdd_7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					add(tabla[pagina+6][2]);

				}
			});
			btnAdd_7.setBounds(271, 226, 89, 23);
			panel_7.add(btnAdd_7);
		}
		
		
		
		
if(size > 5+pagina) {
	panel_6 = new JPanel();
	panel_6.setBackground(new Color(30, 30, 30, 250));
	panel_6.setBounds(685, 687, 450, 260);
	frame.getContentPane().add(panel_6);
	panel_6.setLayout(null);
	
	lblNewLabel_6 = new JLabel(tabla[pagina+5][1]);
	lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_6.setForeground(Color.WHITE);
	lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_6.setBounds(213, 30, 227, 25);
	panel_6.add(lblNewLabel_6);
	
	ImageIcon img6 = descargar(tabla[pagina+5][0]);

	lblImg_6 = new JLabel("");
	lblImg_6.setBounds(10, 11, 178, 229);
	panel_6.add(lblImg_6);
	Icon icono6 = new ImageIcon(img6.getImage().getScaledInstance(lblImg_6.getWidth(), lblImg_6.getHeight(), Image.SCALE_DEFAULT));
	lblImg_6.setIcon(icono6);
	
	btnAdd_6 = new JButton("Add");
	btnAdd_6.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			add(tabla[pagina+5][2]);

		}
	});
	btnAdd_6.setBounds(285, 217, 89, 23);
	panel_6.add(btnAdd_6);
		}
		
		
		
if(size > 4+pagina) {
	panel_5 = new JPanel();
	panel_5.setBackground(new Color(30, 30, 30, 250));
	panel_5.setBounds(685, 364, 450, 260);
	frame.getContentPane().add(panel_5);
	panel_5.setLayout(null);
	
	lblNewLabel_5 = new JLabel(tabla[pagina+4][1]);
	lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_5.setForeground(Color.WHITE);
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_5.setBounds(213, 31, 227, 25);
	panel_5.add(lblNewLabel_5);
	
	ImageIcon img5 = descargar(tabla[pagina+4][0]);

	lblImg_5 = new JLabel("");
	lblImg_5.setBounds(10, 11, 178, 229);
	Icon icono5 = new ImageIcon(img5.getImage().getScaledInstance(lblImg_5.getWidth(), lblImg_5.getHeight(), Image.SCALE_DEFAULT));
	lblImg_5.setIcon(icono5);
	panel_5.add(lblImg_5);
	
	btnAdd_5 = new JButton("Add");
	btnAdd_5.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			add(tabla[pagina+4][2]);
		}
	});
	btnAdd_5.setBounds(288, 226, 89, 23);
	panel_5.add(btnAdd_5);
	
	
		}
		
		
if(size > 3+pagina) {
	panel_4 = new JPanel();
	panel_4.setBackground(new Color(30, 30, 30, 250));
	panel_4.setBounds(685, 44, 450, 260);
	frame.getContentPane().add(panel_4);
	panel_4.setLayout(null);
	
	lblNewLabel_4 = new JLabel(tabla[pagina+3][1]);
	lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_4.setForeground(Color.WHITE);
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_4.setBounds(201, 25, 227, 25);
	panel_4.add(lblNewLabel_4);
	
	ImageIcon img4 = descargar(tabla[pagina+3][0]);

	lblImg_4 = new JLabel("");
	lblImg_4.setBounds(13, 11, 178, 229);
	Icon icono4 = new ImageIcon(img4.getImage().getScaledInstance(lblImg_4.getWidth(), lblImg_4.getHeight(), Image.SCALE_DEFAULT));
	lblImg_4.setIcon(icono4);
	panel_4.add(lblImg_4);
	
	btnAdd_4 = new JButton("Add");
	btnAdd_4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			add(tabla[pagina+3][2]);
		}
	});
	btnAdd_4.setBounds(275, 226, 89, 23);
	panel_4.add(btnAdd_4);
		}

		
		
		
if(size > 2+pagina) {
	panel_3 = new JPanel();
	panel_3.setBackground(new Color(30, 30, 30, 250));
	panel_3.setBounds(173, 687, 450, 260);
	frame.getContentPane().add(panel_3);
	panel_3.setLayout(null);
	
	lblNewLabel_3 = new JLabel(tabla[pagina+2][1]);
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_3.setForeground(Color.WHITE);
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_3.setBounds(213, 30, 227, 25);
	panel_3.add(lblNewLabel_3);
	
	ImageIcon img3 = descargar(tabla[pagina+2][0]);
	lblImg_3 = new JLabel("");
	lblImg_3.setBounds(10, 11, 178, 229);
	Icon icono3 = new ImageIcon(img3.getImage().getScaledInstance(lblImg_3.getWidth(), lblImg_3.getHeight(), Image.SCALE_DEFAULT));
	lblImg_3.setIcon(icono3);
	panel_3.add(lblImg_3);
	
	btnAdd_3 = new JButton("Add");
	btnAdd_3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			add(tabla[pagina+2][2]);
		}
	});
	btnAdd_3.setBounds(274, 217, 89, 23);
	panel_3.add(btnAdd_3);
		}

		
		
if(size > 1+pagina) {
	panel_2 = new JPanel();
	panel_2.setBackground(new Color(30, 30, 30, 250));
	panel_2.setBounds(173, 364, 450, 260);
	frame.getContentPane().add(panel_2);
	panel_2.setLayout(null);
	
	
	lblNewLabel_2 = new JLabel(tabla[pagina+1][1]);
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setForeground(Color.WHITE);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_2.setBounds(196, 31, 227, 25);
	panel_2.add(lblNewLabel_2);
	
	ImageIcon img2 = descargar(tabla[pagina+1][0]);
	lblImg_2 = new JLabel("");
	lblImg_2.setBounds(10, 11, 178, 229);
	Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(lblImg_2.getWidth(), lblImg_2.getHeight(), Image.SCALE_DEFAULT));
	lblImg_2.setIcon(icono2);
	panel_2.add(lblImg_2);
	
	btnAdd_2 = new JButton("Add");
	btnAdd_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			add(tabla[pagina+1][2]);
		}
	});
	btnAdd_2.setBounds(271, 217, 89, 23);
	panel_2.add(btnAdd_2);
		}


	
		
if(size > pagina) {
	
	panel_1 = new JPanel();
	panel_1.setBounds(173, 44, 450, 260);
	panel_1.setBackground(transparent);
	frame.getContentPane().add(panel_1);
	panel_1.setLayout(null);
	
	ImageIcon img1 = descargar(tabla[pagina+0][0]);
	lblImg_1 = new JLabel("");
	lblImg_1.setBounds(10, 11, 178, 229);
	Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(lblImg_1.getWidth(), lblImg_1.getHeight(), Image.SCALE_DEFAULT));
	lblImg_1.setIcon(icono1);
	panel_1.add(lblImg_1);
	
	lblName_1 = new JLabel(tabla[pagina+0][1]);
	lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblName_1.setForeground(Color.WHITE);
	lblName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName_1.setBounds(196, 27, 227, 25);
	panel_1.add(lblName_1);
	
	btnAdd_1 = new JButton("Add");
	btnAdd_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			add(tabla[pagina][2]);
		}
	});
	btnAdd_1.setBounds(264, 226, 89, 23);
	panel_1.add(btnAdd_1);
	
		}





JButton btnNext = new JButton("Next >");


if(pagina+26 >= size) {
	btnNext.setEnabled(false);
	btnNext.setVisible(false);
}else {
	btnNext.setEnabled(true);
	btnNext.setVisible(true);


}

btnNext.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		
			
		frame.setVisible(false);
		pagina+=27;
		new PeliculasView(pagina);
		

	}
});
btnNext.setBounds(969, 966, 122, 23);
frame.getContentPane().add(btnNext);

JButton btnPrev = new JButton("< Previous");

if(pagina == 0) {
	btnPrev.setEnabled(false);
	btnPrev.setVisible(false);
}else {
	btnPrev.setEnabled(true);
	btnPrev.setVisible(true);


}

btnPrev.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		frame.setVisible(false);
		pagina-=27;
		new PeliculasView(pagina);
		
		
	}
});
btnPrev.setBounds(802, 966, 122, 23);
frame.getContentPane().add(btnPrev);

		
		


		
//		table = new JTable();
//		table.setForeground(Color.WHITE);
//		table.setBackground(new Color(30, 30, 30, 200));
//		table.setModel(new DefaultTableModel(
//			tabla,
//			new String[] {
//				"Poster", "Titulo", "Year", "Add"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Object.class, String.class, Integer.class, Object.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		table.getColumnModel().getColumn(0).setPreferredWidth(30);
//		table.getColumnModel().getColumn(0).setMinWidth(40);
//		table.getColumnModel().getColumn(1).setPreferredWidth(156);
//		table.getColumnModel().getColumn(2).setPreferredWidth(155);
//		table.getColumnModel().getColumn(3).setPreferredWidth(243);
//		table.setBounds(150, 46, 1031, 692);
//		frame.getContentPane().add(table);

		
		JPanel panel = new JPanel();
		panel.setBackground(transparent);
		panel.setBounds(0, 0, 105, 1030);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnSerach_bar = new JButton("Search");

		btnSerach_bar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = JOptionPane.showInputDialog("Type your film name");
				
				frame.setVisible(false);
				new SearchView(name,0);
				
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
		btnlog_out.setBounds(0, 935, 105, 65);
		panel.add(btnlog_out);
		btnSerach_bar.setBounds(0, 25, 105, 65);
		panel.add(btnSerach_bar);
		
//		btnSerach_bar3 = new JButton("Add");
//		btnSerach_bar3.setBounds(0, 119, 105, 65);
//		panel.add(btnSerach_bar3);
		
		btnlog_out_1 = new JButton("Return");
		btnlog_out_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				
				new PeliculasView(0);
				
			}
		});
		btnlog_out_1.setBounds(0, 840, 105, 65);
		panel.add(btnlog_out_1);
		
		
		
		
		
		//TODO pasar lo que hacia el boton de añadir a una funcion ADD
		
		
		
//		btnSerach_bar3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ArrayList<String> companies = new ArrayList<String>();
//				
//				ArrayList<String> actors = new ArrayList<String>();
//				ArrayList<String> characters = new ArrayList<String>();
//				
//				ArrayList<String> directors = new ArrayList<String>();
//				
//				ArrayList<String> genres = new ArrayList<String>();
//				
//				String idaux = JOptionPane.showInputDialog("Introduzca el índice de la pelicula a añadir");
//				System.out.println(Resultados.get(Integer.parseInt(idaux)-1));
//				
//				
//				
//				 add =  API.Consulta2(Resultados.get(Integer.parseInt(idaux)-1));
//				System.out.println(add);
//				
//				
//				String id = add.getString("id");	
//
//				String title = add.getString("title");
//
//				 Integer year = add.getInt("year");
//
//				 Integer duration = add.getInt("runtimeMins");
//
//				 String description = add.getString("plot");
//
//				 String poster = add.getString("image");
//
//				 Double valoration = Double.parseDouble(add.getString("imDbRating"));
//				 								
//				 JSONArray dir = (JSONArray) add.get("directorList");
//				 
//				 JSONObject dire = dir.getJSONObject(0);
//				 
//				 String director =dire.getString("name");
//				 
//
//				 String fullTitle = add.getString("fullTitle");
//
//				 String image = add.getString("image");
//
//				 String type = add.getString("type");
//
//				 String releaseDate = add.getString("releaseDate");
//				
//				 
//					Pelicula a = new Pelicula(id,title,year,duration,description,poster,valoration,director,fullTitle,image,type,releaseDate);
//					System.out.println(a);
//
//					DAO.insertpeliculas(a);
//					
//					JSONArray com = (JSONArray) add.get("companyList");
//
//					for (int i = 0; i < com.length(); i++) {
//						
//						JSONObject comp = com.getJSONObject(i);
//						
//						String id_company = comp.getString("id");
//						companies.add(id_company);
//						String name_company = comp.getString("name");
//						
//						Company c = new Company(id_company,name_company);
//						System.out.println(c);
//						DAO.insertCompany(c);
//						
//					}
//					
//					for (int i = 0; i < companies.size(); i++) {
//						
//						CompanyPelicula cp = new CompanyPelicula(companies.get(i),id);
//						
//						DAO.insertCP(cp);
//						
//					}
//					
//					JSONArray direc = (JSONArray) add.get("directorList");
//					
//					for (int i = 0; i < direc.length(); i++) {
//						
//						JSONObject direct = direc.getJSONObject(i);
//						
//						String id_director = direct.getString("id");
//						directors.add(id_director);
//						String director_name = direct.getString("name");
//						
//						Director d = new Director (id_director,director_name);
//						System.out.println(d);
//						DAO.insertDirector(d);
//						
//					}
//					
//					for (int i = 0; i < directors.size(); i++) {
//						
//						DirectorPelicula dp = new DirectorPelicula(directors.get(i),id);
//						
//						DAO.insertDP(dp);
//						
//					}
//					
//					JSONArray act = (JSONArray) add.get("actorList");
//					
//					
//					for (int i = 0; i < act.length(); i++) {
//						
//						JSONObject actr = act.getJSONObject(i);
//						
//						String id_actor = actr.getString("id");
//						actors.add(id_actor);
//						String actor_name = actr.getString("name");
//						String actor_image = actr.getString("image");
//						characters.add(actr.getString("asCharacter"));
//						
//						Actor d = new Actor (id_actor,actor_name,actor_image);
//						
//						System.out.println(d);
//						DAO.insertActor(d);
//						
//					}
//					
//					for (int i = 0; i < actors.size(); i++) {
//						
//						ActorFilm ap = new ActorFilm(actors.get(i),id,characters.get(i));
//						
//						DAO.insertAP(ap);
//						
//					}
//					
//					JSONArray genr = (JSONArray) add.get("genreList");
//					
//					
//					for (int i = 0; i < genr.length(); i++) {
//						
//						JSONObject genre = genr.getJSONObject(i);
//						
//						String id_genre = genre.getString("key");
//						genres.add(id_genre);
//						String genre_name = genre.getString("value");
//
//						
//						Genres g = new Genres (id_genre,genre_name);
//						
//						System.out.println(g);
//						DAO.insertGenre(g);
//						
//					}
//					
//					for (int i = 0; i < genres.size(); i++) {
//						
//						GenreFilm ap = new GenreFilm(genres.get(i),id);
//						
//						DAO.insertGP(ap);
//						
//					}
//			}
//		});
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(icon);
		frame.getContentPane().add(lblFondo);
	}
	
	 ImageIcon descargar(String Url ) {
		ImageIcon image=null;
		try {
			URL url  = new URL(Url);
			URLConnection urlcon;
			try {
				urlcon = url.openConnection();
				
				InputStream is = urlcon.getInputStream();
				
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				
				byte[] buf = new byte[1024];
				int n = 0;
				while (-1!=(n=is.read(buf)))
				{
				   out.write(buf, 0, n);
				}
				
				out.close();
				is.close();
				byte[] response = out.toByteArray();
				
				
				 image = new ImageIcon(response);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		
		return image;
		
	}
	 
	 private void add(String id) {
		 //TODO add
	 }
	 
	 
	 
}
