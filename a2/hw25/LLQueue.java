/* Anna Tolen
APCS2 pd9
HW25 -- Brits Do Not Wait In Line
2016-04-04 */
/*****************************************************
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
    { 
	_front = _end = new LLNode<T>(null,null);

    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	LLNode<T> newNode = new LLNode<T>(enQVal,null);
	if( isEmpty() ) 
	    _front = _end = newNode;
	
	else {
	    _end.setNext(newNode);
	    _end = _end.getNext();
	}
    }//O(1)
	


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    { 
	T tmp = _front.getValue();
	_front = _front.getNext();
	return tmp;
	
    }//O(1)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	return _front.getValue();
    }//O(1)


    public boolean isEmpty() 
    {
	return _front.getValue() == null;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    {
	String retStr = "";
	LLNode<T> tmp = _front;
	while( tmp != null ) {
	    retStr += tmp.getValue() + " ";
	    tmp = tmp.getNext();
	}
	return retStr;
    }//O(n)



    public static void main( String[] args ) {


	Queue<String> LLQueuelJ = new LLQueue<String>();

	  System.out.println("\nnow enqueuing thrice..."); 
	  LLQueuelJ.enqueue("James");
	  LLQueuelJ.enqueue("Todd");
	  LLQueuelJ.enqueue("Smith");
	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( LLQueuelJ ); //for testing toString()...

	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  //error confirmed -- NPE
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
