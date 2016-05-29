/* Anna Tolen
APCS2 pd9
HW12b -- Truckin' Through the Night
2016-03-14 */
public class LList implements List {
    private LLNode head;

    //constructors
    public LList() {
	head = new LLNode();
    }
	
    public LList(LLNode headNode) {
	head = headNode;
    }

    public LList(String val) {
	head = new LLNode(val);
    }
    
    public boolean add(String x) {
	LLNode newNode = new LLNode(x);
	head.setConnection(newNode);
	return true;
    }

    //precond: i < this.size()
    public String get(int i) {
	LLNode hold = head;
	for(int j = 0; j < i; j++) {
	    hold = hold.getConnection();
	}
	return hold.getValue();
    }
    
    public String set(int i, String x) {
	String ret = this.get(i);
	
	LLNode hold = head;
	for( int j = 0; j < i; j++ ) {
	    hold = hold.getConnection();
	}
	hold.setValue(x);
	
	return ret;
    }

    public int size() {
	int ctr = 1;
	LLNode hold = head;
	
	while( hold.getConnection() != null ) {
	    ctr++;
	    hold = hold.getConnection();
	}
	return ctr;
    }

    public String toString() {
	String retStr = "[ ";
	for( int i = 0; i < this.size(); i++ ) {
	    retStr +=  get(i) + ", ";
	}
	retStr += "]";
	return retStr;
    }
    
    public static void main( String[] args ) {
	LList a = new LList("foo");

	System.out.println(a); //foo
	System.out.println(a.add("bar")); //true
	System.out.println(a.get(0));
	System.out.println(a.get(1));
	System.out.println(a.set(1,"goo"));
	System.out.println(a); 
	System.out.println(a.size()); 
    }
}
