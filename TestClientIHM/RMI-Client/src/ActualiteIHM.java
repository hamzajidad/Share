import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ActualiteIHM {

	private JFrame frmActualit;
	private JTextField txtPublierIci;

	/**
	 * Launch the application.
	 */
	public static void NewPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualiteIHM window = new ActualiteIHM();
					window.frmActualit.setVisible(true);

					window.frmActualit.setSize(500,400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ActualiteIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmActualit = new JFrame();
		frmActualit.setBackground(new Color(128, 128, 128));
		frmActualit.getContentPane().setBackground(new Color(128, 128, 128));
		frmActualit.setTitle("Actualité");
		frmActualit.setBounds(100, 100, 450, 300);
		frmActualit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmActualit.getContentPane().setLayout(null);
		
		JButton btnPublier = new JButton("Publier");
		
		btnPublier.setBackground(new Color(233, 150, 122));
		btnPublier.setBounds(155, 218, 117, 25);
		frmActualit.getContentPane().add(btnPublier);
		
		JButton btnClose = new JButton("Fermer");
		
		btnClose.setBackground(new Color(233, 150, 122));
		btnClose.setBounds(155, 244, 117, 25);
		frmActualit.getContentPane().add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmActualit.dispose();

			}
		});
		
		txtPublierIci = new JTextField();
		txtPublierIci.setBackground(new Color(250, 235, 215));
		txtPublierIci.setText("Publier ici");
		txtPublierIci.setBounds(12, 12, 424, 160);
		frmActualit.getContentPane().add(txtPublierIci);
		txtPublierIci.setColumns(10);
		
		frmActualit.setSize(500,500);
		frmActualit.setVisible(true); 
		btnPublier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String contenu = txtPublierIci.getText();
					System.out.println(contenu);
					Actualite a=new Actualite(contenu, LoginIHM.utilisateur.getLogin() );
					a.sendActualite();
					frmActualit.dispose();
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}