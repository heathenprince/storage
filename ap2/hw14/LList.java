public class LList implements List {

    //instance vars
    private DLLNode _head;
    private int _size; //quick access to list size
    
    //constructor
    public LList() {
	_head = null;
	_size = 0;
    }

    //List interface methods
    public boolean add( String x ) { //adds to front
	DLLNode newNode = new DLLNode( x, _head, null );
	_head = newNode; //head points to newNode
	_size++;
	return true;
    }

    //add-at-index
    public void add( int index, String s ) { //default private

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode newNode = new DLLNode( s, null, null );
	//if index==0, insert node before head node
	if( index == 0 ) 
	    add(s);

	else {
	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i = 0; i < index-1; i++ ) 
		tmp = tmp.getNext(); //find element before one added
	    
	    //insert new node
	    newNode.setNext( tmp.getNext() );
	    tmp.setNext( newNode );

	    //increment size attribute
	    _size++;
	}
    }

    //removes the node at position i and returns its cargo
    public String remove( int index ) { //default private

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	
	String retVal;
	DLLNode tmp = _head; //create alias to head

	//if index==0, reassign head node
	if( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();
	}

	else { //else, iterate thru list
	    //walk to node before desired node
	    for( int i = 0; i < index-1; i++ ) 
		tmp = tmp.getNext(); //find element before one removed

	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
	}
	_size--;
	return retVal;
    }
    
    public String get( int index ) {
	
	if ( index < 0 || index >= size() ) 
	    throw new IndexOutOfBoundsException();

	DLLNode hold = _head;

	//walk to desired node
	for( int i = 0; i < index; i++ ) 
	    hold = hold.getNext();

	return hold.getCargo();
    }
    
    public String set( int index, String newVal ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
		
	DLLNode hold = _head; //create alias to head
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
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    public static void main( String[] args ) {
	LList a = new LList();
	a.add("2");
	a.add("0");
	System.out.println(a);
	
	System.out.println("\nTesting add-at-index...");
	a.add(1,"1");
	System.out.println(a);

	System.out.println("\nTesting remove...");
	System.out.println(a.remove(0));
	System.out.println(a);
    }
}
