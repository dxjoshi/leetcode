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
    private int rot(int[][] g, int i, int j, int d) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 1) return 0;
        g[i][j] = d + 3;
        return 1;
    }
    public int orangesRotting(int[][] g) {
        int fresh = 0, d = 0;
        for (int i = 0; i < g.length; ++i)
            for (int j = 0; j < g[i].length; ++j)
                if (g[i][j] == 1) ++fresh;
        for (int old_fresh = fresh; fresh > 0; ++d, old_fresh = fresh) {
            for (int i = 0; i < g.length; ++i)
                for (int j = 0; j < g[i].length; ++j)
                    if (g[i][j] == d + 2)
                        fresh -= rot(g, i + 1, j, d) + rot(g, i - 1, j, d) +
                                rot(g, i, j + 1, d) + rot(g, i, j - 1, d);
            if (fresh == old_fresh) return -1;
        }
        return d;
    }
}
