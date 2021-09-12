/*
*
* 387. First Unique Character in a String
*
* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
*
* */
public class L387 {
    public int firstUniqChar(String s) {
        int res = -1;
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        for(int i = 0; i < chars.length; i++) {
            freq[chars[i] - 'a']++;
        }
        for(int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
