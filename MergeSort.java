public class MergeSort {

    private static int[] merge(int leftArr[], int rightArr[]) {

        int[] mergedArray = new int[leftArr.length + rightArr.length];
        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {

            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                mergedArray[mergeIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                mergedArray[mergeIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            
            mergeIndex++;
        }

        if (leftIndex < leftArr.length) {
            while (leftIndex < leftArr.length) {
                mergedArray[mergeIndex] = leftArr[leftIndex];
                leftIndex++;
                mergeIndex++;
            }
        } else if (rightIndex < rightArr.length) {
            while (rightIndex < rightArr.length) {
                mergedArray[mergeIndex] = rightArr[rightIndex];
                rightIndex++;
                mergeIndex++;
            }
        }

        return mergedArray;
    }

    public static int[] sort(int unsorted[]) {

        if (unsorted.length > 1) {
            int midPoint = unsorted.length / 2;

            int[] leftArr = new int[midPoint];
            int[] rightArr = new int[unsorted.length - midPoint];

            for (int i = 0; i < unsorted.length; i++) {
                if (i < midPoint) {
                    leftArr[i] = unsorted[i];
                } else {
                    rightArr[i - midPoint] = unsorted[i];
                }
            }

            return merge(sort(leftArr), sort(rightArr));
        } else {
            return unsorted;
        }
    }
}