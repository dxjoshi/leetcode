import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
*
* 187. Repeated DNA Sequences
*
* The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
* For example, "ACGAATTCCG" is a DNA sequence.
* When studying DNA, it is useful to identify repeated sequences within the DNA.
* Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
*
* */
public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <=10) return res;
        Set<String> set = new HashSet<>();
        for (int i=0; i< s.length()-9; i++) {
            String str = s.substring(i, i+10);
            if (!set.add(str)) {
                if (!res.contains(str)) res.add(str);
            }
        }
        return res;
    }
}