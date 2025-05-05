

public class MergeSort extends Sort {
    private int[][] sorted;

    public MergeSort() {
        sorted = new int[initial.length][];
        for (int i = 0; i < initial.length; i++) {
            sorted[i] = new int[initial[i].length];
            System.arraycopy(initial[i], 0, sorted[i], 0, initial[i].length);
            sw.startTimer();
            mergeSort(sorted[i], 0, sorted[i].length - 1);
            sw.stopTimer();
            System.out.println("MergeSort: Array of size " + sorted[i].length + " sorted in " + sw.elapsedTime() + " ms");
            System.out.println("Is sorted: " + isSorted(sorted[i]));
        }
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < n1) {
            array[k++] = L[i++];
        }

        while (j < n2) {
            array[k++] = R[j++];
        }
    }

    public int[][] getSorted() {
        return sorted;
    }
}