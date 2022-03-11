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

import DAO.DAO;
import models.Pelicula;

import javax.swing.SwingConstants;

public class PelifiltradaView {

	private JFrame frame;
	private JButton btnSerachAdd;
	private JButton btnlog_out;

	private ArrayList<String> PeliculasTabla = new ArrayList<>();
	private int pagina;

	
	public PelifiltradaView(int pagina, ArrayList<String> PeliculasTabla) {
		
		this.pagina = pagina;
		
		this.PeliculasTabla = PeliculasTabla;
		
		
		initialize();
		
		
	}


	private void initialize() {
		
	//TODO cambiar icono del mouse:
	//TODO https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_Ratio0.6762_AL_.jpg zoom
	//	https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_
	//TODO https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_QL75_UX75_CR0,0,75,100_.jpg chiquita

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0,0,1920,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon(PelifiltradaView.class.getResource("/images/cinefondobuena.jpg"));
		ImageIcon imgSearch = new ImageIcon(PelifiltradaView.class.getResource("/images/search.jpg"));
		ImageIcon imgSearchAdd = new ImageIcon(PelifiltradaView.class.getResource("/images/busquedaanyadir.jpg"));
		ImageIcon imgLogout = new ImageIcon(PelifiltradaView.class.getResource("/images/logout.jpg"));
		ImageIcon imgNew = new ImageIcon(PelifiltradaView.class.getResource("/images/add.jpg"));
		ImageIcon imgBack = new ImageIcon(PeliculasView.class.getResource("/images/back.jpg"));

		
		Color transparent = new Color(30, 30, 30, 250);
		frame.getContentPane().setLayout(null);
		
		
		
		

		
		JButton btnDetalles1 = new JButton("Mas detalles");
		btnDetalles1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String idpeli = PeliculasTabla.get(pagina);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
				
			}
		});
		
		JButton btnDetalles9 = new JButton("Mas detalles");
		btnDetalles9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+24);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles9.setBounds(1520, 856, 122, 23);
		frame.getContentPane().add(btnDetalles9);
		
		JButton btnDetalles8 = new JButton("Mas detalles");
		btnDetalles8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+21);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles8.setBounds(1520, 555, 122, 23);
		frame.getContentPane().add(btnDetalles8);
		
		JButton btnDetalles7 = new JButton("Mas detalles");
		btnDetalles7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+18);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles7.setBounds(1520, 262, 122, 23);
		frame.getContentPane().add(btnDetalles7);
		
		JButton btnDetalles6 = new JButton("Mas detalles");
		btnDetalles6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+15);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles6.setBounds(969, 856, 122, 23);
		frame.getContentPane().add(btnDetalles6);
		
		JButton btnDetalles5 = new JButton("Mas detalles");
		btnDetalles5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+12);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles5.setBounds(969, 555, 122, 23);
		frame.getContentPane().add(btnDetalles5);
		
		JButton btnDetalles4 = new JButton("Mas detalles");
		btnDetalles4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+9);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles4.setBounds(969, 262, 122, 23);
		frame.getContentPane().add(btnDetalles4);
		
		JButton btnDetalles3 = new JButton("Mas detalles");
		btnDetalles3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+6);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles3.setBounds(443, 856, 122, 23);
		frame.getContentPane().add(btnDetalles3);
		
		JButton btnDetalles2 = new JButton("Mas detalles");
		btnDetalles2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idpeli = PeliculasTabla.get(pagina+3);
				Pelicula peli = DAO.getPeliculaTocho(idpeli);
				new DatosView(peli);
				frame.setVisible(false);
			}
		});
		btnDetalles2.setBounds(443, 555, 122, 23);
		frame.getContentPane().add(btnDetalles2);
		btnDetalles1.setBounds(443, 262, 122, 23);
		frame.getContentPane().add(btnDetalles1);
		
		
		
		JButton btnNext = new JButton("Next >");
		
		
		if(pagina+26 >= PeliculasTabla.size()) {
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
				new PelifiltradaView(pagina, PeliculasTabla);
				
		
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
				new PelifiltradaView(pagina, PeliculasTabla);
				
				
			}
		});
		btnPrev.setBounds(802, 966, 122, 23);
		frame.getContentPane().add(btnPrev);
		
		
		if(PeliculasTabla.size() > pagina + 2) {
			
			ImageIcon img1 = descargar(PeliculasTabla.get(pagina+1));

			JPanel panel1 = new JPanel();
			panel1.setBounds(173, 44, 450, 260);
			panel1.setBackground(transparent);
			frame.getContentPane().add(panel1);
			panel1.setLayout(null);
			
			JLabel lblPeli1 = new JLabel("");
			lblPeli1.setBounds(10, 11, 178, 238);
			Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(lblPeli1.getWidth(), lblPeli1.getHeight(), Image.SCALE_DEFAULT));
			lblPeli1.setIcon(icono1);
			lblPeli1.repaint();
			panel1.add(lblPeli1);
			
			JLabel lblname1 = new JLabel(PeliculasTabla.get(pagina+2));
			lblname1.setHorizontalAlignment(SwingConstants.CENTER);
			lblname1.setForeground(Color.WHITE);
			lblname1.setBounds(198, 30, 242, 14);
			panel1.add(lblname1);
			
		}
		
		if(PeliculasTabla.size() > pagina + 5) {

		ImageIcon img2 = descargar(PeliculasTabla.get(pagina+4));

			
		JPanel panel2 = new JPanel();
		panel2.setBounds(173, 347, 450, 260);
		panel2.setBackground(transparent);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblPeli2 = new JLabel("");
		lblPeli2.setBounds(10, 11,178, 238);
		panel2.add(lblPeli2);
		Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(lblPeli2.getWidth(), lblPeli2.getHeight(), Image.SCALE_DEFAULT));
		lblPeli2.setIcon(icono2);
		
		JLabel lblname2 = new JLabel(PeliculasTabla.get(pagina+5));
		lblname2.setHorizontalAlignment(SwingConstants.CENTER);
		lblname2.setForeground(Color.WHITE);
		lblname2.setBounds(198, 38, 242, 14);
		panel2.add(lblname2);
		lblPeli2.repaint();
		
		
		}
		
		if(PeliculasTabla.size() > pagina + 8) {
		
			ImageIcon img3 = descargar(PeliculasTabla.get(pagina+7));

			
		JPanel panel3 = new JPanel();
		panel3.setBounds(173, 645, 450, 260);
		panel3.setBackground(transparent);
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);
		
		JLabel lblPeli3 = new JLabel("");
		lblPeli3.setBounds(10, 11, 178, 238);
		panel3.add(lblPeli3);
		Icon icono3 = new ImageIcon(img3.getImage().getScaledInstance(lblPeli3.getWidth(), lblPeli3.getHeight(), Image.SCALE_DEFAULT));
		lblPeli3.setIcon(icono3);
		
		JLabel lblname3 = new JLabel(PeliculasTabla.get(pagina+8));
		lblname3.setHorizontalAlignment(SwingConstants.CENTER);
		lblname3.setForeground(Color.WHITE);
		lblname3.setBounds(198, 42, 242, 14);
		panel3.add(lblname3);
		lblPeli3.repaint();
		
		

		
		}
		if(PeliculasTabla.size() > pagina + 11) {
			
			ImageIcon img4 = descargar(PeliculasTabla.get(pagina+10));

		
		JPanel panel4 = new JPanel();
		panel4.setBounds(723, 44, 450, 260);
		panel4.setBackground(transparent);
		frame.getContentPane().add(panel4);
		panel4.setLayout(null);
		
		JLabel lblPeli4 = new JLabel("");
		lblPeli4.setBounds(10, 11,178, 238);
		panel4.add(lblPeli4);
		Icon icono4 = new ImageIcon(img4.getImage().getScaledInstance(lblPeli4.getWidth(), lblPeli4.getHeight(), Image.SCALE_DEFAULT));
		lblPeli4.setIcon(icono4);
		
		JLabel lblname4 = new JLabel(PeliculasTabla.get(pagina+11));
		lblname4.setHorizontalAlignment(SwingConstants.CENTER);
		lblname4.setForeground(Color.WHITE);
		lblname4.setBounds(198, 39, 242, 14);
		panel4.add(lblname4);
		lblPeli4.repaint();
		
		

		}
		if(PeliculasTabla.size() > pagina + 14) {
			
			ImageIcon img5 = descargar(PeliculasTabla.get(pagina+13));

		
		JPanel panel5 = new JPanel();
		panel5.setBounds(723, 347, 450, 260);
		panel5.setBackground(transparent);
		frame.getContentPane().add(panel5);
		panel5.setLayout(null);
		
		JLabel lblPeli5 = new JLabel("");
		lblPeli5.setBounds(10, 11, 178, 238);
		panel5.add(lblPeli5);
		Icon icono5 = new ImageIcon(img5.getImage().getScaledInstance(lblPeli5.getWidth(), lblPeli5.getHeight(), Image.SCALE_DEFAULT));
		lblPeli5.setIcon(icono5);
		
		JLabel lblname5 = new JLabel(PeliculasTabla.get(pagina+14));
		lblname5.setHorizontalAlignment(SwingConstants.CENTER);
		lblname5.setForeground(Color.WHITE);
		lblname5.setBounds(198, 46, 242, 14);
		panel5.add(lblname5);
		lblPeli5.repaint();
		
		

		
		}
		if(PeliculasTabla.size() > pagina + 17) {
			
			ImageIcon img6 = descargar(PeliculasTabla.get(pagina+16));

		
		JPanel panel6 = new JPanel();
		panel6.setBounds(723, 645, 450, 260);
		panel6.setBackground(transparent);
		frame.getContentPane().add(panel6);
		panel6.setLayout(null);
		
		JLabel lblPeli6 = new JLabel("");
		lblPeli6.setBounds(10, 11, 178, 238);
		panel6.add(lblPeli6);
		Icon icono6 = new ImageIcon(img6.getImage().getScaledInstance(lblPeli6.getWidth(), lblPeli6.getHeight(), Image.SCALE_DEFAULT));
		lblPeli6.setIcon(icono6);
		
		JLabel lblname6 = new JLabel(PeliculasTabla.get(pagina+17));
		lblname6.setHorizontalAlignment(SwingConstants.CENTER);
		lblname6.setForeground(Color.WHITE);
		lblname6.setBounds(198, 44, 242, 14);
		panel6.add(lblname6);
		lblPeli6.repaint();
		
		

		
		}
		if(PeliculasTabla.size() > pagina + 20) {
		
			ImageIcon img7 = descargar(PeliculasTabla.get(pagina+19));

			
		JPanel panel7 = new JPanel();
		panel7.setBackground(transparent);
		panel7.setBounds(1269, 44, 450, 260);
		frame.getContentPane().add(panel7);
		panel7.setLayout(null);
		
		JLabel lblname7 = new JLabel(PeliculasTabla.get(pagina+20));
		lblname7.setHorizontalAlignment(SwingConstants.CENTER);
		lblname7.setForeground(Color.WHITE);
		lblname7.setBounds(202, 31, 238, 14);
		panel7.add(lblname7);
		
		JLabel lblPeli7 = new JLabel("");
		lblPeli7.setBounds(14, 11, 178, 238);
		panel7.add(lblPeli7);
		Icon icono7  = new ImageIcon(img7.getImage().getScaledInstance(lblPeli7.getWidth(), lblPeli7.getHeight(), Image.SCALE_DEFAULT));
		lblPeli7.setIcon(icono7);
		
		

		}
		if(PeliculasTabla.size() > pagina + 23) {
			
			ImageIcon img8 = descargar(PeliculasTabla.get(pagina+22));

		
		JPanel panel8 = new JPanel();
		panel8.setBackground(transparent);
		panel8.setBounds(1269, 347, 450, 260);
		frame.getContentPane().add(panel8);
		panel8.setLayout(null);
		
		JLabel lblname8 = new JLabel(PeliculasTabla.get(pagina+23));
		lblname8.setHorizontalAlignment(SwingConstants.CENTER);
		lblname8.setForeground(Color.WHITE);
		lblname8.setBounds(198, 38, 242, 14);
		panel8.add(lblname8);
		
		JLabel lblPeli8 = new JLabel("");
		lblPeli8.setBounds(10, 11, 178, 238);
		panel8.add(lblPeli8);
		Icon icono8 = new ImageIcon(img8.getImage().getScaledInstance(lblPeli8.getWidth(), lblPeli8.getHeight(), Image.SCALE_DEFAULT));
		lblPeli8.setIcon(icono8);
		
		

		}
		if(PeliculasTabla.size() > pagina + 26) {
		
			ImageIcon img9 = descargar(PeliculasTabla.get(pagina+25));

			
		JPanel panel9 = new JPanel();
		panel9.setBackground(transparent);
		panel9.setBounds(1269, 645, 450, 260);
		frame.getContentPane().add(panel9);
		panel9.setLayout(null);
		
		JLabel lblname9 = new JLabel(PeliculasTabla.get(pagina+26));
		lblname9.setHorizontalAlignment(SwingConstants.CENTER);
		lblname9.setForeground(Color.WHITE);
		lblname9.setBounds(198, 34, 242, 14);
		panel9.add(lblname9);
		
		JLabel lblPeli9 = new JLabel("");
		lblPeli9.setBounds(10, 11, 178, 238);
		panel9.add(lblPeli9);
		Icon icono9 = new ImageIcon(img9.getImage().getScaledInstance(lblPeli9.getWidth(), lblPeli9.getHeight(), Image.SCALE_DEFAULT));
		lblPeli9.setIcon(icono9);
		

		
		}
		

		

		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 105, 1020);
		panel.setBackground(transparent);
		frame.getContentPane().add(panel);
		
		JButton btnback= new JButton("");
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new PeliculasView(0);
				frame.setVisible(false);
			}
		});

		btnback.setBounds(22, 856, 56, 56);
		btnback.setForeground(Color.WHITE);
		Icon iconback = new ImageIcon(imgBack.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
		btnback.setIcon(iconback);
		panel.add(btnback);
		panel.add(btnback);
		
		btnlog_out = new JButton("");
		btnlog_out.setBounds(23, 937, 56, 56);
		btnlog_out.setForeground(Color.WHITE);
		Icon imglogout = new ImageIcon(imgLogout.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
		btnlog_out.setIcon(imglogout);
		
				btnlog_out.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.setVisible(false);
						new LoginView();
					}
				});
				
				
				
				btnSerachAdd = new JButton("");
				btnSerachAdd.setBounds(23, 22, 56, 56);
				btnSerachAdd.setForeground(Color.WHITE);
				Icon newimg = new ImageIcon(imgSearchAdd.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
				btnSerachAdd.setIcon(newimg);
				
					btnSerachAdd.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							String name = JOptionPane.showInputDialog("Type your film name");
							


							frame.setVisible(false);
							new SearchView(name,0);
						}
					});
					panel.setLayout(null);
					panel.add(btnSerachAdd);
					panel.add(btnlog_out);
					
					JButton btnSearch = new JButton("");
					btnSearch.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							String name = JOptionPane.showInputDialog("Search by name");
							
							DAO.filtrado(name);

							frame.setVisible(false);
							new SearchView(name,0);
						}
					});
					btnSearch.setForeground(Color.WHITE);
					btnSearch.setBounds(23, 106, 56, 56);
					panel.add(btnSearch);
					Icon imgsearch = new ImageIcon(imgSearch.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
					btnSearch.setIcon(imgsearch);
					
					JButton btnNew = new JButton("");
					btnNew.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							frame.setVisible(false);
							new CreateView();
						}
					});
					btnNew.setForeground(Color.WHITE);
					btnNew.setBounds(23, 191, 56, 56);
					panel.add(btnNew);
					Icon imgnew = new ImageIcon(imgNew.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
					btnNew.setIcon(imgnew);
					
					
					
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
}
