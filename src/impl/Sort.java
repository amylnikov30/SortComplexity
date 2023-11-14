package impl;

/**
 * A class that contains various sorting algorithms.
 */
public class Sort
{
    /**
     * Sorts an array using the merge sort algorithm.
     * @param array The array to sort.
     * @return The sorted array.
     */
    public static int[] mergeSort(int[] array)
    {
        if (array.length <= 1)
            return array;

        int start = 0;
        int mid = array.length / 2;
        int end = array.length;

        int[] left = new int[mid - start];
        int[] right = new int[end - mid];

        System.arraycopy(array, start, left, 0, mid - start);
        System.arraycopy(array, mid, right, 0, end - mid);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    /**
     * Merges two sorted arrays into one sorted array.
     * @param left The left array.
     * @param right The right array.
     * @return The merged array.
     */
    private static int[] merge(int[] left, int[] right)
    {
        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length)
        {
            if (left[leftIndex] < right[rightIndex])
                result[resultIndex++] = left[leftIndex++];
            else
                result[resultIndex++] = right[rightIndex++];
        }

        while (leftIndex < left.length)
            result[resultIndex++] = left[leftIndex++];

        while (rightIndex < right.length)
            result[resultIndex++] = right[rightIndex++];

        return result;
    }

    /**
     * Sorts an array using the selection sort algorithm.
     * @param array The array to sort.
     * @return The sorted array.
     */
    public static int[] selectionSort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[minIndex])
                    minIndex = j;

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }
}
