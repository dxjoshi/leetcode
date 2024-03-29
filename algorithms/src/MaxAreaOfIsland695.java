/*
*
* 695. Max Area of Island
*
* You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water. The area of an island is the number of cells with a value 1 in the island. Return the maximum area of an island in grid. If there is no island, return 0.
*
* */

public class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
                }
            }
        }
        return max_area;
    }

    public int AreaOfIsland(int[][] grid, int i, int j) {
        if( i >= 0 && i < grid.length &&
                j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 +
                    AreaOfIsland(grid, i+1, j) +
                    AreaOfIsland(grid, i-1, j) +
                    AreaOfIsland(grid, i, j-1) +
                    AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }

}
