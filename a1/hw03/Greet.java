/* Anna Tolen
APCS1 pd10
HW02 -- Howdy, Partner!
2015-09-16 */

public class Greet {
    public static void main (String [] args) {
	greet("Karl");
	greet("Sigmund");
	greet("Friedrich");
    }
	public static void greet(String s){
	    System.out.print("Hey, ");
	    System.out.print(s);
	    System.out.println(", how's it hanging?");
	}
}
    
