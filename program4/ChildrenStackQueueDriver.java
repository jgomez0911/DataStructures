import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ChildrenStackQueueDriver {
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
                    default -> {
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // making copys of the stacks for each method
        Stack<Children> toInt = new Stack<>();
        Stack<Children> some = new Stack<>();
        Stack<Children> extractFS = new Stack<>();
        Stack<Children> eqstack = new Stack<>();
        Stack<Children> rPlace = new Stack<>();
        Stack<Children> extra = new Stack<>();
        Stack<Children> swp = new Stack<>();

        for (Children child : stack) {
            toInt.push(new Children(child));
            some.push(new Children(child));
            extractFS.push(new Children(child));
            eqstack.push(new Children(child));
            rPlace.push(new Children(child));
            extra.push(new Children(child));
            swp.push(new Children(child));
        }
/*
         // Test cases for stackToint
        System.out.println("\n---Testing stackToint---");
        System.out.println("Stack to int: " + stackToint(stack)); // Test case 1: Stack with at least four items
        Stack<Children> oneItem = new Stack<>();
        Children test = new Children("TestChild", 5);
        oneItem.push(test); // Test case 3: Adding a child with age 0
        System.out.printf("Stack to int with one object: %d\n", stackToint(oneItem));// Test case 2: Stack with 1 item
        toInt.push(stack.pop()); toInt.push(stack.pop());
        Children test1 = new Children("Tesild", 0);
        toInt.push(test1); // Test case 3: Adding a child with age 0
        System.out.printf("Stack to int with age 0: %d\n", stackToint(toInt)); // Test case 3
        toInt.pop(); toInt.pop(); toInt.pop();

        // Test cases for popSome
        System.out.println("\n---Testing popSome---");
        System.out.println("Sum of popped ages (count 2): " + popSome(some, 2));
        System.out.println("Sum of popped ages (count 5): " + popSome(some, 5));
        System.out.println("Sum of popped ages (0 items): " + popSome(some, 0));
        System.out.println("Sum of popped ages (0 items): " + popSome(some, 1));
        System.out.println("Sum of popped ages (0 items): " + popSome(some, -1));

        // Example of extracting from stack
        System.out.println("\n---Testing extractFromStack---");
        Children childToExtract = new Children("Jorge", 29);

        // current stack
        System.out.println("curent stack:");
        for (Children child : extractFS) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        int extractedCount = extractFromStack(extractFS, childToExtract);
        System.out.println("\nafter extraction count: " + extractedCount); // matches 1

        // after extracting 1
        for (Children child : extractFS) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        Children childToExtract1 = new Children("Jamie", 29);
        extractFS.push(childToExtract); extractFS.push(childToExtract1); extractFS.push(childToExtract1);
        // current stack
        System.out.println("\n\ncurent stack:");
        for (Children child : extractFS) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        int extractedCountMany = extractFromStack(extractFS, childToExtract1);
        System.out.println("\nafter extraction count: " + extractedCountMany);
        // after extracting 3
        for (Children child : stack) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }

        // no match
        Children childToExtract2 = new Children("John", 35);
        // current stack
        System.out.println("\n\ncurent stack:");
        for (Children child : extractFS) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        int extractedCountNone = extractFromStack(extractFS, childToExtract2);
        System.out.println("\nafter extraction count: " + extractedCountNone);
        // after extracting
        for (Children child : extractFS) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }

        // empty // no match
        Children childToExtract3 = new Children("John", 35);
        extractFS.pop(); extractFS.pop(); extractFS.pop(); extractFS.pop(); extractFS.pop();// stack is now empty
        // current stack
        System.out.println("\n\ncurent stack:");
        for (Children child : extractFS) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        int extractedCountE = extractFromStack(extractFS, childToExtract3);
        System.out.println("after extraction count: " + extractedCountE); // matches 0
        // after extracting 4
        for (Children child : extractFS) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }

        // Example of checking equality of two stacks
        System.out.println("\n---Testing equality---");
        System.out.print("Stack 1: ");
        for (Children child : rPlace) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println();
        System.out.print("Stack 2: ");
        for (Children child : toInt) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println("\nStacks are equal: " + equalStacks(rPlace, toInt));

        System.out.print("\nStack 1: ");
        for (Children child : rPlace) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println();
        extra.pop();
        System.out.print("Stack 2: ");
        for (Children child : extra) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println("\nStacks are equal: " + equalStacks(rPlace, extra));

        System.out.print("\nStack 1: ");
        for (Children child : rPlace) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println();
        extra.pop();
        System.out.print("Stack 2: ");
        for (Children child : some) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println("\nStacks are equal: " + equalStacks(rPlace, some));

        System.out.print("\nStack 1: ");
        for (Children child : some) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println();
        extra.pop();
        System.out.print("Stack 2: ");
        for (Children child : some) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
        System.out.println("\nStacks are equal: " + equalStacks(some, some));

        // Example of replacing in queue
        System.out.println("\n---Testing replace---");
        // replace front
        printQueue(queue);
        int replacedCountf = replace(queue, new GrandChildren("Daniel", 6, 1), new GrandChildren("Daniel", 16, 2));
        System.out.println("Repalce Daniel 6 with Daniel 16");
        System.out.println("Replaced count in queue: " + replacedCountf);
        printQueue(queue);
        // replace rear
        int replacedCountr = replace(queue, new Nephew("Lorena", 27, false), new Nephew("Lorena", 16, false));
        System.out.println("Repalce Lorena 27  with Lorena 16");
        System.out.println("Replaced count in queue: " + replacedCountr);
        printQueue(queue);
        // adding more oldvalues
        queue.offer(new Nephew("Ben", 1,true));queue.offer(new Nephew("Ben", 1,true));
        System.out.println("--New Queue--");
        printQueue(queue);
        System.out.println("Repalce Ben 1  with Ben 16");
        int replacedCountm = replace(queue, new Nephew("Ben", 1, true), new Nephew("Ben", 16, true));
        System.out.println("Replaced count in queue: " + replacedCountm);
        printQueue(queue);
        // no old val
        System.out.println("Repalce John 16  with Joe 16");
        int replacedCountx = replace(queue, new Nephew("John", 16, true), new Nephew("Joe", 16, true));
        System.out.println("Replaced count in queue: " + replacedCountx);
        printQueue(queue);
        // empty queue
        System.out.println("Repalce Bob 16  with Bill 16");
        int replacedCounte = replace(queue, new Nephew("John", 16, true), new Nephew("Joe", 16, true));
        System.out.println("Replaced count in queue: " + replacedCounte);
        printQueue(queueE);
*/
        // Example of swapping stack and queue
        System.out.println("\n---Testing swapping---");
        System.out.print("Stack: ");
        printStack(swp);
        printQueue(queue);
        swap(swp, queue);
        System.out.print("After swapping, \n\nStack: ");
        printStack(swp);
        printQueue(queue);
/*
        // Example of splitting the queue
        System.out.println("\n---Testing splitting---");
        Queue<Children>[] splitQueues = split(queue);
        System.out.println("Children Queue: " + splitQueues[0]);
        System.out.println("GrandChildren Queue: " + splitQueues[1]);
        System.out.println("Nephew Queue: " + splitQueues[2]);
*/
    }

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
            //Check if the length exceeds 8 digits
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

        // Restore the original queue
        while (!ChildrenQueue.isEmpty()) {
            q.offer(ChildrenQueue.poll());
        }

        return new Queue[]{ChildrenQueue,grandChildrenQueue, nephewQueue};
    }

    public static void printQueue(Queue<Children> queue) {
        System.out.println(); // New line after printing the queue
        // Create a temporary queue to hold the elements
        Queue<Children> tempQueue = new LinkedList<>();

        // Print the elements and add them to the temporary queue
        System.out.print("Queue: ");
        while (!queue.isEmpty()) {
            Children child = queue.poll(); // Remove the head of the queue
            System.out.printf("%s  %d, ",child.getName(),child.getAge()); // Print the child
            tempQueue.offer(child); // Add to the temporary queue
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }

        System.out.println(); // New line after printing the queue
        System.out.println(); // New line after printing the queue
    }

    public static void printStack(Stack<Children>s){
        for (Children child : s) {
            System.out.printf("%s  %d, ",child.getName(),child.getAge());
        }
    }

}