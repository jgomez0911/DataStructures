import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author Jorge Gomez
 * @date 02/22/25
 * A driver class to test the functionality of the ChildrenTypesLists class.
 * This class reads data from a file and demonstrates adding, removing,
 * and retrieving GrandChildren and Nephew objects from the appropriate lists.
 */
public class ChildrenTypesListsDriver {
    public static void main(String[] args) {
        // Create an instance of ChildrenTypesLists
        ChildrenTypesLists childrenTypesLists = new ChildrenTypesLists();

        // Read data from the input file
        try {
            Scanner sc = new Scanner(System.in);
            String file = "info.txt";
            File f = new File(file);
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] part = line.split("\\s+");

                int type = Integer.parseInt(part[0]);
                String name = part[1];
                int age = Integer.parseInt(part[2]);
                int generation = 0; // Default value for GrandChildren
                boolean male = false; // Default value for Nephew

                if (type == 1) { // GrandChildren
                    generation = Integer.parseInt(part[3]); // Assuming this is an integer
                    GrandChildren grandChild = new GrandChildren(name, age, generation);
                    childrenTypesLists.add(grandChild);
                } else if (type == 2) { // Nephew
                    male = Boolean.parseBoolean(part[3]); // Assuming this is a boolean
                    Nephew nephew = new Nephew(name, age, male);
                    childrenTypesLists.add(nephew);
                }
            }
            sc.close();
            read.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (ClassCastException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test display
        System.out.println("\nGrandChildren List:");
        childrenTypesLists.display(childrenTypesLists.getList('a')); // Display GrandChildren list
        System.out.println("Size of GrandChildren List: " + childrenTypesLists.sizeOf(childrenTypesLists.getList('a')));
        System.out.println("\nNephew List:");
        childrenTypesLists.display(childrenTypesLists.getList('b')); // Display Nephew list
        System.out.println("Size of Nephew List: " + childrenTypesLists.sizeOf(childrenTypesLists.getList('b')));

        // Test indexOf method
        GrandChildren testGrandChild = new GrandChildren("Daniel", 6, 1);
        System.out.println("\nIndex of Daniel in GrandChildren List: " + childrenTypesLists.indexOf(testGrandChild));
        Nephew testNephew = new Nephew("Ben", 1, true);
        System.out.println("Index of Ben in Nephew List: " + childrenTypesLists.indexOf(testNephew));

        // Test remove method
        System.out.println("\nRemoving Daniel from GrandChildren List: " + childrenTypesLists.remove(testGrandChild));
        System.out.println("Removing Ben from Nephew List: " + childrenTypesLists.remove(testNephew));
        System.out.println("\nChildren List after removal:");
        childrenTypesLists.display(childrenTypesLists.getList('a'));
        childrenTypesLists.display(childrenTypesLists.getList('b'));

        //test add
        System.out.println("\nadding back Daniel and Ben");
        childrenTypesLists.add(testGrandChild);
        childrenTypesLists.add(testNephew);
        System.out.println("\nChildren list after adding them back");
        childrenTypesLists.display(childrenTypesLists.getList('a'));
        childrenTypesLists.display(childrenTypesLists.getList('b'));

        //testing get
        System.out.println("\ngetting index of 5 from GrandChildren list: " + childrenTypesLists.get(childrenTypesLists.getList('a'), 5));
        System.out.println("getting index of 5 from Nephew list: " + childrenTypesLists.get(childrenTypesLists.getList('b'), 5));
    }
}