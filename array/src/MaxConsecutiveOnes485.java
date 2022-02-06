/*
*
* Given a binary array nums, return the maximum number of consecutive 1's in the array.
* */
public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, sum = 0;
        for (int num : nums) {
            if (num == 1) {
                sum++;
            } else {
                res = Math.max(res, sum);
                sum = 0;
            }
        }
        return Math.max(res, sum);
    }
}
