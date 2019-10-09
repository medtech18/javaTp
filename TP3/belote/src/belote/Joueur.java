package belote;

public class Joueur {
	
	String nom ;
	Carte carte ;
	int points ;
	
	public Joueur(String nom)
	{
		this.nom 	= nom;
		this.carte 	= new Carte();
		this.points = 0;
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
	
	public void remporte(int points)
	{
		this.points = points;
	}
}
