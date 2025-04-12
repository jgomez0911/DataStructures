
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
    // Copy constructor
    public Children(Children other) {
        this.name = other.name;
        this.age = other.age;
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
        if (this == obj) return true; // Check if they are the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and type
        Children children = (Children) obj; // Cast to Children
        return age == children.age && name.equals(children.name); // Compare relevant fields
    }

    @Override
    public int hashCode() {
        int result = 17; // Start with a non-zero constant
        result = 31 * result + (name != null ? name.hashCode() : 0); // Include the name field
        result = 31 * result + age; // Include the age field
        return result;
    }

    // override array to string print out
    @Override
    public String toString(){
        return String.format("%-8s%-2d", name, age);
    }
    @Override
    public int compareTo(Children o) {
        // First compare by name
        int nameComparison = this.name.compareToIgnoreCase(o.name);
        if (nameComparison != 0) {
            return nameComparison; // If names are different, return the comparison result
        }
        // If names are the same, compare by age
        return Integer.compare(this.age, o.age);
    }
}