package week6;
/* 
public class HW6{
    // this is given
    public class Node<E> {
        E data;
        Node<E> link;

        public Node<E>( E data, Node<E> next ) {
            this.data = data;
            this.link = next;
        }

        public Node<E>() {
            this.data = null;
            this.link = null;
        }

        public E getData() { return data; }
        public Node<E> getLink() { return link; }
        public void setData( E data ) { this.data = data; }
        public void setLink( Node<E> link ) { this.link = link; }
    }
    // this is the method to create // exercise 2
    public static <E> E removeFirst(E target, Node<E> head) {
        // Check if the head is null
        if (head == null) {
            return null; // List is empty
        }

        Node<E> current = head;
        Node<E> previous = null;

        // Traverse the linked list
        while (current != null) {
            // Check if the current node's data matches the target
            if (current.getData().equals(target)) {
                // If the node to remove is the head
                if (previous == null) {
                    // Update head to the next node
                    head = current.getLink();
                } else {
                    // Bypass the current node
                    previous.setLink(current.getLink());
                }
                // Return the data of the removed node
                return current.getData();
            }
            // Move to the next node
            previous = current;
            current = current.getLink();
        }
        // If we reach here, the target was not found
        return null;
    }

    // this is given // excercise 3
    public class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public E getData() { return data; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }

        public void setData( E data ) { this.data = data; }
        public void setPrev ( Node<E> prev ) { this.prev = prev; }
        public void setNext ( Node<E> next ) { this.prev = next; }

    }
    // this is the method to create
    public E removeLast( E target, Node<E> head, Node<E> tail ){

        Node<E> current = tail; // Start from the tail of the list

    // Traverse the list backwards until we find the target or reach the head
    while (current != null) {
        if (current.getData().equals(target)) {
            // Found the target, now remove this node
            Node<E> prevNode = current.getPrev();
            Node<E> nextNode = current.getNext();

            // Adjust the pointers of the previous and next nodes
            if (prevNode != null) {
                prevNode.setNext(nextNode);
            } else {
                // If there is no previous node, we are removing the head
                head = nextNode; // Update head if necessary
            }

            if (nextNode != null) {
                nextNode.setPrev(prevNode);
            } else {
                // If there is no next node, we are removing the tail
                tail = prevNode; // Update tail if necessary
            }

            // Clear the current node's references (optional)
            current.setPrev(null);
            current.setNext(null);
            current.setData(null);

            return target; // Return the removed target
        }
        current = current.getPrev(); // Move to the previous node
    }

    return null; // Return null if the target was not found
    }

}
    */