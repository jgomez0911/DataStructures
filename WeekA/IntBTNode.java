public class IntBTNode {
	private int data;
	private IntBTNode left;
	private IntBTNode right;
	
	public IntBTNode( int data, IntBTNode left, IntBTNode right ) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() { return data; }
	public IntBTNode getLeft() { return left; }
	public IntBTNode getRight() { return right; }
	
	public void setData( int data ) { this.data = data; }
	public void setLeft( IntBTNode left ) { this.left = left; }
	public void setRight( IntBTNode right ) { this.right = right; }
	
	public boolean isLeaf() {
		return ( left == null ) && ( right == null );
	}
	
	public void preorder() {
		System.out.print( getData() + " " );
		if ( getLeft() != null ) {
			getLeft().preorder();
		}
		if ( getRight() != null ) {
			getRight().preorder();
		}
	}
	
	public void inorder() {
		if ( getLeft() != null ) {
			getLeft().inorder();
		}
		System.out.print( getData() + " " );
		if ( getRight() != null ) {
			getRight().inorder();
		}
	}
	
	public void postorder() {
		if ( getLeft() != null ) {
			getLeft().postorder();
		}
		if ( getRight() != null ) {
			getRight().postorder();
		}
		System.out.print( getData() + " " );
	}
}
