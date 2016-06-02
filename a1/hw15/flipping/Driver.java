/*=============================
  driver for class Coin
  ~~~ SUGGESTED WORKFLOW: ~~~
  1. Compile this file and run.
  2. Cut&paste the "TOP" line below the first statement. 
  (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
  3. Compile and run again. 
  4. Resolve errors 1 at a time until it works
  5. Repeat 2-4 until TOP meets BOTTOM
  =============================*/

public class Driver {

    public static void main( String[] args ) {
	int x = 5;
	int y = 7;
	
	//build Objects from blueprint specified by class Coin
	
	//test default constructor
	Coin mine = new Coin();

	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );

	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );

	//test toString() methods of each Coin
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

	//test flip() method
	System.out.println("\nAfter flipping...");
	yours.flip();
	wayne.flip();
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

	//test equals() method
	if ( yours.equals(wayne) ) 
	    System.out.println( "Matchee matchee!" );
	else
	    System.out.println( "No match. Firestarter you can not be." );

	//------------------------------------------------------------------
	//1a
	int headsCtr = mine.getHeadsCtr();
	while ( x > headsCtr ) {
	    mine.flip();
	    headsCtr = mine.getHeadsCtr();
	    }
	System.out.println("Yay! you got " + headsCtr + " heads");

	//1b
	int matches = 0;
	while ( y > matches ) {
	    mine.flip();
	    wayne.flip();
	    if (mine.equals(wayne))
		matches += 1;
	}
	
	System.out.println("Yay! You got " + matches + " matches");

	//1c
	int tailsCtr = mine.getTailsCtr();
	while ( matches < 13 ) && ( (matches % mine.value) == 0 ) && ( (matches % wayne.value) == 0 ) {
	    mine.flip();
	    wayne.flip();
	    if (mine.equals(wayne))
		matches += 1;
	
	    }
	System.out.print(tailsCtr);
    }
}
	       
	    
	
	    /*===================TOP==========================
	    ====================BOTTOM======================*/

    
	
	
	
