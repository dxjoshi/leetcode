/*
*
* 5. Longest Palindromic Substring
*
* Given a string s, return the longest palindromic substring in s.
*
*
* */
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        char[] ca = s.toCharArray();
        int rs = 0, re = 0;
        int max = 0;
        for(int i = 0; i < ca.length; i++) {
            if(isPalindrome(ca, i - max - 1, i)) {
                rs = i - max - 1; re = i;
                max += 2;
            } else if(isPalindrome(ca, i - max, i)) {
                rs = i - max; re = i;
                max += 1;
            }
        }
        return s.substring(rs, re + 1);
    }

    private boolean isPalindrome(char[] ca, int s, int e) {
        if(s < 0) return false;

        while(s < e) {
            if(ca[s++] != ca[e--]) return false;
        }
        return true;
    }

}
