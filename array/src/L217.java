/*
*
* 217. Contains Duplicate
* 
* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
* */
import java.util.HashSet;
import java.util.Set;

public class L217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> bucket = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (bucket.contains(nums[i])) {
                return true;
            } else {
                bucket.add(nums[i]);
            }
        }
        return false;
    }
}
