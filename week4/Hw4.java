
public class Hw4 {
/*
 this is solution 1

    public static int listRange( IntNode head ) {

        if ( head == null ) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = 0;
        int d;
        IntNode cursor = head;
        while( cursor != null ) {
            d = cursor.getData();
            low = Math.min( low, d );
            high = Math.max( high, d );
            cursor = cursor.getLink();
        }
        return (high - low);
    }
*/
    // solution 2
    public static int listRange(IntNode head) {
        if (head == null) {
            return -1; // Return -1 if the list is empty
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        IntNode current = head;
        while (current != null) {
            if (current.getData() < min) {
                min = current.getData(); // Update min if current data is smaller
            }
            if (current.getData() > max) {
                max = current.getData(); // Update max if current data is larger
            }
            current = current.getLink(); // Move to the next node
        }

        return max - min;
    }

}