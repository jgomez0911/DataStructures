package program3;

public class ChildrenOrderedListDriver {
    public static void main(String[] args) {
        // Create an instance of ChildrenOrderedList
        ChildrenOrderedList list = new ChildrenOrderedList();

        // Create some Children objects (assuming a constructor exists)
        Children child1 = new Children("Alice", 10);
        Children child2 = new Children("Bob", 12);
        Children child3 = new Children("Charlie", 8);
        Children child4 = new Children("Diana", 11);

        // Test add method
        System.out.println("Adding children to the list:");
        list.add(child1);
        list.add(child2);
        list.add(child3);
        list.add(child4);
        list.display(); // Display the list

        // Test size method
        System.out.println("Size of the list: " + list.size());

        // Test add at specific index
        System.out.println("Adding a child at index 2:");
        list.add(2, new Children("Eve", 9));
        list.display(); // Display the list

        // Test remove by item
        System.out.println("Removing child Bob:");
        list.remove(child2);
        list.display(); // Display the list

        // Test remove by index
        System.out.println("Removing child at index 1:");
        list.remove(1);
        list.display(); // Display the list

        // Test indexOf method
        System.out.println("Index of Charlie: " + list.indexOf(child3));
        System.out.println("Index of Bob: " + list.indexOf(child2)); // Should return -1

        // Test get method
        System.out.println("Child at index 2: " + list.get(2).getName()); // Assuming getName() method exists

        // Test size after removals
        System.out.println("Size of the list after removals: " + list.size());

        // Final display of the list
        System.out.println("Final list contents:");
        list.display();
    }
}