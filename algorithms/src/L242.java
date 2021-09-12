/*
*
* 242. Valid Anagram
*
* Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*
* */
public class L242 {
    public boolean isAnagram(String s, String t) {
        if (s==null && t==null) {
            return true;
        } else if (s==null || t==null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }

        char[] count = new char[26];
        for (int i = 0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

        }
        for (int j = 0; j< count.length; j++) {
            if (count[j] != 0) {
                return false;
            }
        }
        return true;

    }
}