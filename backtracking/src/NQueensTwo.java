public class NQueensTwo {
    int distinct = 0;

    public static void main(String[] args) {
        NQueensTwo obj = new NQueensTwo();
        obj.totalNQueens(4);
    }
    public int totalNQueens(int n) {
        solve(n, 0, 0, new int[n][n], 0);
        return distinct;
    }

    public void solve(int n, int r, int c, int[][] visited, int queens) {
        System.out.println("--------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        if (r*c > (n-1)*(n-1)) {
            return;
        }
        if (queens == n) {
            distinct +=1;
            return;
        }
        for (int i = r; i < n; i++) {
            for (int j = c; j < n; j++) {
                if (isValid(i, j, n, visited)) {
                    visit(i, j, n, visited);
                    solve(n, i+1, j+1, visited, queens+1);
                    unvisit(i, j, n, visited);
                }
            }
        }

    }

    public boolean isValid(int row, int col, int n, int[][] visited) {
        // check horizontally
        for (int i = 0; i < n; i++) {
            if (visited[row][i] == 1) {
                return false;
            }
        }

        // check vertically
        for (int j = 0; j < n; j++) {
            if (visited[j][col] == 1) {
                return false;
            }
        }

        // check diagonally down
        for (int i = row, j = col; i < n && j < n; i++, j++) {
            if (visited[i][j] == 1) {
                return false;
            }
        }
        // check diagonally down
        for (int i = row, j = col; i < n && j > 0; i++, j--) {
            if (visited[i][j] == 1) {
                return false;
            }
        }
        // check diagonally down
        for (int i = row, j = col; i > 0 && j > 0; i--, j--) {
            if (visited[i][j] == 1) {
                return false;
            }
        }
        // check diagonally down
        for (int i = row, j = col; i > 0 && j < n; i--, j++) {
            if (visited[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public boolean visit(int row, int col, int n, int[][] visited) {
        // check horizontally
        for (int i = 0; i < n; i++) {
            visited[row][i] = 1;
        }

        // check vertically
        for (int j = 0; j < n; j++) {
            visited[j][col] = 1;
        }

        // check diagonally down
        for (int i = row, j = col; i < n && j < n; ) {
            visited[i][j] = 1;
            if (i < n && j < n) {
                i++; j++;
            } else if (i < n) {
                i++;
            } else if (j < n) {
                j++;
            }
        }
        // check diagonally down
        for (int i = row, j = col; i < n && j > 0; i++, j--) {
            visited[i][j] = 1;
        }
        // check diagonally down
        for (int i = row, j = col; i > 0 && j > 0; i--, j--) {
            visited[i][j] = 1;
        }
        // check diagonally down
        for (int i = row, j = col; i > 0 && j < n; i--, j++) {
            visited[i][j] = 1;
        }

        visited[row][col] = 2;
        return true;
    }

    public boolean unvisit(int row, int col, int n, int[][] visited) {
        // check horizontally
        for (int i = 0; i < n; i++) {
            visited[row][i] = 0;
        }

        // check vertically
        for (int j = 0; j < n; j++) {
            visited[j][col] = 0;
        }

        // check diagonally down
        for (int i = row, j = col; i < n && j < n; i++, j++) {
            visited[i][j] = 0;
        }
        // check diagonally down
        for (int i = row, j = col; i < n && j > 0; i++, j--) {
            visited[i][j] = 0;
        }
        // check diagonally down
        for (int i = row, j = col; i > 0 && j > 0; i--, j--) {
            visited[i][j] = 0;
        }
        // check diagonally down
        for (int i = row, j = col; i > 0 && j < n; i--, j++) {
            visited[i][j] = 0;
        }

        return true;
    }


}
