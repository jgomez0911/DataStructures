package Program1;

public class ChildrenSortedArraySet {

    private Children[] childrenAry;
    private Integer max;

    public ChildrenSortedArraySet(Integer max) {
        this.max = max;
        this.childrenAry = new Children[max];
    }

    // Inserts an object of type Children in the set
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

    // Returns the number of items in the collection
    public int size() {
        int count = 0;
        for (Children child : childrenAry) {
            if (child != null) {
                count++;
            }
        }
        return count;
    }

    // Returns a string representation of the collection
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

    // Returns the index of the input Children or -1 if not found
    public int indexOf(Children child) {
        for (int i = 0; i < max; i++) {
            if (childrenAry[i] != null && childrenAry[i].equals(child)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Removes the specified Children from the set
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

    // Returns the Children at the specified index or null if out of bounds
    public Children grab(int index) {
        if (index < 0 || index >= max) {
            return null; // Index out of bounds
        }
        return childrenAry[index];
    }

    // Returns a ChildrenSortedArraySet that contains only specific subitem types
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
                    resultSet.insert(child); // Insert only r Nephew
                }
            }
        }
        return resultSet;
    }
}