import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class ActualiteMethodes{

	
	public static List<Integer> recupererFilActualite() throws MalformedURLException, RemoteException, NotBoundException{
		
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Actualite");
		List<Integer> filActu = ((ActualiteInterface) r).recupererFilActu();
		return filActu;
	}


}
