package views;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PeliculasView {

	private JFrame frame;
	private JButton btnSerach_bar;
	private JButton btnlog_out;


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
		panel.setLayout(null);
		
		btnSerach_bar = new JButton("New button");
		btnSerach_bar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = JOptionPane.showInputDialog("Type your film name");
				

				System.out.println(name);
			}
		});
		btnSerach_bar.setBounds(23, 28, 58, 59);
		panel.add(btnSerach_bar);
		
		btnlog_out = new JButton("New button");
		btnlog_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new LoginView();
			}
		});
		btnlog_out.setBounds(17, 591, 64, 59);
		panel.add(btnlog_out);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg")));
		lblNewLabel.setBounds(0, 0, 1256, 796);
		frame.getContentPane().add(lblNewLabel);
	}
}
