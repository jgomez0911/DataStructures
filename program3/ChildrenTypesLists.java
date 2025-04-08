package program3;
/**
 * @author Jorge Gomez
 * @date 02/22/25
 * Represents a collection of ordered lists for GrandChildren and Nephews.
 * This class provides methods to add, remove, and retrieve Children objects
 * from the appropriate list based on their type.
 */
public class ChildrenTypesLists {

    private ChildrenOrderedList grandChildrenList; // List for GrandChildren
    private ChildrenOrderedList nephewList; // List for Nephew

    /**
     * Constructs a ChildrenTypesLists object with initialized lists for GrandChildren and Nephews.
     */
    public ChildrenTypesLists() {
        this.grandChildrenList = new ChildrenOrderedList(); // Initialize GrandChildren list
        this.nephewList = new ChildrenOrderedList(); // Initialize Nephew list
    }

    /**
     * Adds a Children object to the appropriate list based on its type.
     * @param element the Children object to be added
     * @throws ClassCastException if the element is not an instance of GrandChildren or Nephew
     */
    public void add(Children element) {
        if (element instanceof GrandChildren) {
            grandChildrenList.add(element);
        } else if (element instanceof Nephew) {
            nephewList.add(element);
        } else {
            // If the element is not of the correct type, throw an exception
            throw new ClassCastException("Element not instance of either subclass.");
        }
    }

    /**
     * Returns the size of the specified ChildrenOrderedList.
     * @param child the ChildrenOrderedList whose size is to be returned
     * @return the size of the list
     */
    public int sizeOf(ChildrenOrderedList child) {
        return child.size();
    }

    /**
     * Displays the contents of the specified ChildrenOrderedList.
     * @param child the ChildrenOrderedList to be displayed
     */
    public void display(ChildrenOrderedList child) {
        child.display();
    }

    /**
     * Adds a Children object at a specified index in the appropriate list.
     * @param index   the position to add the Children object (1-based index)
     * @param element the Children object to be added
     * @return true if the element was added, false if the index is invalid
     */
    public boolean add(int index, Children element) {
        if (index < 1) {
            return false; // Invalid index
        }
        if (element instanceof GrandChildren) {
            return grandChildrenList.add(index, element);
        } else if (element instanceof Nephew) {
            return nephewList.add(index, element);
        } else {
            return false; // Element is not of the correct type
        }
    }

    /**
     * Removes one occurrence of the specified Children object from the appropriate list.
     * @param target the Children object to be removed
     * @return true if the object was removed, false if not found
     */
    public boolean remove(Children target) {
        if (target instanceof GrandChildren) {
            return grandChildrenList.remove(target);
        } else if (target instanceof Nephew) {
            return nephewList.remove(target);
        } else {
            return false; // Target is not of the correct type
        }
    }

    /**
     * Removes the item located at the specified index in the given ChildrenOrderedList.
     * @param child  the ChildrenOrderedList from which to remove the item
     * @param index  the position of the item to be removed (1-based index)
     * @return true if the item was removed, false if the index is invalid
     */
    public boolean remove(ChildrenOrderedList child, int index) {
        return child.remove(index);
    }

    /**
     * Returns the index of the first occurrence of the specified Children object in the appropriate list.
     * @param target the Children object to find
     * @return the index of the first occurrence, or -1 if not found
     */
    public int indexOf(Children target) {
        if (target instanceof GrandChildren) {
            return grandChildrenList.indexOf(target);
        } else if (target instanceof Nephew) {
            return nephewList.indexOf(target);
        } else {
            return -1; // Target is not of the correct type
        }
    }

    /**
     * Returns the ChildrenOrderedList of the specified type.
     * @param type the type of list to retrieve ('a' for GrandChildren, 'b' for Nephew)
     * @return the corresponding ChildrenOrderedList, or null if the type is invalid
     */
    public ChildrenOrderedList getList(char type) {
        return switch (Character.toLowerCase(type)) {
            case 'a' -> grandChildrenList;
            case 'b' -> nephewList;
            default -> null; // Invalid type
        };
    }

    /**
     * Returns the Children object located at the specified index in the given ChildrenOrderedList.
     * @param child the ChildrenOrderedList from which to retrieve the item
     * @param index the position of the item to retrieve (1-based index)
     * @return the Children object at the specified index, or null if not found
     */
    public Children get(ChildrenOrderedList child, int index) {
        return child.get(index);
    }
}