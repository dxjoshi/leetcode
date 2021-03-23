/*
*
* 392. Is Subsequence
*
* Given two strings s and t, check if s is a subsequence of t.
* A subsequence of a string is a new string that is formed from
* the original string by deleting some (can be none) of the characters
* without disturbing the relative positions of the remaining characters.
* (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
* */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        return solve(s.toCharArray(), t.toCharArray(), 0, 0);

    }

    public boolean solve(char[] s, char[] t, int si, int ti) {
        if (si == s.length) {
            return true;
        }
        if (ti == t.length) {
            return false;
        }

        if (s[si] == t[ti]) {
            si += 1;
        }
        ti += 1;
        return solve(s, t, si, ti);
    }
}
