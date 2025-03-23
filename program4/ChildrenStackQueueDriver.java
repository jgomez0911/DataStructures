import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ChildrenStackQueueDriver {


    public static void main(String[] args) {
        Stack<Children> stack = new Stack<>();
        Queue<Children> queue = new LinkedList<>();

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

        Stack<Children> stackZ = stack;
        Stack<Children> stack1 = stack;
        Stack<Children> stack2 = stack;
        Stack<Children> stack3 = stack;
        Stack<Children> stack4 = stack;

         // Test cases for stackToint
        System.out.println("\n---Testing stackToint---");
        System.out.println("Stack to int: " + stackToint(stack)); // Test case 1: Stack with at least four items
        stackZ.push(stack.pop());
        System.out.printf("Stack to int with one object: %d\n", stackToint(stackZ));
        stackZ.push(stack.pop()); stackZ.push(stack.pop());
        Children test = new Children("TestChild", 0);
        stackZ.push(test); // Test case 3: Adding a child with age 0
        System.out.printf("Stack to int with age 0: %d\n", stackToint(stackZ)); // Test case 3

        // Test cases for popSome
        System.out.println("\n---Testing popSome---");
        System.out.println("Sum of popped ages (2 items): " + popSome(stack, 2));
        System.out.println("Sum of popped ages (4 items): " + popSome(stackZ, 4));
        System.out.println("Sum of popped ages (0 items): " + popSome(stackZ, 0));
        System.out.println("Sum of popped ages (0 items): " + popSome(stackZ, 1));
        System.out.println("Sum of popped ages (0 items): " + popSome(stackZ, -1));

        // Example of extracting from stack
        System.out.println("\n---Testing extractFromStack---");
        Children childToExtract = new Children("Vania", 31);
        int extractedCount = extractFromStack(stack1, childToExtract);
        System.out.println("Extracted count: " + extractedCount);

        // Example of checking equality of two stacks
        System.out.println("\n---Testing equality---");
        System.out.println("Stacks are equal: " + equalStacks(stack2, stack3));
        System.out.println("Stacks are equal: " + equalStacks(stack2, stackZ));

        // Example of replacing in queue
        System.out.println("\n---Testing replacing---");
        int replacedCount = replace(queue, new Nephew("Daniel", 6, true), new Nephew("Daniel", 6, false));
        System.out.println("Replaced count in queue: " + replacedCount);

        // Example of swapping stack and queue
        System.out.println("\n---Testing swapping---");
        swap(stack, queue);
        System.out.println("After swapping, stack: " + stack.toString());
        System.out.println("After swapping, queue: " + queue.toString());

        // Example of splitting the queue
        System.out.println("\n---Testing splitting---");
        Queue<Children>[] splitQueues = split(queue);
        System.out.println("GrandChildren Queue: " + splitQueues[1]);
        System.out.println("Nephew Queue: " + splitQueues[2]);
    }

    public static int stackToint(Stack<Children> s){

        StringBuilder stack = new StringBuilder();
        Stack<Children> tempStack = new Stack<>();

        while (!s.isEmpty()) {
            Children child = s.pop();
            tempStack.push(child);
            stack.append(child.getAge());
            if (stack.length()>=8) break;
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        return Integer.parseInt(stack.toString());
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

        if (s1.size() != s2.size()) return false;

        Stack<Children> temp1 = new Stack<>();
        Stack<Children> temp2 = new Stack<>();

        while (!s1.isEmpty() && !s2.isEmpty()) {
            Children child1 = s1.pop();
            Children child2 = s2.pop();
            if (!child1.equals(child2)) {
                // Restore the stacks
                temp1.push(child1);
                temp2.push(child2);
                while (!temp1.isEmpty()) s1.push(temp1.pop());
                while (!temp2.isEmpty()) s2.push(temp2.pop());
                return false;
            }
            temp1.push(child1);
            temp2.push(child2);
        }

        // Restore the stacks
        while (!temp1.isEmpty()) s1.push(temp1.pop());
        while (!temp2.isEmpty()) s2.push(temp2.pop());

        return true;
    }

    public static int replace(Queue<Children> q, Children oldVal, Children newVal) {

        int count = 0;
        int size = q.size();

        for (int i = 0; i < size; i++) {
            Children child = q.poll();
            if (child.equals(oldVal)) {
                q.offer(newVal);
                count++;
            } else {
                q.offer(child);
            }
        }

        return count;
    }

    public static void swap(Stack<Children> s, Queue<Children> q) {

        if (s.isEmpty() && q.isEmpty()) return;

        Stack<Children> tempStack = new Stack<>();
        Queue<Children> tempQueue = new LinkedList<>();

        // Swap top of stack with front of queue
        if (!s.isEmpty()) {
            tempQueue.offer(s.pop());
        }
        while (!q.isEmpty()) {
            tempStack.push(q.poll());
        }
        while (!tempStack.isEmpty()) {
            q.offer(tempStack.pop());
        }
        while (!s.isEmpty()) {
            tempStack.push(s.pop());
        }
        while (!tempQueue.isEmpty()) {
            s.push(tempQueue.poll());
        }
        while (!tempStack.isEmpty()) {
            q.offer(tempStack.pop());
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

}