import java.util.ArrayList;

public class Sorter {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length-1; ++i)
            System.out.print(arr[i] + ",");
        System.out.println(arr[arr.length-1]);
    }

    // Driver method
    public static void main(String args[]) {

        ArrayList<Integer> inputList = new ArrayList<>();
        
        if (args != null && args.length > 0) {
            String[] vals = args[0].split(",");

            for (String val : vals) {
                inputList.add(Integer.parseInt(val));
            }
        } else {
            inputList.add(1);
            inputList.add(7);
            inputList.add(5);
            inputList.add(10);
            inputList.add(3);
            inputList.add(8);
        }

        int[] inputVals = new int[inputList.size()];
        for(int i = 0; i < inputList.size(); i++) {
            inputVals[i] = inputList.get(i);
        }

        // System.out.print("Given Array: ");
        // printArray(inputVals);

        int[] mergeVals = inputVals;
        System.out.println(String.format("Merge Sort array: %d", timeMerge(mergeVals)));

        int[] quickVals = inputVals;
        System.out.println(String.format("Quick Sort array: %d", timeQuick(quickVals)));

        int[] heapVals = inputVals;
        System.out.println(String.format("Heap Sort array: %d", timeHeap(heapVals)));

        // if (mergeVals.equals(quickVals) && quickVals.equals(heapVals)) {
        //     System.out.print("Unanimous Sorted Array: ");
        //     printArray(mergeVals);
        // } else {
        //     System.out.print("Merge Sorted Array: ");
        //     printArray(mergeVals);

        //     System.out.print("Quick Sorted Array: ");
        //     printArray(quickVals);

        //     System.out.print("Heap Sorted Array: ");
        //     printArray(heapVals);
        // }
    }

    private static long timeMerge(int[] arr) {
        long startTime = System.nanoTime();
        arr = MergeSort.sort(arr);
        long endTime = System.nanoTime();

        //divide by 1000000 to get milliseconds.
        long duration = (endTime - startTime);
        return duration;
    }

    private static long timeQuick(int[] arr) {
        long startTime = System.nanoTime();
        arr = QuickSort.sort(arr);
        long endTime = System.nanoTime();

        //divide by 1000000 to get milliseconds.
        long duration = (endTime - startTime);
        return duration;
    }

    private static long timeHeap(int[] arr) {
        long startTime = System.nanoTime();
        arr = HeapSort.sort(arr);
        long endTime = System.nanoTime();
        
        //divide by 1000000 to get milliseconds.
        long duration = (endTime - startTime);
        return duration;
    }
}