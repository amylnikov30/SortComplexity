package stats;

import impl.Sort;

import java.io.FileWriter;
import java.io.IOException;

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

    public static long testMergeSort(int[] array)
    {
        final long startTime = System.nanoTime();
        Sort.mergeSort(array);

        return System.nanoTime() - startTime;
    }

    public static long testSelectionSort(int[] array)
    {
        final long startTime = System.nanoTime();
        Sort.selectionSort(array);

        return System.nanoTime() - startTime;
    }

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

    // TODO: Add startSize parameter and its functionality.
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

    private static long average(long[] collected)
    {
        long sum = 0;

        for (long time : collected)
            sum += time;

        return sum / collected.length;
    }
}
