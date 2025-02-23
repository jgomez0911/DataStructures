package program3;

/**
 * Represents a grandchild with a name, age, and generation.
 * This class extends the Children class and adds an additional attribute for generation.
 * Author: Jorge Gomez
 * Date: 02/09/25
 */

public class GrandChildren extends Children {
    private int generation;

    /**
     * Constructs a GrandChildren object with the specified name, age, and generation.
     * @param name      the name of the grandchild
     * @param age       the age of the grandchild
     * @param generation the generation number of the grandchild
     */
    public GrandChildren(String name, int age, int generation) {
        super(name, age); // Call the constructor of the Children class
        this.generation = generation; // Initialize the final field
    }

    /**
     * Returns a string representation of the GrandChildren object.
     * @return a formatted string containing the name, age, and generation of the grandchild
     */
    @Override
    public String toString() {
        return String.format("%-10s%-4d%-5d",this.getName(),this.getAge(),generation);
    }

    /**
     * Checks if this GrandChildren object is equal to another object.
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
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