public class Swapper {
    
    public static String matrixToStr( String[][] a2 ) {
	String retStr = "";
	for( String[] k : a2 ) {
	    for( String s : k ) {
		retStr += s + " ";
	    }
	    retStr += "\n";
	}
	return retStr;
    }
	
    public static String[][] swap( String[][] a2, int i1, int j1, int i2, int j2 ) {}
	
    public static void main( String[] args ) {
	String[][] a2 = { { "foo","doo","goo" } , { "boo","soo","too" } };
	System.out.println( matrixToStr(a2) );
    }
			    
}
