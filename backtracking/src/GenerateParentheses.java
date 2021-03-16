import java.util.ArrayList;
import java.util.List;

/*
*
* 22. Generate Parentheses
*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
* */
public class GenerateParentheses {
    char[] brackets = new char[]{'(', ')'};

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        solve(n, result, str, 0, 0);
        return result;
    }

    public void solve(int n, List<String> result, StringBuilder str, int count, int diff) {
        if  (count > 2*n || diff < 0) {
            return;
        }
        if  (count == 2*n && diff == 0) {
            result.add(str.toString());
            return;
        }

        for (int i = 0; i< brackets.length; i++) {
            str.append(brackets[i]);

            if (i==0 || (i==1 && diff>0))
                solve(n, result, str, count+1, i==0 ? diff+1: diff-1);
            str.deleteCharAt(str.length() -1 );
        }
    }
}
