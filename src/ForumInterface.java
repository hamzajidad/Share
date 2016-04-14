package share;

public interface ForumInterface {

	public void posterSujet(int idProfil,int idSujet,String sujet);
	public void repondreSujet(int idProfil,String sujet);
	public void supprimerSujet(int idSujet);
	public void supprimerCommentaire(int idSujet,String commentaire);
	public void validationSujet(int idSujet,boolean valide);
}
