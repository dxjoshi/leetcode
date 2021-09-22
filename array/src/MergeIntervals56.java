import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
*
* 56. Merge Intervals
*
* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*
* */
public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> list = new ArrayList<>();
        int start = 0, end = 1, j = 0;
        int result[] = intervals[0];
        list.add(result);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][start] >= result[start] &&
                    intervals[i][start] <= result[end]) {
                result[end] = Math.max(intervals[i][end], result[end]);
            } else {
                result = intervals[i];
                list.add(result);
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
