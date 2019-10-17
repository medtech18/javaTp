package belote;

public enum Couleur {
	PIQUE("PIQUE"),
	COEUR("COEUR"),
	CARREAU("CARREAU"),
	TREFLE("TREFLE");
	
	String indice;
	
	Couleur(String indice)
	{
		this.indice = indice;
	}
	    
    public String getNom() 
    {
    	return this.indice.toLowerCase();
    } 
}