import java.util.Stack;

/*
*
* 1249. Minimum Remove to Make Valid Parentheses
*
* Given a string s of '(' , ')' and lowercase English characters.
*
* Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
*
* Formally, a parentheses string is valid if and only if:
*
* It is the empty string, contains only lowercase characters, or
* It can be written as AB (A concatenated with B), where A and B are valid strings, or
* It can be written as (A), where A is a valid string.
*
* */
public class MinimumRemovetoMakeValidParentheses1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty()) st.pop();
                else sb.setCharAt(i, '*');
            }
        }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }

/*
//    MY SOLUTION
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int diff = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(ch);
                diff += 1;
            }
            else if (ch == ')') {
                if (diff >=1) {
                    stack.push(ch);
                    diff -= 1;
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (diff > 0 && ch =='(') {
                diff -= 1;
                continue;
            }
            if (diff < 0 && ch ==')') {
                diff += 1;
                continue;
            }
            sb.append(ch);
        }
        return sb.reverse().toString();

    }
*/
}
