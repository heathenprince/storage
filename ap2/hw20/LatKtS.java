/*****************************************************
 * skeleton for class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) //bleh this is slow
    {
	Latkes stack = new Latkes(s.length());
	String retStr = "";
	
	for( int i = 0; i < s.length(); i++ ) {
	    String letter = s.substring(i,i+1);
	    stack.push(letter);
	}

	for( int c = 0; c < s.length(); c++ ) {
	    retStr += stack.pop();
	}

	return retStr;
	    
    }//end flip()



    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    {
	Latkes stack = new Latkes(s.length());
	for( int i = 0; i < s.length(); i++ ) {
	    String brack = s.substring(i,i+1);
	    if( brack.equals("{") || brack.equals("(") || brack.equals("[") ) 
		stack.push(brack);
	    
	    else if( (stack.isEmpty()) ) { return false; }
	    
	    else if( (brack.equals("}") && (stack.peek().equals("{"))) || (brack.equals(")") && (stack.peek().equals("("))) || (brack.equals("]") && (stack.peek().equals("["))) ) //so gross
		    stack.pop();
	    else
		return false;
	}
	if( !(stack.isEmpty()) ) { return false; }
	return true;
    }//end allMatched()


    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false 
        System.out.println(allMatched( "(){([])}(" ) ); //false 
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	/^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
	
    }

}//end class LatKtS
