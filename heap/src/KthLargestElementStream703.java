import java.util.PriorityQueue;

/*
*
* 703. Kth Largest Element in a Stream
*
* Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
*
* Implement KthLargest class:
*
* KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
* int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
*
* */
public class KthLargestElementStream703 {
    PriorityQueue<Integer> minHeap;
    int size;
    public KthLargestElementStream703(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>(k);
        for (int val : nums) {
            add(val);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > size) {
            minHeap.poll();
        }
        return minHeap.peek();

    }
}
