
public class BubbleSort extends Sort {
    private int[][] sorted;

    public BubbleSort() {
        sorted = new int[initial.length][];
        for (int i = 0; i < initial.length; i++) {
            sorted[i] = new int[initial[i].length];
            System.arraycopy(initial[i], 0, sorted[i], 0, initial[i].length);
            sw.startTimer();
            bubbleSort(sorted[i]);
            sw.stopTimer();
            System.out.println("BubbleSort: Array of size " + sorted[i].length + " sorted in " + sw.elapsedTime() + " ms");
            System.out.println("Is sorted: " + isSorted(sorted[i]));
        }
    }

    private void bubbleSort(int[] array) {
        int n = array.length;
        for ( int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public int[][] getSorted() {
        return sorted;
    }
}
