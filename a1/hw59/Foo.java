public class Foo {
    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
	int[] a = new int[numTosses];
	for( int i = 0; i < numTosses; i++ ) {
	    a[i] = cube.toss();
	}
	return a;
    }

    public static int getLongestRun( int[] values ) {
	int runLen = 0;
	int index = 0;
	int hold = 0;
	for( int i = 0; i < values.length-1; i++ ) { //starting index
	    for( int c = 1; c < values.length-i; c++ ) { //index from starting index
		if( values[i] != values[i+c] ) { break; }
		else { hold++ }
	    }
	    if hold > runLen { runLen = hold; hold = 0; index = i; }
	}
	return index;
    }

    private int[] rateTable;

    private int getChargingCost(int startHour, int chargeTime) {
	int hold = 0;
	for( int i = startHour; i < startHour + chargeTime; i++ ) {
	    hold += rateTable[i];
	}
	return hold;
    }

    public int getChargeStartTime(int chargeTime) {
	int hold = 0;
	for( int i = 0; i < 23-chargeTime; i++ ) {
	    if( getChargingCost(i,chargeTime) < hold ) {
		hold = i;
	    }
	}
	return hold;
    }

    private ArrayList<NumberTile> board;
    public TileGame() { board = new ArrayList<NumberTile>(); }

    private int getIndexForFit(NumberTile tile) {
	int pos = 0;
	int left = tile.getLeft();
	int right = tile.getRight();

	for( int i = 0; i < board.size(); i++ ) {
	    if( 
	
