import impl.Sort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSort
{
    @Test
    public  void mergeSort()
    {
        final int[] array = new int[] {3, 5, 6, 2, 1, 8, 9, 0, 7, 4};

        assertArrayEquals(Sort.mergeSort(array), new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void selectionSort()
    {
        final int[] array = new int[] {3, 5, 6, 2, 1, 8, 9, 0, 7, 4};

        assertArrayEquals(Sort.selectionSort(array), new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
