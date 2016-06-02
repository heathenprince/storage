/* Anna Tolen
APCS1 pd10
HW18 -- For the Love of Strings
2015-10-20 */
public class Foresrever {

    // fenceF(int posts) takes non-negative integer posts, and returns a String representation of a fence with the specified number of posts.
    public static String fenceF( int posts ) {
	String retStr = "";
	if ( posts > 0 ) {
	    retStr += "|";
	    for( int i = 1; i < posts; i++) {
		retStr += "--|";
	    }
	}
	return retStr;
    }

    // reverseF(String s) a non-empty String s and returns s with its letters reversed -- employs for loop.
    public static String reverseF( String s ) {
	  String retStr = "";
	  int len = s.length() - 1;
	  for( int i = len; i >= 0; i-- ) { // decrements len by 1
	      retStr += s.substring(i,i+1); // adds last letter to retStr
	  }
	  return retStr;
    }

    // reverseF(String s) a non-empty String s and returns s with its letters reversed -- employs recursion.
    public static String reverseR( String s ) {
	String retStr = "";
	int i = s.length() - 1;
	if( i >= 0 ) {
	    retStr += s.substring(i); // last letter
      	    retStr += reverseR(s.substring(0,i)); // runs func on everything before the last letter (tb to car and cdr)
	}
	return retStr;
    }
	  

    public static void main( String [] args ) {
	System.out.println(fenceF(0));
	System.out.println(fenceF(1));
	System.out.println(fenceF(3));
	System.out.println(fenceF(6));
	System.out.println(reverseF("david"));	
	System.out.println(reverseF("tennant"));
	System.out.println(reverseF("was"));
	System.out.println(reverseR("the"));	
	System.out.println(reverseR("best"));
	System.out.println(reverseR("doctor"));	
    }
}
