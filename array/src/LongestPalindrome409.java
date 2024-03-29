import java.util.HashMap;
import java.util.Map;

/*
*
* 409. Longest Palindrome
*
* Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
* Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*
* */
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) lowercase[temp-'a']++;
            else uppercase[temp-'A']++;
        }
        for (int i = 0; i < 26; i++){
            res+=(lowercase[i]/2)*2;
            res+=(uppercase[i]/2)*2;
        }

        return res == s.length() ? res : res+1;
    }
}
