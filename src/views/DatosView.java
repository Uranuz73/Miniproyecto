package views;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Pelicula;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DatosView {

	private JFrame frame;
	private Pelicula peli = null;
	
	public DatosView(Pelicula p) {
		
		this.peli = p;
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0,0,1920,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg"));
		ImageIcon imgSearch = new ImageIcon(PeliculasView.class.getResource("/images/search.jpg"));
		ImageIcon imgLogout = new ImageIcon(PeliculasView.class.getResource("/images/logout.jpg"));
		ImageIcon imgBack = new ImageIcon(PeliculasView.class.getResource("/images/back.jpg"));
		
		Color transparent = new Color(30, 30, 30, 250);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(transparent);
		panel.setBounds(0, 0, 105, 1080);
		frame.getContentPane().add(panel);
		Icon newimg = new ImageIcon(imgSearch.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
		

		
		JButton btnlog_out = new JButton("");
		btnlog_out.setBounds(23, 937, 56, 56);
		btnlog_out.setForeground(Color.WHITE);
		Icon imglogout = new ImageIcon(imgLogout.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
		btnlog_out.setIcon(imglogout);
		panel.add(btnlog_out);
		
		JButton btnback = new JButton("Back");
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new PeliculasView(0);
				frame.setVisible(false);
			}
		});
		btnback.setBounds(23, 853, 56, 56);
		btnback.setForeground(Color.WHITE);
		Icon iconback = new ImageIcon(imgBack.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
		btnback.setIcon(iconback);
		panel.add(btnback);
		
		JButton btnSearch = new JButton("");
		btnSearch.setBounds(23, 34, 56, 56);
		panel.add(btnSearch);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setIcon(newimg);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(138, 64, 1703, 889);
		panel_1.setBackground(transparent);

		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(peli.getFullTitle());
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(406, 44, 1198, 52);
		panel_1.add(lblTitulo);
		
		JLabel lblIcono = new JLabel("");
		ImageIcon img = descargar(peli.getImage());
		lblIcono.setBounds(45, 51, 220, 324);
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(lblIcono.getWidth(), lblIcono.getHeight(), Image.SCALE_DEFAULT));
		lblIcono.setIcon(icono);
		panel_1.add(lblIcono);
		
		JLabel lblDescripcion = new JLabel("<html>" + peli.getDescription());
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescripcion.setBounds(491, 135, 1113, 240);
		panel_1.add(lblDescripcion);
		
		JLabel lblRating = new JLabel("Rating: " +String.valueOf(peli.valoration) + " / 10");
		lblRating.setHorizontalAlignment(SwingConstants.LEFT);
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRating.setBounds(45, 418, 660, 59);
		panel_1.add(lblRating);
		
		JLabel lblDirector = new JLabel("Director: " + peli.director);
		lblDirector.setHorizontalAlignment(SwingConstants.LEFT);
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDirector.setBounds(45, 494, 660, 59);
		panel_1.add(lblDirector);
		
		JLabel lblDuracion = new JLabel("Duration: " +String.valueOf(peli.duration) + " mins.");
		lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDuracion.setBounds(45, 564, 660, 59);
		panel_1.add(lblDuracion);
		
		JLabel lblDate = new JLabel("Release Date: " +peli.releaseDate);
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(45, 646, 660, 59);
		panel_1.add(lblDate);
		
		JLabel lblType = new JLabel("Type: " +peli.type);
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblType.setBounds(45, 709, 660, 59);
		panel_1.add(lblType);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(10, 0, frame.getWidth(), frame.getHeight());
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		
		frame.getContentPane().add(lblFondo);
		lblFondo.setIcon(icon);
		
		
		
		
		
		
	}
	
	public ImageIcon descargar(String Url ) {
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
