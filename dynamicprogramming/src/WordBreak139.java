import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
*
* 139. Word Break
*
* Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
* Note that the same word in the dictionary may be reused multiple times in the segmentation.
*
* */
public class WordBreak139 {
/*
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<=i; j++) {
                String str = s.substring(j, i+1);
                if (wordDict.contains(str) && (j==0 || dp[j-1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
*/

    Boolean[] mem;
    public boolean wordBreak(String s, List<String> wordDict) {
        mem=new Boolean[s.length()];
        return wordBreak(0,s,new HashSet<String>(wordDict));
    }
    private boolean wordBreak(int p, String s, Set<String> dict){
        int n=s.length();
        if(p==n) {
            return true;
        }
        if(mem[p]!=null) {
            return mem[p];
        }
        for(int i=p+1;i<=n;i++) {
            if(dict.contains(s.substring(p,i))&&wordBreak(i,s,dict)) {
                return mem[p]=true;
            }
        }
        return mem[p]=false;
    }
}
