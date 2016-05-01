import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AfficherUnProfilIHM {

	

	private JFrame frame;
	private static Profil profil;
	private JTextField txtNouveauNom;
	private JTextField txtNouveauPrenom;
	private JTextField txtNouveauPoste;
	private JTextField txtNouvelEmail;
	private JTextField txtNouveauMdp;
	/**
	 * Launch the application.
	 */
	public static void main(Profil p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profil=p;

					AfficherUnProfilIHM window = new AfficherUnProfilIHM();
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
	public AfficherUnProfilIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(6, 6, 61, 16);
		frame.getContentPane().add(lblNom);
		
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(6, 51, 61, 16);
		frame.getContentPane().add(lblPrenom);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setBounds(6, 79, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Poste :");
		lblNewLabel_1.setBounds(6, 129, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setBounds(6, 157, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setBounds(6, 196, 61, 16);
		frame.getContentPane().add(lblStatut);
		
		JLabel lblModerateur = new JLabel("Moderateur :");
		lblModerateur.setBounds(6, 224, 79, 16);
		frame.getContentPane().add(lblModerateur);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setBounds(242, 293, 117, 29);
		frame.getContentPane().add(btnFermer);
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
			}
		});
		
		JButton btnModifierNom = new JButton("Modifier Nom");
		btnModifierNom.setBounds(284, 6, 130, 29);
		btnModifierNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nNom = txtNouveauNom.getText();
				try {
					Profil.modifNom(profil.getLogin(), nNom, LoginIHM.utilisateur.getStatut());
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnModifierPrenom = new JButton("Modifier Prenom");
		btnModifierPrenom.setBounds(284, 38, 130, 29);
		btnModifierPrenom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nPrenom = txtNouveauPrenom.getText();
				try {
					Profil.modifPrenom(profil.getLogin(), nPrenom, LoginIHM.utilisateur.getStatut());
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnModifierPoste = new JButton("Modifier Poste");
		btnModifierPoste.setBounds(284, 109, 130, 29);
		btnModifierPoste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nPoste = txtNouveauPoste.getText();
				try {
					Profil.modifFonction(profil.getLogin(), nPoste, LoginIHM.utilisateur.getStatut());
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnModifierEmail = new JButton("Modifier Email");
		btnModifierEmail.setBounds(284, 135, 130, 29);
		btnModifierEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nEmail = txtNouvelEmail.getText();
				try {
					Profil.modifEmail(profil.getLogin(), nEmail, LoginIHM.utilisateur.getStatut());
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNom_1 = new JLabel(profil.getNom());
		lblNom_1.setBounds(79, 6, 198, 16);
		frame.getContentPane().add(lblNom_1);
				
		JLabel lblPrenom_1 = new JLabel(profil.getPrenom());
		lblPrenom_1.setBounds(79, 51, 193, 16);
		frame.getContentPane().add(lblPrenom_1);
				
		JLabel lblLogin = new JLabel(profil.getLogin());
		lblLogin.setBounds(79, 79, 149, 16);
		frame.getContentPane().add(lblLogin);
		
		
		JLabel lblPoste = new JLabel(profil.getFonction());
		lblPoste.setBounds(79, 157, 198, 16);
		frame.getContentPane().add(lblPoste);
		
		
		JLabel lblEmail = new JLabel(profil.getEmail());
		lblEmail.setBounds(79, 122, 198, 16);
		frame.getContentPane().add(lblEmail);
		
		
		JLabel lblStatut_1 = new JLabel(profil.getStatut());
		lblStatut_1.setBounds(79, 196, 149, 16);
		frame.getContentPane().add(lblStatut_1);
		
		
		
		JLabel lblModerateur_1 = new JLabel();
		lblModerateur_1.setBounds(167, 224, 61, 16);
		frame.getContentPane().add(lblModerateur_1);
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
			}
		});
		
		JCheckBox chckbxModerateur = new JCheckBox("Moderateur");
		chckbxModerateur.setBounds(286, 220, 128, 23);
		chckbxModerateur.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(chckbxModerateur.isSelected()){
					try {
						Profil.modifModerateur(profil.getLogin(), LoginIHM.utilisateur.getStatut());
					} catch (RemoteException | MalformedURLException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});		
		
		
		String[] tab={"","membre","admin"};
		JComboBox comboBox = new JComboBox(tab);
		comboBox.setBounds(294, 176, 120, 27);
		
		class ItemState implements ItemListener {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 try {
					 String choix =(String) comboBox.getSelectedItem();
					Profil.modifStatut(profil.getLogin(), choix, LoginIHM.utilisateur.getStatut());
					System.out.println(choix);
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 }

		}
		
		txtNouveauNom = new JTextField();
		txtNouveauNom.setText("Nouveau nom");
		txtNouveauNom.setBounds(410, 6, 134, 28);
		txtNouveauNom.setColumns(10);
		
		txtNouveauPrenom = new JTextField();
		txtNouveauPrenom.setText("Nouveau prenom");
		txtNouveauPrenom.setBounds(410, 37, 134, 28);
		txtNouveauPrenom.setColumns(10);
		
		txtNouveauPoste = new JTextField();
		txtNouveauPoste.setText("Nouveau poste");
		txtNouveauPoste.setBounds(410, 108, 134, 28);
		txtNouveauPoste.setColumns(10);
		
		txtNouvelEmail = new JTextField();
		txtNouvelEmail.setText("Nouvel email");
		txtNouvelEmail.setBounds(410, 134, 134, 28);
		txtNouvelEmail.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(6, 263, 96, 16);
		frame.getContentPane().add(lblMotDePasse);
		
		JLabel lblNewLabel_3 = new JLabel("mdp");
		lblNewLabel_3.setBounds(114, 263, 163, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnModifierMdp = new JButton("Modifier Mdp");
		btnModifierMdp.setBounds(284, 255, 130, 29);
		btnModifierMdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nMdp = txtNouveauMdp.getText();
				try {
					Profil.modifMdp(profil.getLogin(), nMdp, LoginIHM.utilisateur.getStatut());
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		
		txtNouveauMdp = new JTextField();
		txtNouveauMdp.setText("Nouveau mdp");
		txtNouveauMdp.setBounds(410, 255, 134, 28);
		txtNouveauMdp.setColumns(10);
		comboBox.addItemListener(new ItemState());
		
		if(!LoginIHM.utilisateur.getStatut().equals("membre")){
			frame.getContentPane().add(btnModifierPrenom);
			frame.getContentPane().add(btnModifierNom);
			frame.getContentPane().add(btnModifierEmail);
			frame.getContentPane().add(btnModifierPoste);
			frame.getContentPane().add(btnModifierMdp);
			frame.getContentPane().add(txtNouvelEmail);
			frame.getContentPane().add(txtNouveauNom);
			frame.getContentPane().add(txtNouveauPrenom);
			frame.getContentPane().add(txtNouveauPoste);
			frame.getContentPane().add(comboBox);
			frame.getContentPane().add(chckbxModerateur);
			frame.getContentPane().add(txtNouveauMdp);

			






		
		
		}
		
	}
	
	
}
