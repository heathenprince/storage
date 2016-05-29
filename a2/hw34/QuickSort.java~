/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 *
 * 2a. Worst pivot choice and associated runtime: 
 *
 * 2b. Best pivot choice and associated runtime:
 *
 * 3. Approach to handling duplicate values in array:
 *
 *****************************************************/

public class QuickSort {

    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------

    public static int partition( int[] arr, int pvtPos, int lo, int hi ) { //pvtPos --> index of value around which to pivot
	
	int pvtVal = arr[pvtPos]; //pvtVal --> value being pivoted around
	swap(pvtPos,hi,arr);
	int savPos = lo; //points to 1st index
	for( int i = lo; i < hi; i++ ) {
	    if( arr[i] < pvtVal ) {
		swap( savPos,i,arr );
		savPos++;
	    }
	}
	
        swap( arr.length-1,savPos,arr ); //put pvtVal in right pos
        return savPos;
    } //O(n)
    
    /*******
     * algo: partition around rand #
     ******
    public static int quickSelect( int[] arr, int k ) {
     
	if( k >= hi )
	    return arr[k];
	int rand = (int)((Math.random() * hi) + lo);
	int pivInd = partition( arr,rand );
	if( pivInd == k )
	    return arr[pivInd];
	
	else if( pivInd < k )
	    return quickSelect( arr,k,pivInd,hi );

	else
	    return quickSelect( arr,k,lo,pivInd );
	    } //O(1) */

    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) {
	qsortHelp( d , 0 , d.length-1 );
    }

    //you may need a helper method...

    public static void qsortHelp( int[] d , int lo , int hi ) {
	int pos = partition( d , lo , lo , hi );
	if( hi-lo > 1 ) {
	    qsortHelp( d , 0 , pos );
	    qsortHelp( d , pos+1 , hi );
	}
	
	else
	    return;
    }

    //main method for testing
    public static void main( String[] args ) {


	int[] a = {3,5,6,1,46,4};
	partition( a, 0, 3,a.length-1);
	printArr(a);
		      
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;
	    
	shuffle(arrN);
	printArr( arrN );
	qsort( arrN );
	printArr( arrN );

	System.out.println("\narrN init'd to: " );
	printArr(arrN);
	    
	    
	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
