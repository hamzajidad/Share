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

public class RechercheDeProfilIHM {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercheDeProfilIHM window = new RechercheDeProfilIHM();
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
	public RechercheDeProfilIHM() {
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
		
		JLabel lblEntrezLeLogin = new JLabel("Entrez le login de la personne avec laquelle vous voulez chatter :");
		lblEntrezLeLogin.setBounds(20, 47, 413, 16);
		frame.getContentPane().add(lblEntrezLeLogin);
		
		JButton btnTchatterAvec = new JButton("Tchatter avec !");
		btnTchatterAvec.setBounds(157, 174, 117, 29);
		frame.getContentPane().add(btnTchatterAvec);
		btnTchatterAvec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String loginDestinataire = textField.getText();
				try {
					Profil destinataire = new Profil(loginDestinataire);
					Boolean bool =true;
					if(!MainIHM.listTchat.isEmpty()){
						for(int j=0; j < MainIHM.listTchat.size(); j++){
							if(MainIHM.listTchat.get(j).getCorrespondant().getLogin().equals(destinataire.getLogin())){
								bool=false;
							}
						}
					}
					if(bool){
						Tchat tchat = new Tchat(LoginIHM.utilisateur,destinataire);
						MainIHM.listTchat.add(tchat);
						TchatIHM.NewPage(tchat);
					}

					
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
