package IHM;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;

public class Login {

	protected static final Container frame = null;
	private JFrame frmLogIn;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogIn.setVisible(true);
					window.frmLogIn.setSize(800, 800);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setBackground(Color.GRAY);
		frmLogIn.getContentPane().setBackground(new Color(128, 128, 128));
		frmLogIn.setTitle("Log in");
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(250, 235, 215));
		textField.setBounds(23, 57, 114, 19);
		frmLogIn.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Identifiant");
		lblName.setBounds(33, 30, 104, 15);
		frmLogIn.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(250, 235, 215));
		textField_1.setBounds(23, 115, 114, 19);
		frmLogIn.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(33, 88, 96, 15);
		frmLogIn.getContentPane().add(lblMotDePasse);
		
		JButton btnGo = new JButton("Connectez-vous");
		btnGo.setBackground(new Color(233, 150, 122));
		btnGo.setBounds(143, 220, 166, 25);
		frmLogIn.getContentPane().add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String cmd =e1.getActionCommand();
					if (cmd.equals("Connectez-vous")){
						frmLogIn.dispose();
						Main log = new Main();
						log.NewPage();
					}
				}
			});
		btnGo.setBounds(143, 220, 166, 25);
		frmLogIn.getContentPane().add(btnGo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/IHM/logo.png")));
		lblNewLabel.setBounds(185, 0, 251, 175);
		frmLogIn.getContentPane().add(lblNewLabel);
	}



}
