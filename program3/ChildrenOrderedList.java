package program3;
/**
 * @author Jorge Gomez
 * @date 02/22/25
 * Represents an ordered linked list of Children objects.
 * This class provides methods to add, remove, and retrieve Children objects
 * while maintaining their order based on the compareTo method.
 */
public class ChildrenOrderedList {

    private ChildrenNode head; // Reference to the head of the linked list
    private ChildrenNode tail; // Reference to the tail of the linked list

    /**
     * Constructs an empty ChildrenOrderedList.
     */
    public ChildrenOrderedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Adds a Children object to the list in order.
     * @param element the Children object to be added
     */
    public void add(Children element) {
        ChildrenNode newNode = new ChildrenNode(element, null);

        // If the list is empty, add the new node as the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        // If the new element should be added at the head
        if (head.getMyChild().compareTo(element) > 0) {
            newNode.setLink(head);
            head = newNode;
            return;
        }
        // Traverse the list to find the correct position
        ChildrenNode current = head;
        while (current.getLink() != null && current.getLink().getMyChild().compareTo(element) < 0) {
            current = current.getLink();
        }
        // Insert the new node
        newNode.setLink(current.getLink());
        current.setLink(newNode);

        // If the new node is added at the end, update the tail
        if (newNode.getLink() == null) {
            tail = newNode;
        }
    }

    /**
     * Returns the number of nodes in the list.
     * @return the size of the list
     */
    public int size() {
        int count = 0;
        ChildrenNode current = head;
        while (current != null) {
            count++;
            current = current.getLink();
        }
        return count;
    }

    /**
     * Displays the contents of the list.
     * Each Children object is printed to the console.
     */
    public void display() {
        ChildrenNode current = head;
        while (current != null) {
            System.out.println(current.getMyChild().toString());
            current = current.getLink();
        }
    }

    /**
     * Adds a Children object at a specified index in the list.
     * @param index   the position to add the Children object (1-based index)
     * @param element the Children object to be added
     * @return true if the element was added, false if the index is invalid
     */
    public boolean add(int index, Children element) {
        if (index < 1) {
            return false; // Index must be 1 or greater
        }
        ChildrenNode newNode = new ChildrenNode(element, null);
        if (index == 1) { // Add at the head
            newNode.setLink(head);
            head = newNode;
            if (tail == null) { // If the list was empty, set tail
                tail = newNode;
            }
            return true;
        } else {
            ChildrenNode current = head;
            for (int i = 1; i < index - 1 && current != null; i++) {
                current = current.getLink();
            }
            if (current != null) {
                newNode.setLink(current.getLink());
                current.setLink(newNode);
                if (newNode.getLink() == null) { // If added at the end, update tail
                    tail = newNode;
                }
                return true;
            } else {
                // If index is greater than the list size, add to the end
                add(element);
                return true;
            }
        }
    }

    /**
     * Removes one occurrence of the specified Children object from the list.
     * @param target the Children object to be removed
     * @return true if the object was removed, false if not found
     */
    public boolean remove(Children target) {
        if (head == null) {
            return false; // List is empty
        }
        // Check if the head needs to be removed
        if (head.getMyChild().equals(target)) {
            head = head.getLink();
            if (head == null) { // If the list is now empty, update tail
                tail = null;
            }
            return true;
        }
        // Traverse the list to find the target
        ChildrenNode current = head;
        while (current.getLink() != null) {
            if (current.getLink().getMyChild().equals(target)) {
                current.setLink(current.getLink().getLink());
                if (current.getLink() == null) { // If removed last node, update tail
                    tail = current;
                }
                return true;
            }
            current = current.getLink();
        }
        return false; // Target not found
    }

    /**
     * Removes the item located at the specified index in the list.
     * @param index the position of the item to be removed (1-based index)
     * @return true if the item was removed, false if the index is invalid
     */
    public boolean remove(int index) {
        if (index < 1 || head == null) {
            return false; // Invalid index or empty list
        }

        if (index == 1) { // Remove from the head
            head = head.getLink();
            if (head == null) { // If the list is now empty, update tail
                tail = null;
            }
            return true;
        }

        ChildrenNode current = head;
        for (int i = 1; i < index - 1 && current.getLink() != null; i++) {
            current = current.getLink();
        }
        if (current.getLink() == null) {
            return false; // Index out of bounds
        }
        current.setLink(current.getLink().getLink());
        if (current.getLink() == null) { // If removed last node, update tail
            tail = current;
        }
        return true;
    }

    /**
     * Returns the index of the first occurrence of the specified Children object.
     * @param target the Children object to find
     * @return the index of the first occurrence, or -1 if not found
     */
    public int indexOf(Children target) {
        int index = 1;
        ChildrenNode current = head;
        while (current != null) {
            if (current.getMyChild().equals(target)) {
                return index; // Return the index if found
            }
            current = current.getLink();
            index++;
        }
        return -1; // Return -1 if not found
    }

    /**
     * Returns the Children object located at the specified index.
     * @param index the position of the item to retrieve (1-based index)
     * @return the Children object at the specified index, or null if not found
     */
    public Children get(int index) {
        if (index < 1) {
            return null; // Invalid index
        }
        ChildrenNode current = head;
        for (int i = 1; i < index && current != null; i++) {
            current = current.getLink();
        }
        return current == null ? null : current.getMyChild(); // Return the item or null if not found
    }
}