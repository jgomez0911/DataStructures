package week5;

public class HW5 {

    //O(1), O(log n), O(n), O(n log n), O(n2), O(2n), O(n!).
    public void method1( int n ) {
        for ( int j = 1; j <= n; j++ ) {
            for ( int k = 1; k < n; k++ ) {
                System.out.println ( j * k ) ;
            }
        }
    }
    //Big-O running time of method1 is O(n^2)


    // Assume the method Math.max(…) runs in constant time.
    public void method2( int n ) {
        for ( int j = n; j <= 2; j /= 2 ) {
            for ( int k = 0; k < j; k++ ) {
                System.out.print( Math.max( j, k ) );
            }
        }
    }
    //Big-O running time of method2 is O(n)


    public void method3( int n ) {
        int k =1;
        for ( int j = 1; j <= n; j *= 2 ) {
            System.out.println ( j * k ) ;
        }
    }
    //Big-O running time of method3 is O(log n)


    public void method4( int n ) {
        for ( int j = 1; j <= n; j++ ) {
            System.out.println ( j ) ;
        }
    }
    //Big-O running time of method4 is O(n)

    public void method5( int m, int n ) {
        for ( int j = 1; j <= m; j++ ) {
            for ( int k = 1; k < n; k++ ) {
                System.out.println ( j * k ) ;
            }
        }
    }
    //Big-O running time of method5 is O(n log n)

    public void method6( int m, int n ) {
        for ( int j = 1; j <= m; j *= 2 ) {
            for ( int k = 1; k < n; k *= 2 ) {
                System.out.println ( j * k ) ;
            }
        }
    }
    //Big-O running time of method6 is O(log n)
/* 
    public class ThingNode {
        Thing data;
        ThingNode next;

        public Thing getData() { return data; }
        public ThingNode getNext() { return next; }

        public void setData( E data ) { this.data = data; }
        public void setNext ( ThingNode next ) { this.next = next; }

        public Thing removeSecond(Thing target, ThingNode head){

            if (head == null || head.getNext() == null){
                return null;
            }

            ThingNode first = head;
            ThingNode second = head.getNext();
            ThingNode third = second.getNext();

            Thing removed = second.getData();

            first.setNext(third);
            second.setNext(null);

            return removed;
        }
    }
    */
}