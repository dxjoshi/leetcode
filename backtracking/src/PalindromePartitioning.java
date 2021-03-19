/*
*
* 131. Palindrome Partitioning
*
* Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
* A palindrome string is a string that reads the same backward as forward.
* */
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        obj.partition("aab");
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s.toCharArray(), result, new ArrayList<>(), 0, 0);
        return result;
    }

    public void solve(char[] s, List<List<String>> result,
                      List<String> list, int pivot, int size ) {
        if (pivot == s.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (pivot > s.length) {
            return;
        }

        String str = "";
        int i = pivot;
        while (i< s.length) {
            str = str + s[i];
            if (isPalindrome(str)) {
                list.add(str);
                solve(s, result, list, i+1, size);
                list.remove(list.size()-1);
            }
            i++;

        }


    }

    public boolean isPalindrome(String str) {
        if (str.length()==1) {
            return true;
        }
        boolean result = true;
        int i = 0;
        int j = str.length()-1;
        while (i<j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return result;
    }
}