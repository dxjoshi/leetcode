/*
*
* 383. Ransom Note
*
* Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
* Each letter in magazine can only be used once in ransomNote.
*
* */
public class L383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--freq[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }

        return true;

    }
}
