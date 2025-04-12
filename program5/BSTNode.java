package program5;

public class BSTNode {

    private MenuItem data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(MenuItem m, BSTNode l, BSTNode r) {
        data = m;
        left = l;
        right = r;
    }

    // Getter for the MenuItem data
    public MenuItem getMenuItem() {
        return data;
    }

    // Setter for the MenuItem data
    public void setMenuItem(MenuItem data) {
        this.data = data;
    }

    // Getter for the left child
    public BSTNode getLeft() {
        return left;
    }

    // Setter for the left child
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    // Getter for the right child
    public BSTNode getRight() {
        return right;
    }

    // Setter for the right child
    public void setRight(BSTNode right) {
        this.right = right;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return data.toString(); // Uses the toString method of MenuItem
    }
}