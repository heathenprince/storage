/* Anna Tolen
APCS2 pd9 
HW37 -- Algorithm as Data Structure
2016-05-11 */

/*****************************************************
 * class BST - skeleton
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST {

    //instance variables / attributes of a BST:
    int[] a;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) {
	root = int[10];
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) {
	

	
	if (root == null) {
	    root = new TreeNode(newVal);
	}
	else {
	    insertH(newVal, root);
	}

    }
    public void insertH(int newVal, TreeNode node) {
	TreeNode newNode = new TreeNode(newVal);
	if (newVal < node.getValue()) { 
	    if (node.getLeft() == null) {
		node.setLeft(newNode);
	    }
	    else {
		insertH(newVal, node.getLeft());
	    }
	}
	else { //newVal > _cargo
	    if (node.getRight() == null) {
		node.setRight(newNode);
	    }
	    else {
		insertH(newVal, node.getRight());
	    }
	}
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderHelp( TreeNode node ) {
	System.out.print( node.getValue() );
	if( node.getLeft() != null ) {
	    preOrderHelp( node.getLeft() );
	}
	if( node.getRight() != null ) {
	    preOrderHelp( node.getRight() );
	}
    }
           
    public void preOrderTrav() 
    {
	preOrderHelp( root );
	System.out.println();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void inOrderHelp( TreeNode node ) {
	if( node.getLeft() != null ) {
	    inOrderHelp( node.getLeft() );
	}

	System.out.print( node.getValue() );

	if( node.getRight() != null ) {
	    inOrderHelp( node.getRight() );
	}
    }
    
    public void inOrderTrav() 
    {
	inOrderHelp( root );
	System.out.println();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void postOrderHelp( TreeNode node ) {
	if( node.getLeft() != null ) {
	    postOrderHelp( node.getLeft() );
	}

	if( node.getRight() != null ) {
	    postOrderHelp( node.getRight() );
	}

	System.out.print( node.getValue() );
    }
    
    public void postOrderTrav() 
    {
	postOrderHelp( root );
	System.out.println();
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) {


	BST arbol = new BST();

	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();

	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~	
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
