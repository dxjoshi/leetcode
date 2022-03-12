import java.util.HashMap;

public class CompleteString_CodeStudio {
    public static String completeString(int n, String[] a) {

        String ans = "";

        HashMap < String, Integer > mp = new HashMap< >();

        // Storing all strings in hashmap.
        for (int i = 0; i < n; i++) {
            mp.put(a[i], 1);
        }

        for (int i = 0; i < n; i++) {
            String pre = "";
            boolean flag = true;
            // Traversing over all prefixes of the string 'a[i]'.
            for (int j = 0; j < a[i].length(); j++) {
                pre += a[i].charAt(j);
                // If current prefix is not present in map, this string is invalid.
                if (mp.containsKey(pre));
                else {
                    flag = false;
                    break;
                }
            }

            // Current string is a valid string.
            if (flag) {
                // If current string is longer than ans, we update it.
                if (ans.length() < a[i].length()) {
                    ans = a[i];
                }
                // If current string is of same length as 'ans', but lexicographically smaller, we update it.
                else if (ans.length() == a[i].length() && ans.compareTo(a[i]) > 0) {
                    ans = a[i];
                }
            }
        }

        // If there is no valid answer, we return "None".
        if (ans.length() == 0) {
            ans = "None";
        }
        // Return the final result.
        return ans;
    }
}
