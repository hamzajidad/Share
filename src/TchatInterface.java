package share;

public interface TchatInterface {
	
	public void envoyerMessage(String message);
	public String recevoirMessage(int idMessage,String message);
    public void rechercheReceveur(String nom,String prenom,String email,String fonction);
}
