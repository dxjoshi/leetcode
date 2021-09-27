import java.util.ArrayList;
import java.util.List;

/*
*
* 763. Partition Labels
*
* You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
* Return a list of integers representing the size of these parts.
*
* */
public class PartitionLabels763 {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];

        for(int i = 0; i < S.length(); i++) {
            map[S.charAt(i)-'a'] = i;
        }

        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
