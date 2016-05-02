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
	private JButton[] tabButton= new JButton[10];
	
	public ThreadFilDactualiteIHM(){}
	
	public List<Actualite> getActu(){
		
		return actu;
		
	}
	
	public JButton MajButton(int index, int position){
		
		JButton btnActu = new JButton(ThreadFilDactualiteIHM.tab[index]);
		btnActu.setBackground(new Color(255, 127, 80));
		btnActu.setBounds(413, position, 290, 43);
		frame.getContentPane().add(btnActu);
		btnActu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(actu.size()>=10){
				String[] tab2= {actu.get(index).getIdProfil(),actu.get(index).getContenu(),actu.get(index).getdate(), actu.get(index).getTitre()};
				AfficherActualiteIHM.main(tab2);
				}
			}
		});
		
		return btnActu;
		
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
					}
				}

				//ArrayList<Integer> listActu = new ArrayList<Integer>();
				List<Integer> listActu = ActualiteMethodes.recupererFilActualite();
				System.out.println(actu.isEmpty() || listActu.get(listActu.size()-1) != (actu.get(actu.size()-1)).getId());
				if(!actu.isEmpty()){
					for(int i=0; i<actu.size();i++){
						System.out.println("actu "+actu.get(i).getId()+" "+i);
					}
					for(int i=0; i<listActu.size();i++){
						System.out.println("listActu "+listActu.get(i)+" "+i);
					}
				}
				if(actu.isEmpty() || listActu.get(listActu.size()-1) != (actu.get(actu.size()-1)).getId()){
					Actualite a;
					actu.clear();
					for(int i=0; i<listActu.size(); i++){
						a = new Actualite(listActu.get(i));
						actu.add(a);	
						//actu.add(i,a);
					}
					for(int i=0;i<actu.size();i++){
						if(i<10){
							tab[i]=actu.get(i).getTitre();
							//System.out.println(tab[i]);
						}

					}
					
					
					
					
					for(int i=9; i >= 0; i--){
						if(tabButton[i]!=null){
						frame.remove(tabButton[i]);}
						JButton button = MajButton(i, 434-i*44);
						tabButton[i]=button;
						frame.add(button);

						
					}
					
					

					
					frame.repaint();
				}
				
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(5000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}