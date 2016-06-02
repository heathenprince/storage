/* Anna Tolen
APCS1 pd10
HW39 -- Array of Steel
2015-12-01 */

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data = new int[10];
	_lastPos = -1;
	_size = 10;
    }
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
	String retStr = "[ ";
	for( int i = 0; i < _size - 1; i++ )
	    retStr += _data[i] + ",";
	retStr += _data[_size - 1];
	retStr += " ]";
	return retStr;
    }
		
    //double capacity of this SuperArray
    private void expand() {
	int[] a = new int[_size * 2];
	for( int i : _data )
	    a[i] = _data[i];
	_data = a;
	_size = _data.length;
    }

    	
    //accessor -- return value at specified index
    public int get( int index ) {
	return _data[index];
    }

    	
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {
	int ret = _data[index];
	_data[index] = newVal;
	return ret;
    }
    
    
    //main method for testing
    public static void main( String[] args ) {
	SuperArray a = new SuperArray();
	System.out.println( a );
	a.expand();
	System.out.println( a );		
	a.set( 12,42 );
	System.out.println( a );
	int i = a.get( 12 );
	System.out.print( i );
	System.out.println( "\t...should be 42" );
	int j = a.set( 9,73 );	
	System.out.print( j );
	System.out.println( "\t...should be 0" );	
    }//end main
		
}//end class
