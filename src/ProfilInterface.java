package share;

public interface ProfilInterface {

	public void creerProfil(String nom, String prenom,String mdp,String email,String fonction, String statut); 
	public String[] recupererProfil(int id);
	public String recupererNom(int id);
	public String recupererPrenom(int id);
	public String recupererMdp(int id);
	public String recupererEmail(int id);
	public String recupererFonction(int id);
	public String recupererStatut(int id);
	public void supprimmerProfil(int id);
	public void modifierNom(int id,String nom);
	public void modifierPrenom(int id, String prenom);
	public void modifierMdp(int id,String mdp);
	public void modifierEmail(int id,String email);
	public void modifierFonction(int id,String fonction);
	public void modifierStatut(int id,String statut);

}
