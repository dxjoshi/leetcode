/*
*
* 1219. Path with Maximum Gold
*
* In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
* Return the maximum amount of gold you can collect under the conditions:
*  Every time you are located in a cell you will collect all the gold in that cell.
*  From your position you can walk one step to the left, right, up or down.
*  You can't visit the same cell more than once.
*  Never visit a cell with 0 gold.
*
* You can start and stop collecting gold from any position in the grid that has some gold.
* */
public class PathWithMaximumGold {

    public static void main(String[] args) {
        PathWithMaximumGold obj = new PathWithMaximumGold();
        int result = obj.getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}});
        System.out.println("Result= "+ result   );
    }

    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        int sum = 0;
        for (int i=0; i< row; i++) {
            for (int j=0; j< col; j++) {
                if (grid[i][j] != 0) {
                    sum = Math.max(sum, solve(grid, vis, i, j, row, col));
                }
            }
        }
        return sum;

    }
    public int solve(int[][] grid, int[][] vis, int r, int c, int row, int col) {
        if (grid[r][c] == 0 || vis[r][c] == 1) {
            return 0;
        }

        int sum = 0;
        sum = grid[r][c];
        vis[r][c] = 1;
        int left = c>0 ? solve(grid, vis, r, c-1, row, col) : 0;
        int right = c<col-1 ? solve(grid, vis, r, c+1, row, col) : 0;
        int up = r>0 ? solve(grid, vis, r-1, c, row, col) : 0;
        int down = r<row-1 ? solve(grid, vis, r+1, c, row, col) : 0;
        sum += Math.max(Math.max(left, right), Math.max(up, down));
        vis[r][c] = 0;
        return sum;
    }
}
