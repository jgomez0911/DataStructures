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

	public static void main(String[] args) {
		//nodes
		IntBTNode node3 = new IntBTNode(3, null, null);
		IntBTNode node2= new IntBTNode(2, node3, null);
		IntBTNode node30= new IntBTNode(30, null, null);
		IntBTNode node11= new IntBTNode(11, null, node30);
		// root
		IntBTNode root= new IntBTNode(14,node2,node11);

		root.preorder(); System.out.println();
		root.inorder(); System.out.println();
		root.postorder(); System.out.println();
	}
}