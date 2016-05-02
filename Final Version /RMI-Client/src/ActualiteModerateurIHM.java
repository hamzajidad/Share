import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ActualiteModerateurIHM {
	private JButton[] tabButton= new JButton[10];
	private JFrame frame;
	private ArrayList<Actualite> actu = new ArrayList<Actualite>();


	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualiteModerateurIHM window = new ActualiteModerateurIHM();
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
	public ActualiteModerateurIHM() {
		initialize();
	}
	
public JButton MajButton(int index, int position){
		
		JButton btnActuNonValide = new JButton(actu.get(index).getTitre());
		btnActuNonValide.setBackground(new Color(255, 127, 80));
		btnActuNonValide.setBounds(10, position, 290, 29);
		frame.getContentPane().add(btnActuNonValide);
		btnActuNonValide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
			String[] tab2= {actu.get(index).getIdProfil(),actu.get(index).getContenu(),actu.get(index).getdate(), actu.get(index).getTitre()};
			AfficherActualiteIHM.main(tab2);
			}
		});
		
		return btnActuNonValide;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JButton Valider1 = new JButton("Valider");
		Valider1.setBackground(new Color(0, 255, 0));
		Valider1.setBounds(303, 6, 77, 29);
		frame.getContentPane().add(Valider1);
		Valider1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(0).modifierAffichable(actu.get(0).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Valider10 = new JButton("Valider");
		Valider10.setBounds(303, 273, 77, 29);
		frame.getContentPane().add(Valider10);
		Valider10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(9).modifierAffichable(actu.get(9).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer10 = new JButton("Supprimer");
		Supprimer10.setBounds(381, 273, 98, 29);
		frame.getContentPane().add(Supprimer10);
		Supprimer10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(9).modifierAffichable(actu.get(9).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		
		JButton Valider2 = new JButton("Valider");
		Valider2.setBackground(new Color(0, 255, 0));
		Valider2.setBounds(303, 36, 77, 29);
		frame.getContentPane().add(Valider2);
		Valider2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(1).modifierAffichable(actu.get(1).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Valider3 = new JButton("Valider");
		Valider3.setBounds(303, 67, 77, 29);
		frame.getContentPane().add(Valider3);
		Valider3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(2).modifierAffichable(actu.get(2).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Valider4 = new JButton("Valider");
		Valider4.setBounds(303, 96, 77, 29);
		frame.getContentPane().add(Valider4);
		Valider4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(3).modifierAffichable(actu.get(3).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Valider5 = new JButton("Valider");
		Valider5.setBounds(303, 126, 77, 29);
		frame.getContentPane().add(Valider5);
		Valider5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(4).modifierAffichable(actu.get(4).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Valider6 = new JButton("Valider");
		Valider6.setBounds(303, 156, 77, 29);
		frame.getContentPane().add(Valider6);
		Valider6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(5).modifierAffichable(actu.get(5).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Valider7 = new JButton("Valider");
		Valider7.setBounds(303, 186, 77, 29);
		frame.getContentPane().add(Valider7);
		Valider7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(6).modifierAffichable(actu.get(6).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Valider8 = new JButton("Valider");
		Valider8.setBounds(303, 216, 77, 29);
		frame.getContentPane().add(Valider8);
		Valider8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(7).modifierAffichable(actu.get(7).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Valider9 = new JButton("Valider");
		Valider9.setBounds(303, 243, 77, 29);
		frame.getContentPane().add(Valider9);
		Valider9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					actu.get(8).modifierAffichable(actu.get(8).getId(),true,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer1 = new JButton("Supprimer");
		Supprimer1.setBounds(381, 6, 98, 29);
		frame.getContentPane().add(Supprimer1);
		Supprimer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(0).modifierAffichable(actu.get(0).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		
		JButton Supprimer2 = new JButton("Supprimer");
		Supprimer2.setBounds(381, 36, 98, 29);
		frame.getContentPane().add(Supprimer2);
		Supprimer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(1).modifierAffichable(actu.get(1).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer3 = new JButton("Supprimer");
		Supprimer3.setBounds(381, 67, 98, 29);
		frame.getContentPane().add(Supprimer3);
		Supprimer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(2).modifierAffichable(actu.get(2).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer4 = new JButton("Supprimer");
		Supprimer4.setBounds(381, 96, 98, 29);
		frame.getContentPane().add(Supprimer4);
		Supprimer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(3).modifierAffichable(actu.get(3).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer5 = new JButton("Supprimer");
		Supprimer5.setBounds(381, 126, 98, 29);
		frame.getContentPane().add(Supprimer5);
		Supprimer5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(4).modifierAffichable(actu.get(4).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer6 = new JButton("Supprimer");
		Supprimer6.setBounds(381, 156, 98, 29);
		frame.getContentPane().add(Supprimer6);
		Supprimer6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(5).modifierAffichable(actu.get(5).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer7 = new JButton("Supprimer");
		Supprimer7.setBounds(381, 186, 98, 29);
		frame.getContentPane().add(Supprimer7);
		Supprimer7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(6).modifierAffichable(actu.get(6).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer8 = new JButton("Supprimer");
		Supprimer8.setBounds(381, 216, 98, 29);
		frame.getContentPane().add(Supprimer8);
		Supprimer8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(7).modifierAffichable(actu.get(7).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton Supprimer9 = new JButton("Supprimer");
		Supprimer9.setBounds(381, 243, 98, 29);
		frame.getContentPane().add(Supprimer9);
		Supprimer9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("je passe try suppr");
					actu.get(8).modifierAffichable(actu.get(8).getId(),false,true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setBounds(328, 318, 117, 29);
		frame.getContentPane().add(btnFermer);
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();

			}
		});
		
		JButton Recuperer = new JButton("Recuperer");
		Recuperer.setBounds(91, 318, 117, 29);
		frame.getContentPane().add(Recuperer);
		Recuperer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {					
					
					List<Integer> listActuNonValide = ActualiteMethodes.recupererActuNonValide(true);
				
					for(int i=0; i < listActuNonValide.size(); i++ ){
						System.out.println("for1 "+listActuNonValide.size());
						Actualite a = new Actualite(listActuNonValide.get(i));
						if(actu.size()<10){actu.add(a);}
						
					}
					for(int i=0; i < actu.size(); i++){
						System.out.println("for2 "+actu.size());

						if(tabButton[i]!=null){
							frame.remove(tabButton[i]);
						}
						JButton button = MajButton(i, 6 + i*30);
						tabButton[i]=button;
						frame.add(button);
					}	
					
					frame.repaint();
					
					
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
	}

}
