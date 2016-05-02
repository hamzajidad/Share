import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ThreadTchat implements Runnable{
	public static String tampon="";
	private JTextArea textArea;
	private Tchat tchatAttribut;
	private JPanel panel=TchatIHM.panel;
	
	public ThreadTchat(Tchat tchat){
		this.tchatAttribut=tchat;

		
	}
	
	  public void writeMsg(String l){  textArea.setText(textArea.getText()+l);  }


	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(true){
			System.out.println("debut whiletchat");
		try {
			if(panel!=null){
			textArea = new JTextArea();
			textArea.setBounds(121, 12, 312, 248);
			panel.add(textArea);
			}
			List<String> mess = tchatAttribut.recevoirMessage();
			if(!mess.isEmpty()){
			System.out.println(mess);
			for(int i=0; i<mess.size();i++){
				tampon += tchatAttribut.getCorrespondant().getLogin()+" : "+mess.get(i)+"\n"; 
			}
			writeMsg(tampon);

			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("je mendors");
			Thread.sleep(5000);
			System.out.println("je me reveil");
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
