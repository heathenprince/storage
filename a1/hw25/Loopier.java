public class Loopier {
    private static int[] ary = {4,12,86,29,67,-4,-22,67};
	
    public static int linSearch( int[] a, int target ) {
	for( int i = 0; i < a.length; i++ ) {
	    if( a[i] == target )
		return i;
	}
	return -1;
    }

    public static int linSearchR( int[] a, int target ) {
	return linSearchRHelp( a,target,0 );
    }

    public static int linSearchRHelp( int[] a, int target, int retInt ) {
	if( retInt == a.length ) 
	    return -1;
	else if ( a[retInt] == target )
	    return retInt;
	else
	    return linSearchRHelp( a, target, retInt + 1 );
    }

    public static int freq( int[] a, int target ) {
	int retInt = 0;
	for( int i : a ) {
	    if( i == target ) 
		retInt += 1;
	}
	return retInt;
    }

    public static int freqRec( int[] a, int target ) {
        return freqRecHelp(a, target, 0, 0);
    }

    public static int freqRecHelp( int[] a, int target, int i, int curFreq ) {
	if( i == a.length )
	    return curFreq;
	else if( a[i] == target ) 
	    return freqRecHelp(a, target, i+1, curFreq+1);
	else
	    return freqRecHelp(a, target, i+1, curFreq);
    }
   
    public static void main( String[] args ) {
	System.out.println( linSearch(ary, 67) ); //4
	System.out.println( linSearch(ary, 42) ); //-1
	System.out.println( linSearchR(ary, 67) ); //4
       	System.out.println( linSearchR(ary,42) ); //-1
	System.out.println( freq(ary, 67) );	//2
	System.out.println( freqRec(ary, 67) ); //2
	
    }
}
