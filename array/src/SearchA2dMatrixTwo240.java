/*
*
* 240. Search a 2D Matrix II
*
* Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
* Integers in each row are sorted in ascending from left to right.
* Integers in each column are sorted in ascending from top to bottom.
*
* */
public class SearchA2dMatrixTwo240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length-1;
        while (r <= matrix.length-1 && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
