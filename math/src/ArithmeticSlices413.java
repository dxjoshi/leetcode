/*
*
* 413. Arithmetic Slices
*
* An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
*
* For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
* Given an integer array nums, return the number of arithmetic subarrays of nums.
*
* A subarray is a contiguous subsequence of the array.
*
* */
public class ArithmeticSlices413 {
/*
    "curr" the number of different "Arithmetic Slices" ends at index = i
    a small example :
    we have :[1, 2, 3, 4]
    index = 2, we have curr = 1, sum = 1, which is [1,2,3];
    index = 3, curr = 2, sum = 2 + 1 = 3; because we look back from index = 3 which is 4 , we will have two "Arithmetic Slices", which is [2,3,4] and [1,2,3,4].
*/
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
