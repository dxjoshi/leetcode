/*
*
* 740. Delete and Earn
*
* You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
* Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
* Return the maximum number of points you can earn by applying the above operation some number of times.
*
*
* */
public class DeleteandEarn740 {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }

}
