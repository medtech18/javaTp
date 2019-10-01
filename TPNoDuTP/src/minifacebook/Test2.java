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
public class Test2 {
        public static void main(String[] args) 
        {
        
        DateNaissance naissancehermonnie = new DateNaissance(15, 4, 1990);
        Personne hermonnie = new Personne("Granger","Hermonie",naissancehermonnie);
        
        DateNaissance naissanceron = new DateNaissance(24, 8, 1988);
        Personne ron = new Personne("Weasley","Ron",naissanceron);

        DateNaissance naissanceharry = new DateNaissance(23, 7, 1989);
        Personne harry = new Personne("Potter", "Harry", naissanceharry);
        
        hermonnie.setAmi(ron);
        hermonnie.setMeilleurAmi(harry);
        
        ron.setAmi(harry);
        ron.setMeilleurAmi(hermonnie);
        
        harry.setAmi(ron);
        harry.setMeilleurAmi(hermonnie);
 
    }
}
