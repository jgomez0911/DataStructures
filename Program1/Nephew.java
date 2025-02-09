package Program1;

public class Nephew extends Children {
    private boolean male;

    public Nephew(String name, int age, boolean male) {
        super(name, age); // Call the constructor of the Children class
        this.male = male; // Initialize the final field
    }

    @Override
    public String toString() {
        return String.format("Name:  %-8s Age: %-2d  Male:  %-5b",this.getName(),this.getAge(),male);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Check base class equality
        if (!(obj instanceof Nephew)) return false;
        Nephew other = (Nephew) obj;
        return this.male == other.male; // Compare male field
    }

    @Override
    public int hashCode() {
        int result = super.hashCode(); // Get the hash code from the parent class
        result = 31 * result + (male ? 1 : 0); // Include the male field
        return result;
    }
}