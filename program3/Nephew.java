package Program3;

/**
 * Represents a nephew with a name, age, and gender.
 * This class extends the Children class and adds an additional attribute for gender.
 * Author: Jorge Gomez
 * Date: 02/09/25
 */

public class Nephew extends Children {
    private boolean male;

    /**
     * Constructs a Nephew object with the specified name, age, and gender.
     * @param name the name of the nephew
     * @param age the age of the nephew
     * @param male true if the nephew is male, false otherwise
     */
    public Nephew(String name, int age, boolean male) {
        super(name, age); // Call the constructor of the Children class
        this.male = male; // Initialize the final field
    }

    /**
     * Returns a string representation of the Nephew object.
     * @return a formatted string containing the name, age, and gender of the nephew
     */
    @Override
    public String toString() {
        return String.format("Name:  %-8s Age: %-2d  Male:  %-5b",this.getName(),this.getAge(),male);
    }

    /**
     * Checks if this Nephew object is equal to another object.
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
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