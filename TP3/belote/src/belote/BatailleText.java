package belote;

import java.util.Scanner;

public class BatailleText
{
	Belote bataille ;

    public BatailleText(String nomJ1 , String nomJ2)
    {
        this.bataille = new Belote(nomJ1,nomJ2,"A","B");
    }

    void tour()
    {
        bataille.distribue();
        bataille.afficheMains();
        
        /*
        if(bataille.gagnant() == null)
        {
            System.out.println("Bataille ! on rejoue..\" et relance le tour, dans le cas où il y a bataille");

        }
        else
        {
            System.out.println("C'est le joueur "+ bataille.gagnant().getNom() +" qui remporte le tour");
        }
        
        */
    }
}
