package week7;

// Assuming the Node and Stack classes are defined as follows:

class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<E> {
    private Node<E> top;

    public Stack() {
        this.top = null;
    }

    public void push(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E value = top.data;
        top = top.next;
        return value;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

// The countOccurrences method
public class StackUtils {
    public static int countOccurrences(Stack<Integer> s, Integer val) {
        Stack<Integer> tempStack = new Stack<>();
        int count = 0;

        // Count occurrences and transfer elements to tempStack
        while (!s.isEmpty()) {
            Integer current = s.pop();
            if (current.equals(val)) {
                count++;
            }
            tempStack.push(current);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        return count;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(2);

        int occurrences = countOccurrences(stack, 2);
        System.out.println("Occurrences of 2: " + occurrences); // Output: 3
    }
}