package belote;

public class Joueur {
	
	String nom ;
	Carte carte ;
	
	public Joueur(String nom)
	{
		this.nom = nom;
		this.carte = new Carte();
	}
	
	public void donnerCarte(Carte carte)
	{
		
	}

	public String getNom()
	{
		return this.nom;
	}
	
	public Carte joue()
	{
		return this.carte;
	}
}
