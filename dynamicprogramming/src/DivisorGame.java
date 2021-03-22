/*
*
* 1025. Divisor Game
*
* Alice and Bob take turns playing a game, with Alice starting first.
*
* Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
*
* Choosing any x with 0 < x < N and N % x == 0.
* Replacing the number N on the chalkboard with N - x.
* Also, if a player cannot make a move, they lose the game.
* 
* Return True if and only if Alice wins the game, assuming both players play optimally.
* */
public class DivisorGame {

    int count = 0;

    public static void main(String[] args) {
        DivisorGame obj = new DivisorGame();
        obj.divisorGame(2);
    }

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = false;
        solve(N, dp, 2);       // for bottom up
        return dp[N];
    }

    // bottom up
    public void solve(int N, boolean[] dp, int curr) {
        if (curr > N ) {
            return;
        }
        dp[curr] = !dp[curr-1];
        solve(N, dp, curr+1);
    }
}
