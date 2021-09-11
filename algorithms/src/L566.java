/*
* 566. Reshape the Matrix
*
* In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data. You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix. The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
* If the reshape operation with given parameters is possible and legal, output the new reshaped matrix;
* Otherwise, output the original matrix.
*
* */
public class L566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null) {
            return mat;
        }
        int r1 = mat.length, c1 = mat[0].length;
        if (r1*c1 != r*c) {
            return mat;
        }

        int[][] res = new int[r][c];
        //transform
        for (int i = 0; i<r*c; i++) {
            res[i/c][i%c] = mat[i/c1][i%c1];
        }
        return res;
    }
}
