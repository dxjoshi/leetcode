/*
*
* Given an integer array nums, return the number of reverse pairs in the array.
  A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
*
* */
public class ReversePairs493 {
    int[] helper;
    public int reversePairs(int[] nums) {
        this.helper = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        //Arrays.sort(nums, s, e+1);
        myMerge(nums, s, mid, e);
        return cnt;
    }

    private void myMerge(int[] nums, int s, int mid, int e){
        for(int i = s; i<=e; i++) helper[i] = nums[i];
        int p1 = s;//pointer for left part
        int p2 = mid+1;//pointer for rigth part
        int i = s;//pointer for sorted array
        while(p1<=mid || p2<=e){
            if(p1>mid || (p2<=e && helper[p1] >= helper[p2])){
                nums[i++] = helper[p2++];
            }else{
                nums[i++] = helper[p1++];
            }
        }
    }
}
