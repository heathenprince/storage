/*****************************************************
 * class BST - v1:partial
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
    TreeNode _root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) {
	_root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	TreeNode newNode = new TreeNode( newVal );

	if ( _root == null ) {
	    _root = newNode;
	    return;
	}
        insert( _root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode ) {

	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }//end insert()

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public TreeNode remove( int target ) {
	return remove( _root , target );
    }
    
    public TreeNode remove( TreeNode stRoot, int target ) {
	
	if( stRoot.getValue() == target ) { // root is target
	    TreeNode newSubRoot = stRoot.getLeft(); 
	    while( newSubRoot.getRight() != null ) //find rightmost element of left subtree
		newSubRoot = stRoot.getRight();
	    
	    //stRoot.setLeft( newSubRoot );
	    newSubRoot.setRight( stRoot.getRight() );
	    _root = newSubRoot;
	    return stRoot;
	}
 
    
	if( stRoot.getLeft().getValue() == target ) { 
	    TreeNode rm = stRoot.getLeft();
	    if( rm.getLeft() == null && rm.getRight() == null ) {  // if no kids
		stRoot.setLeft(null);
		return rm;
	    }

	    
	    else if( rm.getLeft() != null && rm.getRight() != null ) { // if 2 children
		TreeNode newSubRoot = rm.getLeft(); //rightmost element of left subtree
		while( newSubRoot.getRight().getRight() != null ) 
		    newSubRoot = rm.getRight();

		stRoot.setLeft( newSubRoot );

		return remove( newSubRoot , target );
	    }

	    
	    else if( rm.getLeft() != null ) {//if left child
		stRoot.setLeft( rm.getLeft() );
		return rm;
	    }
	    else {//if right child
		stRoot.setLeft( rm.getRight() );
		return rm;
	    }
	}
	
	else if( stRoot.getRight().getValue() == target ) {
	    TreeNode rm = stRoot.getRight();
	    if( rm.getLeft() == null && rm.getRight() == null ) {  // if no kids
		stRoot.setLeft(null);
		return rm;
	    }

	    
	    else if( rm.getLeft() != null && rm.getRight() != null ) { // if 2 children
		TreeNode newSubRoot = rm.getLeft(); //rightmost element of left subtree
		while( newSubRoot.getRight().getRight() != null ) 
		    newSubRoot = rm.getRight();

		stRoot.setLeft( newSubRoot );

		return remove( newSubRoot , target );
	    }

	    
	    else if( rm.getLeft() != null ) {//if left child
		stRoot.setLeft( rm.getLeft() );
		return rm;
	    }
	    else {//if right child
		stRoot.setLeft( rm.getRight() );
		return rm;
	    }
	}
	     
	else {
	    if( target < stRoot.getValue() )
		return remove( stRoot.getLeft() , target );

	    else
		return remove( stRoot.getRight() , target );
	}
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav() {
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode ) {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav() {
	inOrderTrav( _root );
    }
    public void inOrderTrav( TreeNode currNode ) {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav() {
	postOrderTrav( _root );
    }
    public void postOrderTrav( TreeNode currNode ) {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	return search( target, _root );
    }

    TreeNode search( int target, TreeNode node ) {
	if( node.getValue() == target )
	    return node;
	
	else if( node.getValue() < target && node.getRight() != null ) 
	    return search( target, node.getRight() );
	
	else if( node.getLeft() != null )
	    return search( target, node.getLeft() );
	
	else 
	    return null;
    }

    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
	return height( _root );
    }

    
    public int height( TreeNode root ) {
	if( root.getLeft() != null && root.getRight() != null )
	    return ( Math.max( 1 + height( root.getLeft() ) , ( 1 + height( root.getRight() ) )) );
	
	return 1;
    }
	

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves( _root );
    }

     public int numLeaves( TreeNode root ) {
	if( root.getLeft() == null && root.getRight() == null ) 
	    return 1;

	else if( root.getLeft() == null )
	    return numLeaves( root.getRight() );

	else if( root.getRight() == null )
	    return numLeaves( root.getLeft() );

	else
	    return numLeaves( root.getLeft() ) + numLeaves ( root.getRight() );
    }

    //main method for testing
    public static void main( String[] args ) {
	BST arbol = new BST();

	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );
	
	System.out.print("PRE-TEST TRAVERSALS\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();

	arbol.remove(1); //leaf test case
	System.out.print("AFTER REMOVING LEAF OF VAL 1\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();

	arbol.remove(2); //one child test case
	System.out.print("AFTER REMOVING NODE OF VAL 2\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();

	arbol.remove(4); //root test case
	System.out.print("AFTER REMOVING ROOT (OF VAL 4)\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
