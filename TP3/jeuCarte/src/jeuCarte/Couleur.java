package jeuCarte;

public enum Couleur {
	PIQUE("pique"),
	COEUR("coeur"),
	CARREAU("carreau"),
	TREFFLE("trefle"); 
	
	String indice ;
    
    public String getNom() 
    {
    	return this.indice;
    }
    
    Couleur(String indice)
    {
    	this.indice = indice ;
    }
   



}
