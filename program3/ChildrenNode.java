package program3;

public class ChildrenNode {

    private Children myChild;

    private ChildrenNode link;

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