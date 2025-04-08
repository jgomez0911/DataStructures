import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jorge Gomez
 * @date 02/22/25
 * A driver class to test the functionality of the ChildrenOrderedList class.
 * This class demonstrates adding, removing, and retrieving Children objects
 * from an ordered linked list.
 */
public class ChildrenOrderedListDriver {
    public static void main(String[] args) {
        // Create an instance of ChildrenOrderedList
        ChildrenOrderedList childrenList = new ChildrenOrderedList();

        // Read from the file and populate the list
        try (Scanner scanner = new Scanner(new File("info.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                int type = Integer.parseInt(parts[0]); // 1 for GrandChildren, 2 for Nephew
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);

                if (type == 1) {
                    // Assuming the last part is generation for GrandChildren
                    int generation = Integer.parseInt(parts[3]);
                    GrandChildren grandChild = new GrandChildren(name, age, generation);
                    childrenList.add(grandChild);
                } else if (type == 2) {
                    // Assuming the last part is gender for Nephew
                    boolean male = Boolean.parseBoolean(parts[3]);
                    Nephew nephew = new Nephew(name, age, male);
                    childrenList.add(nephew);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // testing display
        System.out.println("\nChildren Ordered List:");
        childrenList.display();
        System.out.println("\nSize of the list: " + childrenList.size());

        // Test removing
        Children target = new GrandChildren("Jorge", 29, 2); // Example target
        boolean removed = childrenList.remove(target);
        System.out.println("\nRemoved Jorge: " + removed);
        System.out.println("\nChildren Ordered List after removal:");
        childrenList.display();

        // Test adding
        System.out.println("adding back Jorge");
        childrenList.add(target);
        Children newChild = new GrandChildren("NewChild", 5, 1);
        boolean addedAtIndex = childrenList.add(2, newChild);
        System.out.println("\nAdded NewChild at index 2: " + addedAtIndex);
        System.out.println("\nChildren Ordered List after adding NewChild:");
        childrenList.display();

        // test indexOf
        System.out.println("\nindex of Jorge: " + childrenList.indexOf(target));
        System.out.println("index of newChild: " + childrenList.indexOf(newChild));
    }
}