/* Anna Tolen
APCS2 pd9
HW28 -- All Hands On Deque!
2016-04-06 */

/***************************************
 * MODIFICATIONS TO QUEUE:
 * LLNode ---> DLLNode
 * methods for adding/removing frmo either end of data structure
 **************************************/


public class Deque<T> implements DequeIntr<T> { //locally defined Deque interface

    private DLLNode<T> _first, _end;
    private int _size;

    //default constructor creates an empty deque
    public Deque() {
	_first = _end = new DLLNode<T>(null,null,null);
	_size = 0;
    }

    public void addFirst( T newVal ) {
	DLLNode<T> newNode = new DLLNode<T>(newVal,null,null);
	if( isEmpty() )
	    _first = _end = newNode;

	else {
	    newNode.setNext(_first);
	    _first.setPrev(newNode);
	    _first = newNode;
	}
	_size++;
    }
	
    public void addLast( T newVal ) {
	DLLNode<T> newNode = new DLLNode<T>(newVal,null,null);
	if( isEmpty() ) 
	    _first = _end = newNode;
	
	
	else {
	    newNode.setPrev(_end);
	    _end.setNext(newNode);
	    _end = _end.getNext();
	}
	_size++;
    }


    public T peekFirst() { return _first.getCargo(); }
    public T peekLast() { return _end.getCargo(); }
    

    public T removeFirst() {
	DLLNode<T> retVal = _first;
	_first = _first.getNext();
	_first.setPrev(null);
	_size--;
	return retVal.getCargo();
    }

    public T removeLast() {
	DLLNode<T> retVal = _end;
	_end = _end.getPrev();
	_end.setNext(null);
	_size--;
	return retVal.getCargo();
    }

    public boolean isEmpty() { return _size == 0; }

    public String toString() {
	String retStr = "";
	DLLNode<T> tmp = _first;
	while( tmp != null ) {
	    retStr += tmp.getCargo() + " ";
	    tmp = tmp.getNext();
	}
	return retStr;
    }
    
    //main method for testing
    public static void main( String[] args ) {
	Deque<String> bar = new Deque<String>();
	bar.addFirst("foo");
	bar.addFirst("eoo");
	bar.addLast("goo");
	bar.addLast("hoo");
	
	System.out.println( bar );
	System.out.println( bar.removeLast() );
	System.out.println( bar );
	System.out.println( bar.removeFirst() );
	System.out.println( bar ); //foo goo

	System.out.println( bar.peekFirst() );	//foo
	System.out.println( bar.peekLast() ); //goo
	
    }
}
	
