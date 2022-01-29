import java.util.ArrayList;
import java.util.List;

/*
*
* Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
*
* */
public class MajorityElementTwo229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        int count = 0, countTwo = 0;
        int result = 0, resultTwo = 0;
        for (int i=0; i<nums.length; i++) {
            if (result == nums[i]) {
                count++;
            } else if (resultTwo == nums[i]) {
                countTwo++;
            } else if (count == 0) {
                result = nums[i];
                count++;
            } else if (countTwo == 0) {
                resultTwo = nums[i];
                countTwo++;
            } else {
                count--;
                countTwo--;
            }
        }
        count=0;
        countTwo=0;
        for (int j=0; j<nums.length; j++) {
            if (result == nums[j]) {
                count++;
            } else if (resultTwo == nums[j]) {
                countTwo++;
            }
        }
        if  (count > nums.length/3) {
            list.add(result);
        }
        if (countTwo > nums.length/3) {
            list.add(resultTwo);
        }
        return list;
    }
}
