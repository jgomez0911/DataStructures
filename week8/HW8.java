package week8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;


public class HW8 {

    public static  void main(String[] args) {
        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(5);
        Queue<Integer> line = new LinkedList<>();
        try {
            // Adding elements to the queue
            abq.add(100);
            printQueue(abq);
            abq.add(200);
            printQueue(abq);
            abq.add(300);
            printQueue(abq);
            abq.remove();
            printQueue(abq);
            abq.add(400);
            printQueue(abq);
            abq.add(500);
            printQueue(abq);
            abq.add(600);
            printQueue(abq);
            abq.remove();
            printQueue(abq);
            abq.add(700);
            printQueue(abq);

            line.add(8);
            line.add(5);
            line.add(7);
            line.add(4);
            line.add(7);
            line.add(5);
            line.add(9);
            line.add(7);

            printQueue(line);
            moveToFront(line, 7);
            printQueue(line);

        } catch (IllegalStateException e) {
            System.out.println("Queue is full, cannot add more elements.");
        }
    }

    public static <E> Queue<E> moveToFront(Queue<E> q, E item) {
        // Create a new queue to hold the result
        Queue<E> resultQueue = new LinkedList<>();

        // Create a temporary stack to hold non-matching items
        Stack<E> tempStack = new Stack<>();

        // Iterate through the original queue
        while (!q.isEmpty()) {
            E current = q.poll(); // Remove the head of the queue

            if (current.equals(item)) {
                // If the current item matches, add it to the result queue
                resultQueue.add(current);
            } else {
                // Otherwise, push it onto the stack
                tempStack.push(current);
            }
        }

        // Now add the remaining items from the stack to the result queue
        while (!tempStack.isEmpty()) {
            resultQueue.add(tempStack.pop());
        }

        return resultQueue;
    }

    public static <E> void printQueue(Queue<E> queue) {
        System.out.println(); // New line before printing the queue
        // Create a temporary queue to hold the elements
        Queue<E> tempQueue = new LinkedList<>();

        // Print the elements and add them to the temporary queue
        System.out.print("Queue: ");
        while (!queue.isEmpty()) {
            E element = queue.poll(); // Remove the head of the queue
            System.out.print(element + " "); // Print the element
            tempQueue.offer(element); // Add to the temporary queue
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }

        System.out.println(); // New line after printing the queue
    }

}