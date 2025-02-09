package Program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChildrenDriver {

    public static void main(String[] args) {

        ChildrenSortedArraySet childrenSet = new ChildrenSortedArraySet(25); // Assuming a max size of 100

        // Read the file and populate the ChildrenSortedArraySet
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the data file (e.g., info.txt): ");
            //String file = sc.nextLine();
            File f = new File("info.txt");
            System.err.println();
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] part = line.split("\\s+");

                int type = Integer.parseInt(part[0]);
                String name = part[1];
                int age = Integer.parseInt(part[2]);
                int generation = 0; // Default value for GrandChildren
                boolean male = false; // Default value for Nephew

                // Determine the type and create the appropriate object
                switch (type) {
                    case 1 -> {
                        // Children
                        Children child = new Children(name, age);
                        childrenSet.insert(child); // Use insert method
                    }
                    case 2 -> {
                        // GrandChildren
                        generation = Integer.parseInt(part[3]);
                        GrandChildren gChild = new GrandChildren(name, age, generation);
                        childrenSet.insert(gChild); // Use insert method
                    }
                    case 3 -> {
                        // Nephew
                        male = Boolean.parseBoolean(part[3]);
                        Nephew neph = new Nephew(name, age, male);
                        childrenSet.insert(neph); // Use insert method
                    }
                    default -> System.err.println("Unknown type: " + type);
                }
            }
            sc.close();
            read.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Testing

        for(int i=0;i<childrenSet.size();i++){
            System.out.println(childrenSet.grab(i));
        }

        // Grab
        System.out.println(childrenSet.grab(0)); // ben age 1 male ture
        System.out.println(childrenSet.grab(1)); // oliva age 2 generation 2

        // CategorySet
        System.out.println("GrandChildren: " + childrenSet.categorySet(2));
        System.out.println("Nephews: " + childrenSet.categorySet(3));

        //indexOf
        System.out.println(childrenSet.indexOf(childrenSet.grab(5)));
        System.out.println(childrenSet.indexOf(childrenSet.grab(12)));

        // Remove
        System.out.println(childrenSet.remove(childrenSet.grab(5))); // true
        System.out.println(childrenSet.remove(childrenSet.grab(12)));// true

    }
}