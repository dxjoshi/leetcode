import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
*
* 347. Top K Frequent Elements
*
* Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*
* */
public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        while(!minHeap.isEmpty()){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res[--k] = entry.getKey();
        }
        return res;
    }

}
