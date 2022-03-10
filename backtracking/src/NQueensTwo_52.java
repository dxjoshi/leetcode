/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
*/
public class NQueensTwo_52 {
    int distinct = 0;
    public int totalNQueens(int n) {
        boolean[] vis = new boolean[n];
        boolean[] d1 = new boolean[2*n-1];
        boolean[] d2 = new boolean[2*n-1];
        solve(n, vis, d1, d2, 0);
        return distinct;
    }

    public void solve(int n, boolean[] vis, boolean[] d1, boolean[] d2, int row) {
        if (n == row) {
            distinct += 1;
        }

        for(int col=0; col<n; col++)  {
            if (vis[col] || d1[row+col] || d2[row-col+n-1]) continue;
            vis[col] = d1[row+col] = d2[row-col+n-1] = true;
            solve(n, vis, d1, d2, row+1);
            vis[col] = d1[row+col] = d2[row-col+n-1] = false;
        }
    }

}
