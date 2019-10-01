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
        switch (this.indice)
        {
            case "1":
                return "sept";
            case "2":
                return "huit";
            case "3":
                return "neuf";
            case "4":
                return "dix";
            case "5":
                return "valet";
            case "6":
                return "dame";
            case "7":
                return "roi";
            case "8":
                return "as";

        }
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
