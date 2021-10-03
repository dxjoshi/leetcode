import java.util.PriorityQueue;

/*
*
* 1337. The K Weakest Rows in a Matrix
*
* You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
*
* A row i is weaker than a row j if one of the following is true:
*
* The number of soldiers in row i is less than the number of soldiers in row j.
* Both rows have the same number of soldiers and i < j.
* Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
*
* */
public class TheKWeakestRowsinaMatrix1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
//b[0] last index of 1
// b[1] row index
// It's a max heap. the comparator basically says, if a[0] != b[0], then go by the last index of 1,
// if they are equal in length for 1s, then go by the row index. max heap wants the max elem first.
// since higher row index for same 1s is considered bigger (less prior) according to problem statement,
// we want that higher index to be max elem.
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {numOnes(mat[i]), i});
            if (pq.size() > k)
                pq.poll();
        }

        while (k > 0)
            ans[--k] = pq.poll()[1];

        return ans;
    }

    // find index of 1st zero instead of counting all ones
    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
}
