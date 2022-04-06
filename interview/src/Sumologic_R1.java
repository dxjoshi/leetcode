import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// input - numbers , data - number
// Service A - process Data - list of number - takes data and sort in //ascending order
// Service B - number to search the data
// Service C search for the service

// [1,3,2] -> [3,1]
// [7,2,3,5,4,6,7,8] - input, 0, 7 - [5,2]
// [2,3,4,5,6,7,7,8] - sorted
// lo = 0, hi = n-1
// mid =
// [0,1,0,1,0,,0,0]
// fun(arr,  i, j) - fun(arr, i, mid-1); fun(Arr, mid+1, j);
// 0 - not visited, 1- succ, -1 -fail
// is binSearch succes -> check for smaller elements on right side -> exclude these
// mid == key - >
// searchable (lo to mid-1) if a[mid] < a[i] - not searchable
// searchable (mid+1 to hi) if a[mid] > a[i] - not searchable
// mid > key
// mid < key


// Test cases
// [1, 2, 3, 4, 5]
// [5, 4, 3, 2, 1]
// [1, 3, 2]
// []
// [8]
// [10, 9, 8, 7, 6, 4]
// [10, 5, 9, 8, 7, 6, 4]
// [10, 5, 9, 8, 7, 6, 4, 12]
// [10, 5, 9, 8, 13, 6, 4, 12]

// [5, 4, 3, 2, 1]
// [1, 3, 2]
// []
// [8]
// [10, 9, 8, 7, 6, 4]
// [10, 5, 9, 8, 7, 6, 4]
// [10, 5, 9, 8, 7, 6, 4, 12]
// [10, 5, 9, 8, 13, 6, 4, 12][5, 4, 3, 2, 1]
// [1, 3, 2]
// []
// [8]
// [10, 9, 8, 7, 6, 4]
// [10, 5, 9, 8, 7, 6, 4]
// [10, 5, 9, 8, 7, 6, 4, 12]
// [10, 5, 9, 8, 13, 6, 4, 12]

public class Sumologic_R1 {
    public static void main(String[] args) {
//        System.out.println(findNums(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(findNums(new int[]{5, 4, 3, 2, 1}));
//        System.out.println(findNums(new int[]{1, 3, 2}));
//        System.out.println(findNums(new int[]{}));
//        System.out.println(findNums(new int[]{8}));
        System.out.println(findNums(new int[]{10, 9, 8, 7, 6, 4}));
        System.out.println(findNums(new int[]{10, 5, 9, 8, 7, 6, 4}));
        System.out.println(findNums(new int[]{10, 5, 9, 8, 7, 6, 4, 12}));
        System.out.println(findNums(new int[]{10, 5, 9, 8, 13, 6, 4, 12}));
    }

    public static List<Integer> findNums(int[] input) {
        int[] searchable = new int[input.length];
        Arrays.fill(searchable, 1);
        solve(input, searchable, 0, input.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < searchable.length; i++) {
            if (searchable[i] == 1) {
                res.add(input[i]);
            }
        }
        return res;
    }

    public static void solve(int[] input, int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] != 1) return;
        for (int i = lo; i <= hi; i++) {
            if (i < mid && input[i] > input[mid]) arr[i] = -1;
            if (i > mid && input[i] < input[mid]) arr[i] = -1;
        }
        System.out.println(String.format("Lo: %s, Hi:%s, Mid: %s, arr: %s", lo, hi, mid, print(arr)));
        solve(input, arr, lo, mid - 1);
        solve(input, arr, mid + 1, hi);
    }

    public static String print(int[] arr) {
        return Arrays.toString(arr);
    }
}


