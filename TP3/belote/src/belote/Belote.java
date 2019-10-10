package belote;

import java.util.Random;

public class Belote 
{
	Joueur joueurNord ;
	Joueur joueurSud ;
	Joueur joueurOuest ;
	Joueur joueurEst ;
	Couleur atout ;
	Couleur demandee;
	
	Belote(String nomJnord , String nomJsud , String nomJest  , String nomJouest )
	{
		this.joueurNord  = new Joueur(nomJnord);
		this.joueurSud   = new Joueur(nomJsud);
		this.joueurOuest = new Joueur(nomJouest);
		this.joueurEst   = new Joueur(nomJest);
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
		this.joueurEst.carte   	= tabCartes[3];
		
		this.demandee	 = joueurJoue(joueurNord).couleur;	

	}
	
    public boolean isUnique(Carte[] cardArray, Carte oneCard) // A Modifier la boucle while 
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
		System.out.println("le joueur  " + this.joueurEst.getNom() + " a  une(e) " + this.joueurEst.carte.getNom());
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
	
	public Joueur gagnant() 
	{ 		
		Joueur winerEquipe1=remporte(joueurNord,joueurSud); 
		Joueur winerEquipe2=remporte(joueurOuest,joueurEst);
		if (winerEquipe1==null)
			winerEquipe1=joueurNord;
		if (winerEquipe2==null)
			winerEquipe2=joueurOuest;
		return remporte(winerEquipe1,winerEquipe2);
	}
	
	public int valeurcarte(Joueur j) 
	{ 		
		int v=0;
		if(j.carte.couleur == atout) 
		{
			v=j.carte.valeur.getValeurAtout();
		}else
		{ 			
			v=j.carte.valeur.getValeur(); 		
		} 		
		return v; 	
	} 	
	public int points() 
	{ 		
		int s=0; 		
		s=s+valeurcarte(joueurNord); 		
		s=s+valeurcarte(joueurSud); 		
		s=s+valeurcarte(joueurOuest); 		
		s=s+valeurcarte(joueurEst); 		
		return s; 	
	}
	
	public String mains()
	{
		String maChaine = "<html>\n";
		maChaine += "La couleur d'atout est "+ this.atout +"<br/>\n" ;
		maChaine += "La couleur demandée est "+ this.demandee +"<br/>\n";
		maChaine += "Le joueur Nord"+ this.joueurNord.getNom() +"a un(e)"+ this.joueurNord.carte.getNom() + "<br/>\n";
		maChaine += "Le joueur Nord"+ this.joueurOuest.getNom() +"a un(e)"+ this.joueurOuest.carte.getNom() + "<br/>\n";
		maChaine += "Le joueur Nord"+ this.joueurSud.getNom() +"a un(e)"+ this.joueurSud.carte.getNom() + "<br/>\n";
		maChaine += "Le joueur Nord"+ this.joueurEst.getNom() +"a un(e)"+ this.joueurEst.carte.getNom() + "</br>\n";
		maChaine += "</html> \n";

		return maChaine;
	}
}
