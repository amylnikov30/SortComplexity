import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(Sort.mergeSort(new int[]{9, 3, 5, 2, 1, 7, 4, 6, 8, 0})));
        System.out.println(Arrays.toString(Sort.mergeSort(new int[]{3, 5, 2, 1, 7, 4, 6, 8, 0})));

        System.out.println(Arrays.toString(Sort.selectionSort(new int[]{9, 3, 5, 2, 1, 7, 4, 6, 8, 0})));
        System.out.println(Arrays.toString(Sort.selectionSort(new int[]{3, 5, 2, 1, 7, 4, 6, 8, 0})));
    }
}
