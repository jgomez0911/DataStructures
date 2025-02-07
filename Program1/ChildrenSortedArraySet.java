package Program1;

public class ChildrenSortedArraySet {

    private Children[] ChildrenAry;
    private Integer max;

    public Integer Children(Integer max){
        return this.max = max;
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
    public void insert(Children i){
        if (i == null) {
            throw new NullPointerException("Cannot insert null into the set");
        }
    }

    /*Returns the number of items in the collection. */
    public int size(){
        return 0;
    }

    /*Returns a string representation of the collection
    that includes all items. The output string must be nicely
    formatted in a tabular format. For example, a list of Circles
    is displayed as follows. Note the second row shows an <ItemA> 
    object while the third row shows an <ItemB> object */
    public String toString(){
        return "[]";
    }

    /*Returns an int that represents the array index at 
    which the input <Item> is found or -1 if the <Item> 
    is not found. The equality of items is determined by 
    the equals method. */
    public int indexOf(Children i){
        return -1;
    }

    /*Search the collection for an Item that equals the 
    input <Item> and, if found, remove this <Item> from 
    the set. Return true if the <Item> is removed and false 
    otherwise. This method must maintain the sorted order.  
    Shift the array elements down to fill the gap that is 
    created by the deleted <Item>. . Do not use the Java's 
    Arrays.sort(…) method. */
    public Boolean remove(Children i){
        return false;
    }

    /*Just replacing the deleted item with the last element 
    in the array will not work anymore because this may break 
    the sorted order Return the <Item> that is stored at position 
    index in the set or null if index is beyond the size of the
    collection. Do not delete the element from the set. */
    public Children grab(int index){
        return null;
    }

    /*Return as output an <Item>SortedArraySet that contains only
    specific subitem type. Assume 1 represents <ItemA>, 2 represents 
    <ItemB>, and 3 represents items that are neither <ItemA> nor <ItemB>. 
    Then categorySet(1) returns a set of items of type <ItemA>, in an array 
    of type <Item>. The method returns null if the input is any number other
    than 1, 2, or 3. The method returns an empty set (not nulfl) if there are
    no items of the given type. */
    public ChildrenSortedArraySet categorySet(int type){
        return null;
    }
}
