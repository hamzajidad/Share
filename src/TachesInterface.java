package share;

public interface TachesInterface {

	public void creerTache(String date,String lieu, int idProfil,String sujet,int idTache,String organisateur);
	public void supprimerTache(int idTache);
}
