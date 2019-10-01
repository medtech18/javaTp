package jeuCarte;

public enum Valeur {

    SEPT("1"),
    HUIT("2"),
    NEUF("3"),
    DIX("4"),
    VALET("5"),
    DAME("6"),
    ROI("7"),
    AS("8");
	
	String indice ;
    
    public String getNom() 
    {
    	return this.indice;
    }
    
    Valeur(String indice )
    {
    	this.indice = indice ;
    }

    int getIndice()
    {
        return Integer.valueOf(this.indice);
    }

}
