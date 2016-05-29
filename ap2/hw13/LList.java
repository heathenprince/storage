/* Anna Tolen
APCS2 pd9
HW13 -- LoList, LoLit
2016-03-15 */
public class LList implements List {

    //instance vars
    private LLNode _head;
    private int _size; //quick access to list size
    
    //constructor
    public LList() {
	_head = null;
	_size = 0;
    }

    //List interface methods
    public boolean add( String x ) { //adds to front
	LLNode newNode = new LLNode( x, _head );
	_head = newNode; //head points to newNode
	_size++;
	return true;
    }

    //add-at-index
    public void add( int index, String s ) { //default private

	LLNode temp = _head;
	for( int i = 0; i < index-1; i++ ) 
	    temp = temp.getNext(); //find element before one added
	LLNode after = temp.getNext();
	
	LLNode newNode = new LLNode( s, after );
	temp.setNext(newNode);
	_size++;
    }

    //removes the node at position i and returns its cargo
    public String remove( int index ) { //default private
	String retStr;
	
	if( index == 0 ) { //if removing old element, reassign _head to next element
	    retStr = _head.getCargo(); 
	    _head = _head.getNext();
	}

	else { //else, iterate thru list
	    
	    LLNode temp = _head;
	    for( int i = 0; i < index-1; i++ ) 
		temp = temp.getNext(); //find element before one removed
	    LLNode hold = temp.getNext(); //element being removed
	    LLNode next = temp.getNext().getNext();
	    
	    temp.setNext(next);
	    retStr = hold.getCargo();
	}
	_size--;
	return retStr;
    }
    
    public String get( int index ) {
	
	if ( index < 0 || index >= size() ) 
	    throw new IndexOutOfBoundsException();

	LLNode hold = _head;

	//walk to desired node
	for( int i = 0; i < index; i++ ) 
	    hold = hold.getNext();

	return hold.getCargo();
    }
    
    public String set( int index, String newVal ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
		
	LLNode hold = _head; //create alias to head
	String oldVal = hold.getCargo();
	
	for( int i = 0; i < index; i++ ) 
	    hold = hold.getNext();
	
	hold.setCargo( newVal );
	
	return oldVal;
    }

    public int size() { return _size; }

    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    public static void main( String[] args ) {
	LList a = new LList();
	a.add("DOG");
	a.add("CAT");
	System.out.println(a);
	
	System.out.println("\nTesting add-at-index...");
	a.add("COW");
	System.out.println(a);

	System.out.println("\nTesting remove...");
	System.out.println(a.remove(0));
	System.out.println(a);
    }
}
