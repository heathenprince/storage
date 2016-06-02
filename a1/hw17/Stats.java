/* (!)Team Lone Gunman -- Anna Tolen
APCS1 pd10
HW17 -- GCD Three Ways
2015-10-16 */

public class Stats {

    public static double max(double a, double b, double c) {
	if(a > b)
	    if(a > c)
		return a;
	    else
		return c;
	else
	    if(b > c)
		return b;
	    else
		return c;
    }

    
    public static int geoMean(int a, int b, int c) {
	double trouble = Math.cbrt(a*b*c);
	int ret = (int)trouble;
	return ret;
    }
   
    public static double geoMean(double a, double b, double c) {
	double ret = Math.cbrt(a*b*c);
	return ret;
    }

    // ------------------ HW 17 (GCD) ------------------
    
    // uses brute-force approach, beginning at 1 and working up to lesser input
    public static int gcd0( int a, int b ) { // started from the bottom, now we here
	int n = 1;
	int ret = 1;
	while(n <= b) {
	    if( (a % n == 0) && (b % n == 0)) {
		ret = n;
	    } 
	    n += 1;
	} 
	return ret;
    } 

    public static int gcd1( int a, int b ) { // top to tha bottom
	int n = b;
	while(n > 0) {
	    if( (a % n == 0) && (b % n == 0) ) {
		return n;
	    }
	    else {
		n -= 1;
	    }
	}
	return n; 
    }     

   /* 
     1. find the modulus of a & b (hereinafter referred to as "c")
     2. if the modulus is 0, the smaller of the two numbers is the GCD.
        if not, find the modulus of b and c.
     3. repeat step 2 until modulus is 0. 
   */
    
    // employs Euclid's algorithm recursively
    public static int gcdER( int a, int b ) {
	int c = (a % b);
	if( c == 0 ) 
	    return b;
      
	else 
	    return gcdER(b,c);
    } 

    // employs Euclid's algorithm iteravely with a while loop
    public static int gcdEW( int a, int b ) {
	int c = (a % b);
	while( c != 0 ) {
	    a = b;
	    b = c;
	    c = (a % b);
	} 
	return b;
    } 
	    

    public static void main( String [] args ) {
	// brute force tests
	System.out.println( gcd0(24,12) + "\tshould be 12" );	
	System.out.println( gcd0(270,192) + "\tshould be 6" );
	System.out.println( gcd0(192,270) + "\tshould be 6" );
	System.out.println( gcd0(1014,21) + "\tshould be 3" );
	System.out.println( gcd0(-1014,21) + "\tshould be 3\n" );

	System.out.println( gcd1(24,12) + "\tshould be 12" );	
	System.out.println( gcd1(270,192) + "\tshould be 6" );
	System.out.println( gcd1(192,270) + "\tshould be 6" );
	System.out.println( gcd1(1014,21) + "\tshould be 3" );
	System.out.println( gcd1(-1014,21) + "\tshould be 3\n" );
	
	// recursion tests
	System.out.println( gcdER(24,12) + "\tshould be 12" );		
	System.out.println( gcdER(270,192) + "\tshould be 6" );
	System.out.println( gcdER(192,270) + "\tshould be 6" );
	System.out.println( gcdER(1014,21) + "\tshould be 3" );
	System.out.println( gcdER(-1014,21) + "\tshould be 3\n" );	

	// iterative tests
	System.out.println( gcdEW(24,12) + "\tshould be 12" );		
	System.out.println( gcdEW(270,192) + "\tshould be 6" ); 
	System.out.println( gcdEW(192,270) + "\tshould be 6" );
	System.out.println( gcdEW(1014,21) + "\tshould be 3" );	
	System.out.println( gcdEW(-1014,21) + "\tshould be 3" );

    } // close main
} // close class
