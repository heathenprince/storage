public class DLLNode {
    
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
    private DLLNode _prevNode; //pointer to other DLLNode    


    //constructor -- initializes instance vars
    public DLLNode( String value, DLLNode next, DLLNode prev ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }
       
    //mutators
    public String setCargo( String newCargo ) {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
	DLLNode foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }
    
    //---------------------------------------------

    
    //accessors
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }
}
