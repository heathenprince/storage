public class bttf {
    public static String printNumW() {
	int i = 1;
	String retStr = "";
	while( i <= 20 ){
		retStr += i + " ";
		i++;
	    }
	return retStr;
    }

    public static String printNumF() {
	String retStr = "";
	for( int i = 1; i <= 20; i++ ) {
	    retStr += i + " ";
	}
	return retStr;
    }

    public static String printEvens() {
	String retStr = "";
	for( int i = 2; i <= 20; i+=2 ) {
	    retStr += i + " ";
	}
	return retStr;
    }

    public static String printThrees() {
	String retStr = "";
	for( int i = 3; i <= 20; i+=3 ) {
	    retStr += i + " ";
	}
	return retStr;
    }

    public static String oddSquares() {
	String retStr = "";
	for( int i = 1; i <= 20; i+=2 ) {
	    retStr += i*i + " ";
	}
	return retStr;
    }
    
    public static void main( String [] args ) {
	//	System.out.println( printNumW() );
	//  	System.out.println( printNumF() );
	System.out.println( printEvens() );
    }
}
