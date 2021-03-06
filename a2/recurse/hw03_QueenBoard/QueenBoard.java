/* Anna Tolen
APCS2 pd9
HW03 -- Execution
2016-02-23 */
/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard {

    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	int col = 0;
	return solveH(col);
	
    }
    
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	//	System.out.println(this);
	if( col == _board.length ) { return true; }
	int i = 0;
	while( i < _board.length ) { //i --> row
	    if( _board[i][col] == 0 ) {
		addQueen(i,col);
		if( !solveH(col+1) ) {
		    removeQueen(i,col);
		}
		else {
		    return true;
		}
	    }
	    i++;
	}
	return false;
    }
    

    public void printSolution() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if( _board[r][c] == 1 ) { ans += "Q"; }
		else { ans += "_"; }
		ans += "\t";
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }	

    
    //================= YE OLDE SEPARATOR =================

    /***
     * Adds queen at specified location
     * precondition: [row][col] is empty and an allowable space for a queen
     * postcondition: [row][col] set to 1. All cells in row to right of queen given value of -1 (or less, if previously negative). All cells to the right of and diagonal to queen given value of -1 (or less, if previously negative). 
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Removes queen from specified location
     * precondition: [row][col] currently contains a queen
     * postcondition: [row][col] set to 0. All cells in row to right of queen given value of 0 (or less, if previously less than -1). All cells to the right of and diagonal to queen given value of 0 (or less, if previously less than -1)
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * provides string representation of _board 
     * precondition: 
     * postcondition: 
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(8);
       	b.solve();
	//	System.out.println(b);
	/*b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
	b.removeQueen(0,1); */

    }
    
}//end class
