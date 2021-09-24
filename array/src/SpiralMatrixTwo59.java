/*
*
* 59. Spiral Matrix II
*
* Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
*
* */
public class SpiralMatrixTwo59 {
    public int[][] generateMatrix(int n) {
        int total = n*n, num = 1;
        int rB = 0, cB = 0, rE = n-1, cE = n-1;
        int[][] arr = new int[n][n];
        while (num <= total) {
            for (int i = cB; i<= cE; i++) {
                arr[rB][i] = num++;
            }
            rB++;
            for (int i = rB; i<= rE; i++) {
                arr[i][cE] = num++;
            }
            cE--;
            for (int i = cE; i>= cB; i--) {
                arr[rE][i] = num++;
            }
            rE--;
            for (int i = rE; i>= rB; i--) {
                arr[i][cB] = num++;
            }
            cB++;
        }
        return arr;
    }
}
