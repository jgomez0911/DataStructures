package program2;

/**
 * Represents a sorted set of Children objects.
 * This class allows for insertion, removal, and retrieval of Children objects,
 * while maintaining a sorted order based on the age and name of the children.
 * Author: Jorge Gomez
 * Date: 02/09/25
 */

public class ChildrenSortedArraySet {

    private Children[] childrenAry;
    private Integer max;

    /**
     * Constructs a ChildrenSortedArraySet with the specified maximum size.
     * @param max the maximum number of Children objects that can be stored in the set
     */
    public ChildrenSortedArraySet(Integer max) {
        this.max = max;
        this.childrenAry = new Children[max];
    }

    /**
     * Inserts a Children object into the set.
     * If the object is null or a duplicate, it will not be inserted.
     * @param child the Children object to insert
     * @throws NullPointerException if the child is null
     */
    public void insert(Children child) {
        if (child == null) {
            throw new NullPointerException("Cannot insert null into the set");
        }
        if (indexOf(child) != -1) {
            return; // Duplicate found, do not insert
        }

        // Find the correct position to insert the new child
        int i = 0;
        while (i < max && childrenAry[i] != null && childrenAry[i].compareTo(child) < 0) {
            i++;
        }

        // Shift elements to the right to make space for the new child
        for (int j = max - 1; j > i; j--) {
            childrenAry[j] = childrenAry[j - 1];
        }
        // Insert the new child
        if (i < max) {
            childrenAry[i] = child;
        }
    }

    /**
     * Returns the number of Children objects currently in the set.
     * @return the number of items in the collection
     */
    public int size() {
        int count = 0;
        for (Children child : childrenAry) {
            if (child != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a string representation of the collection of Children objects.
     * @return a string representation of the ChildrenSortedArraySet
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[\n");
        for (Children child : childrenAry) {
            if (child != null) {
                result.append("  ").append(child.toString()).append("\n"); // Concatenate each non-null item
            }
        }
        result.append("]"); // Close the array representation
        return result.toString();
    }

    /**
     * Returns the index of the specified Children object, or -1 if not found.
     * @param child the Children object to find
     * @return the index of the child, or -1 if not found
     */
    public int indexOf(Children child) {
        for (int i = 0; i < max; i++) {
            if (childrenAry[i] != null && childrenAry[i].equals(child)) {
                return i;
            }
        }
        return -1; // Not found
    }

    /**
     * Removes the specified Children object from the set.
     * @param child the Children object to remove
     * @return true if the child was successfully removed, false if not found
     */
    public Boolean remove(Children child) {
        int index = indexOf(child);
        if (index == -1) {
            return false; // Child not found
        }
        // Shift elements to the left to fill the gap
        for (int i = index; i < max - 1; i++) {
            childrenAry[i] = childrenAry[i + 1];
        }
        childrenAry[max - 1] = null; // Clear the last element
        return true;
    }

    /**
     * Returns the Children object at the specified index, or null if out of bounds.
     * @param index the index of the Children object to retrieve
     * @return the Children object at the specified index, or null if out of bounds
     */
    public Children grab(int index) {
        if (index < 0 || index >= max) {
            return null; // Index out of bounds
        }
        return childrenAry[index];
    }

    /**
     * Returns a new ChildrenSortedArraySet containing only specific subitem types.
     * @param type the type of children to include (1 for Children, 2 for GrandChildren, 3 for Nephew)
     * @return a new ChildrenSortedArraySet containing the specified types, or null if the type is invalid
     */
    public ChildrenSortedArraySet categorySet(int type) {
        if (type < 1 || type > 3) {
            return null; // Invalid type
        }

        ChildrenSortedArraySet resultSet = new ChildrenSortedArraySet(max);
        for (Children child : childrenAry) {
            if (child != null) {
                if (type == 1 && child instanceof Children) {
                    resultSet.insert(child); // Insert only Children
                } else if (type == 2 && child instanceof GrandChildren) {
                    resultSet.insert(child); // Insert only GrandChildren
                } else if (type == 3 && child instanceof Nephew) {
                    resultSet.insert(child); // Insert only Nephew
                }
            }
        }
        return resultSet;
    }
}