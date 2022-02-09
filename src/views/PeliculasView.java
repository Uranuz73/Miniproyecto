package views;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAO;

public class PeliculasView {

	private JFrame frame;
	private JButton btnSerach_bar;
	private JButton btnlog_out;
	private JTable table;
	private ArrayList<String> PeliculasTabla = new ArrayList<>();
	private String[][] tabla;
	
	
	public PeliculasView() {
		
		this.PeliculasTabla = DAO.getPelicula();
		this.tabla = new String[PeliculasTabla.size()][2];
		
		initialize();
		
		
	}


	private void initialize() {
		
//TODO cambiar icono del mouse:
	//TODO https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_Ratio0.6762_AL_.jpg zoom
	//	https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_
		//TODO https://imdb-api.com/images/original/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_QL75_UX75_CR0,0,75,100_.jpg chiquita

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100,100,1256,835);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
		
		for (int i = 0; i < PeliculasTabla.size(); i++) {
			tabla[i][1] = PeliculasTabla.get(i);
			tabla[i][0] = String.valueOf(i+1);
		}

		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			tabla,
			new String[] {
				"Id", "Nombre"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(233);
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(30, 30, 30, 200));
		table.setBounds(163, 63, 1031, 692);
		frame.getContentPane().add(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 30, 250));
		panel.setBounds(0, 0, 105, 796);
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
		
		btnSerach_bar = new JButton("Search");
		
			btnSerach_bar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String name = JOptionPane.showInputDialog("Type your film name");
					


					frame.setVisible(false);
					new SearchView(name);
				}
			});
			btnSerach_bar.setBounds(0, 25, 105, 65);
			panel.add(btnSerach_bar);
		btnlog_out.setBounds(0, 708, 105, 65);
		panel.add(btnlog_out);
		
		JButton btnSerach_bar_1 = new JButton("Details");
		btnSerach_bar_1.setBounds(0, 113, 105, 65);
		panel.add(btnSerach_bar_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg")));
		lblNewLabel.setBounds(0, 0, 1256, 796);
		frame.getContentPane().add(lblNewLabel);
	}
}
