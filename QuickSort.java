public class QuickSort {
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int[] array, int begin, int end)
    {
        int pivot = array[end];
        int pivotIndex = begin - 1;
     
        for(int i = begin; i < end; i++) {
            if (array[i] < pivot) {
                pivotIndex++;
                swap(array, pivotIndex, i);
            }
        }

        swap(array, pivotIndex + 1, end);
        return (pivotIndex + 1);
    }

    private static void quickSort(int[] unsorted, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(unsorted, begin, end);

            quickSort(unsorted, begin, pivotIndex - 1);
            quickSort(unsorted, pivotIndex + 1, end);
        }
    }


    public static int[] sort(int[] unsorted) {

        quickSort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }
}