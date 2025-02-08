package Program1;

public class ChildrenSortedArraySet {

    private Children[] childrenAry;
    private Integer max;

    public ChildrenSortedArraySet(Integer max){
        this.max = max;
        this.childrenAry = new Children[max];
    }

    /*Inserts an object of type <Item> in the set such that: 
    (1) the method must maintain the sorted order according to
    the compareTo method and (2) duplicates are not allowed which 
    means that the item is not inserted if the set already has another
    item that is equal to the input item where equality is determined 
    as described above. It is not the responsibility of the collection 
    class to decide on how to sort items or how to test the equality. 
    Sorting and equality depend merely on the semantics of your <Item> 
    class. Moreover, according to compareTo, the items will be sorted either 
    in ascending or descending order. 
    You are not allowed to use the java Arrays.sort method. */
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

    /*Returns the number of items in the collection. */
    public int size(){
        int count = 0;
        for (Children child : childrenAry) {
            if (child != null) {
                count++;
            }
        }
        return count;
    }

    /*Returns a string representation of the collection
    that includes all items. The output string must be nicely
    formatted in a tabular format. For example, a list of Circles
    is displayed as follows. Note the second row shows an <ItemA> 
    object while the third row shows an <ItemB> object */
    @Override
    public String toString() {
        String result = "[\n";
        for (int i = 0; i < max; i++) {
            if (childrenAry[i] != null) {
                result += "  " + childrenAry[i].toString() + "\n"; // Concatenate each non-null item
            }
        }
        result += "]"; // Close the array representation
        return result;
    }
    /*Returns an int that represents the array index at
    which the input <Item> is found or -1 if the <Item>
    is not found. The equality of items is determined by
    the equals method. */
    public int indexOf(Children child){
        for (int i = 0; i < max; i++) {
            if (childrenAry[i] != null && childrenAry[i].equals(child)) {
                return i;
            }
        }
        return -1; // Not found
    }

    /*Search the collection for an Item that equals the 
    input <Item> and, if found, remove this <Item> from 
    the set. Return true if the <Item> is removed and false 
    otherwise. This method must maintain the sorted order.  
    Shift the array elements down to fill the gap that is 
    created by the deleted <Item>. . Do not use the Java's 
    Arrays.sort(…) method. */
    public Boolean remove(Children child){
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

    /*Just replacing the deleted item with the last element 
    in the array will not work anymore because this may break 
    the sorted order Return the <Item> that is stored at position 
    index in the set or null if index is beyond the size of the
    collection. Do not delete the element from the set. */
    public Children grab(int index){
        if (index < 0 || index >= max) {
            return null; // Index out of bounds
        }
        return childrenAry[index];
    }

    /*Return as output an <Item>SortedArraySet that contains only
    specific subitem type. Assume 1 represents <ItemA>, 2 represents
    <ItemB>, and 3 represents items that are neither <ItemA> nor <ItemB>.
    Then categorySet(1) returns a set of items of type <ItemA>, in an array
    of type <Item>. The method returns null if the input is any number other
    than 1, 2, or 3. The method returns an empty set (not nulfl) if there are
    no items of the given type. */
    public ChildrenSortedArraySet categorySet(int type){
        if (type < 1 || type > 3) {
            return null; // Invalid type
        }

        ChildrenSortedArraySet resultSet = new ChildrenSortedArraySet(max);
        for (int i = 0; i < max; i++) {
            if (childrenAry[i] != null) {
                if (type == 1 && childrenAry[i] instanceof Children && !(childrenAry[i] instanceof GrandChildren)) {
                    resultSet.insert(childrenAry[i]); // Insert only Children, not GrandChildren
                } else if (type == 2 && childrenAry[i] instanceof GrandChildren) {
                    resultSet.insert(childrenAry[i]); // Insert only GrandChildren
                } else if (type == 3 && childrenAry[i] instanceof Nephew) {
                    resultSet.insert(childrenAry[i]); // Insert only Nephew
                }
            }
        }
        return resultSet;
    }
}
