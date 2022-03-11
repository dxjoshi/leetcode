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

    // https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution

    public int[][] mergeTwo(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        res.add(intervals[0]);

        for(int i=1, j=0; i<n; i++)  {
            int[] lRes = res.get(res.size()-1);

            if (intervals[i][0] >= lRes[0] && intervals[i][0] <= lRes[1])   {
                lRes[1] = Math.max(lRes[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);

            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
