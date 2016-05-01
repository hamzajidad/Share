import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadFilDactualiteIHM implements Runnable {
	
	public static JFrame frame = MainIHM.frame;
	public static String[] tab={"","","","","","","","","",""};
	public JButton btnActu1, btnActu2, btnActu3, btnActu4, btnActu5, btnActu6, btnActu7, btnActu8, btnActu9, btnActu10;
	private ArrayList<Actualite> actu = new ArrayList<Actualite>();
	
	public ThreadFilDactualiteIHM(){}
	
	public List<Actualite> getActu(){
		
		return actu;
		
	}
	
	public void run(){

		while(true){
			try {
				
				List<String> listTchat = TchatMethodes.detecteterConversation();
				if(!listTchat.isEmpty()){
					for(int i = 0; i < listTchat.size(); i++){
						Profil destinataire = new Profil(listTchat.get(i));
						Boolean bool =true;
						if(!MainIHM.listTchat.isEmpty()){
							System.out.println(MainIHM.listTchat.size());
							for(int j=0; j < MainIHM.listTchat.size(); j++){
								if(MainIHM.listTchat.get(j).getCorrespondant().getLogin().equals(destinataire.getLogin())){
									bool=false;
								}
							}
						}
						if(bool){
							Tchat tchat = new Tchat(LoginIHM.utilisateur,destinataire);
							TchatIHM.NewPage(tchat);
						}
					}
				}

				List<Integer> listActu = ActualiteMethodes.recupererFilActualite();
				if(actu.isEmpty() || listActu.get(listActu.size()-1) != (actu.get(actu.size()-1)).getId()){
					Actualite a;
					
					for(int i=0; i<listActu.size(); i++){
						a = new Actualite(listActu.get(i));
						actu.add(i, a);	
						//if(!actu.isEmpty()){System.out.println("actu :"+actu.get(actu.size()-1).getContenue());}
					}
					System.out.println("passe2");
					for(int i=0;i<actu.size();i++){
						if(i<10){
							tab[i]=actu.get(i).getContenu();
							System.out.println(tab[i]);
						}

					}
					
					JButton btnActu1 = new JButton(ThreadFilDactualiteIHM.tab[9]);
					btnActu1.setBackground(new Color(255, 127, 80));
					btnActu1.setBounds(413, 38, 290, 43);
					frame.getContentPane().add(btnActu1);
					btnActu1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=10){
							String[] tab2= {actu.get(9).getIdProfil(),actu.get(9).getContenu(),actu.get(9).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu1.repaint();

					
					JButton btnActu2 = new JButton(ThreadFilDactualiteIHM.tab[8]);
					btnActu2.setBackground(new Color(255, 127, 80));
					btnActu2.setBounds(413, 82, 290, 43);
					frame.getContentPane().add(btnActu2);
					btnActu2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=9){

							String[] tab2= {actu.get(8).getIdProfil(),actu.get(8).getContenu(),actu.get(8).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu2.repaint();

					
					JButton btnActu3 = new JButton(ThreadFilDactualiteIHM.tab[7]);
					btnActu3.setBackground(new Color(255, 127, 80));
					btnActu3.setBounds(413, 126, 290, 43);
					frame.getContentPane().add(btnActu3);
					btnActu3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=8){

							String[] tab2= {actu.get(7).getIdProfil(),actu.get(7).getContenu(),actu.get(7).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu3.repaint();

					
					JButton btnActu4 = new JButton(ThreadFilDactualiteIHM.tab[6]);
					btnActu4.setBackground(new Color(255, 127, 80));
					btnActu4.setBounds(413, 170, 290, 43);
					frame.getContentPane().add(btnActu4);
					btnActu4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=7){

							String[] tab2= {actu.get(6).getIdProfil(),actu.get(6).getContenu(),actu.get(6).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu4.repaint();

					
					JButton btnActu5 = new JButton(ThreadFilDactualiteIHM.tab[5]);
					btnActu5.setBackground(new Color(255, 127, 80));
					btnActu5.setBounds(413, 214, 290, 43);
					frame.getContentPane().add(btnActu5);
					btnActu5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=6){

							String[] tab2= {actu.get(5).getIdProfil(),actu.get(5).getContenu(),actu.get(5).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu5.repaint();

					
					JButton btnActu6 = new JButton(ThreadFilDactualiteIHM.tab[4]);
					btnActu6.setBackground(new Color(255, 127, 80));
					btnActu6.setBounds(413, 258, 290, 43);
					frame.getContentPane().add(btnActu6);
					btnActu6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=5){

							String[] tab2= {actu.get(4).getIdProfil(),actu.get(4).getContenu(),actu.get(4).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu6.repaint();

					
					JButton btnActu7 = new JButton(ThreadFilDactualiteIHM.tab[3]);
					btnActu7.setBackground(new Color(255, 127, 80));
					btnActu7.setBounds(413, 302, 290, 43);
					frame.getContentPane().add(btnActu7);
					btnActu7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=4){

							String[] tab2= {actu.get(3).getIdProfil(),actu.get(3).getContenu(),actu.get(3).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu7.repaint();

					
					JButton btnActu8 = new JButton(ThreadFilDactualiteIHM.tab[2]);
					btnActu8.setBackground(new Color(255, 127, 80));
					btnActu8.setBounds(413, 346, 290, 43);
					frame.getContentPane().add(btnActu8);
					btnActu8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=3){

							String[] tab2= {actu.get(2).getIdProfil(),actu.get(2).getContenu(),actu.get(2).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu8.repaint();

					
					JButton btnActu9 = new JButton(ThreadFilDactualiteIHM.tab[1]);
					btnActu9.setBackground(new Color(255, 127, 80));
					btnActu9.setBounds(413, 390, 290, 43);
					frame.getContentPane().add(btnActu9);
					btnActu9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=2){

							String[] tab2= {actu.get(1).getIdProfil(),actu.get(1).getContenu(),actu.get(1).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu9.repaint();

					
					JButton btnActu10 = new JButton(ThreadFilDactualiteIHM.tab[0]);
					btnActu10.setBackground(new Color(255, 127, 80));
					btnActu10.setBounds(413, 434, 290, 43);
					frame.getContentPane().add(btnActu10);
					btnActu10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1) {
							if(actu.size()>=1){

							String[] tab2= {actu.get(0).getIdProfil(),actu.get(0).getContenu(),actu.get(0).getdate()};
							AfficherActualiteIHM.main(tab2);
							}
						}
					});
					
					btnActu10.repaint();

					
				}
				
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}