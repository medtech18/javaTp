package mePackage;

public class Types {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i       = 0   ;
		long l      = 0L  ;
		double d    = 0.  ;
		float f     = 0.F ;
		boolean b   = false ;
		 
		d = 3.14 ;                          // L1 3.14
		System.out.println("L1 = "+d) ;
		f = (float)(d / 2.) ;               // L2 1.57
		System.out.println("L2 = "+f) ;
		i = (int)  (d / 2.) ;               // L3 1
		System.out.println("L3 = "+i) ;
		i = -3 * i / 2 ;                    // L4 -1
		System.out.println("L4 = "+i) ;
		d = i / 2.*i ;                      // L5 0.5
		System.out.println("L5 = "+d) ;
		l =  Integer.MAX_VALUE ;            // L6 2147483647
		System.out.println("L6 = "+l) ;
		i = (int)  (l + 1) ;                // L7	-2147483647
		System.out.println("L7 = "+i) ;
		l = l + 1 ;                         // L8  2147483647
		System.out.println("L8 = "+l) ;
		b = (1 + 1 == 2) ;                 	// L9  true
		System.out.println("L9 = "+b) ;
		b = (!b || (2.==d) && (i<0)) ;      // L10  false
		System.out.println("L10= "+b) ;


		 
		float x, y, z ;
		x = 0.1234567890F * 1e9F ;
		y = x + 1F ;
		z = 1 / (y-x) ;
		 
		System.out.println("z = "+z) ;
		 
		double xx, yy, zz ;
		xx = 0.1234567890D * 1e9D ;
		yy = xx + 1D ;
		zz = 1 / (yy-xx) ;
		 
		System.out.println("zz = "+zz) ;
	}

}
