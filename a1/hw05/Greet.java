/* Anna Tolen
APCS1 pd10
HW05 -- A Classy Division of Labor
2015-09-21 */

public class Greet {        //public class == filename?
    public static void main (String [] args) {
	BigSib.greet("Blinky");
	BigSib.greet("Pinky");
	BigSib.greet("Inky");
	greet("Clyde");    //test
    }
	public static void greet(String s) {
	    System.out.print("Hey, ");
	    System.out.print(s);
	    System.out.println(", how's it hanging?");
	}
   
}
