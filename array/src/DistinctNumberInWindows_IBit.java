import java.util.ArrayList;
import java.util.List;

/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE:  if B > N, return an empty array.
*/
public class DistinctNumberInWindows_IBit {
    public int[] dNums(int[] A, int B) {
        if (A == null || A.length <= B) return A;
        int[] res = new int[A.length-B+1];
        List<Integer> list = new ArrayList<>();
        int count = 0, j = 0;

        for (int i = 0; i < B; i++)    {
            if (!list.contains(A[i]))    {
                count++;
            }
            list.add(A[i]);
        }

        for (int i = B+1; i < A.length; i++)    {
            res[j++] = count;
            int temp = list.get(0);
            list.remove(0);
            if (temp != A[i])    {
                if (!list.contains(temp))   count--;
                if  (!list.contains(A[i]))  {
                    count++;
                }
            }
            list.add(A[i]);
            System.out.println(list);
        }
        return res;
    }
}
