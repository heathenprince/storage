/* Anna Tolen
APCS1 pd10
HW08 -- On BigSib Creation
2015-09-28 */

public class BigSib {
    // instance vars
    private String helloMsg; // no val assigned

    // constructor methods
    public BigSib() {
	setHelloMsg("Ahoy!");
    }

    public BigSib( String helloMsg ) {
	setHelloMsg( helloMsg );
    }

    // methods
    
    public void setHelloMsg( String newMsg ) {
	helloMsg = new String( newMsg );
    }

    public String greet(String freshie) {
	String retStr; // declares string var
	retStr = helloMsg;
	retStr += " " + freshie;
	return retStr;
    }
}
