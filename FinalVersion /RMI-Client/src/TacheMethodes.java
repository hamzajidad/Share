import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class TacheMethodes {
	public static ArrayList<Integer> recupererInvitation(String loginInvite) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		return ((TacheInterface) r).recupererInvitation(loginInvite);
	
	}
}
