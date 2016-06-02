public class BigSib {
    // instance vars
    private String helloMsg; // no val assigned

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
