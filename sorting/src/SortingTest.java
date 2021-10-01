import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortingTest implements Sort{

    List<Sort> sorters;

    public SortingTest(List<Sort> sorters) {
        this.sorters = sorters;
    }

    public static void main(String[] args) {
        List<Sort> sortingAlgos = addSortingAlgos();
        SortingTest testRunner = new SortingTest(sortingAlgos);
        List<int[]> testCases = getTCs();

        for (int[] input : testCases) {
            Util.print("Input Array: ", input);
            System.out.println();
            testRunner.sort(input);
            System.out.println("-----------------------------------");
        }
    }

    private static List<Sort> addSortingAlgos() {
        List<Sort> sortingAlgos = new LinkedList<>();
        sortingAlgos.add(new BubbleSort());
        sortingAlgos.add(new SelectionSort());
        sortingAlgos.add(new InsertionSort());
        return sortingAlgos;
    }

    private static List<int[]> getTCs() {
        List<int[]> testCases = new ArrayList<>();
        testCases.add(new int[] {3, 1, 5, 4, 2, 0});
        testCases.add(new int[] {1, 2, 3, 4, 5});
        testCases.add(new int[] {5, 17, 23, 9, 11, 10, 4, 3, 2, 1});
        return testCases;
    }

    @Override
    public void sort(int[] input) {
        for (Sort algo : sorters) {
            algo.sort(Arrays.copyOf(input, input.length));
        }
    }
}
