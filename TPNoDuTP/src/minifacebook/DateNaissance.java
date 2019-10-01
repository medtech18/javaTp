/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minifacebook;

import java.util.Calendar;

/**
 *
 * @author elasrim
 */
public class DateNaissance {
    private int jour ;
    private int mois ;
    private int annee;
    
    DateNaissance()
    {
        this.jour  = 23   ;
        this.mois  = 07   ;
        this.annee = 1912 ;
    }
    
    DateNaissance(int jour,int mois,int annee)
    {
        this.jour  = jour   ;
        this.mois  = mois   ;
        this.annee = annee ;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    public void ecritDate()
    {
        System.out.println(this.jour +"/" + this.mois + "/" + this.annee );
    }
    
    public int age()
    {
        return Calendar.getInstance().get(Calendar.YEAR) - this.annee;
    }
    
    

}
