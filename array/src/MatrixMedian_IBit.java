import java.util.ArrayList;

/*
Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.
*/

public class MatrixMedian_IBit {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //Find min and max ele in the matrix
        for(int i=0; i<n; i++){
            max = Math.max(max, A.get(i).get(m-1));
            min = Math.min(min, A.get(i).get(0));
        }

        int l = min;
        int h = max;
        // # elements we want to count using binSearch
        int req= ((n*m))/2;
        int ans =0;
        while(l<=h){
            int count = 0;
            int mid = l + (h-l)/2;

            for(int i=0; i<n; i++){
                // count #elements less than mid in each row and add all to get the count of such elements in the matrix
                count+= binarySearch(A.get(i), mid);
            }

            // if count < desired count, we update low to increase the mid value ELSE update high and save mid as probable answer
            if(count<req+1){
                l=mid+1;
            } else{
                ans = mid;
                h=mid-1;
            }
        }
        return ans;
    }

    public int binarySearch(ArrayList<Integer> A, int n){
        if(A.get(0) > n)
            return 0;

        int low,mid,high;

        low = 0;
        mid = 0;
        high = A.size() - 1;

        while(low <= high) {
            mid = (low + high) / 2;
            if(A.get(mid) > n)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
