/*
*
* 20. Valid Parentheses
*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* An input string is valid if:
* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
*
* */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int idx = -1;
        char c = ' ', d = ' ';

        for (int i = 0; i< s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                arr[++idx] = c;
            } else {
                if (idx > -1 && (
                        (arr[idx] == '(' && c == ')') ||
                                (arr[idx] == '[' && c == ']') ||
                                (arr[idx] == '{' && c == '}'))) {
                    --idx;
                } else {
                    return false;
                }
            }
        }
        return idx != -1 ? false : true;

    }
}
