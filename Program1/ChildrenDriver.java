package Program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChildrenDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the data file (e.g., info.txt): ");
        String filename = scanner.nextLine();

        ChildrenSortedArraySet childrenSet = new ChildrenSortedArraySet(100); // Assuming a max size of 100

        // Read the file and populate the ChildrenSortedArraySet
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Children child = parseLineToChildren(line);
                if (child != null) {
                    childrenSet.insert(child);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Print the list
        //System.out.println("Contents of the ChildrenSortedArraySet:");
        //System.out.println(childrenSet.toString());

        // Test indexOf method
        //testIndexOf(childrenSet);

        // Test remove method
        //testRemove(childrenSet);

        // Test grab method
        //testGrab(childrenSet);

        // Test categorySet method
        System.out.println(childrenSet.categorySet(1));
        childrenSet.categorySet(2);
        childrenSet.categorySet(3);

        scanner.close();
    }

    private static Children parseLineToChildren(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length < 3 || parts.length > 4) {
            return null; // Invalid format
        }

        int type;
        try {
            type = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return null; // Invalid type
        }
        String name = parts[1];
        int age;
        try {
            age = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return null; // Invalid age
        }
        switch (type) {
            case 1:
                return new Children(name, age); // Assuming Children has a constructor with name and age
            case 2:
                int generation;
                try {
                    generation = Integer.parseInt(parts[3]); // Assuming generation is the fourth parameter
                } catch (NumberFormatException e) {
                    return null; // Invalid generation
                }
                return new GrandChildren(name, age, generation); // Assuming GrandChildren has a constructor with name, age, and generation
            case 3:
                boolean male = parts.length == 4 && Boolean.parseBoolean(parts[3]);
                return new Nephew(name, age, male); // Assuming Nephew has a constructor with name, age, and male
            default:
                return null; // Invalid type
        }
    }
/*
    private static void testIndexOf(ChildrenSortedArraySet childrenSet) {
        System.out.println("\nTesting indexOf method:");
        System.out.println("Index of Children (Vania, 31) -> " + childrenSet.indexOf(new Children("Vania", 31))); // Should return the index
        System.out.println("Index of GrandChildren (Daniel, 6, 1) -> " + childrenSet.indexOf(new GrandChildren("Daniel", 6, 1))); // Should return the index
        System.out.println("Index of Nephew (Martin, 28, true) -> " + childrenSet.indexOf(new Nephew("Martin", 28, true))); // Should return the index
        System.out.println("Index of Nephew (Nonexistent, 99, false) -> " + childrenSet.indexOf(new Nephew("Nonexistent", 99, false))); // Should return -1
    }

    private static void testRemove(ChildrenSortedArraySet childrenSet) {
        System.out.println("\nTesting remove method:");
        System.out.println("Removing Children (Vania, 31) -> " + childrenSet.remove(new Children("Vania", 31))); // Should return true
        System.out.println("Removing GrandChildren (Daniel, 6, 1) -> " + childrenSet.remove(new GrandChildren("Daniel", 6, 1))); // Should return true
        System.out.println("Removing Nephew (Martin, 28, true) -> " + childrenSet.remove(new Nephew("Martin", 28, true))); // Should return true
        System.out.println("Removing Nephew (Nonexistent, 99, false) -> " + childrenSet.remove(new Nephew("Nonexistent", 99, false))); // Should return false
        System.out.println("Contents after removal:");
        System.out.println(childrenSet.toString());
    }

    private static void testGrab(ChildrenSortedArraySet childrenSet) {
        System.out.println("\nTesting grab method:");
        System.out.println("Grab index 0 -> " + childrenSet.grab(0)); // Should return the first element in the set
        System.out.println("Grab index 1 -> " + childrenSet.grab(1)); // Should return the second element
        System.out.println("Grab index 10 -> " + childrenSet.grab(10)); // Should handle out of bounds gracefully
    }

    private static void testCategorySet(ChildrenSortedArraySet childrenSet) {
        System.out.println("\nTesting categorySet method:");
        ChildrenSortedArraySet childrenCategorySet = childrenSet.categorySet(1);
        System.out.println("Category set for type 1 (Children): " + childrenCategorySet.toString()); // Should return all Children
        ChildrenSortedArraySet grandChildrenCategorySet = childrenSet.categorySet(2);
        System.out.println("Category set for type 2 (GrandChildren): " + grandChildrenCategorySet.toString()); // Should return all GrandChildren
        ChildrenSortedArraySet nephewCategorySet = childrenSet.categorySet(3);
        System.out.println("Category set for type 3 (Nephew): " + nephewCategorySet.toString()); // Should return all Nephews
    }
    */
}