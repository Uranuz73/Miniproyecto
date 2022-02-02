package views;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class PeliculasView {

	private JFrame frame;


	public PeliculasView() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100,100,1256,835);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 30, 250));
		panel.setBounds(0, 0, 105, 796);
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg")));
		lblNewLabel.setBounds(0, 0, 1256, 796);
		frame.getContentPane().add(lblNewLabel);
	}
}
