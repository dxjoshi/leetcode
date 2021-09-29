import java.util.ArrayDeque;
import java.util.Queue;

/*
*
* 1091. Shortest Path in Binary Matrix
*
* Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
*
* A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
*
* All the visited cells of the path are 0.
* All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
* The length of a clear path is the number of visited cells of this path.
*
*
* */
public class ShortestPathinBinaryMatrix1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {

        /*Check if the first element is accessible, else return -1*/
        if (grid[0][0] == 1)
            return -1;

        /*Declaring the length of grid (n == m for a n*m matrix)*/
        int n = grid.length;

        /*Adjacent cells are connected 8-directionally, hence we can move in any of the 8 directions*/
        int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        /*Initializing queue for BFS with the first element with distance 1*/
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});

        /*While there are still elements in the queue*/
        while (!queue.isEmpty()) {

            /*Pop the first element*/
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            /*If the current element is the goal cell, return the steps required*/
            if (x == (n - 1) && y == (n - 1))
                return steps;

            /*Add direction coordinates from the dirs list to the current cell*/
            for (int[] dir: dirs) {

                int dx = dir[0];
                int dy = dir[1];

                /*Check if we are within bounds of the grid and check if we can visit the cell i.e. if it's 0*/
                if ((0 <= x + dx)
                        && (x + dx < n)
                        && (0 <= y + dy)
                        && (y + dy < n)
                        && (grid[x + dx][y + dy] == 0)) {

                    /*If we can visit this cell, mark it as 1 so that we can avoid the need of a visited matrix
                    We do this to make sure we don't travese this cell again*/
                    grid[x + dx][y + dy] = 1;
                    /*Append the current cell to the queue for further exploration*/
                    queue.add(new int[]{x + dx, y + dy, steps + 1});
                }
            }
        }
        /*If no path to goal state exists, simply return -1*/
        return -1;
    }
}
