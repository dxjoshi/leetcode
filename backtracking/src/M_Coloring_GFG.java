import java.util.List;

public class M_Coloring_GFG {
    public static boolean graphColoring2(List<Integer>[] G, int[] color, int i, int C)
    {
        int n = G.length;
        return solve2(i, G, color, n, C);
        // if (solve(i, G, color, n, C) == true) return true;
        // return false;
    }

    private static boolean isSafe2(int node, List <Integer> [] G, int[] color, int n, int col) {
        for (int it: G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }

    private static boolean solve2(int node, List<Integer>[] G, int[] color, int n, int m) {
        if (node == n) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe2(node, G, color, n, i)) {
                color[node] = i;
                if (solve2(node + 1, G, color, n, m) == true) return true;
                color[node] = 0;
            }
        }
        return false;
    }


    public boolean graphColoring(boolean graph[][], int m, int n) {
        // 0 means no color, possiblecolors (1 to m)
        int[] colors = new int[n];
        return solve(graph, colors, 0, m, n);
    }

    // node - current node(0 to n-1), m - #colors available, n - #nodes
    private boolean solve(boolean graph[][], int[] colors, int node, int m, int n){
        if(node==n) return true;
        for(int k=1;k<=m;k++){
            if(isSafe(graph, colors, node, k, n)){
                colors[node]=k;
                if(solve(graph, colors, node+1, m, n)) return true;
                colors[node]=0;
            }
        }
        return false;
    }

    private boolean isSafe(boolean[][] graph, int[]colors, int node, int i, int n){
        for(int it=0;it<n;it++){
            if(it!=node && graph[it][node] && colors[it]==i) return false;
        }
        return true;
    }


}
