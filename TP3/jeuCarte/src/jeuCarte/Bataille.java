package jeuCarte;

public class Bataille 
{
	Joueur joueur1 ;
	Joueur joueur2 ;
	
	public Bataille(String nomJ1 , String nomJ2)
	{
		this.joueur1.nom = nomJ1 ;
		this.joueur2.nom = nomJ2 ;
	}

	public void distribue()
	{
		this.joueur1.carte = new Carte();

		do
		{
			this.joueur1.carte = new Carte();
		}while(this.joueur1.equals(this.joueur1.carte));

	}
	
}