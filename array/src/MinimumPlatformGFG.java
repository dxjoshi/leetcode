import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;

/*
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
*/

public class MinimumPlatformGFG {
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, count = 0, max = 0;

        while (i<n && j<n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}