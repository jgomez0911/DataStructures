import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ChildrenStackQueueDriver {


    public static void main(String[] args) {

    }

    public static int stackToint(Stack<Children> s){
       /*
Assume that the input stack contains at least one Item. The method returns an int (not string) representation
of the instance variables of the Items stored on the stack where the most significant digit is at the top of the
stack. When the method has finished, the input stack must remain unchanged.
For instance, the Item is Pet, and if the Stack (top to bottom) is as given below, the output should be “1381215”.
This is a single integer.

Top of stack                  Bottom of stack
Fido, 13	Spot, 8	Rover, 12	Max, 15

Required Test Cases:
1.	Stack with at least four Items.
2.	Stack with one Item.
3.	Stack with multiple Items, where at least one Item has Integer value 0.

Note:  To avoid overflow on a standard Java int, please make sure that the total number of digits in the output is 8 or fewer.

*/
    int result = 0;
    Stack<Children> tempStack = new Stack<>();

    while (!s.isEmpty()) {
        Children child = s.pop();
        tempStack.push(child);
        result = result * 10 + child.getAge();
    }

    // Restore the original stack
    while (!tempStack.isEmpty()) {
        s.push(tempStack.pop());
    }

    return result;
    }

public static int popSome(Stack<Children> s, int count) {
   /*
The method pops count items from the stack. The method returns the sum of the integer attributes of the popped items.
If the stack has less than count values, pop the entire stack, and the method returns -1. The input stack is changed
because some items are popped.

Required Test Cases:
1.	Stack has count items.
2.	Stack has multiple items and count < number of items.
3.	Stack has multiple items and count > number of items.
4.	Empty stack and count > 1.
5.	Non-empty stack and count = 0.
6.	Non-empty stack and count is negative

*/
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
/*
The method removes all occurrences of the input item from the stack and returns the number of extracted items.
All other items in the stack must remain unchanged and in the same order.  Use the equals method of Item.

Required Test Cases:
1.	Non-empty stack with one item matching the input item.
2.	Non-empty stack with several items matching the input item.
3.	Non-empty stack with no items matching the input item.
4.	Empty stack.

*/

public static boolean equalStacks(Stack<Children> s1, Stack<Children> s2) {
    /*
Returns true or false based on whether the two input stacks are equal. Assume that two stacks are equal
if they have the same Items in the same order. The two input stacks must be unchanged after the call to
this method returns. Use the equals method of Item.

Required Test Cases:
1.	Non-empty stacks and equal.
2.	Non-empty stacks and not equal.
3.	One of the input stacks is empty (returns false).
4.	Both input stacks are empty (returns true).
*/
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
   /*
Updates the input queue by replacing each occurrence of oldVal with newVal. All other values in the input
queue must remain the same and in the same order. Use the equals method of Item.  Return the number of replaced Items.

Required Test Cases:
1.	Queue has multiple entries, including one oldVal.
2.	Queue has multiple entries, including multiple oldVal.
3.	oldVal is first in the queue.
4.	oldVal is last in the queue.
5.	Queue has multiple entries, not including oldVal.
6.	Queue is empty

 */
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
   /*
Swaps the contents of the stack and the queue such that the top element in the stack becomes the front element in the
queue and the front element in the queue becomes the bottom element in the stack.

For example, assume the inputs to the swap method are the following stack s and queue q:
Top of stack              Bottom of stack       Front of queue             Rear of queue
Red, 1	Blue, 2	Green, 3	White, 4	    	Green, 5	Blue, 6	Red, 7	Black, 8

After calling swap, the stack and queue become:
Top of stack               Bottom of stack      Front of queu           Rear of queue
Black, 8	Red, 7	Blue, 6	Green, 5	      	Red, 1	Blue, 2	Green, 3	White, 4

Required Test Cases:
1.	Non-empty stack and queue, both the same length.
2.	Non-empty stack and queue not of the same length.
3.	Empty stack and non-empty queue.
4.	Empty queue and non-empty stack.
5.	Empty queue and empty stack.
 */
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
   /*
A static method that takes one parameter, QueueChildren, that includes a mix of items of types GrandChildren and Nephew.
The method returns an array of two QueueChildren as output where the first queue includes all items of type GrandChildren
and the second queue includes all items of type Nephew.  After the method, the input queue should include only the items
that are not of type GrandChildren nor of type Nephew.

Required Test Cases:
1.	Input queue has a mix of Item, GrandChildren and Nephew items.
2.	Input queue has only GrandChildren items.
3.	Input queue has only Nephew items.
4.	Input queue has only Children items.
5.	Input queue is empty.

 */
    Queue<Children> grandChildrenQueue = new LinkedList<>();
    Queue<Children> nephewQueue = new LinkedList<>();
    Queue<Children> ChildrenQueue = new LinkedList<>();

    while (!q.isEmpty()) {
        Children child = q.poll();
        // Assuming GrandChildren and Nephew are subclasses of Children
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

    return new Queue[]{grandChildrenQueue, nephewQueue};
    }

}
