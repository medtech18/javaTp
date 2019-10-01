package equation;

public class Trinome {
	
		double a ;
		double b ;
		double c ;
		double delta ;
		Trinome(double a , double b , double c){
			this.a=a;
			this.b=b;
			this.c=c;
			this.delta=(b*b)-4*a*c;
		}
		
		
	public int nbRacines() {
		int res = 1;
		if(delta < 0) {
			res=0;
		}else if (delta==0) {
			res=1;
		}else {
			res=2;
		}
		return res ;
	}
	
	public double getRacine1() {
		double racine=0.0;
		int nbracine = this.nbRacines();
		if (a!=0) 
		{
				switch(nbracine) 
				{
					case 1:
						racine = -b / (2*a);
						break;
					case 2:
						racine = (-b -Math.sqrt(delta)) / (2*a);
						break;
					case 0:
						default:
							System.out.println("Attention pas de racine");
							break;					
				}		
			}else 
			{ 
				if (b!=0) 
				{
					racine = -c / b;
				}else 
				{
					System.out.println("equation non valide");
				}
			}
		return racine ;
		}
	
	public double getRacine2() {
		double racine=0.0;
		int nbracine = this.nbRacines();
		if (a!=0) 
		{
				switch(nbracine) 
				{
					case 1:
						racine = -b / (2*a);
						break;
					case 2:
						racine = (-b -Math.sqrt(delta)) / (2*a);
						break;
					case 0:
						default:
							System.out.println("Attention pas de racine");
							break;					
				}		
			}else 
			{ 
				if (b!=0) 
				{
					racine = -c / b;
				}else 
				{
					System.out.println("equation non valide");
				}
			}
		return racine ;
		}
	
	public String equation()
	 {
		
		String s = " ";
		if (a != 0) {
			s+=a+"x*x";
		}
		if(b>0) {
			s+="+"+b+"x";
		}
		else if (b<0) {
			s+=b+"x";
		}
		if (c>0) {
			s+="+"+c;
		}
		else if (c<0) {
			s+=c ;
		}
		s+="=0";
		return s;
	 }
}
