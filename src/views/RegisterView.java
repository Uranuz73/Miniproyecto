package views;

 import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.DAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setUIComponents();
		setListeners();
		
		frame.setVisible(true);	
	}
	private void setUIComponents() {
		
		
		txtEmail = new JLabel("Email");
		txtEmail.setBounds(49, 72, 52, 21);
		frame.getContentPane().add(txtEmail);
		
		txtPass = new JLabel("Password");
		txtPass.setBounds(49, 104, 68, 21);
		frame.getContentPane().add(txtPass);
		
		txtemail =  new JTextField();
		txtemail.setBounds(170, 72, 96, 19);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(170, 104, 96, 19);
		frame.getContentPane().add(txtpassword);
		
		RegisterButton = new JButton("Register");
		
		
		RegisterButton.setBounds(90, 182, 85, 21);
		frame.getContentPane().add(RegisterButton);
		
		btnBack = new JButton("Back");
				btnBack.setBounds(211, 182, 85, 21);
		frame.getContentPane().add(btnBack);
		
		lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setBounds(49, 136, 109, 21);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordCField = new JPasswordField();
		passwordCField.setBounds(170, 136, 96, 19);
		frame.getContentPane().add(passwordCField);
		
		lblName = new JLabel("Name");
		lblName.setBounds(49, 40, 52, 21);
		frame.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(170, 40, 96, 19);
		frame.getContentPane().add(textName);
		
		
		
		
	}
	private void setListeners() {
		RegisterButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				String nombre = textName.getText();
				String email =txtemail.getText();
				String password = new String(txtpassword.getPassword());
				loginPressed();
				System.out.println(nombre);
				System.out.println(email);
				System.out.println(password);
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
		
		if(password.equals(passwordC)) {
			if(DAO.register(nombre,email,password)) {
				new WelcomeView(email);
				frame.setVisible(false);
				
			} else {
				JOptionPane.showMessageDialog(frame, "Register INCORRECTO","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
	
	
}