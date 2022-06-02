public class NthRoot_Practice {

    public static void main(String[] args) {
        System.out.println(nthRoot(3, 27));
        System.out.println(kthelement(new int[]{2,3,6,7,9}, new int[]{1,4,8,10}, 5, 4, 5));

    }

    public static double nthRoot(int n, int m) {
        double lo = 1;
        double hi = m;
        double mid = 0;
        double eps = 1e-3;
        while((hi-lo) > eps) {
            mid = lo +(hi-lo)/2;
            if(Math.pow(mid,n) > m) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    public static int kthelement(int arr1[], int arr2[], int m, int n, int k) {
        if (m > n) return kthelement(arr1, arr2, n, m, k);
        int lo = Math.min(0,k-m);
        int hi = Math.min(n,k);
        int c1, c2;
        while (lo <= hi) {
            c1 = lo +(hi-lo)/2;
            c2 = k-c1;
            int l1 = c1 == 0 ? Integer.MIN_VALUE : arr1[c1-1];
            int l2 = c2 == 0 ? Integer.MIN_VALUE : arr2[c2-1];

            int r1 = c1 == n ? Integer.MAX_VALUE : arr1[c1];
            int r2 = c2 == m ? Integer.MAX_VALUE : arr2[c2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2){
                hi = c1-1;
            } else {
                lo = c1+1;
            }
        }
        return -1;

    }
}
