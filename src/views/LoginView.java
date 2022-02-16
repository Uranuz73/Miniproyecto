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
	private JLabel lblPass;
	private JButton loginButton;
	private DAO loginDAO;
	private JButton registerButton;
	private JLabel lblTitulo;
	private JLabel lblEmail;

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
		
		lblPass = new JLabel("Password");
		lblPass.setBounds(43, 185, 68, 21);
		panel.add(lblPass);
		lblPass.setForeground(SystemColor.window);
		
		txtemail =  new JTextField();
		txtemail.setBounds(129, 134, 96, 19);
		panel.add(txtemail);
		txtemail.setToolTipText("");
		txtemail.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(132, 185, 96, 19);
		panel.add(txtpassword);
		txtpassword.setToolTipText("Password");
		
		loginButton = new JButton("Login");
		loginButton.setBounds(29, 256, 85, 21);
		panel.add(loginButton);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(152, 256, 85, 21);
		panel.add(registerButton);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(43, 134, 52, 21);
		panel.add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(LoginView.class.getResource("/images/cinefondo.jpg")));
		lblFondo.setBounds(0, 0, 1366, 763);
		frame.getContentPane().add(lblFondo);
		
		
	}
	
	private void setListeners() {
		loginButton.addMouseListener(new MouseAdapter() {
			
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
			new PeliculasView(0);
			frame.setVisible(false);
			
		} else {
			JOptionPane.showMessageDialog(frame, "Login INCORRECTO","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
}
