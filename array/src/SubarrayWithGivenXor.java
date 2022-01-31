import java.util.HashMap;

/*
*
Problem Description
Given an array of integers A and an integer B.
Find the total number of subarrays having bitwise XOR of all elements equals to B.
*
* */
public class SubarrayWithGivenXor {
        public int solve(int[] A, int B) {
            HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
            int c = 0;
            int cpx = 0;
            int n = A.length;

            for(int i = 0;i<n;i++) {
                cpx = cpx ^ A[i];
                int cpy = cpx^B;
                if(visited.get(cpx^B) != null)
                    c += visited.get(cpx ^ B);
                if(cpx == B) {
                    c++;
                }
                if(visited.get(cpx) != null)
                    visited.put(cpx, visited.get(cpx) + 1);
                else
                    visited.put(cpx, 1);
                //System.out.println(cpx + " - " + cpy  + " - " + c);

            }
            return c;
        }

    public static void main(String[] args) {
        SubarrayWithGivenXor obj = new SubarrayWithGivenXor();
        obj.solve(new int[]{4, 2, 2, 6, 4}, 6);
    }
}
