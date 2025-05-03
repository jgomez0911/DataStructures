package program6;

import java.util.Arrays;

public class ArraysSort extends Sort {
    private int[][] sorted;

    public ArraysSort() {
        sorted = new int[initial.length][];
        for (int i = 0; i < initial.length; i++) {
            sorted[i] = new int[initial[i].length];
            System.arraycopy(initial[i], 0, sorted[i], 0, initial[i].length);
            sw.startTimer();
            Arrays.sort(sorted[i]);
            sw.stopTimer();
            System.out.println("Arrays.sort: Array of size " + sorted[i].length + " sorted in " + sw.elapsedTime() + " ms");
            System.out.println("Is sorted: " + isSorted(sorted[i]));
        }
    }
}