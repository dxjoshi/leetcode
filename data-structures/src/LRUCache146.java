import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache146 {
    Map<Integer, Integer> map;
    int cap;
    List<Integer> q = new ArrayList<>();

    public LRUCache146(int capacity) {
        map = new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        if (q.size() == cap) {
            int evict = q.get(0);
            q.remove(0);
            map.put(evict, -1);
        }
        map.put(key, value);
        q.add(key);
    }

}
