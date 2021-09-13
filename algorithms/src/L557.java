/*
*
* 557. Reverse Words in a String III
*
* Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*
* */
public class L557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                solve(chars, begin,i-1);
                begin = i+1;
            }
        }
        if (begin < chars.length) {
            solve(chars, begin, chars.length-1);
        }
        return String.valueOf(chars);
    }

    public void solve(char[] s, int i, int j) {
        while (i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            --j;++i;
        }
    }
}
