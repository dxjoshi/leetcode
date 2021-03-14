/*
*
* 1415. The k-th Lexicographical String of All Happy Strings of Length n
*
* A happy string is a string that: consists only of letters of the set ['a', 'b', 'c'].
* s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
* For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and
* strings "aa", "baa" and "ababbc" are not happy strings.
* Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
* Return the kth string of this list or return an empty string if there are less than k happy strings of length n
*
* */
import java.util.ArrayList;
import java.util.List;

public class KthLexicographicalString {
    char[] input = new char[]{'a','b','c'};

    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        //char[] str = new char[n];
        String str ="";
        solve(result, str, n, 0, 0);
        System.out.println(result);
        return result.size() >= k ? result.get(k-1) : "";

    }

    public void solve(List<String> result, String str, int n, int pos, int idx) {
        if (pos == n) {
            result.add(str);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (pos > 0 && input[i] == str.charAt(pos-1)) {
                continue;
            }
            str += input[i];
            solve(result, str, n, pos+1, idx);
            str = str.substring(0, str.length()-1);
        }
    }

    public static void main(String[] args) {
        KthLexicographicalString obj = new KthLexicographicalString();
        obj.getHappyString(3, 9);

    }
}
