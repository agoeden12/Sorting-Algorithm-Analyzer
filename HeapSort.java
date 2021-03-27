public class HeapSort {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void heapify(int array[], int depth, int root) {

        int largest = root;
        int leftNode = 2 * root + 1;
        int rightNode = 2 * root + 2;

        if (leftNode < depth && array[leftNode] > array[largest])
            largest = leftNode;

        if (rightNode < depth && array[rightNode] > array[largest])
            largest = rightNode;

        if (largest != root) {
            swap(array, root, largest);
            heapify(array, depth, largest);
        }
    }

    public static int[] sort(int unsorted[]) {
        int length = unsorted.length;

        for (int i = ((length / 2) - 1); i >= 0; i--) {
            heapify(unsorted, length, i);
        }

        for (int i = (length - 1); i > 0; i--) {
            swap(unsorted, 0, i);
            heapify(unsorted, i, 0);
        }

        return unsorted;
    }
}
