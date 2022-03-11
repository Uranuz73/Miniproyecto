package views;


import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;

import DAO.DAO;
import models.Pelicula;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateView {

	private JFrame frame;
	private JTextField txtTitle;
	private JTextField txtYear;
	private JTextField txtDuration;
	private JTextField txtValoration;
	private JTextField txtType;
	private JTextField txtRelease;
	private JTextField txtDescription;
	public String nombre = "";
	public int year = 0;
	public int duration = 0;
	public Double valoration = 0.0;
	public String type = "";
	public String releaseDate = "";
	public String description = "";
	public String fulltitle = "";
	String defaultimg = "https://imdb-api.com/images/original/nopicture.jpg";

	public CreateView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0,0,1920,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Color transparent = new Color(30, 30, 30, 250);
		
		ImageIcon image = new ImageIcon(PeliculasView.class.getResource("/images/cinefondobuena.jpg"));
		ImageIcon imgSave = new ImageIcon(PeliculasView.class.getResource("/images/guardar.jpg"));
		ImageIcon imgBack = new ImageIcon(PeliculasView.class.getResource("/images/back.jpg"));
		
		frame.getContentPane().setLayout(null);

		
		

		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 105, 1020);
		panel.setBackground(transparent);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(138, 126, 1703, 600);
		panel_1.setBackground(transparent);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(49, 49, 127, 25);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblTitle);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(625, 49, 127, 25);
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblYear);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(49, 160, 127, 25);
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblDuration);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(49, 364, 127, 25);
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblDescription);
		
		JLabel lblValoration = new JLabel("Valoration");
		lblValoration.setBounds(572, 160, 127, 25);
		lblValoration.setForeground(Color.WHITE);
		lblValoration.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblValoration);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(49, 258, 127, 25);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblType);
		
		JLabel lblRelease = new JLabel("Release date");
		lblRelease.setBounds(533, 258, 166, 25);
		lblRelease.setForeground(Color.WHITE);
		lblRelease.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblRelease);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(181, 48, 221, 26);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setBounds(714, 48, 221, 26);
		txtYear.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtYear.setColumns(10);
		panel_1.add(txtYear);
		
		txtDuration = new JTextField();
		txtDuration.setBounds(181, 159, 221, 26);
		txtDuration.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDuration.setColumns(10);
		panel_1.add(txtDuration);
		
		txtValoration = new JTextField();
		txtValoration.setBounds(714, 159, 221, 26);
		txtValoration.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtValoration.setColumns(10);
		panel_1.add(txtValoration);
		
		txtType = new JTextField();
		txtType.setBounds(181, 268, 221, 26);
		txtType.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtType.setColumns(10);
		panel_1.add(txtType);
		
		txtRelease = new JTextField();
		txtRelease.setBounds(714, 257, 221, 26);
		txtRelease.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtRelease.setColumns(10);
		panel_1.add(txtRelease);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(49, 420, 1581, 145);
		txtDescription.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDescription.setColumns(10);
		panel_1.add(txtDescription);
		
		JButton btnSave = new JButton("");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(CamposLlenos() == true) {
					JOptionPane.showInputDialog(btnSave,
	                        "Added successfully");
					insertarPeli();
					
				}else {
					JOptionPane.showInputDialog(btnSave,
	                        "Error, can't be empty fields");
				}
				
			}
		});
		btnSave.setBounds(22, 24, 56, 56);
		btnSave.setForeground(Color.WHITE);
		Icon imgsave = new ImageIcon(imgSave.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;
		panel.setLayout(null);
		btnSave.setIcon(imgsave);
		
		panel.add(btnSave);
		
		JButton btnback= new JButton("");
		btnback.setBounds(22, 928, 56, 56);
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new PeliculasView(0);
			}
		});
		btnback.setForeground(Color.WHITE);
		Icon iconback = new ImageIcon(imgBack.getImage().getScaledInstance( 56, 56,  java.awt.Image.SCALE_SMOOTH )) ;  
		btnback.setIcon(iconback);
		panel.add(btnback);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1904, 1041);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(icon);
		frame.getContentPane().add(lblFondo);

		
		
		
		
		
		
		
	}
	
	public boolean CamposLlenos() {
		
		if(!(txtTitle.getText() == "" && txtYear.getText() == "" && txtDuration.getText() == "" && txtValoration.getText() == "" && txtType.getText() == ""
				&& txtRelease.getText() == "" && txtDescription.getText() == "")) {
			return true;
			
		}else {
			
			return false;
		}
	
	}
	
	public void insertarPeli(){
		
		String nombre = txtTitle.getText();
		int year = Integer.parseInt(txtYear.getText());
		int duration = Integer.parseInt(txtDuration.getText());
		Double valoration = Double.parseDouble(txtValoration.getText());
		String type = txtType.getText();
		String releaseDate = txtRelease.getText();
		String description = txtDescription.getText();
		String fulltitle = nombre + " (" + year + ")";
		
		
		Pelicula peli = new Pelicula("aa0000002",nombre,year,duration,description,defaultimg,valoration,"",fulltitle,defaultimg,type,releaseDate);

		DAO.insertpeliculas(peli);
	}
}
