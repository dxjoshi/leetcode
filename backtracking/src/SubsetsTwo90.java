import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* 90. Subsets II
*
* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
* The solution set must not contain duplicate subsets. Return the solution in any order.
*
* */
public class SubsetsTwo90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> result) {
        // As we need empty sets so add empty here first
        result.add(new ArrayList<>(ds));

        for (int i = index; i < nums.length; i++) {
            // Avoid duplicates
            if (i != index && nums[i] == nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, result);
            ds.remove(ds.size() - 1);
        }
    }

}
