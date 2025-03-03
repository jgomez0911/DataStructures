/*
 * @author Jorge Gomez
 * @date 02/22/25
 * Represents a node in a linked list that stores a Children object.
 * Each node contains a reference to the next node in the list.
 */
public class ChildrenNode {

    private Children myChild;
    private ChildrenNode link;
    /**
    * Constructs a ChildrenNode with the specified Children object and link to the next node.
    *
    * @param i the Children object to be stored in this node
    * @param n the next ChildrenNode in the linked list
     */
    public ChildrenNode(Children i, ChildrenNode n){
        this.myChild = i;
        this.link = n;
    }

    // Setter for link
    public void setLink(ChildrenNode link) {
        this.link = link;
    }

    // Setter for myChild
    public void setMyChild(Children myChild) {
        this.myChild = myChild;
    }

    // Getter for myChild
    public Children getMyChild() {
        return myChild;
    }

    // Getter for link
    public ChildrenNode getLink() {
        return link;
    }
}