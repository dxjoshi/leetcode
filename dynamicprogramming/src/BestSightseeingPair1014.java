/*
*
* 1014. Best Sightseeing Pair
*
* You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
* The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
* Return the maximum score of a pair of sightseeing spots.
*
* */
public class BestSightseeingPair1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int curr = values[i] + i;
        for(int j=1; j<values.length; j++) {
            curr = values[i] + i;
            max = Math.max(max, curr + values[j] - j);
            if (values[j] + j > curr) {
                i = j;
            }
        }
        return max;
    }
}
