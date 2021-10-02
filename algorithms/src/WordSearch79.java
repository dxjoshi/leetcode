/*
*
* 79. Word Search
*
* Given an m x n grid of characters board and a string word, return true if word exists in the grid.
* The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*
* */
public class WordSearch79 {
/*
    // MY SOLUTION: 220 ms, IDEAL SOLUTION: 80 ms
    int[] dir = {0, 1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (solve(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, String word, boolean[][] visited, int i, int j, int idx) {
        if (idx == word.length()) return true;

        if (i<0 || i>=board.length || j<0 || j>=board[0].length ||
                visited[i][j] == true || idx > word.length() || word.charAt(idx) != board[i][j]) {
            return false;
        }

        boolean result = false;
        for(int k=0; k<4; k++) {
            visited[i][j] = true;
            result = result || solve(board, word, visited, i+dir[k], j+dir[k+1], idx+1);
            visited[i][j] = false;
        }
        return result;
    }
*/

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        }
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        //it is like setting board[x][y] = '#'. The range of char is between 0 - 255.
        // By doing xor with 256, board[x][y] becomes a number >= 256 and thus is different from any character.
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
                dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
                dfs(board, words, idx + 1, x - 1, y) ;
        board[x][y] ^= 256;
        return exist;
    }
}
