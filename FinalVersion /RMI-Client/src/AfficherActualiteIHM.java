import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AfficherActualiteIHM {

	private JFrame frame;
	private static String idProfil;
	private static String date;
	private static String contenu;
	private static String titre;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					idProfil=args[0];
					contenu=args[1];
					date=args[2];
					titre=args[3];
					AfficherActualiteIHM window = new AfficherActualiteIHM();
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
	public AfficherActualiteIHM() {
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
		
		JLabel lblAuteur = new JLabel(idProfil);
		lblAuteur.setBounds(27, 16, 61, 16);
		frame.getContentPane().add(lblAuteur);
		
		
		JLabel lblNewLabel = new JLabel(date);
		lblNewLabel.setBounds(301, 16, 151, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(contenu);
		lblNewLabel_1.setBounds(6, 94, 438, 139);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblTitre = new JLabel(titre);
		lblTitre.setBounds(129, 54, 177, 16);
		frame.getContentPane().add(lblTitre);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setBounds(151, 243, 117, 29);
		frame.getContentPane().add(btnFermer);
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				frame.dispose();
			}
		});
	}

}
