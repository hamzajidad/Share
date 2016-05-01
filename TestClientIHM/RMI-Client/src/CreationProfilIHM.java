import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CreationProfilIHM {

	private JFrame frmCreationprofil;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtEmail;
	private JTextField txtStatut;
	private JTextField txtFonction;
	private JTextField txtLogin;
	private JTextField txtMotdepasse;

	/**
	 * Launch the application.
	 */
	public static void NewPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationProfilIHM window = new CreationProfilIHM();
					window.frmCreationprofil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreationProfilIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreationprofil = new JFrame();
		frmCreationprofil.setTitle("CreationProfil");
		frmCreationprofil.setBounds(100, 100, 453, 480);
		frmCreationprofil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreationprofil.getContentPane().setLayout(null);
		
		txtNom = new JTextField();
		txtNom.setText("nom");
		txtNom.setBounds(154, 23, 134, 28);
		frmCreationprofil.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setText("prenom");
		txtPrenom.setBounds(154, 63, 134, 28);
		frmCreationprofil.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("email");
		txtEmail.setBounds(154, 223, 134, 28);
		frmCreationprofil.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtStatut = new JTextField();
		txtStatut.setText("statut");
		txtStatut.setBounds(154, 143, 134, 28);
		frmCreationprofil.getContentPane().add(txtStatut);
		txtStatut.setColumns(10);
		
		txtFonction = new JTextField();
		txtFonction.setText("fonction");
		txtFonction.setBounds(154, 183, 134, 28);
		frmCreationprofil.getContentPane().add(txtFonction);
		txtFonction.setColumns(10);
		
		JButton btn = new JButton("CreerProfil");
		btn.setBackground(new Color(233, 150, 122));
		btn.setBounds(6, 310, 117, 29);
		frmCreationprofil.getContentPane().add(btn);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setBounds(6, 29, 61, 16);
		frmCreationprofil.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setBounds(6, 69, 61, 16);
		frmCreationprofil.getContentPane().add(lblPrenom);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(6, 229, 61, 16);
		frmCreationprofil.getContentPane().add(lblEmail);
		
		JLabel lblStatut = new JLabel("statut");
		lblStatut.setBounds(6, 149, 61, 16);
		frmCreationprofil.getContentPane().add(lblStatut);
		
		JLabel lblFonction = new JLabel("fonction");
		lblFonction.setBounds(6, 189, 61, 16);
		frmCreationprofil.getContentPane().add(lblFonction);
		
		txtLogin = new JTextField();
		txtLogin.setText("login");
		txtLogin.setBounds(154, 103, 134, 28);
		frmCreationprofil.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setBounds(6, 109, 61, 16);
		frmCreationprofil.getContentPane().add(lblLogin);
		
		txtMotdepasse = new JTextField();
		txtMotdepasse.setText("motdepasse");
		txtMotdepasse.setBounds(154, 262, 134, 28);
		frmCreationprofil.getContentPane().add(txtMotdepasse);
		txtMotdepasse.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		lblMotDePasse.setBounds(6, 268, 100, 16);
		frmCreationprofil.getContentPane().add(lblMotDePasse);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(164, 310, 117, 28);
		frmCreationprofil.getContentPane().add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreationprofil.dispose();
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String cmd =e1.getActionCommand();
					if (cmd.equals("CreerProfil")){
						frmCreationprofil.dispose();
						try {
							String login;
							String nom;
							String prenom;
							String email;
							String fonction;
							String mdp;
							String statut;
							ProfilMethodes.creerUnProfil(login = txtLogin.getText(),nom=txtNom.getText(),prenom=txtPrenom.getText(),email=txtEmail.getText(),fonction=txtFonction.getText(),mdp=txtMotdepasse.getText(),statut=txtStatut.getText(),LoginIHM.utilisateur.getStatut());
						} catch (MalformedURLException | RemoteException | NotBoundException e) {
							e.printStackTrace();
						}
						
					}
				}
			});

		btnClose.setBounds(6, 400, 117, 29);
		frmCreationprofil.getContentPane().add(btnClose);
		
		frmCreationprofil.setSize(500,500);
		frmCreationprofil.setVisible(true); 
	}
}
