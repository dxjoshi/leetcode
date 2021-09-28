/*
*
* 547. Number of Provinces
*
* There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
*
* A province is a group of directly or indirectly connected cities and no other cities outside of the group.
*
* You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
*
* Return the total number of provinces.
*
* */
public class NumberofProvinces547 {
    public int findCircleNum(int[][] isConnected) {
        int count = 0, l=isConnected.length;

        for(int i = 0; i< l; i++) {
            count += dfs(isConnected, i);
        }

        return count;
    }

    int dfs(int[][] arr, int i) {
        if (i < 0 || i >= arr.length || arr[i][i] == 0) {
            return 0;
        }

        for (int j=0; j<arr.length; j++) {
            if (arr[i][j] == 1) {
                arr[i][j] = 0;
                dfs(arr, j);
            }
        }
        return 1;
    }

}
