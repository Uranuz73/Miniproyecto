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
	private JLabel txtEmail;
	private JLabel txtPass;
	private JButton RegisterButton;
	private DAO DAO;
	private JPasswordField passwordCField;
	private JLabel lblName;
	private JTextField textName;
	private JButton btnBack;
	private JLabel lblConfirmPassword;

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
		
		
		txtEmail = new JLabel("Email");
		txtEmail.setForeground(SystemColor.window);
		txtEmail.setBounds(585, 368, 52, 21);
		frame.getContentPane().add(txtEmail);
		
		txtPass = new JLabel("Password");
		txtPass.setForeground(SystemColor.window);
		txtPass.setBounds(585, 409, 68, 21);
		frame.getContentPane().add(txtPass);
		
		txtemail =  new JTextField();
		txtemail.setBounds(693, 368, 96, 19);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(693, 409, 96, 19);
		frame.getContentPane().add(txtpassword);
		
		RegisterButton = new JButton("Register");
		
		
		RegisterButton.setBounds(568, 522, 85, 21);
		frame.getContentPane().add(RegisterButton);
		
		btnBack = new JButton("Back");
				btnBack.setBounds(704, 522, 85, 21);
		frame.getContentPane().add(btnBack);
		
		lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setForeground(SystemColor.window);
		lblConfirmPassword.setBounds(574, 456, 109, 21);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordCField = new JPasswordField();
		passwordCField.setBounds(693, 456, 96, 19);
		frame.getContentPane().add(passwordCField);
		
		lblName = new JLabel("Name");
		lblName.setForeground(SystemColor.window);
		lblName.setBounds(585, 324, 52, 21);
		frame.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(693, 324, 96, 19);
		frame.getContentPane().add(textName);
		

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/cinefondo.jpg")));
		lblNewLabel.setBounds(0, 0, 1366, 763);
		frame.getContentPane().add(lblNewLabel);
		
		
		
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
		String passwordC = new String(passwordCField.getPassword());
		
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