package serveur;

public enum statut {
	superAdmin("superAdmin"),
	admin("admin"),
	user("user");
	
	private String name="";
	
	//constructeur
	statut(String name){
		
		this.name=name;
	}	
	
	public String toString(){
		return name;
	}
	
	
	
}

