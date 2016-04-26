package IHM;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class Tchat {

	private JFrame frmTchat;
	private JTextField txtEntrezVotreTexte;
	private JButton btnEnvoyer;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tchat window = new Tchat();
					window.frmTchat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tchat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTchat = new JFrame();
		frmTchat.setBackground(Color.GRAY);
		frmTchat.setTitle("Tchat");
		frmTchat.setBounds(100, 100, 450, 300);
		frmTchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
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
		
		textArea = new JTextArea();
		textArea.setBounds(121, 12, 312, 248);
		panel.add(textArea);
		
		//frmTchat.setContentPane(panel);
		 frmTchat.setSize(500,500);
		 frmTchat.setVisible(true); 
		
	}
}
