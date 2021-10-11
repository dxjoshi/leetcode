import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
*
* 451. Sort Characters By Frequency
*
* Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
*
* Return the sorted string. If there are multiple answers, return any of them.
*
* */
public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char key = entry.getKey();
            int value = entry.getValue();
            for(int k=0; k< value; k++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
