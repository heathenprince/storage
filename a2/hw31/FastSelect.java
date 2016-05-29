/* Anna Tolen
APCS2 pd9
HW31 -- Fast Selection
2016-04-13 */

public class FastSelect {
    
    public static void swap( int[] arr, int pos1, int pos2 ) {
	int tmp = arr[pos1];
	arr[pos1] = arr[pos2];
	arr[pos2] = tmp;
    } //O(1)
    
    public static int partition( int[] arr, int pvtPos ) { //pvtPos --> index of value around which to pivot
	int pvtVal = arr[pvtPos]; //value being pivoted around
	swap(arr,pvtPos,arr.length-1); //stick at end
	int savPos = 0; //points to 1st
	for( int i = 0; i < arr.length-1; i++ ) {
	    if( arr[i] < pvtVal ) {
		swap( arr,savPos,i );
		savPos++;
	    }
	}
	swap( arr,arr.length-1,savPos ); //put pvtVal in right pos
	return savPos;
    } //O(n)

    /*******
     * algo: partition around rand #
     * iteration!
     *****/
    public static int fastSelectHelp( int[] arr, int k, int lo, int hi ) {
	if( k >= hi )
	    return arr[k];
	
	int rand = (int)((Math.random() * hi) + lo);	
	int pivInd = partition( arr,rand );
	
	if( pivInd == k )
	    return arr[pivInd]; 
	
	else if( pivInd < k ) 
	    return fastSelectHelp( arr,k,pivInd,hi ); 
	
	
	else 
	    return fastSelectHelp( arr,k,lo,pivInd );
	
    } //O(?????wtf)

    //wrapper fxn
    public static int fastSelect( int[] a,int k ) {
	return fastSelectHelp(a,k,0,a.length-1);
    }

    
    public static void main( String[] args ) {
	int[] a = {7,1,5,12,3};
	System.out.println( fastSelect(a,0) );
	System.out.println( fastSelect(a,1) );
	System.out.println( fastSelect(a,2) );
	System.out.println( fastSelect(a,3) );
	System.out.println( fastSelect(a,4) );
    }
}	    

/*********
 * n + n/2 + n/4 + ... = ~2n
 * 2n --> n 
 * linear??????????????
 */
