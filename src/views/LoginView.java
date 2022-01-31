package views;

 import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.DAO;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView {

	private JFrame frame;
	private JTextField txtemail;
	private JPasswordField txtpassword;
	private JLabel lblemail;
	private JLabel lblpassword;
	private JButton loginButton;
	private DAO loginDAO;
	private JButton registerButton;

	public LoginView() {
		loginDAO = new DAO();
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.paint(frame.getGraphics());
		frame.getContentPane().setLayout(null);
		
		setUIComponents();
		setListeners();
		
		frame.setVisible(true);	
	}
	private void setUIComponents() {
		
		
		lblemail = new JLabel("Email");
		lblemail.setBounds(108, 72, 52, 21);
		frame.getContentPane().add(lblemail);
		
		lblpassword = new JLabel("Password");
		lblpassword.setBounds(108, 126, 68, 21);
		frame.getContentPane().add(lblpassword);
		
		txtemail =  new JTextField();
		txtemail.setBounds(200, 73, 96, 19);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(200, 127, 96, 19);
		frame.getContentPane().add(txtpassword);
		
		loginButton = new JButton("Login");
		
		
		loginButton.setBounds(120, 182, 85, 21);
		frame.getContentPane().add(loginButton);
		
		registerButton = new JButton("Register");
				registerButton.setBounds(228, 181, 85, 21);
		frame.getContentPane().add(registerButton);
		
		
		
		
	}
	private void setListeners() {
		loginButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				String email =txtemail.getText();
				String password = new String(txtpassword.getPassword());
				loginPressed();

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
		
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterView();
				frame.setVisible(false);
				
			}
		});
		
	}
	private void loginPressed() {
		String email = txtemail.getText();
		String password = new String(txtpassword.getPassword());
		
		if(loginDAO.login(email, password)) {
			new WelcomeView(email);
			frame.setVisible(false);
			
		} else {
			JOptionPane.showMessageDialog(frame, "Login INCORRECTO","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	public void paint (Graphics g) {
		Dimension size = frame.getSize();
		ImageIcon imagen = new ImageIcon("/images/cinefondo.jpg");
	    g.drawImage(imagen.getImage(), 0, 0, size.width, size.height, null);
	  
	}
	
}
