/* Anna Tolen
APCS1 pd10
HW23 -- Augmenting Your Array of Tools
2015-11-03 */

public class ArrayUtils {

    private static int[] intArray = new int[3];
    
    public static void populate( int lower, int upper, int[] ary ) {
	int diff = upper-lower;
	for( int i = 0; i < ary.length; i++ ) {
	    double rand = (Math.random() * diff + lower);
	    ary[i] = (int)rand;
	}
    }

    public static String arrayToString( int[] ary ) {
	String retStr = "{";
	int len = ary.length;
	for( int i = 0; i < len - 1; i++ )
	    retStr += ary[i] + ",";
	retStr += ary[len - 1];
	retStr += "}";
	return retStr;
    }
    
    public static void main( String[] args ) {
	populate(3,12,intArray);
	System.out.println(arrayToString(intArray));
	populate(-9,-3,intArray);
	System.out.println(arrayToString(intArray));	
    }
}
