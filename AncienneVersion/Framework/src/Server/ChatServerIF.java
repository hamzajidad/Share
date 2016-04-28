package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Client.ChatClientIF;

public interface ChatServerIF extends Remote {
	
	void registerChatClient(ChatClientIF chatClient) throws RemoteException;
	void broadcastMessage(String Message) throws RemoteException;

}
