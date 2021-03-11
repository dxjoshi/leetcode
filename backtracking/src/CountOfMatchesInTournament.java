/*
* 1688. Count of Matches in Tournament
*
* You are given an integer n, the number of teams in a tournament that has strange rules:
*
* If the current number of teams is even, each team gets paired with another team.
* A total of n / 2 matches are played, and n / 2 teams advance to the next round.
*
* If the current number of teams is odd, one team randomly advances in the tournament,
* and the rest gets paired. A total of (n - 1) / 2 matches are played,
* and (n - 1) / 2 + 1 teams advance to the next round.
*
*
*/

public class CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        // path (taken for odd/even number of teams)
        // selection list (teams left)
        // end condition (0 or 1 teams)
        if  (n == 0 || n == 1) return 0;
        return (n%2 == 0) ?  numberOfMatches(n/2) + n/2 : numberOfMatches(n/2) + (n/2 + 1);
    }
}
