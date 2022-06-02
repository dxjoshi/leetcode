import java.util.ArrayList;

public class AllocateBooks_BinarySearch {
    static boolean isPossible(ArrayList < Integer > A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sumAllocated + A.get(i) > pages) {
                cnt++;
                sumAllocated = A.get(i);
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += A.get(i);
            }
        }
        if (cnt < students) return true;
        return false;
    }

    public static int books(ArrayList< Integer > A, int B) {
        if (B > A.size()) return -1;
        int low = A.get(0);
        int high = 0;
        for (int i = 0; i < A.size(); i++) {
            high = high + A.get(i);
            low = Math.min(low, A.get(i));
        }
        while (low <= high) {
            int mid = (low + high) >> 1;

            if (isPossible(A, mid, B)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return res -> this is also correct
        return low;
    }

    public static int books2(ArrayList<Integer> A, int B) {
        int lo = 1;
        int hi = 0;
        int mid = 0;
        for(Integer i : A) {
            lo = Math.min(lo, i);
            hi += i;
        }
        int res = 0;
        while (lo <= hi) {
            mid = lo +(hi-lo)/2;
            if (isPossible(A, mid, B)) {
                hi = mid-1;
                res = mid;
            } else {
                lo = mid+1;
            }
        }
        return res;
    }
}
