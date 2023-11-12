import stats.Benchmarks;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Merge sort: ");
        Benchmarks.collectDataMergeSort(0, 2, 10, 10000);

        System.out.println("\nSelection sort: ");
        Benchmarks.collectDataSelectionSort(2, 10, 10000);
    }
}