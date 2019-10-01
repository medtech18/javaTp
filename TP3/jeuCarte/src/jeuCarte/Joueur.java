package jeuCarte;

public class Joueur {
	
	String nom ;
	Carte carte ;
	
	public Joueur(String nom)
	{
		this.nom = nom;
	}
	
	public void donnerCarte(Carte carte)
	{
		
	}
	
	public Carte joue()
	{
		return this.carte;
	}
}
