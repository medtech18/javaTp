package jeuCarte;

public enum Valeur {

    SEPT("sept"),
    HUIT("huit"),
    NEUF("neuf"),
    DIX("dix"),
    VALET("valet"),
    DAME("dame"),
    ROI("roi"),
    AS("as");
	
	String indice ;
    
    public String getNom() 
    {
    	return this.indice;
    }
    
    Valeur(String indice )
    {
    	this.indice = indice ;
    }
   
}
