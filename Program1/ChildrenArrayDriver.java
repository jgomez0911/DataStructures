package program1;
import java.io.*;
import java.util.*;

/*
 * @author Jorge Gomez
 * @date 01/26/25
 * this is the ChildrenArrayDriver class where there is 5 methods that
 * test the Children class attributes in the main method.
 */

public class ChildrenArrayDriver {

/*
 * method loops through the array and
 * @returns the avagerage age of the full Children array as an integer
 * @param children array of Children object,
 */
    public static int overallAvg(Children[] a){
        int sum = 0;
        int count = 0;
        for (Children child : a){
            sum += child.getAge();
            count++;
        }
        return sum/count;
    }

/*
 * method loops through the array and determines if the object values
 * match the array values and counts how many match
 * @param children array of Children object and other children object
 * @returns the count of how many Children objects equal the same value
 * of the Children array
 */
    public static int count( Children[] a, Children o ){
        int count = 0;
        for (Children child : a){
            if (child.getAge() == o.getAge() && child.getName().equalsIgnoreCase(o.getName())){
                count++;
            }
        }
        return count;
    }

/*
 * method seaches for a string in the Children object array and gets the average age withing the search
 * @param children array of Children object and the string to search for
 * @Returns the average of the Integer attributes of Childrens with String attribute equal to
 * the input string.
*/
    public static int groupAvg(Children[] a, String s){
        int sum =0;
        int count = 0;
        for (Children child: a){
            if (child.getName().equalsIgnoreCase(s)){
                sum += child.getAge();
                count++;
            }
        }
        return sum / count;
    }

/*
 * method searches the Children array for all interger values less then integer given and returns new array
 * @param children array of Children object and integer value
 * @Returns an array of Children objects.
 */
    public static Children[] lessThan(Children[] c, Integer A ){
        Children[] newArr = new Children[20];

        for (int i=0; i<c.length;i++){
            if (c[i].getAge() < A){
                newArr[i] = c[i];
                System.out.println(c[i].toString());
            }
        }
        return newArr;
    }
/*
 * method seaches Children array with given string, and addes given integer to the age of the Children array
 * @param children array of Children object, string to search for, and integer to add to age
 */
    public static void groupEdit(Children[] a, String s, Integer n ){

        for (Children child: a){
            if (child.getName().equalsIgnoreCase(s)){
                child.setAge(child.getAge() + n);
                System.out.println(child.toString());
            }
        }
    }

/*
 * in this main method an array from the Children class object gets iniates with the size of 20,
 * there is a scanner class user input and to read a file with the File class.
 * it loops through the text file to retreive the name and age informatino to creat the Children class, then prints both attributes.
 * it then calls each method from the ChildrenArrayDriver class to test the methods.
 */
    public static void main(String[] args) throws FileNotFoundException {

        Children[] childrenArr = new Children[20];

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter file name: ");
        String file = sc.next();

        File f = new File(file);
        Scanner read = new Scanner(f);

        int i = 0;
        while(read.hasNext()){
            String name = read.next();
            int age = read.nextInt();
            childrenArr[i] = new Children(name,age);
            i++;
        }

        for (Children child : childrenArr){
            System.out.println(child.getName() + " " + child.getAge());
        }

        System.out.println(overallAvg(childrenArr)); // return 18
        System.out.println(groupAvg(childrenArr, "olivia")); // returns 2
        lessThan(childrenArr, 25); // returns every children under 25
        groupEdit(childrenArr,"jorge",1 ); // returns jorge 30

        sc.close();
        read.close();
    }
}