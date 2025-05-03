import java.util.Random;

public abstract class Sort {
    protected int[][] initial;
    public static final int TEST = 20;
    public Stopwatch sw;

    public Sort() {
        initial = new int[5][];
        Random r = new Random();

        // Initialize the test array
        initial[0] = new int[TEST];
        for (int j = 0; j < TEST; j++) {
            initial[0][j] = r.nextInt();
        }

        // Initialize other arrays of increasing sizes
        initial[1] = new int[100]; // Smallest size
        initial[2] = new int[1000];
        initial[3] = new int[5000];
        initial[4] = new int[10000]; // Largest size

        for (int i = 1; i < initial.length; i++) {
            for (int j = 0; j < initial[i].length; j++) {
                initial[i][j] = r.nextInt();
            }
        }

        sw = new Stopwatch();
    }

    public static void show(int[] a) {
        for (int num : a) {
            System.out.printf("%20d%n", num);
        }
    }

    public boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
}