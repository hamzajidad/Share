

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MainIHM {
	// création de la fenetre 
	JFrame frame;
	private JTextField txtRechercher;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void NewPage(String id) throws MalformedURLException, RemoteException, NotBoundException {
		System.out.println(id);
		Profil utilisateur = new Profil(id);
		System.out.println("utilisateur :" + utilisateur.getNom());

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainIHM window = new MainIHM();
					window.frame.setVisible(true);
					window.frame.setTitle("Share");
					window.frame.setSize(800,800);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(192, 192, 192));
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Tchat");
		btnNewButton.setBackground(new Color(255, 127, 80));
		btnNewButton.setBounds(123, 227, 117, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TchatIHM iu = new TchatIHM();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAnnonce = new JButton("Actualité");
		btnAnnonce.setBackground(new Color(255, 127, 80));
		btnAnnonce.setBounds(123, 264, 117, 25);
		btnAnnonce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				
				ActualiteIHM actu = new ActualiteIHM();
			}
		});
		frame.getContentPane().add(btnAnnonce);
		
		JButton btnForum = new JButton("Forum");
		btnForum.setBackground(new Color(255, 127, 80));
		btnForum.setBounds(123, 301, 117, 25);
		frame.getContentPane().add(btnForum);
		
		JButton btnTaches = new JButton("Taches");
		btnTaches.setBackground(new Color(255, 127, 80));
		btnTaches.setBounds(123, 338, 117, 25);
		frame.getContentPane().add(btnTaches);
		
		txtRechercher = new JTextField();
		txtRechercher.setBounds(126, 385, 114, 22);
		txtRechercher.setText("Rechercher");
		frame.getContentPane().add(txtRechercher);
		txtRechercher.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.GRAY);
		menuBar.setBackground(Color.GRAY);
		frame.setJMenuBar(menuBar);
		
		JMenu mnLogin = new JMenu("Login");
		menuBar.add(mnLogin);
		
		JMenu mnLogout = new JMenu("Logout");
		mnLogout.setBackground(Color.GRAY);
		menuBar.add(mnLogout);
		
		JMenuItem mntmTheEnd = new JMenuItem("THE END");
		mnLogout.add(mntmTheEnd);	
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(413, 38, 290, 343);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDsyh = new JLabel("Fil d'actualité");
		lblDsyh.setBounds(510, 6, 186, 37);
		frame.getContentPane().add(lblDsyh);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainIHM.class.getResource("logo.png")));
		lblNewLabel.setBounds(68, 6, 340, 191);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
}
