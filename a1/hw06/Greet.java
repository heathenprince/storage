/* Anna Tolen
APCS1 pd10
HW06 -- Return, I Declare!
2015-09-21 */

public class Greet {        //public class == filename?
    public static void main (String [] args) {
	String greeting; // creates string var named greeting

	greeting = BigSib.greet("Blossom"); // assigns value to greeting
	System.out.println( greeting ); 
	greeting = BigSib.greet("Bubbles");
	System.out.println( greeting );
	greeting = BigSib.greet("Buttercup");
	System.out.println( greeting ); 
    }
	
}
