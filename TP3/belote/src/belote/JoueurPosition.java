package belote;

public enum JoueurPosition {
	NORD(1) ,
	EST(2) ,
	SUD(3) ,
	OUEST(4);
	
	int indice;
	
	JoueurPosition(int indice)
	{
		this.indice = indice;
	}
	
	
}
