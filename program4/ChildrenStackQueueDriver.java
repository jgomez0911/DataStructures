package program4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Jorge Gomez
 * @date 03/23/25
 * The ChildrenStackQueueDriver class demonstrates the use of stacks and queues
 * to manage and manipulate collections of Children, GrandChildren, and Nephew objects.
 */
public class ChildrenStackQueueDriver {
    /**
     * The main method serves as the entry point for the program.
     * It reads data from a file, populates stacks and queues, and performs various operations
     * to demonstrate the functionality of the implemented methods.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Stack<Children> stack = new Stack<>();
        Queue<Children> queue = new LinkedList<>();
        Queue<Children> queueE = new LinkedList<>();

        // Read from the info.txt file and populate the stack and queue
        try (Scanner scanner = new Scanner(new File("program4/info.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                int type = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);

                switch (type) {
                    case 1 -> // Create a Children object
                        stack.push(new Children(name, age));
                    case 2 -> {
                        // Create a GrandChildren object
                        int generation = Integer.parseInt(parts[3]);
                        queue.offer(new GrandChildren(name, age, generation));
                    }
                    case 3 -> {
                        // Create a Nephew object
                        boolean male = Boolean.parseBoolean(parts[3]);
                        queue.offer(new Nephew(name, age, male));
                    }
                    default -> {}
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // making copies of the stacks for each method
        Stack<Children> toInt = new Stack<>();
        Stack<Children> some = new Stack<>();
        Stack<Children> extractFS = new Stack<>();
        Stack<Children> eqstack = new Stack<>();
        Stack<Children> rPlace = new Stack<>();
        Stack<Children> extra = new Stack<>();
        Stack<Children> swp = new Stack<>();
        Stack<Children> empty = new Stack<>();

        for (Children child : stack) {
            toInt.push(new Children(child));
            some.push(new Children(child));
            extractFS.push(new Children(child));
            eqstack.push(new Children(child));
            rPlace.push(new Children(child));
            extra.push(new Children(child));
            swp.push(new Children(child));
        }

        // Test cases for stackToint
        System.out.println("\n----Testing stackToint----------");
        System.out.println("Stack to int: " + stackToint(stack)); // Test case 1: Stack with at least four items
        Stack<Children> oneItem = new Stack<>();
        Children test = new Children("TestChild", 5);
        oneItem.push(test); // Test case 3: Adding a child with age 0
        System.out.printf("Stack to int with one object: %d\n", stackToint(oneItem)); // Test case 2: Stack with 1 item
        toInt.push(stack.pop()); toInt.push(stack.pop());
        Children test1 = new Children("Tesild", 0);
        toInt.push(test1); // Test case 3: Adding a child with age 0
        System.out.printf("Stack to int with age 0: %d\n", stackToint(toInt)); // Test case 3
        toInt.pop(); toInt.pop(); toInt.pop(); // removing them for future method

        // Test cases for popSome
        System.out.println("\n----Testing popSome----------");
        System.out.println("Sum of popped ages (count 2): " + popSome(some, 2));
        System.out.println("Sum of popped ages (count 4): " + popSome(some, 4));
        System.out.println("Sum of popped ages (0 items): " + popSome(some, 0));
        System.out.println("Sum of popped ages (0 items): " + popSome(some, 1));
        System.out.println("Sum of popped ages (0 items): " + popSome(some, -1));

        // Example of extracting from stack
        System.out.println("\n----Testing extractFromStack----------");
        Children childToExtract = new Children("Jorge", 29);

        // current stack
        System.out.println("current stack:");
        printStack(extractFS);
        int extractedCount = extractFromStack(extractFS, childToExtract);
        System.out.println("\nafter extraction count: " + extractedCount); // matches 1

        // after extracting 1
        printStack(extractFS);
        Children childToExtract1 = new Children("Jamie", 29);
        extractFS.push(childToExtract);
        extractFS.push(childToExtract1);
        extractFS.push(childToExtract1);
        // current stack
        System.out.println("\n\ncurrent stack:");
        printStack(extractFS);
        int extractedCountMany = extractFromStack(extractFS, childToExtract1);
        System.out.println("\nafter extraction count: " + extractedCountMany);
        // after extracting 3
        printStack(stack);

        // no match
        Children childToExtract2 = new Children("John", 35);
        // current stack
        System.out.println("\n\ncurrent stack:");
        printStack(extractFS);
        int extractedCountNone = extractFromStack(extractFS, childToExtract2);
        System.out.println("\nafter extraction count: " + extractedCountNone);
        // after extracting
        printStack(extractFS);

        // empty // no match
        Children childToExtract3 = new Children("John", 35);
        extractFS.pop(); extractFS.pop(); extractFS.pop();
        extractFS.pop(); extractFS.pop(); // stack is now empty
        // current stack
        System.out.println("\n\ncurrent stack:");
        printStack(extractFS);
        int extractedCountE = extractFromStack(extractFS, childToExtract3);
        System.out.println("after extraction count: " + extractedCountE); // matches 0
        // after extracting 4
        printStack(extractFS);

        // Example of checking equality of two stacks
        System.out.println("\n----Testing equality----------");
        System.out.print("Stack 1: ");
        printStack(rPlace);
        System.out.println();
        System.out.print("Stack 2: ");
        printStack(toInt);
        System.out.println("\nStacks are equal: " + equalStacks(rPlace, toInt));

        System.out.print("\nStack 1: ");
        printStack(rPlace);
        System.out.println();
        extra.pop();
        System.out.print("Stack 2: ");
        printStack(extra);
        System.out.println("\nStacks are equal: " + equalStacks(rPlace, extra));

        System.out.print("\nStack 1: ");
        printStack(rPlace);
        System.out.println();
        extra.pop();
        System.out.print("Stack 2: ");
        printStack(some);
        System.out.println("\nStacks are equal: " + equalStacks(rPlace, some));

        System.out.print("\nStack 1: ");
        printStack(some);
        System.out.println();
        extra.pop();
        System.out.print("Stack 2: ");
        printStack(some);
        System.out.println("\nStacks are equal: " + equalStacks(some, some));

        // Example of replacing in queue
        System.out.println("\n----Testing replace----------");
        // replace front
        printQueue(queue);
        int replacedCountf = replace(queue, new GrandChildren("Daniel", 6, 1), new GrandChildren("Daniel", 16, 2));
        System.out.println("Replace Daniel 6 with Daniel 16");
        System.out.println("Replaced count in queue: " + replacedCountf);
        printQueue(queue);
        // replace rear
        int replacedCountr = replace(queue, new Nephew("Lorena", 27, false), new Nephew("Lorena", 16, false));
        System.out.println("Replace Lorena 27 with Lorena 16");
        System.out.println("Replaced count in queue: " + replacedCountr);
        printQueue(queue);
        // adding more old values
        queue.offer(new Nephew("Ben", 1, true));
        queue.offer(new Nephew("Ben", 1, true));
        System.out.println("--New Queue--");
        printQueue(queue);
        System.out.println("Replace Ben 1 with Ben 16");
        int replacedCountm = replace(queue, new Nephew("Ben", 1, true), new Nephew("Ben", 16, true));
        System.out.println("Replaced count in queue: " + replacedCountm);
        printQueue(queue);
        // no old val
        System.out.println("Replace John 16 with Joe 16");
        int replacedCountx = replace(queue, new Nephew("John", 16, true), new Nephew("Joe", 16, true));
        System.out.println("Replaced count in queue: " + replacedCountx);
        printQueue(queue);
        // empty queue
        System.out.println("Replace Bob 16 with Bill 16");
        int replacedCounte = replace(queue, new Nephew("John", 16, true), new Nephew("Joe", 16, true));
        System.out.println("Replaced count in queue: " + replacedCounte);
        printQueue(queueE);

        // Example of swapping stack and queue
        System.out.println("\n----Testing swapping----------");
        System.out.print("Stack: ");
        printStack(swp); printQueue(queue);
        swap(swp, queue);
        System.out.print("After swapping, \n\nStack: ");
        printStack(swp); printQueue(queue);
        // empty queue
        System.out.println("--Empty Queue--");
        System.out.print("Stack: ");
        printStack(swp); printQueue(queueE);
        swap(swp, queueE);
        System.out.print("After swapping, \n\nStack: ");
        printStack(swp); printQueue(queueE);
        // empty stack
        System.out.println("--Empty Stack--");
        System.out.print("Stack: ");
        printStack(some); printQueue(queue);
        swap(some, queue);
        System.out.print("After swapping, \n\nStack: ");
        printStack(some); printQueue(queue);
        // both empty
        System.out.println("--Both Empty--");
        System.out.print("Stack: ");
        printStack(empty); printQueue(queue);
        swap(empty, queue);
        System.out.print("After swapping, \n\nStack: ");
        printStack(empty); printQueue(queue);

        // Example of splitting the queue
        System.out.println("\n----Testing splitting----------");
        transferChildrenToQueue(stack, queueE);
        Queue<Children>[] splitQueues = split(queueE);
        System.out.println("Children Queue: " + splitQueues[0]);
        System.out.println("GrandChildren Queue: " + splitQueues[1]);
        System.out.println("Nephew Queue: " + splitQueues[2]);
        // empty queue
        System.out.println("\n---Empty Queue---");
        Queue<Children>[] splitQueuesE = split(queueE);
        System.out.println("Children Queue: " + splitQueuesE[0]);
        System.out.println("GrandChildren Queue: " + splitQueuesE[1]);
        System.out.println("Nephew Queue: " + splitQueuesE[2]);
    }

    /**
     * Converts the ages of the children in the stack to an integer.
     * The ages are concatenated until the length reaches 8 digits.
     * @param s The stack of Children objects.
     * @return The integer representation of the concatenated ages.
     */
    public static int stackToint(Stack<Children> s) {
        // Use a String to accumulate the ages
        String results = "";
        Stack<Children> stack = new Stack<>();

        while (!s.isEmpty()) {
            Children child = s.pop();
            stack.push(child);
            int age = child.getAge();
            // Append the age to the results string
            results += age;
            // Check if the length exceeds 8 digits
            if (results.length() >= 8) {
                break;
            }
        }

        // Restore the original stack
        while (!stack.isEmpty()) {
            s.push(stack.pop());
        }

        // Convert the results string to an integer
        return Integer.parseInt(results);
    }

    /**
     * Pops a specified number of children from the stack and returns the sum of their ages.
     * @param s The stack of Children objects.
     * @param count The number of children to pop from the stack.
     * @return The sum of the ages of the popped children, or -1 if fewer children were popped than requested.
     */
    public static int popSome(Stack<Children> s, int count) {
        if (count <= 0) return 0;

        int sum = 0;
        int poppedCount = 0;

        while (poppedCount < count && !s.isEmpty()) {
            sum += s.pop().getAge();
            poppedCount++;
        }

        if (poppedCount < count) {
            return -1;
        }

        return sum;
    }

    /**
     * Extracts all occurrences of a specified child from the stack.
     * @param s The stack of Children objects.
     * @param i The child to extract.
     * @return The count of extracted children.
     */
    public static int extractFromStack(Stack<Children> s, Children i) {
        Stack<Children> tempStack = new Stack<>();
        int count = 0;

        while (!s.isEmpty()) {
            Children child = s.pop();
            if (!child.equals(i)) {
                tempStack.push(child);
            } else {
                count++;
            }
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        return count;
    }

    /**
     * Checks if two stacks of Children objects are equal.
     * @param s1 The first stack.
     * @param s2 The second stack.
     * @return True if the stacks are equal, false otherwise.
     */
    public static boolean equalStacks(Stack<Children> s1, Stack<Children> s2) {
        // Check if the sizes are equal
        if (s1.size() != s2.size()) return false;

        // Temporary stacks to hold the popped elements
        Stack<Children> temp1 = new Stack<>();
        Stack<Children> temp2 = new Stack<>();

        // Compare elements in both stacks
        while (!s1.isEmpty() && !s2.isEmpty()) {
            Children child1 = s1.pop();
            Children child2 = s2.pop();

            // Check for equality
            if (!child1.equals(child2)) {
                // Restore the stacks
                temp1.push(child1);
                temp2.push(child2);
                break; // Exit the loop if they are not equal
            }

            // Push the elements to temporary stacks for restoration
            temp1.push(child1);
            temp2.push(child2);
        }

        // Restore the original stacks
        while (!temp1.isEmpty()) {
            s1.push(temp1.pop());
        }
        while (!temp2.isEmpty()) {
            s2.push(temp2.pop());
        }

        // If we exited the loop without finding a difference, the stacks are equal
        return true;
    }

    /**
     * Replaces occurrences of an old value in a queue with a new value.
     * @param q The queue of Children objects.
     * @param oldVal The value to be replaced.
     * @param newVal The value to replace with.
     * @return The count of replacements made.
     */
    public static int replace(Queue<Children> q, Children oldVal, Children newVal) {
        int count = 0;
        int size = q.size(); // Store the initial size of the queue

        // Use a temporary queue to hold the modified values
        Queue<Children> tempQueue = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            Children child = q.poll(); // Remove the head of the queue
            if (child.equals(oldVal)) {
                tempQueue.offer(newVal); // Replace with newVal
                count++;
            } else {
                tempQueue.offer(child); // Keep the original child
            }
        }

        // Restore the original queue with the modified values
        while (!tempQueue.isEmpty()) {
            q.offer(tempQueue.poll());
        }

        return count; // Return the count of replacements
    }

    /**
     * Swaps the contents of a stack and a queue.
     * @param s The stack of Children objects.
     * @param q The queue of Children objects.
     */
    public static void swap(Stack<Children> s, Queue<Children> q) {
        if (s.isEmpty() && q.isEmpty()) return;

        Stack<Children> tempStack = new Stack<>();
        Queue<Children> tempQueue = new LinkedList<>();

        // Move elements from stack to tempQueue
        while (!s.isEmpty()) {
            tempQueue.offer(s.pop());
        }

        // Move elements from queue to tempStack
        while (!q.isEmpty()) {
            tempStack.push(q.poll());
        }

        // Move elements from tempStack to stack
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        // Move elements from tempQueue to queue
        while (!tempQueue.isEmpty()) {
            q.offer(tempQueue.poll());
        }
    }

    /**
     * Splits a queue of Children into three separate queues: one for Children,
     * one for GrandChildren, and one for Nephews.
     * @param q The queue of Children objects to split.
     * @return An array of queues containing the split results.
     */
    @SuppressWarnings("unchecked")
    public static Queue<Children>[] split(Queue<Children> q) {
        Queue<Children> grandChildrenQueue = new LinkedList<>();
        Queue<Children> nephewQueue = new LinkedList<>();
        Queue<Children> ChildrenQueue = new LinkedList<>();

        while (!q.isEmpty()) {
            Children child = q.poll();
            if (child instanceof GrandChildren) {
                grandChildrenQueue.offer(child);
            } else if (child instanceof Nephew) {
                nephewQueue.offer(child);
            } else {
                ChildrenQueue.offer(child);
            }
        }

        return new Queue[]{ChildrenQueue, grandChildrenQueue, nephewQueue};
    }

    /**
     * Prints the contents of a queue of Children objects.
     * @param queue The queue to print.
     */
    public static void printQueue(Queue<Children> queue) {
        System.out.println(); // New line after printing the queue
        // Create a temporary queue to hold the elements
        Queue<Children> tempQueue = new LinkedList<>();

        // Print the elements and add them to the temporary queue
        System.out.print("Queue: ");
        while (!queue.isEmpty()) {
            Children child = queue.poll(); // Remove the head of the queue
            System.out.printf("%s  %d, ", child.getName(), child.getAge()); // Print the child
            tempQueue.offer(child); // Add to the temporary queue
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }

        System.out.println(); // New line after printing the queue
        System.out.println(); // New line after printing the queue
    }

    /**
     * Prints the contents of a stack of Children objects.
     * @param s The stack to print.
     */
    public static void printStack(Stack<Children> s) {
        for (Children child : s) {
            System.out.printf("%s  %d, ", child.getName(), child.getAge());
        }
    }

    /**
    * Transfers all Children objects from a stack to a queue.
    * @param stack The stack containing Children objects to be transferred.
    *              This stack will be emptied after the operation.
    * @param queue The queue to which the Children objects will be added.
    *              The queue will contain all the Children objects that were in the stack after the operation.
    */
    public static void transferChildrenToQueue(Stack<Children> stack, Queue<Children> queue) {
        while (!stack.isEmpty()) {
            // Pop the child from the stack
            Children child = stack.pop();
            // Add the child to the queue
            queue.offer(child);
        }
    }
}