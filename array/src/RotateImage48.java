/*
*
* 48. Rotate Image
*
* You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
* You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*
* */
public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = i ; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0, k=matrix.length-1; i<k; i++,k--) {
            for (int j = 0 ; j < matrix.length; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }
    }
}
