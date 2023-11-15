package stats;

import impl.Sort;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that contains methods for benchmarking sorting algorithms.
 */
public class Benchmarks
{
    public static void main(String[] args) throws IOException
    {
        long time = 0;
        final int n = Integer.parseInt(args[1]);
        final int arrSize = Integer.parseInt(args[2]);

        if (args[0].equals("merge"))
            time = averageMergeSortTime(n, arrSize);
        else if (args[0].equals("selection"))
            time = averageSelectionSortTime(n, arrSize);

        final FileWriter fw = new FileWriter(args[3], true);
        fw.write(arrSize + "," + time + "\n");
        fw.close();
    }

    /**
     * Returns the average time it takes to sort an array of size arrSize using merge sort.
     * @param n The number of times to run the test.
     * @param arrSize The size of the array to sort.
     * @return The average time it takes to sort an array of size arrSize using merge sort.
     */
    public static long averageMergeSortTime(int n, int arrSize)
    {
        long sum = 0;

        for (int i = 0; i < n; i++)
        {
            int[] array = new int[arrSize];
            for (int j = 0; j < array.length; j++)
                array[j] = (int) (Math.random() * 1000);

            sum += testMergeSort(array);
        }

        return sum / n;
    }

    /**
     * Returns the average time it takes to sort an array of size arrSize using selection sort.
     * @param n The number of times to run the test.
     * @param arrSize The size of the array to sort.
     * @return The average time it takes to sort an array of size arrSize using selection sort.
     */
    public static long averageSelectionSortTime(int n, int arrSize)
    {
        long sum = 0;

        for (int i = 0; i < n; i++)
        {
            int[] array = new int[arrSize];
            for (int j = 0; j < array.length; j++)
                array[j] = (int) (Math.random() * 1000);

            sum += testSelectionSort(array);
        }

        return sum / n;
    }

    /**
     * Times the merge sort algorithm on an array.
     * @param array The array to sort.
     * @return The time it took to sort the array.
     */
    public static long testMergeSort(int[] array)
    {
        final long startTime = System.nanoTime();
        Sort.mergeSort(array);
        final long time = System.nanoTime() - startTime;

        return time;
    }

    /**
     * Times the merge sort algorithm on a randomly-generated array of size arrSize.
     * @param arrSize The size of the array to sort.
     * @return The time it took to sort the array.
     */
    public static long testMergeSort(int arrSize)
    {
        final int[] array = generateRandomArray(arrSize);
        
        return testMergeSort(array);
    }

    /**
     * Times the selection sort algorithm on an array.
     * @param array The array to sort.
     * @return The time it took to sort the array.
     */
    public static long testSelectionSort(int[] array)
    {
        final long startTime = System.nanoTime();
        Sort.selectionSort(array);
        final long time = System.nanoTime() - startTime;

        return time;
    }

    /**
     * Times the selection sort algorithm on a randomly-generated array of size arrSize.
     * @param arrSize The size of the array to sort.
     * @return The time it took to sort the array.
     */
    public static long testSelectionSort(int arrSize)
    {
        final int[] array = generateRandomArray(arrSize);
        
        return testSelectionSort(array);
    }

    /**
     * Collects data on the merge sort algorithm.
     * @param startSize The starting size of the array.
     * @param base The base of the exponent.
     * @param x The maximum exponent.
     * @param n The number of times to run the test at each size.
     */
    public static void collectDataMergeSort(int startSize, int base, int x, int n)
    {
        long[] times = new long[x+1];

        for (int i = 0; i <= x; i++)
        {
            final int arrSize = startSize + (int) Math.pow(base, i);
            long[] collected = new long[n];

            for (int j = 0; j < n; j++)
            {
                int[] array = new int[arrSize];
                for (int k = 0; k < array.length; k++)
                    array[k] = (int) (Math.random() * 1000);

                collected[j] = testMergeSort(array);
            }

            times[i] = average(collected);

            System.out.println("n = " + arrSize + ": " + times[i] + " nanoseconds");
        }

//        System.out.println("Merge Sort:");
//        for (int i = 0; i <= x; i++)
//            System.out.println("n = " + (startSize + (int) Math.pow(base, i)) + ": " + times[i] + " nanoseconds");
    }

    /**
     * Collects data on the selection sort algorithm.
     * @param base The base of the exponent.
     * @param x The maximum exponent.
     * @param n The number of times to run the test at each size.
     */
    public static void collectDataSelectionSort(int base, int x, int n)
    {
        long[] times = new long[x+1];

        for (int i = 0; i <= x; i++)
        {
            long[] collected = new long[n];

            for (int j = 0; j < n; j++)
            {
                int[] array = new int[(int) Math.pow(base, i)];
                for (int k = 0; k < array.length; k++)
                    array[k] = (int) (Math.random() * 1000);

                collected[j] = testSelectionSort(array);
            }

            times[i] = average(collected);
        }

        System.out.println("Merge Sort:");
        for (int i = 0; i <= x; i++)
            System.out.println("n = " + (int) Math.pow(base, i) + ": " + times[i] + " nanoseconds");
    }

    /**
     * Returns the average of an array of longs.
     * @param collected The array of longs.
     * @return The average of the array of longs.
     */
    private static long average(long[] collected)
    {
        long sum = 0;

        for (long time : collected)
            sum += time;

        return sum / collected.length;
    }

    /**
     * Generates a random array of size arrSize.
     * @param arrSize The size of the array to generate.
     * @return The generated array.
     */
    private static int[] generateRandomArray(int arrSize)
    {
        int[] array = new int[arrSize];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 1000);
        
        return array;
    }
}
