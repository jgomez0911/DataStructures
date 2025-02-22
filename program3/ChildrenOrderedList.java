package program3;

public class ChildrenOrderedList {

    private ChildrenNode head; // Reference to the head of the linked list
    private ChildrenNode tail; // Reference to the tail of the linked list

    // Constructor
    public ChildrenOrderedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to add an Item to the end of the list
    public void add(Children element) {
        ChildrenNode newNode = new ChildrenNode(element, null);
        if (head == null) { // If the list is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.setLink(newNode); // Link the new node to the end
            tail = newNode; // Update the tail
        }
    }

    // Method to return the number of nodes in the list
    public int size() {
        int count = 0;
        ChildrenNode current = head;
        while (current != null) {
            count++;
            current = current.getLink();
        }
        return count;
    }

    // Method to display the contents of the list
    public void display() {
        ChildrenNode current = head;
        while (current != null) {
            System.out.println(current.getMyChild().toString()); // Assuming Children has a proper toString method
            current = current.getLink();
        }
    }

    // Method to add an element at a given index
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

    // Method to remove one occurrence of target from the list
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

    // Method to remove the item located at position index
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

    // Method to return the index of the first occurrence of target
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

    // Method to return the item at position index
    public Children get(int index) {
        if (index < 1) {
            return null; // Invalid index
        }
        ChildrenNode current = head;
        for (int i = 1; i < index && current != null; i++) {
            current = current.getLink();
        }
        return (current != null) ? current.getMyChild() : null; // Return the item or null if not found
    }
}