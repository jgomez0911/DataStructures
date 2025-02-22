package program3;

public class ChildrenTypesLists {

    private ChildrenOrderedList grandChildrenList; // List for GrandChildren
    private ChildrenOrderedList nephewList; // List for Nephew

    // Constructor
    public ChildrenTypesLists() {
        this.grandChildrenList = new ChildrenOrderedList(); // Initialize GrandChildren list
        this.nephewList = new ChildrenOrderedList(); // Initialize Nephew list
    }

    // Method to add an element to the correct list
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

    // Method to return the size of the given list
    public int sizeOf(ChildrenOrderedList iol) {
        return iol.size();
    }

    // Method to display the contents of the specified list
    public void display(ChildrenOrderedList iol) {
        iol.display();
    }

    // Method to add an element at a given index in the correct list
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

    // Method to remove one occurrence of target from the correct list
    public boolean remove(Children target) {
        if (target instanceof GrandChildren) {
            return grandChildrenList.remove(target);
        } else if (target instanceof Nephew) {
            return nephewList.remove(target);
        } else {
            return false; // Target is not of the correct type
        }
    }

    // Method to remove the item located at position index in the specified list
    public boolean remove(ChildrenOrderedList iol, int index) {
        return iol.remove(index);
    }

    // Method to return the index of the first occurrence of target in the appropriate list
    public int indexOf(Children target) {
        if (target instanceof GrandChildren) {
            return grandChildrenList.indexOf(target);
        } else if (target instanceof Nephew) {
            return nephewList.indexOf(target);
        } else {
            return -1; // Target is not of the correct type
        }
    }

    // Method to return the ChildrenOrderedList of the given type
    public ChildrenOrderedList getList(char type) {
        if (Character.toLowerCase(type) == 'a') {
            return grandChildrenList;
        } else if (Character.toLowerCase(type) == 'b') {
            return nephewList;
        } else {
            return null; // Invalid type
        }
    }

    // Method to return the item at position index in the specified list
    public Children get(ChildrenOrderedList iol, int index) {
        return iol.get(index);
    }
}