/*
*
* 130. Surrounded Regions
*
* Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
* A region is captured by flipping all 'O's into 'X's in that surrounded region.
*
* */
public class SurroundedRegions130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if ((i == 0 || i == board.length-1 || j == 0 || j == board[i].length-1)
                        && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == 'B')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O')
            return;
        board[i][j] = 'B';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
