import java.util.LinkedList;
import java.util.Queue;

/*
*
* 994. Rotting Oranges
*
* You are given an m x n grid where each cell can have one of three values:
*
* 0 representing an empty cell,
* 1 representing a fresh orange, or
* 2 representing a rotten orange.
* Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
*
* Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
* */
public class RottingOranges994 {

    class Solution {
        // https://leetcode.com/problems/rotting-oranges/discuss/238681/Java-Clean-BFS-Solution-with-comments

        public int orangesRotting1(int[][] grid) {
            if(grid == null || grid.length == 0) return 0;
            int rows = grid.length;
            int cols = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int count_fresh = 0;
            //Put the position of all rotten oranges in queue
            //count the number of fresh oranges
            for(int i = 0 ; i < rows ; i++) {
                for(int j = 0 ; j < cols ; j++) {
                    if(grid[i][j] == 2) {
                        queue.offer(new int[]{i , j});
                    }
                    else if(grid[i][j] == 1) {
                        count_fresh++;
                    }
                }
            }
            //if count of fresh oranges is zero --> return 0
            if(count_fresh == 0) return 0;
            int count = 0;
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            //bfs starting from initially rotten oranges
            while(!queue.isEmpty()) {
                ++count;
                int size = queue.size();
                for(int i = 0 ; i < size ; i++) {
                    int[] point = queue.poll();
                    for(int dir[] : dirs) {
                        int x = point[0] + dir[0];
                        int y = point[1] + dir[1];
                        //if x or y is out of bound
                        //or the orange at (x , y) is already rotten
                        //or the cell at (x , y) is empty
                        //we do nothing
                        if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                        //mark the orange at (x , y) as rotten
                        grid[x][y] = 2;
                        //put the new rotten orange at (x , y) in queue
                        queue.offer(new int[]{x , y});
                        //decrease the count of fresh oranges by 1
                        count_fresh--;
                    }
                }
            }
            return count_fresh == 0 ? count-1 : -1;
        }

        // https://leetcode.com/problems/rotting-oranges/discuss/602284/Java-DFS-No-extra-space-Beats-100

        public int orangesRotting(int[][] grid) {
            if(grid == null || grid.length == 0) return -1;

            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
                }
            }

            int minutes = 2;
            for(int[] row : grid) {
                for(int cell : row) {
                    if(cell == 1) return -1;
                    minutes = Math.max(minutes, cell);
                }
            }

            return minutes - 2;
        }

        private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
            if(i < 0 || i >= grid.length /* out of bounds */
                    || j < 0 || j >= grid[0].length /* out of bounds */
                    || grid[i][j] == 0 /* empty cell */
                    || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
            ) return;
            else {
                grid[i][j] = minutes;
                rotAdjacent(grid, i - 1, j, minutes + 1);
                rotAdjacent(grid, i + 1, j, minutes + 1);
                rotAdjacent(grid, i, j - 1, minutes + 1);
                rotAdjacent(grid, i, j + 1, minutes + 1);
            }
        }

    }

    private int rot(int[][] g, int i, int j, int d) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 1) return 0;
        g[i][j] = d + 3;
        return 1;
    }
    public int orangesRotting(int[][] g) {
        int fresh = 0, d = 0;
        for (int i = 0; i < g.length; ++i) {
            for (int j = 0; j < g[i].length; ++j) {
                if (g[i][j] == 1) {
                    ++fresh;
                }
            }
        }
        for (int old_fresh = fresh; fresh > 0; ++d, old_fresh = fresh) {
            for (int i = 0; i < g.length; ++i) {
                for (int j = 0; j < g[i].length; ++j) {
                    if (g[i][j] == d + 2) {
                        fresh -= rot(g, i + 1, j, d) + rot(g, i - 1, j, d) +
                                rot(g, i, j + 1, d) + rot(g, i, j - 1, d);
                    }
                }
            }
            if (fresh == old_fresh) {
                return -1;
            }
        }
        return d;
    }
}
