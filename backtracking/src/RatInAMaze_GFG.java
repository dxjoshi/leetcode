import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMaze_GFG {
    static int[] d = {0, 1, 0, -1, 0};
    static char[] v = {'R', 'D', 'L','U'};
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] vis = new int[n][n];
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         vis[i][j] = m[i][j];
        //     }
        // }
        for(int i=0; i<n; i++) {
            Arrays.fill(vis[i], -1);
        }
        ArrayList<String> res = new ArrayList<String>();
        solve(m, vis, n, 0, 0, "", res);
        return res;
    }


    public static void solve(int[][] m, int[][] vis, int n, int r, int c,
                             String str, ArrayList<String> res) {
        if (r<0 || r>=n || c<0 || c>=n || m[r][c] == 0 || vis[r][c] != -1) {
            return;
        }

        if (n-1==r && n-1==c) {
            res.add(str);
            return;
        }

        vis[r][c] = 1;
        for(int i=0; i<4; i++) {
            solve(m, vis, n, r+d[i], c+d[i+1], str + v[i], res);
        }
        vis[r][c] = -1;
    }

}
