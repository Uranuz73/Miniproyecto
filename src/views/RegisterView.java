package views;

 import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import DAO.DAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class RegisterView {

	private JFrame frame;
	private JTextField txtemail;
	private JPasswordField txtpassword;
	private JLabel lblEmail;
	private JLabel lblPass;
	private JButton RegisterButton;
	private DAO DAO;
	private JPasswordField txtCPass;
	private JLabel lblName;
	private JTextField textName;
	private JButton btnBack;
	private JLabel lblCPass;

	public RegisterView() {
		DAO = new DAO();
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,1366,763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setUIComponents();
		setListeners();
		
		frame.setVisible(true);	
	}
	private void setUIComponents() {
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 30, 250));
		panel.setBounds(553, 209, 273, 378);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Sign up");
		lblTitulo.setBounds(29, 25, 88, 26);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblTitulo.setForeground(UIManager.getColor("Separator.background"));
		panel.add(lblTitulo);
		
		RegisterButton = new JButton("Register");
		RegisterButton.setBounds(29, 298, 85, 21);
		panel.add(RegisterButton);
		
		lblName = new JLabel("Name");
		lblName.setBounds(34, 96, 52, 21);
		panel.add(lblName);
		lblName.setForeground(SystemColor.window);
		
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(34, 140, 52, 21);
		panel.add(lblEmail);
		lblEmail.setForeground(SystemColor.window);
		
		lblPass = new JLabel("Password");
		lblPass.setBounds(34, 181, 68, 21);
		panel.add(lblPass);
		lblPass.setForeground(SystemColor.window);
		
		lblCPass = new JLabel("Confirm password");
		lblCPass.setBounds(23, 228, 109, 21);
		panel.add(lblCPass);
		lblCPass.setForeground(SystemColor.window);
		
		txtCPass = new JPasswordField();
		txtCPass.setBounds(142, 228, 96, 19);
		panel.add(txtCPass);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(142, 181, 96, 19);
		panel.add(txtpassword);
		
		txtemail =  new JTextField();
		txtemail.setBounds(142, 140, 96, 19);
		panel.add(txtemail);
		txtemail.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(142, 96, 96, 19);
		panel.add(textName);
		textName.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(153, 298, 85, 21);
		panel.add(btnBack);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(LoginView.class.getResource("/images/cinefondo.jpg")));
		lblFondo.setBounds(0, 0, 1366, 763);
		frame.getContentPane().add(lblFondo);
		
		
		
	}
	private void setListeners() {
		RegisterButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				loginPressed();
			}
		});
		
		txtpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginPressed();
				}
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new LoginView();
				frame.setVisible(false);
				
			}
		});
		
	}
	private void loginPressed() {
		String nombre = textName.getText();
		String email = txtemail.getText();
		String password = new String(txtpassword.getPassword());
		String passwordC = new String(txtCPass.getPassword());
		
		if(password.equals(passwordC) && !email.equals("")) {
			if(DAO.register(nombre,email,password) ) {
				new PeliculasView();
				frame.setVisible(false);
				
			} else {
				JOptionPane.showMessageDialog(frame, "Este usuario ya existe","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(frame, "Faltan datos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
}