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
	
	
	int indice;
	int valeur ;
	int valeurAtout ;
	
    Valeur(int indice )
    {
    	switch(indice)
    	{
    		case 1: case 2:
    			this.valeur 	 = 0;
    			this.valeurAtout = 0 ;
    			break;
    		case 3 :
    			this.valeur 	 = 0;
    			this.valeurAtout = 14 ;
    			break;
    		case 4 :
    			this.valeur 	 = 10;
    			this.valeurAtout = 10 ;
    			break;
    		case 5 :
    			this.valeur 	 = 2;
    			this.valeurAtout = 20;
    			break;
    		case 6 :
    			this.valeur 	 = 3;
    			this.valeurAtout = 3;	
    			break;
    		case 7 :
    			this.valeur 	 = 4;
    			this.valeurAtout = 4;
    			break;
    		case 8 :
    			this.valeur 	 = 11;
    			this.valeurAtout = 11;
    			break;
    		default:
    			break;
    			
    	}
    	this.indice = indice ;
    }
    
    int getIndice()
    {
    	return indice;
    }
    public String getNom() 
    {
    	return this.name().toLowerCase();
    }
    
    int getValeur()
    {
        return this.valeur ;
    }

    int getValeurAtout()
    {
        return this.valeurAtout ;
    }
}
