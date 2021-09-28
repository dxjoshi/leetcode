/*
*
* 200. Number of Islands
*
* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*
* */
public class NumberofIslands200 {
    int[] d = {0, 1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i=0; i<grid.length; i++)
            for (int j=0; j<grid[i].length; j++)
                islands += sink(grid, i, j);
        return islands;
    }

    int sink(char[][] g, int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0') {
            return 0;
        }
        g[i][j] = '0';
        for (int k = 0; k<4; k++) {
            sink(g, i+d[k], j+d[k+1]);
        }
        return 1;
    }
}
