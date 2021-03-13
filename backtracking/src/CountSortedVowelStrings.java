/*
*
* 1641. Count Sorted Vowel Strings
*
* Given an integer n, return the number of strings of length n
* that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
*
* A string s is lexicographically sorted if for all valid i,
* s[i] is the same as or comes before s[i+1] in the alphabet.
*
* */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        // n - length of string
        // m - vowel at zero-based index[a,e,i,o,u]
        return solve(n, 0);

    }

    public int solve(int n, int m) {
        // end condition
        if  (n == 0) return 1;  // string found
        if  (m == 5) return 0;  // no vowels left

        int sum = 0;
        sum = solve(n, m+1);    // moving to next vowel
        sum += solve(n-1, m);   // taking the vowel
        return sum;
    }
}
