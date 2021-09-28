import java.util.ArrayList;
import java.util.List;

/*
*
* 438. Find All Anagrams in a String
*
* Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
* An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*
* */
public class FindAllAnagramsinString438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;

        List<Integer> ans = new ArrayList<>();
        for (int r = 0, l = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            cnt[c]--;
            while (cnt[c] < 0) { // If number of characters `c` is more than our expectation
                cnt[s.charAt(l)]++;  // Slide left until cnt[c] == 0
                l++;
            }

            if (cnt[c] == 0 && r - l + 1 == p.length()) {
                // Since cnt of all chars >= 0 and cnt[c] == 0 and r-l+1==p.length
                // -> We already filled enough `p.length()` chars
                ans.add(l); // Add `l` to our result
                cnt[s.charAt(l)]++; // Go next
                l++;
            }
        }
        return ans;
    }
}
