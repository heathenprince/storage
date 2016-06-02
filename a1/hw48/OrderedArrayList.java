/* Team Padawans -- Arpita Abrol, Shamaul Dilmohamed, Anna Tolen
   APCS1 pd10
   HW48 -- Halfing Time Trials
   2015-14-15 */

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;
  
  
public class OrderedArrayList {
  
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;
  
  
    // default constructor initializes instance variable _data
    public OrderedArrayList() {  	    
	_data = new ArrayList<Comparable>();
    }
  
  
    public String toString() { 
	return _data.toString(); 
    }
  
  
    public Comparable remove( int index ) { 
    	return _data.remove(index); 
    }
  
    public int size() { 
	return _data.size();
    }
  
      
    public Comparable get( int index ) { 
    	return _data.get(index); 
    }
  
  
    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
    	for( int p = 0; p < _data.size(); p++ ) {
  	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { //newVal < oal[p]
  	  	_data.add( p, newVal );
  	  	return; //Q:why not break?
  	    }
    	}
    	_data.add( newVal ); //newVal > every item in oal, so add to end
    }
  
  
    // addBinary takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a binary search to find appropriate index
    public void addBinary( Comparable newVal ) { 
    	//initialize upperbound, lowerbound and median
    	int lo = 0;
    	int hi = _data.size();
    	int med = (int)((hi + lo)/2);
    	while (lo != hi) {
	    med = (int)((hi+lo)/2);
	    if (_data.get(med).compareTo(newVal) < 0) {
		lo = med + 1;
		//System.out.println("1:" + lo + "," + med + "," + hi);
	    }
	    else {
		hi = med;
		//System.out.println("2:" + lo + "," + med + "," + hi);
	    }
    	}
    	_data.add(lo, newVal);
    }

    // determine whether element present in data structure using linear search
    // return index of occurrence or -1 if not found
    public int findLin( Comparable target ) {
	int index = -1;
	for( int i = 0; i < _data.size(); i++ ) {
	    if( _data.get(i).equals(target))
		return i;
	}
	return -1;
    }


    // determine whether element present in data structure using binary search
    // return index of occurrence or -1 if not found
    public int findBin( Comparable target ) 
    {
	int lo = 0;
	int hi = _data.size();
	while( lo != hi ) {
	    int med = (int)((hi+lo)/2);
	    if( _data.get(med).equals(target)) {
		while( med > 0 && _data.get(med).equals(med-1)) {
		    med -= 1;
		}
		return med;
	    }
	    if( _data.get(med).compareTo(target) < 0) {
		lo = med + 1;
	    }
	    else {
		hi = med;
	    }
	}
	return -1;
    }
  
  
    // main method solely for testing purposes
    public static void main( String[] args ) {
	
	OrderedArrayList Franz = new OrderedArrayList();
	//System.out.println("\nValues to add via addBinary() calls:");
	// testing linear search
	double popAvg = 0;
	double linAvg = 0;
	double binAvg = 0;
	for( int c = 0; c < 20; c++ ) {
	    long t1 = System.currentTimeMillis();
	    for( int i = 0; i < 10000; i++ ) {
		int valToAdd = (int)( 20000 * Math.random() );
		//  	    System.out.println( valToAdd );
		Franz.addBinary( valToAdd );
		//System.out.println( Franz );
	    }
	    //System.out.println("\nafter population via addBinary() calls:");
	    //System.out.println( Franz );
	    //System.out.println();
	    
	    long t2 = System.currentTimeMillis();
	    popAvg += (t2-t1);
	    
	    //TIMER TEST--WHICH IS MORE EFFECTIVE???
	    
	    //LIN SEARCH
	    long linT1 = System.currentTimeMillis();
	    for( int i = 0; i < 20000; i++ ) { //LINSEARCH
		int search = (int)( 40000 * Math.random() );
		//	    System.out.println( search );
		//	    System.out.println(Franz.findLin( search ));
		Franz.findLin( i );
	    }
	    long linT2 = System.currentTimeMillis();
	    linAvg += (linT2-linT1);
	
	
	    //BIN SEARCH
	    long binT1 = System.currentTimeMillis();
	    for( int i = 0; i < 20000; i++ ) { 
		int search = (int)( 40000 * Math.random() );
		//System.out.println( search );
		//System.out.println(Franz.findBin( search ));
		Franz.findBin( i );		
	    }
	    long binT2 = System.currentTimeMillis();
	    binAvg += (binT2-binT1);
	    
	}

	popAvg /= 20;
	linAvg /= 20;
	binAvg /= 20;
	    
	    
	//RESULTS
	System.out.println("AVG POPULATION TIME (20 FXN CALLS): " + popAvg + "\nAVG LIN SEARCH TIME (20 FXN CALLS): " + linAvg + "\nAVG BIN SEARCH TIME (20 FXN CALLS): " + binAvg );
	    
    }//end main
    
}//end class OrderedArrayList   
