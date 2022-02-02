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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;

public class LoginView {

	private JFrame frame;
	private JTextField txtemail;
	private JPasswordField txtpassword;
	private JLabel lblemail;
	private JLabel lblpassword;
	private JButton loginButton;
	private DAO loginDAO;
	private JButton registerButton;
	private JLabel lblTitulo;

	public LoginView() {
		loginDAO = new DAO();
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setBounds(100,100,1366,763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.paint(frame.getGraphics());
		frame.getContentPane().setLayout(null);
		
		setUIComponents();
		setListeners();
		
		frame.setVisible(true);	
	}
	private void setUIComponents() {
		
		
		lblemail = new JLabel("Email");
		lblemail.setForeground(SystemColor.window);
		lblemail.setBounds(629, 343, 52, 21);
		frame.getContentPane().add(lblemail);
		
		lblpassword = new JLabel("Password");
		lblpassword.setForeground(SystemColor.window);
		lblpassword.setBounds(629, 395, 68, 21);
		frame.getContentPane().add(lblpassword);
		
		txtemail =  new JTextField();
		txtemail.setToolTipText("");
		txtemail.setBounds(691, 343, 96, 19);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setToolTipText("Password");
		txtpassword.setBounds(691, 395, 96, 19);
		frame.getContentPane().add(txtpassword);
		
		loginButton = new JButton("Login");
		
		
		loginButton.setBounds(612, 465, 85, 21);
		frame.getContentPane().add(loginButton);
		
		registerButton = new JButton("Register");
				registerButton.setBounds(728, 465, 85, 21);
		frame.getContentPane().add(registerButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 30, 250));
		panel.setBounds(553, 209, 273, 378);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTitulo = new JLabel("Sign in");
		lblTitulo.setBounds(29, 25, 67, 26);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblTitulo.setForeground(UIManager.getColor("Separator.background"));
		panel.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/cinefondo.jpg")));
		lblNewLabel.setBounds(0, 0, 1366, 763);
		frame.getContentPane().add(lblNewLabel);
		
		
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
			new PeliculasView();
			frame.setVisible(false);
			
		} else {
			JOptionPane.showMessageDialog(frame, "Login INCORRECTO","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
}
