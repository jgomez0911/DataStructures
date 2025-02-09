package Program1;

public class GrandChildren extends Children {
    private int generation;

    public GrandChildren(String name, int age, int generation) {
        super(name, age); // Call the constructor of the Children class
        this.generation = generation; // Initialize the final field
    }

    @Override
    public String toString() {
        return String.format("Name:  %-8s Age: %-2d  Generation: %-5d",this.getName(),this.getAge(),generation);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Check base class equality
        if (!(obj instanceof GrandChildren)) return false;
        GrandChildren other = (GrandChildren) obj;
        return this.generation == other.generation; // Compare generation field
    }

    @Override
    public int hashCode() {
        int result = super.hashCode(); // Get the hash code from the parent class
        result = 31 * result + generation; // Include the generation field
        return result;
    }
}