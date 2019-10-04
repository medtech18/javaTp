package belote;


public class Bataille
{
	Joueur joueur1 ;
	Joueur joueur2 ;
	
	public Bataille(String nomJ1 , String nomJ2)
	{
		this.joueur1 = new Joueur(nomJ1);
		this.joueur2 = new Joueur(nomJ2);
	}

	public void distribue()
	{
		this.joueur1.carte = new Carte();

		do
		{
			this.joueur2.carte = new Carte();
		}while(this.joueur1.carte.egale(this.joueur2.carte));

	}

	public Joueur gagnant()
	{
		if(this.joueur1.carte.egale(this.joueur1.carte))
			return null;
		if(this.joueur1.carte.valeur.getValeur() > this.joueur2.carte.valeur.getValeur())
			return this.joueur1;
		else
			return this.joueur2;
	}

	public void afficheMains()
	{
		System.out.println("le joueur  " + this.joueur1.getNom() + " a  une(e) " + this.joueur1.carte.getNom());
		System.out.println("le joueur  " + this.joueur2.getNom() + " a  une(e) " + this.joueur2.carte.getNom());
	}
}
