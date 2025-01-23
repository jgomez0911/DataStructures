package Program1;
import java.util.*;
import java.io.*;

public class ChildrenArrayDriver {

    // Returns the average (arithmetic mean) of the Integer attributes of all items in input array a.
    public static  int overallAvg( <Item>[] a ){
        null;
    }

    /*Returns the number of <Item>s in the input array a that are equal to the input <Item> o.
    Remember, two <Item>s are equal if they have the same value for both instance variables,
    where String variables are equal if they differ only in case. */
    public static int count( <Item>[] a, <Item> o ){
        null;
    }

    /*Returns the average of the Integer attributes of <Item>s with String attribute equal to
    the input string. For example, groupAvg(itemArr,"abc") returns the average of the
    Integer attributes for all objects with String attribute equal to abc. */
    public static int groupAvg(<Item>[] a, String s){
        null;
    }

    /*Returns an array of <Item> objects that contains all objects with Integer attribute less than the
    input Integer. For example, lessThan(itemArr, 50) returns an array of items with
    Integer attribute < 50. */
    public static <Item>[] lessThan( <Item>[] a, Integer i ){
        null;
    }

    /*For each item in the input array with String attribute equal to the input string, the method
    edits the <Item>’s Integer attribute by adding n to the Integer value. Thus,
    groupEdit(itemArr,"abc",10) adds 10 to the Integer values of each <Item> in
    itemArr with String value abc.*/
    public static void groupEdit( <Item>[] a, String s, Integer n ){
        null;
    }

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
            String[] part = line.split(" ");
            String name = part[0];
            int age = Integer.parseInt(part[1]);
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