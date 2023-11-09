public class Sort
{
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

    public static int[] selectionSort(int[] array)
    {
        return null;
    }
}
