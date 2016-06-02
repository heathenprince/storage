public class ReachFor {
    public static void main( String[] args ) {
	for( String s : args ) {
	    int temp = Integer.parseInt(s);
	    System.out.println( temp );
	}
    }
}
