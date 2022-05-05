import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*Fastest Correct solution*/
    public int[] dNums3(int[] A, int B) {
        if (B>A.length) return new int[0];

        int[] result = new int[A.length-B+1];

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i=0; i<A.length; i++) {

            Integer c1 = count.remove(A[i]);
            count.put(A[i], c1 == null ? 1 : c1+1);
            if (i<B-1) {
                continue;
            }

            if (i>B-1) {
                Integer c = count.remove(A[i-B]);
                if (c != null && c > 1) count.put(A[i-B], c-1);
            }

            result[i-(B-1)] = count.size();
        }

        return result;
    }

    /*Correct solution*/
    public int[] dNums1(int[] A, int B) {
        if (B > A.length) return null;

        int[] ans = new int[A.length - B + 1];
        HashMap<Integer, Integer> h = new HashMap<>();
        int count = B;

        for (int i = 0; i < B; i++) {
            int tmp = h.getOrDefault(A[i], -1);
            if (tmp != -1) {
                count--;
            }
            h.put(A[i], tmp + 1);
        }
        ans[0] = count;
        int ansIdx = 1;
        for (int i = B; i < A.length; i++) {
            //System.out.print("h: " + h);
            Integer tmp = h.remove(A[i - B]);
            //System.out.println(" tmp: " + tmp);
            if (tmp == 0) {
                count--;
            } else {
                h.put(A[i-B], tmp - 1);
            }

            tmp = h.getOrDefault(A[i], -1);
            if (tmp == -1) {
                count++;
            }

            h.put(A[i], tmp + 1);
            ans[ansIdx++] = count;
        }

        return ans;
    }

    /*Correct solution-2*/
    public int[] dNums2(int[] A, int B) {

        int n = A.length;
        if(B > n ) return new int[0];

        List<Integer> result = new ArrayList<Integer>();

        int i=0,j=i;

        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();

        while(i <= n-B){
            while(j-i+1 <= B){
                int count = mp.getOrDefault(A[j],0);
                mp.put(A[j],count+1);
                j++;
            }

            result.add(mp.size());

            if(mp.get(A[i]) > 1){
                int count = mp.get(A[i]);
                mp.put(A[i],count-1);
            }else{
                mp.remove(A[i]);
            }
            i++;
        }

        int arr [] = new int[result.size()];

        int k=0;

        for(int x:result){
            arr[k++] = x;
        }

        return arr;
    }
}
