package week9;

public class HW9 {
 /*
    public static void f( int n ) {
        System.out.println( n );
        if ( n > 1 ) {
            f(n-1);
        }
    }

    public static void g( int n ) {
        if ( n > 1 ) {
            g(n-1);
        }
        System.out.println( n );
    }
*/
    public static void h( int n ) {
        f(n);
    }

    public static void f( int n ) {
        System.out.println( n );
        if ( n > 1 ) {
            g(n-1);
        }
    }

    public static void g( int n ) {
        if ( n > 1 ) {
            f(n-1);
        }
        System.out.println( n );
    }

    public static int catalan1(int n) {
        if (n == 0) return 1; // Base case
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += catalan1(i-1) * catalan1(n - i); // Recursive calculation
        }
        return result;
    }

    public static int catalan2(int n) {
        if (n == 0) return 1; // Base case
        return (2 * (2 * n - 1) / (n + 1) * catalan1(n - 1)) ; // Recursive calculation
    }

    public static void main(String[] args) {

        int x = catalan2(5);
        System.out.println(x);

    }

}