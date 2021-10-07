/*
*
* 91. Decode Ways
*
* A message containing letters from A-Z can be encoded into numbers using the following mapping:
*
* 'A' -> "1"
* 'B' -> "2"
* ...
* 'Z' -> "26"
* To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
*
* "AAJF" with the grouping (1 1 10 6)
* "KJF" with the grouping (11 10 6)
* Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
*
* Given a string s containing only digits, return the number of ways to decode it.
*
* The answer is guaranteed to fit in a 32-bit integer.
*
* */
public class DecodeWays91 {
    public int numDecodings(String s) {
        int n=s.length();
        Integer[] mem=new Integer[n];
        return s.length()==0?0:numDecodings(0,s,mem);
    }

    private int numDecodings(int p, String s, Integer[] mem) {
        int n=s.length();
        if(p==n) return 1;
        if(s.charAt(p)=='0') return 0;
        if(mem[p]!=null) return mem[p];
        int res=numDecodings(p+1,s,mem);
        if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7'))
            res+=numDecodings(p+2,s,mem);
        return mem[p]=res;
    }
}
