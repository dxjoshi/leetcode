import java.util.HashSet;
import java.util.Set;

/*
*
* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.
*
* */
public class LongestConsecutiveSequence128 {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums) set.add(num);
        int max = 1;

        for (int num : nums) {
            if(set.remove(num)) {
                int val = num;
                int sum = 1;
                while (set.remove(val-1))  val--;
                sum += num-val;
                val = num;

                while (set.remove(val+1))  val++;
                sum += val-num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
