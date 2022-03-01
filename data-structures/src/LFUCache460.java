import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache460 {
/*
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.
*/

    // https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet
    // https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList

    /* This will store the minimum frequency which will be needed to evict if capacity exceeds */
    private int min;

    /* Capacity of the cache */
    private final int capacity;

    /* Map from key to value */
    private final HashMap<Integer, Integer> keyToVal;

    /* Map from key to frequency of key */
    private final HashMap<Integer, Integer> keyToCount;

    /* Map from count as key to LinkedHashSet of keys with corresponding count
    LinkedHashSet maintains the insertion order. Elements gets sorted in the same sequence in which they have         been added to the Set */
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public LFUCache460(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) /* If there is no such key in the keyToVal map */
            return -1;

        int count = keyToCount.get(key); /* If it exists, we get the count of that key */
        countToLRUKeys.get(count).remove(key); /* remove key from current count (since we will inc count) */
        if (count == min && countToLRUKeys.get(count).size() == 0)
            min++; /* nothing in the current min bucket */

        putCount(key, count + 1); /* add the key to keyToCount map with incremented count and add the key to                                        corresponding LinkedHashSet in the countToLRUKeys map. */
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) /* If capacity is alrady 0 or negative, we cannot put */
            return;

        /* If key is already present in keyToVal map and just the value is needed to be changed */
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value); // update key's value
            int count = keyToCount.get(key); // we get the old count of that key
            countToLRUKeys.get(count).remove(key); // remove key from current count (since we will inc count)
            if (count == min && countToLRUKeys.get(count).size() == 0)
                min++; // nothing in the current min bucket

            putCount(key, count + 1); // add the key to keyToCount map with incremented count and add the key                                           to corresponding LinkedHashSet in the countToLRUKeys map.
            return;
        }

        /* If the map exceeds the capacity, remove the first key with minimum count */
        if (keyToVal.size() >= capacity)
            evict(countToLRUKeys.get(min).iterator().next());
/* evict LRU from this min count bucket
            This evict function does two things :
            1.) Remove the key from LinkedHashSet correspondinf to minCount
            2.) Remove key from keyToVal map

            Also, we used iterator.next() since the least recently+frequently used value to be removed is the first element in LinkedHashSet with the lowest count/frequency.
            */

        min = 1;
        putCount(key, min); // adding new key and count
        keyToVal.put(key, value); // adding new key and value
    }

    private void evict(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }

    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }

}
