public class KMPAlgorithm {
    public static void main(String[] args) {
        String pattern = "aabaabaaa";
/*
        Proper prefix: All the characters in a string, with one or more cut off the end. “S”, “Sn”, “Sna”, and “Snap” are all the proper prefixes of “Snape”.
        Proper suffix: All the characters in a string, with one or more cut off the beginning. “agrid”, “grid”, “rid”, “id”, and “d” are all proper suffixes of “Hagrid”.

        LPS array is the lookup array where:
        The length of the longest proper prefix in the (sub)pattern that matches a proper suffix in the same (sub)pattern.
*/

        int[] lps = prefix(pattern);
        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i]+" ");
        }
    }

    private static int[] prefix(String pattern) {
        int[] res = new int[pattern.length()];
        int i=0, j=1, count=0;
        res[0] = 0;
        while(j<pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                res[j] = ++i;
                ++j;
            } else {
                if (i<=0) {
                    res[j] = 0;
                    ++j;
                }
                i = i<= 0 ? 0: res[i-1];
            }
        }

        return res;
    }

}
