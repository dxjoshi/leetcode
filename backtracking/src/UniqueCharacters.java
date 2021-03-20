/*
*
* 1239. Maximum Length of a Concatenated String with Unique Characters
*
* Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
* Return the maximum possible length of s.
*
*
* */
import java.util.Arrays;
import java.util.List;

public class UniqueCharacters {
    int res = 0;
    public int maxLength(List<String> arr) {
        solve(arr, 0, "");
        return res;
    }

    public void solve(List<String> arr, int curr, String result) {
        if (curr == arr.size()) {
            return;
        }
        for (int i = curr; i<arr.size(); i++) {
            if (!unique(result+arr.get(i))) {
                continue;
            }
            result += arr.get(i);
            res = Math.max(res, result.length());
            solve(arr, i+1, result);
            result = result.substring(0, result.length()-arr.get(i).length());
        }
    }

    private boolean unique(String input) {
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                return false;
            }
        }
        return true;
    }
}
