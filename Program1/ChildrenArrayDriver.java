package Program1;
import java.util.*;
import java.io.*;

public class ChildrenArrayDriver {

    public static void main(String[] args) throws FileNotFoundException {

        Children[] childrenArr = new Children[20];

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter file name: ");
        String file = sc.next();

        File f = new File("program1/"+ file);
        Scanner read = new Scanner(f);

        int i = 0;
        while(read.hasNextLine()){
            String line = read.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            childrenArr[i] = new Children(name,age);
            i++;
        }

        for (Children child : childrenArr){
            System.out.println(child.getName() + " " + child.getAge());
        }

        sc.close();
        read.close();
    }
}