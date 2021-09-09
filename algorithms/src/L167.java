/*
*
* 167. Two Sum II - Input array is sorted
*
* Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
* Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
*
* */
public class L167 {
    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length-1;
        int sum = 0;
        while(begin < end) {
            sum = numbers[begin] + numbers[end];
            if(sum == target) {
                break;
            } else if(sum > target) {
                --end;
            } else {
                ++begin;
            }
        }
        int[] res = new int[2];
        res[0] = begin+1;
        res[1] = end+1;
        return res;
    }
}
