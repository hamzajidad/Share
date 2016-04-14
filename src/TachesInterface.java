package share;

public interface TachesInterface {

	public void creerTache(String date,String lieu, int idProfil,String sujet,int idTache,String organisateur);
	public void supprimerTache(int idTache);
	public void ajouterInvitation(int idTache,int idProfil,String contenu);
	public void validationInvitation(boolean valide);
}
