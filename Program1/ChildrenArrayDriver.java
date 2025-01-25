package Program1;
import java.io.*;
import java.util.*;

public class ChildrenArrayDriver {

    public static int overallAvg(Children[] a){
        int sum = 0;
        int count = 0;
        for (Children child : a){
            sum += child.getAge();
            count++;
        }
        return sum/count;
    }

    public static int count( Children[] a, Children o ){
        int count = 0;
        for (Children child : a){
            if (child.getAge() == o.getAge() && child.getName().equalsIgnoreCase(o.getName())){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
/*
    Returns the average of the Integer attributes of <Item>s with String attribute equal to
    the input string. For example, groupAvg(itemArr,"abc") returns the average of the
    Integer attributes for all objects with String attribute equal to abc.
    public static int groupAvg(<ChildrenArrayDriver>[] a, String s){
        null;
    }

    Returns an array of <Item> objects that contains all objects with Integer attribute less than the
    input Integer. For example, lessThan(itemArr, 50) returns an array of items with
    Integer attribute < 50.
    public static <ChildrenArrayDriver>[] lessThan( <ChildrenArrayDriver>[] a, Integer i ){
        null;
    }

    For each item in the input array with String attribute equal to the input string, the method
    edits the <Item>’s Integer attribute by adding n to the Integer value. Thus,
    groupEdit(itemArr,"abc",10) adds 10 to the Integer values of each <Item> in
    itemArr with String value abc.
    public static void groupEdit( <ChildrenArrayDriver>[] a, String s, Integer n ){
        null;
    }
*/
    public static void main(String[] args) throws FileNotFoundException {

        Children[] childrenArr = new Children[20];

        Scanner sc = new Scanner(System.in);

        //System.out.print("Please enter file name: ");
        //String file = sc.next();

        File f = new File("./info.txt");
        Scanner read = new Scanner(f);

        int i = 0;
        while(read.hasNext()){
            String name = read.next();
            int age = read.nextInt();
            childrenArr[i] = new Children(name,age);
            i++;
        }
        /*
        for (Children child : childrenArr){
            System.out.println(child.getName() + " " + child.getAge());
        }
            */
        System.err.println(overallAvg(childrenArr));

        sc.close();
        read.close();
    }
}