/*
*
* 169. Majority Element
*
* Given an array nums of size n, return the majority element.
* The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*
* */
public class L169 {
    public int majorityElement(int[] nums) {
        //moores algo
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }
            if (result != nums[i]) {
                count--;
            } else {
                count++;
            }
        }
        return result;
    }
}
