package views;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class WelcomeView {

	private JFrame frame;
	private JLabel label;
	private String username;
	private JButton pokedexbutton;
	private JLabel pokedexlabel;
	private JButton searchbutton;
	private JLabel searchlabel;
	

	public WelcomeView(String username) {
		this.username = username;
		initialize();
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		setUIComponents();
		setListeners();
		
		
	}
	private void setUIComponents() {
	label = new JLabel("Bienvenido");
	label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label.setBounds(132, 105, 151, 23);
		frame.getContentPane().add(label);
		label.setText("bienvenido " + this.username);	
		
		pokedexbutton = new JButton("====>");
		
		pokedexbutton.setBounds(322, 11, 89, 23);
		frame.getContentPane().add(pokedexbutton);
		
		pokedexlabel = new JLabel("Ir a la pokedex");
		pokedexlabel.setForeground(new Color(65, 105, 225));
		pokedexlabel.setBounds(322, 53, 89, 23);
		frame.getContentPane().add(pokedexlabel);
		
		searchbutton = new JButton("<====");
		
		searchbutton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(searchbutton);
		searchlabel = new JLabel("Buscar un pokemon");
		searchlabel.setForeground(new Color(65, 105, 225));
		searchlabel.setBounds(10, 53, 125, 18);
		frame.getContentPane().add(searchlabel);
		
	}
	private void setListeners() {
		searchbutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				frame.setVisible(false);
			}
		});
		pokedexbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cantidad = 0;
				frame.setVisible(false);
			}
		});
	}
}