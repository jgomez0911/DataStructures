package weekB;

import java.util.Deque;

public class HWB {

    public Integer recursiveSumDeque( Deque<Integer> d ){
        // base
        if (d.isEmpty()){return 0;}
        // if only has 1
        if (d.size()==1){
            return d.removeFirst();
        }
        // getting both first and last
        Integer first = d.removeFirst();
        Integer last = d.removeLast();
        // recursive sum
        return first + last + recursiveSumDeque(d);
    }

    class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList<E> {
        private Node<E> head;
        private Node<E> tail;

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertAtHead(Node<E> node) {
            node.next = head; // Point new node to the current head
            head = node;      // Update head to the new node
        }

        public void insertAtTail(Node<E> node) {
            if (tail != null) { // If the list is not empty
                tail.next = node; // Link the current tail to the new node
            }
        }

        public E retrieveHead() {
            if (head != null) {
                return head.data; // Return the data of the head node
            }
            return null; // Return null if the list is empty
        }

        public E retrieveTail() {
            if (tail != null) {
                return tail.data; // Return the data of the tail node
            }
            return null; // Return null if the list is empty
        }
    }
}