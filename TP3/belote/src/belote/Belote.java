package belote;

import java.util.Random;

public class Belote 
{
	Joueur joueurNord ;
	Joueur joueurSud ;
	Joueur joueurOuest ;
	Joueur joueurest ;
	Couleur atout ;
	Couleur demandee;
	
	Belote(String nomJnord , String nomJsud , String nomJouest , String nomJest)
	{
		this.joueurNord  = new Joueur(nomJnord);
		this.joueurSud   = new Joueur(nomJsud);
		this.joueurOuest = new Joueur(nomJouest);
		this.joueurest   = new Joueur(nomJest);
		this.demandee	 = joueurJoue(joueurNord).couleur;	
		changeAtout();
	}
	
	public void distribue()
	{
		Carte[] tabCartes  = new Carte[4] ;
		Carte newCard ;

		for(int i = 0 ; i < tabCartes.length ; i++)
		{
			do
			{
				newCard = new Carte();
			}while(!isUnique(tabCartes,newCard));
			
			tabCartes[i] =  newCard;	
		}
		
		this.joueurNord.carte   = tabCartes[0];
		this.joueurSud.carte   	= tabCartes[1];
		this.joueurOuest.carte 	= tabCartes[2];
		this.joueurest.carte   	= tabCartes[3];

	}
	
    public boolean isUnique(Carte[] cardArray, Carte oneCard) 
    {
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i] != null && cardArray[i].egale(oneCard)) 
            {
                return false;
            }
        }
        return true;
    }
    
	public void afficheMains()
	{
		System.out.println("le joueur  " + this.joueurNord.getNom() + " a  une(e) " + this.joueurNord.carte.getNom());
		System.out.println("le joueur  " + this.joueurSud.getNom() + " a  une(e) " + this.joueurSud.carte.getNom());
		System.out.println("le joueur  " + this.joueurOuest.getNom() + " a  une(e) " + this.joueurOuest.carte.getNom());
		System.out.println("le joueur  " + this.joueurest.getNom() + " a  une(e) " + this.joueurest.carte.getNom());
	}
	
	public Carte joueurJoue(Joueur joueur)
	{
		return joueur.carte;
		
	}
	
	public void changeAtout()
	{
		Couleur[] coleurPossibles = Couleur.values();
		Random rand = new Random();
		int nbAuHasard = rand.nextInt(coleurPossibles.length);
		this.atout = coleurPossibles[nbAuHasard];
	}
	
	public Joueur remporte(Joueur joueur1, Joueur joueur2)
	{
		Joueur tempJoueur = null;
		if(joueur1.carte.couleur != atout && joueur2.carte.couleur != atout)
		{
			if(joueur1.carte.couleur == demandee && joueur2.carte.couleur == demandee)
			{
				if(joueur1.carte.valeur.getValeur() > joueur2.carte.valeur.getValeur())
				{
					tempJoueur = joueur1 ;
				}else
				{
					tempJoueur = joueur2 ;
				}
			}else if(joueur2.carte.couleur == demandee)
			{
				tempJoueur = joueur2 ;
			}else if(joueur1.carte.couleur == demandee)
			{
				tempJoueur = joueur1 ;
			}
		}else if(joueur1.carte.couleur == atout && joueur2.carte.couleur != atout)
		{
			tempJoueur = joueur1 ;
		}else if(joueur1.carte.couleur != atout && joueur2.carte.couleur == atout)
		{
			tempJoueur = joueur2 ;
		}else if(joueur1.carte.couleur == atout && joueur2.carte.couleur == atout)
		{
			if(joueur1.carte.valeur.getValeurAtout() > joueur2.carte.valeur.getValeurAtout())
			{
				tempJoueur = joueur1 ;
			}else
			{
				tempJoueur = joueur2 ;
			}
		}
		return tempJoueur;
	}
}
