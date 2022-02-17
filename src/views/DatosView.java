package views;

import java.awt.Color;
import java.awt.EventQueue;
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
		
		Color transparent = new Color(30, 30, 30, 250);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(transparent);
		panel.setBounds(0, 0, 105, 1080);
		frame.getContentPane().add(panel);
		
		JButton btnSerach = new JButton("");
		btnSerach.setForeground(Color.WHITE);
		btnSerach.setBounds(24, 50, 53, 51);
		panel.add(btnSerach);
		
		JButton btnlog_out = new JButton("Logout");
		btnlog_out.setBounds(0, 925, 105, 65);
		panel.add(btnlog_out);
		
		JButton btnSerach_bar_1 = new JButton("Details");
		btnSerach_bar_1.setBounds(0, 162, 105, 65);
		panel.add(btnSerach_bar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(138, 64, 1703, 889);
		panel_1.setBackground(transparent);

		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(peli.getFullTitle());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 44, 1605, 52);
		panel_1.add(lblNewLabel);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(10, 0, frame.getWidth(), frame.getHeight());
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		
		frame.getContentPane().add(lblFondo);
		lblFondo.setIcon(icon);
		
		
		
		
		
		
	}
}
