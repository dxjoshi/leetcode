/*
*
* 74. Search a 2D Matrix
*
* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
* Integers in each row are sorted from left to right.
* The first integer of each row is greater than the last integer of the previous row.
*
* */
public class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int c = matrix[0].length;
        int r = matrix.length;
        int lo = 0;
        int hi = r*c - 1;
        int mid = 0, row = 0, col = 0;
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            row = mid/c;
            col = mid%c;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
