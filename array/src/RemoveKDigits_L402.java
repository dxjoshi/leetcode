import java.util.HashSet;
import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/

public class RemoveKDigits_L402 {
    // https://leetcode.com/problems/remove-k-digits/discuss/88708/Straightforward-Java-Solution-Using-Stack
    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)   return "0";
        Stack<Character> stack = new Stack<>();
        for(char c : num.toCharArray()) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // corner case for same digits like "1111"
        while(k>0){
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // remove the 0 at the tail
        while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.reverse().toString();
    }
}
