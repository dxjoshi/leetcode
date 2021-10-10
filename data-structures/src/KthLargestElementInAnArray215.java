import java.util.PriorityQueue;

/*
*
* 215. Kth Largest Element in an Array
*
* Given an integer array nums and an integer k, return the kth largest element in the array.
* Note that it is the kth largest element in the sorted order, not the kth distinct element.
*
* */
public class KthLargestElementInAnArray215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
