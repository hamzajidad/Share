package IHM;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;

public class Partage {

	private JFrame frmPartage;
	private JTextField txtEntrezVotreTexte;
	private JTextField txtPath; //Assume this is the text box you placed beside browse button


	/**
	 * Launch the application.
	 */
	public static void NewPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partage pg = new Partage();
					pg.frmPartage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Partage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPartage = new JFrame();
		frmPartage.setBackground(new Color(192, 192, 192));
		frmPartage.setTitle("Partage");
		frmPartage.setBounds(100, 100, 450, 300);
		frmPartage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 448, 10);
		frmPartage.getContentPane().add(panel);
		
		txtEntrezVotreTexte = new JTextField();
		txtEntrezVotreTexte.setForeground(Color.GRAY);
		txtEntrezVotreTexte.setText("Entrez votre texte ici");
		txtEntrezVotreTexte.setBounds(12, 54, 424, 37);
		panel.add(txtEntrezVotreTexte);
		txtEntrezVotreTexte.setColumns(10);
		

		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBackground(new Color(233, 150, 122));
		btnBrowse.setForeground(new Color(0, 0, 0));
		btnBrowse.setBounds(12, 103, 117, 25);
		panel.add(btnBrowse);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
			
				JFileChooser fileChooser = new JFileChooser();
				 
		        // For Directory
		        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		 
		        // For File
		        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		 
		        fileChooser.setAcceptAllFileFilterUsed(false);
		 
		        int rVal = fileChooser.showOpenDialog(null);
		        if (rVal == JFileChooser.APPROVE_OPTION) {
		          txtPath.setText(fileChooser.getSelectedFile().toString());
		        }
			}
				});
	
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBackground(new Color(233, 150, 122));
		btnUpload.setForeground(new Color(0, 0, 0));
		btnUpload.setBounds(12, 154, 117, 25);
		panel.add(btnUpload);
	}
}
