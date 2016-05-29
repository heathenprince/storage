/* Anna Tolen
APCS2 pd9
HW12a -- We Got a Big Ol' Convoy...
2016-03-14 */
public class LLNode {
    private String value;
    private LLNode connection;


    //constructors
    public LLNode() {
	value = null;
	connection = null;
    }

    public LLNode(String val) {
	this();
	setValue(val);
    }

    public LLNode(String val, LLNode conn) {
	this(val);
	setConnection(conn);
    }
       
    //mutators
    public String setValue(String newVal) {
	String oldVal = value;
	value = newVal;
	return oldVal;
    }

    public LLNode setConnection(LLNode newConn) {
	LLNode oldConn = connection;
	connection = newConn;
	return oldConn;
    }
	   
    //accessors
    public String getValue() {
	return value;
    }

    public LLNode getConnection() {
	return connection;
    }
}
