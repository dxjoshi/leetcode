import java.util.ArrayList;
import java.util.List;

public class SortingTest implements Sort{

    List<Sort> sorters;

    public SortingTest(List<Sort> sorters) {
        this.sorters = sorters;
    }

    public static void main(String[] args) {
        List<Sort> sortingAlgos = new ArrayList<>();
        sortingAlgos.add(new BubbleSort());
        SortingTest test  = new SortingTest(sortingAlgos);
        int[] input = {3, 1, 5, 4, 2};
        test.sort(input);
    }

    @Override
    public void sort(int[] input) {
        for (Sort algo : sorters) {
            algo.sort(input);
        }
    }
}
