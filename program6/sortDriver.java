public class SortDriver {
    public static void main(String[] args) {
        System.out.println("\nStarting sorting tests...");

        MergeSort mergeSort = new MergeSort();
        BubbleSort bubbleSort = new BubbleSort();
        ArraysSort arraysSort = new ArraysSort();

        System.out.println("\nMergeSort - Test array before sorting:");
        Sort.show(mergeSort.initial[0]);  // initial is protected so accessible here
        System.out.println("\nMergeSort - Test array after sorting:");
        Sort.show(mergeSort.getSorted()[0]);   // assuming sorted is accessible or add a getter

        System.out.println("\nBubbleSort - Test array before sorting:");
        Sort.show(bubbleSort.initial[0]);
        System.out.println("\nBubbleSort - Test array after sorting:");
        Sort.show(bubbleSort.getSorted()[0]);

        System.out.println("\nArraysSort - Test array before sorting:");
        Sort.show(arraysSort.initial[0]);
        System.out.println("\nArraysSort - Test array after sorting:");
        Sort.show(arraysSort.getSorted()[0]);
    }
}