

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
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
	public static JFrame frame;
	private JTextField txtRechercher;
	private JTextField textField;
	public static ArrayList<Tchat> listTchat = new ArrayList<Tchat>();
	/**
	 * Launch the application.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void NewPage() throws MalformedURLException, RemoteException, NotBoundException {
		//System.out.println(id);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					System.out.println("utilisateur :" + LoginIHM.utilisateur.getNom());	
					//MainIHM window = new MainIHM();
					MainIHM.frame.setVisible(true);

					MainIHM.frame.setTitle("Share Bienvenue " + LoginIHM.utilisateur.getPrenom());
					MainIHM.frame.setSize(750,750);
					MainIHM.frame.repaint();
					MainIHM.frame.revalidate();
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
		
		Thread actualite = new Thread(new ThreadFilDactualiteIHM());
		actualite.start();
		
		
		
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
		//System.out.println("utilisateur :  " + utilisateur.getStatut());
		
		
		JButton btnCreerProfil = new JButton("creerProfil");
		btnCreerProfil.setBackground(new Color(255, 127, 80));
		btnCreerProfil.setBounds(123, 199, 117, 25);
		btnCreerProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreationProfilIHM iu = new CreationProfilIHM();
				System.out.println("utilisateur :" + LoginIHM.utilisateur.getStatut());

			}
		});
		
		
		if(!LoginIHM.utilisateur.getStatut().equals("membre")){frame.getContentPane().add(btnCreerProfil);}
		
		JButton btnNewButton = new JButton("Tchat");
		btnNewButton.setBackground(new Color(255, 127, 80));
		btnNewButton.setBounds(123, 227, 117, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechercheDeProfilIHM.main();
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
		btnForum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
			}
		});

		frame.getContentPane().add(btnForum);
		
		JButton btnTaches = new JButton("Taches");
		btnTaches.setBackground(new Color(255, 127, 80));
		btnTaches.setBounds(123, 338, 117, 25);
		frame.getContentPane().add(btnTaches);
		
		JButton btnRechercher = new JButton("Consulter un profil");
		btnRechercher.setBackground(new Color(255, 127, 80));
		btnRechercher.setBounds(126, 385, 114, 22);
		frame.getContentPane().add(btnRechercher);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				RechercherUnProfilIHM.main();
			}
		});

		
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
		
		
		/*String filActu = "";
		JLabel labelActu = new JLabel(filActu);
		labelActu.setBackground(Color.WHITE);
		//labelActu.setOpaque(true);
		labelActu.setBounds(413, 38, 290, 343);
		frame.getContentPane().add(labelActu);*/
		
				
		JLabel lblDsyh = new JLabel("Fil d'actualité");
		lblDsyh.setBounds(510, 6, 186, 37);
		frame.getContentPane().add(lblDsyh);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainIHM.class.getResource("logo.png")));
		lblNewLabel.setBounds(68, 6, 340, 191);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
