package Program1;

/*
 * @author Jorge Gomez
 * @date 01/26/25
 * this is the Children class with string name and integer age attributies
 */

 public class Children implements Comparable<Children> {
    // private fields
    private String name;
    private int age;
    // constructor
    public Children(){
        this.name = "";
        this.age = 0;
    }
    //constructor with parameters
    public Children(String name, int age){
        this.name = name;
        this.age = age;
    }
    // getters
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
    // setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    // boolean
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Children)) return false;
        Children other = (Children) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }
    // override array to string print out
    @Override
    public String toString(){
        return "Name: " + this.getName() + ", Age: " + this.getAge();
    }
    @Override
    public int compareTo(Children o) {
        if (this.age != o.age){
            return Integer.compare(this.age, o.age);
        }
        return this.name.compareToIgnoreCase(o.name);
    }
}