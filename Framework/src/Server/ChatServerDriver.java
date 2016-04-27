package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ChatServerDriver {
	
	public static void main(String[] agrs) throws RemoteException, MalformedURLException{
		Naming.rebind("RMIChatServer", new ChatServer());
	}

}
