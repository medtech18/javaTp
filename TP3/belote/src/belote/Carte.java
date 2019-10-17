package belote;

import java.awt.Window.Type;
import java.util.Random;

public class Carte {
	Couleur couleur;
	Valeur 	valeur ;
	
	
	public Carte(Couleur couleur, Valeur valeur)
	{
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	public Carte()
	
	{
		
		
		Couleur[] coleurPossibles = Couleur.values();
		Random rand = new Random();
		int nbAuHasard = rand.nextInt(coleurPossibles.length);
		this.couleur = coleurPossibles[nbAuHasard];
		
		Valeur[] valeurPossibles = Valeur.values();
		nbAuHasard = rand.nextInt(valeurPossibles.length);
		this.valeur = valeurPossibles[nbAuHasard];
	}
	
	public String getNom() {
		return this.valeur.getNom()+" de "+this.couleur.getNom();
	}
	
	public boolean egale(Carte oppCarte)
	{
		if((this.valeur == oppCarte.valeur)
				&& (this.couleur == oppCarte.couleur) )
		{
			return true;
		}else
		{
			return false;
		}
			
	}

	public String getFichierImage()
	{
		return valeur.getNom() + "-" + "de-" + couleur.getNom() + ".png" ;
	}
}
