/*
*
* 784. Letter Case Permutation
*
* Given a string S, we can transform every letter individually to be lowercase or uppercase
* to create another string.
* Return a list of all possible strings we could create. You can return the output in any order.
* */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LetterCasePermutation {
    public static void main(String[] args) {
        LetterCasePermutation obj = new LetterCasePermutation();
        Set<String> result = new HashSet<>(obj.letterCasePermutation1("a1b2"));
        System.out.println(result);
    }
    public List<String> letterCasePermutation(String S) {
        Set<String> result = new HashSet<>();
        String str="";
        solve(S, 0, false, result, str);
        solve(S, 0, true, result, str);
        return result.stream().collect(Collectors.toList());
    }

    public void solve(String S, int pos, boolean uppercase, Set<String> result, String str) {
        //end condition
        System.out.println(str);
        if  (pos == S.length()) {
            result.add(str);
            return;
        }

        str += S.charAt(pos);
        // 0 - lowercase, 1- uppercase
        if (uppercase) {
            str = str.substring(0, pos) + str.substring(pos).toUpperCase();
        } else {
            str = str.substring(0, pos) + str.substring(pos).toLowerCase();
        }

        solve(S, pos+1, !uppercase, result, str);
        solve(S, pos+1, uppercase, result, str);
    }

    public List<String> letterCasePermutation1(String S) {
        if (S == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        solve(S.toCharArray(), 0, result);
        return result;
    }

    public void solve(char[] S, int pos, List<String> result) {
        //end condition
        if  (pos == S.length) {
            result.add(new String(S));
            return;
        }

        if (Character.isDigit(S[pos])) {
            solve(S, pos+1, result);
            return;
        }

        S[pos] = Character.toUpperCase(S[pos]);
        solve(S, pos+1, result);

        S[pos] = Character.toLowerCase(S[pos]);
        solve(S, pos+1, result);
    }

}