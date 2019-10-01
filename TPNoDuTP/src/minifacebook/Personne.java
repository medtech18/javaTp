/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minifacebook;

/**
 *
 * @author elasrim
 */
public class Personne {
    private String nom ;
    private String prenom ;
    private DateNaissance dateNaissance ;
    private Personne ami ;
    private Personne meilleurAmi ;

    public Personne(String nom, String prenom, DateNaissance dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ami = null;
        this.meilleurAmi = null;
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public DateNaissance getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(DateNaissance dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Personne getAmi() {
        return ami;
    }

    public void setAmi(Personne ami) {
        this.ami = ami;
    }

    public Personne getMeilleurAmi() {
        return meilleurAmi;
    }

    public void setMeilleurAmi(Personne meilleurAmi) {
        this.meilleurAmi = meilleurAmi;
    }
    
    public void ecritInfos()
    {
        System.out.println("------------------------------------");
        System.out.println(this.prenom +"  " +this.nom );
        System.out.println("Né(e) le : " + this.dateNaissance.getJour() + "/" + this.dateNaissance.getMois() + "/" + this.dateNaissance.getAnnee() + " ("+ this.dateNaissance.age()+" ans)" );
        System.out.println("Meilleur ami : " + getMeilleurAmi().getNom());
        System.out.println("Ami : " + getAmi().getNom());
        System.out.println("------------------------------------");
    }
    
    
    
}
