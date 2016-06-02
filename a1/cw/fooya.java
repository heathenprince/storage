public class fooya {
    private int c = 4;
    public boolean booya(int a){
	a = 4; return true;
    }

    public int hooya() {
	int a=1; int b = 2; int c = 3;
	if (a == 1 || booya(a) ) {
	    return c;
	}
	else if (b == 1 || booya(b) ) {
	    return b;
	}
	else
	    return a;
			
    }

    public void fooya() {
       	int a = 42;
      	System.out.println( hooya() + this.c );
	
    }

    public static void main( String [] args ) {
	String foo = "bar";
	System.out.println(foo.length());
	System.out.println(foo.substring(0,2));
	System.out.println(foo.substring(0,3));
	//	System.out.println(foo.substring(0,4));
	System.out.println(foo.substring(1,2));
	System.out.println(foo.substring(1,1));
	System.out.println(foo.substring(1));
	//	System.out.println( 30 % 0 ); // mod tests
	// System.out.println( 0 % 2 );
    }	
}
