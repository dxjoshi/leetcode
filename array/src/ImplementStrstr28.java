/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/
public class ImplementStrstr28 {
    // public int strStr(String haystack, String needle) {
    //   for (int i = 0; ; i++) { // The length of haystack
    //     for (int j = 0; ; j++) { // The length of needle
    //       if (j == needle.length()) return i; // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
    //       if (i + j == haystack.length()) return -1; // This happens when we run out of elements in haystack, but there are still elements in needle.
    //       if (needle.charAt(j) != haystack.charAt(i + j)) break; // We stop comparing after needle[j], so i will be incremented and cycle repeats itself.
    //     }
    //   }
    // }

    // https://leetcode.com/problems/implement-strstr/discuss/535326/Java-KMP-Solution-O(m%2Bn)-Clean-code

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lps = computeKMPTable(needle);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i; ++j;
                if (j == m) return i - m; // found solution
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++; // don't match -> go to next character of `haystack` string
            }
        }
        return -1;
    }

    private int[] computeKMPTable(String pattern) {
        int i = 1, j = 0, n = pattern.length();
        int[] lps = new int[n];
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++; // don't match -> go to next character
            }
        }
        return lps;
    }
}
