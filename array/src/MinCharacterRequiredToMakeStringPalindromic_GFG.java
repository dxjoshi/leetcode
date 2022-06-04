public class MinCharacterRequiredToMakeStringPalindromic_GFG {
    public int solve(String A) {
        int len = A.length();
        String reverse = new StringBuffer(A).reverse().toString();
        A = A+"$"+reverse;
        return len - KMP(A);
    }

    public static int KMP(String s){
        int m =s.length();
        int lps[] = new int[m];
        // len - length of longest prefrix that is a suffix
        int i=1,len=0;
        lps[0]=0;
        while(i<m) {
            if(s.charAt(i)==s.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if(len!=0) {
                    len = lps[len-1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps[m-1];
    }
}
