package views;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
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
import javax.swing.SwingConstants;

public class PeliculasView {

	private JFrame frame;
	private JButton btnSerach;
	private JButton btnlog_out;

	private ArrayList<String> PeliculasTabla = new ArrayList<>();


	
	public PeliculasView() {
		
		this.PeliculasTabla = DAO.getPelicula();
		
		
		initialize();
		
		
	}


	private void initialize() {
		
	//TODO cambiar icono del mouse:
	//TODO https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_Ratio0.6762_AL_.jpg zoom
	//	https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_
	//TODO https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_QL75_UX75_CR0,0,75,100_.jpg chiquita
for (int i = 0; i < PeliculasTabla.size()-1; i=i+3) {
	String a = PeliculasTabla.get(i);
	String b = PeliculasTabla.get(i+1);
	
	descargar(a,b);
	
}
		frame = new JFrame();
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
		ImageIcon img1 = new ImageIcon("src/images/"+PeliculasTabla.get(0)+".jpg");
		ImageIcon img2 = new ImageIcon("src/images/"+PeliculasTabla.get(3)+".jpg");
		ImageIcon img3 = new ImageIcon("src/images/"+PeliculasTabla.get(6)+".jpg");
		ImageIcon img4 = new ImageIcon("src/images/"+PeliculasTabla.get(9)+".jpg");
		ImageIcon img5 = new ImageIcon("src/images/"+PeliculasTabla.get(12)+".jpg");
		ImageIcon img6 = new ImageIcon("src/images/"+PeliculasTabla.get(15)+".jpg");
		ImageIcon image = new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg"));
		ImageIcon imgSearch = new ImageIcon(PeliculasView.class.getResource("/images/search.jpg"));
		
		Color transparent = new Color(30, 30, 30, 250);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(transparent);
		panel1.setBounds(173, 44, 329, 203);
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblPeli1 = new JLabel("");
		lblPeli1.setBounds(10, 11, 131, 182);
		Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(lblPeli1.getWidth(), lblPeli1.getHeight(), Image.SCALE_DEFAULT));
		lblPeli1.setIcon(icono1);
		lblPeli1.repaint();
		panel1.add(lblPeli1);
		
		JLabel lblname1 = new JLabel(PeliculasTabla.get(2));
		lblname1.setHorizontalAlignment(SwingConstants.CENTER);
		lblname1.setForeground(Color.WHITE);
		lblname1.setBounds(151, 38, 164, 14);
		panel1.add(lblname1);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(transparent);
		panel2.setBounds(173, 291, 329, 203);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblPeli2 = new JLabel("");
		lblPeli2.setBounds(10, 11, 132, 181);
		panel2.add(lblPeli2);
		Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(lblPeli2.getWidth(), lblPeli2.getHeight(), Image.SCALE_DEFAULT));
		lblPeli2.setIcon(icono2);
		
		JLabel lblname2 = new JLabel(PeliculasTabla.get(5));
		lblname2.setHorizontalAlignment(SwingConstants.CENTER);
		lblname2.setForeground(Color.WHITE);
		lblname2.setBounds(155, 38, 164, 14);
		panel2.add(lblname2);
		lblPeli2.repaint();
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(transparent);
		panel3.setBounds(173, 564, 329, 203);
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);
		
		JLabel lblPeli3 = new JLabel("");
		lblPeli3.setBounds(10, 11, 134, 181);
		panel3.add(lblPeli3);
		Icon icono3 = new ImageIcon(img3.getImage().getScaledInstance(lblPeli3.getWidth(), lblPeli3.getHeight(), Image.SCALE_DEFAULT));
		lblPeli3.setIcon(icono3);
		
		JLabel lblname3 = new JLabel(PeliculasTabla.get(8));
		lblname3.setHorizontalAlignment(SwingConstants.CENTER);
		lblname3.setForeground(Color.WHITE);
		lblname3.setBounds(154, 47, 164, 14);
		panel3.add(lblname3);
		lblPeli3.repaint();
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(transparent);
		panel4.setBounds(585, 44, 347, 203);
		frame.getContentPane().add(panel4);
		panel4.setLayout(null);
		
		JLabel lblPeli4 = new JLabel("");
		lblPeli4.setBounds(10, 11, 137, 181);
		panel4.add(lblPeli4);
		Icon icono4 = new ImageIcon(img4.getImage().getScaledInstance(lblPeli4.getWidth(), lblPeli4.getHeight(), Image.SCALE_DEFAULT));
		lblPeli4.setIcon(icono4);
		
		JLabel lblname4 = new JLabel(PeliculasTabla.get(11));
		lblname4.setHorizontalAlignment(SwingConstants.CENTER);
		lblname4.setForeground(Color.WHITE);
		lblname4.setBounds(157, 39, 164, 14);
		panel4.add(lblname4);
		lblPeli4.repaint();
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(transparent);
		panel5.setBounds(585, 291, 347, 203);
		frame.getContentPane().add(panel5);
		panel5.setLayout(null);
		
		JLabel lblPeli5 = new JLabel("");
		lblPeli5.setBounds(10, 11, 133, 181);
		panel5.add(lblPeli5);
		Icon icono5 = new ImageIcon(img5.getImage().getScaledInstance(lblPeli5.getWidth(), lblPeli5.getHeight(), Image.SCALE_DEFAULT));
		lblPeli5.setIcon(icono5);
		
		JLabel lblname5 = new JLabel(PeliculasTabla.get(14));
		lblname5.setHorizontalAlignment(SwingConstants.CENTER);
		lblname5.setForeground(Color.WHITE);
		lblname5.setBounds(153, 45, 164, 14);
		panel5.add(lblname5);
		lblPeli5.repaint();
		
		JPanel panel6 = new JPanel();
		panel6.setBackground(transparent);
		panel6.setBounds(585, 564, 347, 203);
		frame.getContentPane().add(panel6);
		panel6.setLayout(null);
		
		JLabel lblPeli6 = new JLabel("");
		lblPeli6.setBounds(10, 11, 129, 181);
		panel6.add(lblPeli6);
		Icon icono6 = new ImageIcon(img6.getImage().getScaledInstance(lblPeli6.getWidth(), lblPeli6.getHeight(), Image.SCALE_DEFAULT));
		lblPeli6.setIcon(icono6);
		
		JLabel lblname6 = new JLabel(PeliculasTabla.get(17));
		lblname6.setHorizontalAlignment(SwingConstants.CENTER);
		lblname6.setForeground(Color.WHITE);
		lblname6.setBounds(149, 46, 164, 14);
		panel6.add(lblname6);
		lblPeli6.repaint();
		

		

		
		JPanel panel = new JPanel();
		panel.setBackground(transparent);
		panel.setBounds(0, 0, 105, 1020);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnlog_out = new JButton("Logout");
		
				btnlog_out.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.setVisible(false);
						new LoginView();
					}
				});
				
				btnSerach = new JButton("");
				btnSerach.setForeground(Color.WHITE);
				//Image newimg = imgSearch.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
				btnSerach.setIcon(new ImageIcon(PeliculasView.class.getResource("/images/search.jpg")));
				
					btnSerach.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							String name = JOptionPane.showInputDialog("Type your film name");
							


							frame.setVisible(false);
							new SearchView(name);
						}
					});
					btnSerach.setBounds(0, 25, 100, 100);
					panel.add(btnSerach);
					btnlog_out.setBounds(0, 708, 105, 65);
					panel.add(btnlog_out);
					
					JButton btnSerach_bar_1 = new JButton("Details");
					btnSerach_bar_1.setBounds(0, 162, 105, 65);
					panel.add(btnSerach_bar_1);
		
		
		JLabel lblFondo = new JLabel("");	
		lblFondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(icon);
		frame.getContentPane().add(lblFondo);

		
		
	}
	
	
	private void descargar(String id,String Url ) {
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
				
				
				String descarga = "D:\\Eclipse\\JavaProyects\\Miniproyecto1.0\\src\\images\\" + id +".jpg";
				System.out.println(descarga);

				
				FileOutputStream fos = new FileOutputStream(descarga);
				fos.write(response);
				fos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		
		
		
	}
}
