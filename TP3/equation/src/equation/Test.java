package equation;

public class Test {

	public static void main(String[] args) {
	    Trinome eq1 = new Trinome(1,1,1);
	    int nbRac;
	    nbRac = eq1.nbRacines();
	    // ...
	        System.out.println("Le système : " + eq1.equation() + " n'a pas de solution");
	    // ...
	        System.out.println("Le système : " + eq1.equation() + " a une seule solution: " + eq1.getRacine1());
	    // ...
	        System.out.println("Le système : " + eq1.equation() + " a 2 solutions: " + eq1.getRacine1() + " et " + eq1.getRacine2());
	 
	    Trinome eq2 = new Trinome(2, 3, -5);
	     nbRac = eq2.nbRacines();
	    // ...
	        System.out.println("Le système : " + eq2.equation() + " n'a pas de solution");
	    // ...
	        System.out.println("Le système : " + eq2.equation() + " a une seule solution: " + eq2.getRacine1());
	    // ...
	        System.out.println("Le système : " + eq2.equation() + " a 2 solutions: " + eq2.getRacine1() + " et " + eq2.getRacine2());
	 
	     Trinome eq3 = new Trinome(0, 2, 1);
	     nbRac = eq3.nbRacines();
	    // ...
	        System.out.println("Le système : " + eq3.equation() + " n'a pas de solution");
	    // ...
	        System.out.println("Le système : " + eq3.equation() + " a une seule solution: " + eq3.getRacine1());
	    // ...
	        System.out.println("Le système : " + eq3.equation() + " a 2 solutions: " + eq3.getRacine1() + " et " + eq3.getRacine2());
	}

}
