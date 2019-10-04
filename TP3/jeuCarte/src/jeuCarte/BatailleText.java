package jeuCarte;

import java.util.Scanner;

public class BatailleText
{
    Bataille bataille ;

    public BatailleText(String nomJ1 , String nomJ2)
    {
        this.bataille = new Bataille(nomJ1,nomJ2);
    }

    void tour()
    {
        bataille.distribue();
        bataille.afficheMains();
        if(bataille.gagnant() == null)
        {
            System.out.println("Bataille ! on rejoue..\" et relance le tour, dans le cas où il y a bataille");

        }
        else
        {
            System.out.println("C'est le joueur "+ bataille.gagnant().getNom() +" qui remporte le tour");
        }
    }
}
