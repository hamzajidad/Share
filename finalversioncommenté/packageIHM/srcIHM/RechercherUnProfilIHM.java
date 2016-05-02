import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class RechercherUnProfilIHM {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercherUnProfilIHM window = new RechercherUnProfilIHM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RechercherUnProfilIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(103, 117, 234, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblEntrezLeLogin = new JLabel("Entrez le login de la personne recherchée :");
		lblEntrezLeLogin.setBounds(20, 47, 413, 16);
		frame.getContentPane().add(lblEntrezLeLogin);
		
		JButton btnRechercher = new JButton("Rechercher !");
		btnRechercher.setBounds(157, 174, 117, 29);
		frame.getContentPane().add(btnRechercher);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String loginRechercher = textField.getText();
				try {
					Profil pRechercher = new Profil(loginRechercher);
					AfficherUnProfilIHM.main(pRechercher);
				} catch (MalformedURLException | RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
		});

		
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setBounds(157, 225, 117, 29);
		frame.getContentPane().add(btnFermer);
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				frame.dispose();
				
			}
		});

	}

}
