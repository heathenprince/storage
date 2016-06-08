/*****************************************************
 * class HashTableQP --- for exploring hash table collisions
 * Stores String elements in a hash table using simple hash fxn (mod).
 * Uses quadratic probing to resolve collisions. 
 * To guarantee an availabile open slot, ensure
 *    a) load factor is below 50%, and 
 *    b) capacity is prime. 
 *****************************************************/

import java.util.ArrayList;

public class HashTableQP {

    //instance vars
    private String[] _table;
    private int _size = 0;
    private int _collisions = 0;

    private final int _NUMVALS = 10;  //number of elements to store
    private final int _LO = 0;    //lower bound of input value range (incl)
    private final int _HI = 100;  //upper bound of input value range (nonincl)
    private final int _CAPACITY = 23;  //capacity of table


    /*****************************************************
     * constructor --- inits table with placeholders
     *****************************************************/
    HashTableQP()
    {
	_table = new String[ _CAPACITY ];

	for( int i=0; i<_table.length; i++ )
	    _table[i] = "-1";	    
    }


    /*****************************************************
     * hashFxn -- generates a value based upon input String
     * precondition: input is non-negative integer in String form
     *****************************************************/
    public int hashFxn( String s )
    {
	return Integer.parseInt(s) % _CAPACITY;
    }


    /*****************************************************
     * loadTable() --- helper fxn for loading hash table
     * Populates hash table with _NUMVALS elements from range [_LO,_HI)
     * Prints diagnostic information
     * Tip: Use command line redirection to send to txt file
     * eg, $ java HashTableQP > output.txt 
     *****************************************************/
    public void loadTable()
    {
	String[] vals = genVals( _NUMVALS, _LO, _HI );

	System.out.println( "Loading " + _NUMVALS + 
			    " elements into hash table of capacity " 
			    + _CAPACITY );
	System.out.println("Vals to be loaded into table: ");
	System.out.println( stringifyArray(vals) );

	for( String s : vals ) {

	    // Map element to its storage slot
	    int slot = hashFxn(s);

	    System.out.println( s + " hashed to " + slot );

	    // If slot taken, find new slot using quadratic probing
	    int origSlot = slot; //store orig slot to use as offset
	    int probeCtr = 1;
	    while( _table[slot] != "-1" ) {
		_collisions++;
		slot = origSlot + probeCtr * probeCtr;
		System.out.println("*Collision!* Trying slot "  
				   + slot + " instead..." );
		// wrap around if necessary
		probeCtr++;
		slot %= _CAPACITY;
	    }

	    //insert element
	    _table[slot] = s;
	    _size++;
	    System.out.println("load factor: " + 1.0*_size / _CAPACITY );
	}//end loop

	System.out.println("Num of elements inserted: " + _size );
	System.out.println("Num collisions: " + _collisions );
	System.out.println("Final load factor: " + 1.0*_size / _CAPACITY );

    }//end loadTable()



    /*****************************************************
     * getNextPrime(int) --- returns x st x >= input && x prime
     *****************************************************/
    public int getNextPrime( int startNum ) 
    {
	for( int i = startNum; true; i++ )
	    if ( isPrime(i) )
		return i;
    }
    //helper fxn for getNextPrime
    public boolean isPrime( int testNum )
    {
	// even?
	if ( testNum % 2 == 0 )
	    return false;
	// test odds up to sqrt of testNum for divisibility
	for( int i=3; i*i <= testNum; i += 2 ) 
	    if ( testNum % i == 0 )
		return false;
	// made it this far? must be prime
	return true;
    }



    /*****************************************************
     * genVals(int,int,int) --- for generating an array of unique rand vals
     * @param n   number of elements
     * @param lo  lower bound (inclusive)
     * @param hi  upper bound (non-inclusive)
     * @return    String array of unique elements in random order
     *****************************************************/
    private String[] genVals( int n, int lo, int hi )
    {
	String[] retArr = new String[n];

	//construct ArrayList of entire range
	ArrayList<String> al = new ArrayList<String>(hi-lo);
	for( int i=lo; i<hi; i++ )
	    al.add( i + "" );

	//select n items from range
	for( int i=0; i<n; i++ ) {
	    retArr[i] = al.remove( (int)( al.size() * Math.random() ) );
	}

	return retArr;
    }//end genVals()


    //helper fxn for output
    String stringifyArray( String[] sa )
    {
	String retStr = "[";
	for( String s : sa )
	    retStr += s + ",";
	retStr = retStr.substring( 0, retStr.length()-1 );
	return retStr + "]";
    }


    //main method for testing
    public static void main( String[] args ) {

        HashTableQP mesa = new HashTableQP();

	mesa.loadTable();

    }//end main()

}//end class HashTableQP



    /*****************************************************
     * 
     *****************************************************/
    // (  )
    // {
    // 	/*** YOUR IMPLEMENTATION HERE ***/
    // }//O(?)

