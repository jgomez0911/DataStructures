package program3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ChildrenTypesListsDriver {
    public static void main(String[] args) {
        // Create an instance of ChildrenTypesLists
        ChildrenTypesLists childrenTypesLists = new ChildrenTypesLists();

        // Read data from the input file
        String fileName = "./program3/info.tx"; // Change this to your input file path
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                int type = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);

                if (type == 1) { // GrandChildren
                    int extraValue = Integer.parseInt(parts[3]); // Assuming this is an integer
                    GrandChildren grandChild = new GrandChildren(name, age, extraValue);
                    childrenTypesLists.add(grandChild);
                } else if (type == 2) { // Nephew
                    boolean isFavorite = Boolean.parseBoolean(parts[3]); // Assuming this is a boolean
                    Nephew nephew = new Nephew(name, age, isFavorite);
                    childrenTypesLists.add(nephew);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        } catch (ClassCastException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test the methods in ChildrenTypesLists
        System.out.println("GrandChildren List:");
        childrenTypesLists.display(childrenTypesLists.getList('a')); // Display GrandChildren list

        System.out.println("Nephew List:");
        childrenTypesLists.display(childrenTypesLists.getList('b')); // Display Nephew list

        // Test size method
        System.out.println("Size of GrandChildren List: " + childrenTypesLists.sizeOf(childrenTypesLists.getList('a')));
        System.out.println("Size of Nephew List: " + childrenTypesLists.sizeOf(childrenTypesLists.getList('b')));

        // Test indexOf method
        GrandChildren testGrandChild = new GrandChildren("John Doe", 10, 5);
        System.out.println("Index of John Doe in GrandChildren List: " + childrenTypesLists.indexOf(testGrandChild));

        Nephew testNephew = new Nephew("Jane Smith", 12, true);
        System.out.println("Index of Jane Smith in Nephew List: " + childrenTypesLists.indexOf(testNephew));

        // Test remove method
        System.out.println("Removing John Doe from GrandChildren List: " + childrenTypesLists.remove(testGrandChild));
        System.out.println("GrandChildren List after removal:");
        childrenTypesLists.display(childrenTypesLists.getList('a'));
    }
}