import java.util.Stack;

public class NearestSmallestElement_IBit {
    public int[] prevSmaller(int[] A) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<A.length; i++) {

            while (!stack.empty() && A[i] <= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(A[i]);

        }
        return res;
    }

}
