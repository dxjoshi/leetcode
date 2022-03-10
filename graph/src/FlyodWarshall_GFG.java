
/*
* All pair shortest path algorithm
* https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1#
* */
public class FlyodWarshall_GFG {
    public void shortest_distance(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;


        for (int k=0; k<m; k++)  {
            for (int i=0; i<m; i++)  {
                for (int j=0; j<m; j++)  {
                    if(matrix[i][k]==-1 || matrix[k][j]==-1) continue;
                    if(matrix[i][j]==-1) {
                        matrix[i][j] = matrix[i][k]+matrix[k][j];
                    } else {
                        if(matrix[i][k] + matrix[k][j] < matrix[i][j])  {
                            matrix[i][j] = matrix[i][k] + matrix[k][j];
                        }
                    }
                }
            }
        }
    }

}
