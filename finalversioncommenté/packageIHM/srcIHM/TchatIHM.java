

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class TchatIHM {
	private static Tchat tchat;
	private JFrame frmTchat;
	private JTextField txtEntrezVotreTexte;
	private JButton btnEnvoyer, btnFermer;
	private JTextArea textArea;
	public static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void NewPage(Tchat t) {
		tchat=t;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TchatIHM window = new TchatIHM();
					window.frmTchat.setVisible(true);
					window.frmTchat.setSize(600,400);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TchatIHM() {
		initialize();
		
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTchat = new JFrame();
		frmTchat.setBackground(Color.GRAY);
		frmTchat.setTitle(LoginIHM.utilisateur.getLogin() + " parle à " + tchat.getCorrespondant().getLogin());
		//frmTchat.setBounds(100, 100, 450, 300);
		frmTchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 448, 10);
		frmTchat.getContentPane().add(panel);
		panel.setLayout(null);

		txtEntrezVotreTexte = new JTextField();
		txtEntrezVotreTexte.setBackground(new Color(255, 228, 196));
		txtEntrezVotreTexte.setText("Entrez votre texte");
		txtEntrezVotreTexte.setBounds(121, 270, 318, 22);
		panel.add(txtEntrezVotreTexte);
		txtEntrezVotreTexte.setColumns(10);
		
			
		btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setBackground(new Color(233, 150, 122));
		btnEnvoyer.setBounds(199, 321, 117, 25);
		panel.add(btnEnvoyer);
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String contenu=txtEntrezVotreTexte.getText();
				try {
					ThreadTchat.tampon += tchat.getUtilisateur().getLogin()+" : "+contenu+"\n"; 
					tchat.envoyerMessage(contenu);
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnFermer = new JButton("Fermer");
		btnFermer.setBackground(new Color(233, 150, 122));
		btnFermer.setBounds(199, 347, 117, 25);
		panel.add(btnFermer);
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				MainIHM.listTchat.remove(tchat);
				frmTchat.dispose();
			}
		});
		
		
		
		Thread threadTchat= new Thread(new ThreadTchat(tchat));
		threadTchat.start();
		
		
		//frmTchat.setContentPane(panel);
		 frmTchat.setSize(500,500);
		 frmTchat.setVisible(true); 
		
	}
}
