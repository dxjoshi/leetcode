public class KthElementOfTwoSortedArrays_GFG {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m){
            return kthElement(arr2, arr1, m, n, k);
        }

        int low = Math.max(0,k-m), high = Math.min(k,n);

        while(low <= high) {
            int cut1 = (low+high) >> 1;
            int cut2 = k-cut1;
            long l1 = cut1 == 0 ? Long.MIN_VALUE : arr1[cut1-1];
            long l2 = cut2 == 0 ? Long.MIN_VALUE : arr2[cut2-1];
            long r1 = cut1 == n ? Long.MAX_VALUE : arr1[cut1];
            long r2 = cut2 == m ? Long.MAX_VALUE : arr2[cut2];

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            } else if (l1 > r2){
                high = cut1-1;
            } else {
                low = cut1+1;
            }
        }
        return 1;
    }

}
