/*
*
* 567. Permutation in String
*
* Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
* In other words, return true if one of s1's permutations is the substring of s2.
*
* */
public class L567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int k = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(int i = 0; i<=s2.length()-k; i++) {
            if (isPermutation(arr1, arr2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPermutation(char[] s1, char[] s2, int idx) {
        int[] freq = new int[26];
        for (int i = 0; i< s1.length; i++,idx++) {
            freq[s1[i] - 'a']++;
            freq[s2[idx] - 'a']--;
        }
        for (int i = 0; i< 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
