import java.util.LinkedList;
import java.util.Queue;

/*
*
* 200. Number of Islands
*
* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*
* */
public class NumberofIslands200 {
    // https://leetcode.com/problems/number-of-islands/discuss/56364/Java-Union-Find-Solution
    // https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution

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

//    BFS Version:

    public int numIslandsBFS(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }

        return count;
    }

    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0')
                    continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

}
