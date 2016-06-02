/* Anna Tolen
APCS1 pd10
HW53 -- Poker Face
2016-1-4 */
/*======================================
  class InsertionSort -- implements InsertionSort algorithm

  Q1: Is more work done toward beginning or end of insertion sort? Why? -- end, bc element being sorted has to find its place among the sorted list, which grows with every pass
  Q2: For n items, how many passes are necessary to sort? -- n
  Q3: What is known after pass p, and how do you know it? -- p elements are sorted (sorted != in final position)
  Q4: What is the runtime classification of this sort? -- O(n) -- linear search within sorted list to find index of element being inserted
  ======================================*/

import java.util.ArrayList;

public class InsertionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data ) 
    {
	for( int i = 1; i < data.size(); i++ ) {
	    for( int c = 1; i-c >= 0 && data.get(i).compareTo(data.get(i-c)) < 0; i--) {
		data.set(i-1,data.set(i,data.get(i-1))); //keep swapping elements at i,i-1 until you get to i-c
	    }
	}
    }//end insertionSortV -- O(n) -- linear search within 2nd forloop, all other fxns run in constant time


    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> retAry = new ArrayList<Comparable>(); 
	for( int i = 0; i < input.size(); i++ ) { //copy input into new AL
	    retAry.add(input.get(i));
	}
	for( int i = 1; i < retAry.size(); i++ ) {
	    for( int c = 1; i-c >= 0 && retAry.get(i).compareTo(retAry.get(i-c)) < 0; i--) { 
		retAry.set(i-1,retAry.set(i,retAry.get(i-1))); //keep swapping elements at i,i-1 until you get to i-c
	    }
	}
	return retAry;
    }//end insertionSort -- O(n) -- linear search within 2nd forloop, all other fxns run in constant time
    /*================================================================    
    ================================================================*/

    //main method for testing
    public static void main( String [] args ) {

	  /*============================================	
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  insertionSortV(glen);

	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ============================================*/
	
	  /*===============for VOID methods=============	  	 
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  insertionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  ============================================*/
	

	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = insertionSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = insertionSort( coco );
	  System.out.println( "sorted version of ArrayList coco:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  //	  System.out.println( coco );
	  /*==========for AL-returning methods==========
	  ============================================*/
    }//end main

}//end class InsertionSort
