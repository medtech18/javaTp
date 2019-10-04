package belote;

public enum Valeur {

    SEPT(1),
    HUIT(2),
    NEUF(3),
    DIX(4),
    VALET(5),
    DAME(6),
    ROI(7),
    AS(8);
	
	int valeur ;
	int valeurAtout ;
    
    public String getNom() 
    {
    	String nom = "";
    	
        switch (this.valeur)
        {
            case 1:
            	nom = "sept";
                break;
            case 2:
            	nom = "huit";
                break;
            case 3:
            	nom = "neuf";
                break;
            case 4:
            	nom = "dix";
                break;
            case 5:
            	nom = "valet";
            	break;
            case 6:
            	nom = "dame";
            	break;
            case 7:
            	nom = "roi";
            	break;
            case 8:
            	nom = "as";
            	break;
            default :
        }
        return nom;
    }
    
    Valeur(int valeur )
    {
    	this.valeur = valeur ;
    }
    
    int getValeur()
    {
    	return valeur;
    }
    
    int getValeurAtout()
    {
    	return valeurAtout;
    }

}
