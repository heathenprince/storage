/* Anna Tolen
APCS1 pd10
HW27 -- Objectify Your Array Tools
2015-11-09 */

public class ArrayUtils {

    private static Integer[] intArray = {0,1,1,2,3,5};
    private static String[] strArray = {"cat","dog","cat","dog","bear","wolf","cat"};
    
    public static void populate( int lower, int upper, int[] ary ) {
	int diff = upper-lower;
	for( int i = 0; i < ary.length; i++ ) {
	    double rand = (Math.random() * diff + lower);
	    ary[i] = (int)rand;
	}
    }

    public static String arrayToString( Object[] ary ) {
	String retStr = "{";
	int len = ary.length;
	for( int i = 0; i < len - 1; i++ )
	    retStr += ary[i] + ",";
	retStr += ary[len - 1];
	retStr += "}";
	return retStr;
    }

    public static int linSearch( Object[] a, Object target ) {
	for( int i = 0; i < a.length; i++ ) {
	    if( a[i].equals(target) )
		return i;
	}
	return -1;
    }

    public static int linSearchR( Object[] a, Object target ) {
	return linSearchRHelp( a,target,0 );
    }

    public static int linSearchRHelp( Object[] a, Object target, int retInt ) {
	if( retInt == a.length ) 
	    return -1;
	else if ( a[retInt] == target )
	    return retInt;
	else
	    return linSearchRHelp( a, target, retInt + 1 );
    }

    public static int freq( Object[] a, Object target ) {
	int retInt = 0;
	for( Object i : a ) {
	    if( i.equals(target) ) 
		retInt += 1;
	}
	return retInt;
    }

    public static int freqRec( Object[] a, Object target ) {
        return freqRecHelp(a, target, 0, 0);
    }

    public static int freqRecHelp( Object[] a, Object target, int i, int curFreq ) {
	if( i == a.length )
	    return curFreq;
	else if( a[i].equals(target) ) 
	    return freqRecHelp(a, target, i+1, curFreq+1);
	else
	    return freqRecHelp(a, target, i+1, curFreq);
    }
    
    public static void main( String[] args ) {
	System.out.println( arrayToString(intArray) );
	System.out.println( arrayToString(strArray) );
	System.out.println( linSearch(intArray,1) );
	System.out.println( linSearch(strArray,"dog") );
	System.out.println( linSearchR(intArray,1) );
	System.out.println( linSearchR(strArray,"dog") );
	System.out.println( freq(intArray,1) );
	System.out.println( freq(strArray,"dog") );		
	System.out.println( freqRec(intArray,1) );
	System.out.println( freqRec(strArray,"dog") );
	/*===========================================
	=====================================*/
	
    }
}
